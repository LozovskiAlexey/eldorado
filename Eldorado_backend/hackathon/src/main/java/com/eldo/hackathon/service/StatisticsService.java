package com.eldo.hackathon.service;

import com.eldo.hackathon.dto.StatisticsDto;
import com.eldo.hackathon.model.Consultant;
import com.eldo.hackathon.model.Consultation;
import com.eldo.hackathon.repository.ConsultantRepo;
import com.eldo.hackathon.repository.ConsultationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final ConsultantRepo consultantRepo;

    @Transactional
    public StatisticsDto getStatistics(Integer consultantId){
        Consultant consultant = consultantRepo.getById(consultantId);
        List<Consultation> consultationList = consultant.getConsultations();
        List<Consultation> finishedConsultationList = consultationList.stream()
                .filter(c-> c.getStatus().equals("Finished"))
                .collect(Collectors.toList());
        List<Consultation> unfinishedConsultationList = consultationList.stream()
                .filter(c-> c.getStatus().equals("Not finished"))
                .collect(Collectors.toList());

        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setConsultantId(consultantId);
        statisticsDto.setConsultantName(consultant.getName());
        statisticsDto.setSucceededConsultations(finishedConsultationList.size());
        statisticsDto.setTotalConsultations(consultationList.size());
        statisticsDto.setUnfinishedConsultations(unfinishedConsultationList.size());

        return statisticsDto;
    }
}
