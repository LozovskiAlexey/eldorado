package com.eldo.hackathon.controller;

import com.eldo.hackathon.dto.StatisticsDto;
import com.eldo.hackathon.repository.ConsultantRepo;
import com.eldo.hackathon.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/{consultantId}")
    public StatisticsDto getStatistics(@PathVariable Integer consultantId){
        return statisticsService.getStatistics(consultantId);
    }
}
