package com.eldo.hackathon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientInfoDto {
    private String name;
    private Integer consultationId;
    private List<String> tags;
}
