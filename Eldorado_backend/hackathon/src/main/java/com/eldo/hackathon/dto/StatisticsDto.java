package com.eldo.hackathon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsDto {
    Integer consultantId;
    String consultantName;
    Integer totalConsultations;
    Integer succeededConsultations;
    Integer unfinishedConsultations;
}
