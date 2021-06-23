package com.eldo.hackathon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String image;
    private Integer price;
    private Integer amount;
}
