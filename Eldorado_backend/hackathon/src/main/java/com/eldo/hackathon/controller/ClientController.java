package com.eldo.hackathon.controller;

import com.eldo.hackathon.dto.ClientInfoDto;
import com.eldo.hackathon.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{consultantId}/{clientId}")
    public ClientInfoDto getClientInfo(@PathVariable Integer consultantId, @PathVariable Integer clientId){
        return clientService.getClientInfo(consultantId, clientId);
    }

    @PostMapping("/tags/{clientId}")
    public void setClientTags(@PathVariable Integer clientId, @RequestBody List<String> tags){
        clientService.setClientTags(clientId, tags);
    }
}
