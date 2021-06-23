package com.eldo.hackathon.service;

import com.eldo.hackathon.dto.ClientInfoDto;
import com.eldo.hackathon.model.Client;
import com.eldo.hackathon.model.Consultant;
import com.eldo.hackathon.model.Consultation;
import com.eldo.hackathon.model.Tag;
import com.eldo.hackathon.repository.ClientRepo;
import com.eldo.hackathon.repository.ConsultantRepo;
import com.eldo.hackathon.repository.ConsultationRepo;
import com.eldo.hackathon.repository.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;
    private final ConsultantRepo consultantRepo;
    private final ConsultationRepo consultationRepo;
    private final TagRepo tagsRepo;

    @Transactional
    public ClientInfoDto getClientInfo(Integer consultantId, Integer clientId){
        Client client = clientRepo.getById(clientId);
        Consultant consultant = consultantRepo.getById(consultantId);

        Consultation consultation = new Consultation();
        consultation.setClient(client);
        consultation.setConsultant(consultant);
        consultation.setStatus("Not finished");
        consultation.setBusket(Collections.emptyList());

        consultationRepo.save(consultation);
        ClientInfoDto clientInfoDto = new ClientInfoDto();
        clientInfoDto.setName(client.getName());
        clientInfoDto.setTags(client.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        clientInfoDto.setConsultationId(consultation.getId());

        return clientInfoDto;
    }

    @Transactional
    public void setClientTags(Integer clientId, List<String> tags){
        Client client = clientRepo.getById(clientId);
        List<Tag> tagList = tagsRepo.findAllByNameIn(tags);
        client.setTags(tagList);

        clientRepo.save(client);
    }
}
