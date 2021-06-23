package com.eldo.hackathon.controller;

import com.eldo.hackathon.dto.ProductDto;
import com.eldo.hackathon.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consultation")
@RequiredArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping("/{consultationId}/{productid}")
    public ProductDto getProductInfo(@PathVariable Integer consultationId, @PathVariable Integer productid){
        return consultationService.getProductInfo(consultationId, productid);
    }

    @PostMapping("/{consultationId}")
    public void sentBucketToClient(@PathVariable Integer consultationId, @RequestBody List<ProductDto> products){
        consultationService.sendBucketToClient(consultationId, products);
    }

    @PostMapping("/{consultationId}/purchase")
    public void changeConsultationStatus(@PathVariable Integer consultationId, @RequestBody List<ProductDto> products){
        consultationService.changeConsultationStatus(consultationId, products);
    }
}
