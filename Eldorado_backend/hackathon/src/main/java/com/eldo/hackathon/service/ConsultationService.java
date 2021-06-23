package com.eldo.hackathon.service;

import com.eldo.hackathon.dto.ProductDto;
import com.eldo.hackathon.model.Consultation;
import com.eldo.hackathon.model.Product;
import com.eldo.hackathon.repository.ConsultationRepo;
import com.eldo.hackathon.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final ProductRepo productRepo;
    private final ConsultationRepo consultationRepo;

    @Transactional
    public ProductDto getProductInfo(Integer consultationId, Integer productid){
        // Добавить в консультацию товар
        Consultation consultation = consultationRepo.getById(consultationId);

        // Вернуть информацию о товаре
        Product product = productRepo.getById(productid);

        consultation.getBusket().add(product);
        consultationRepo.save(consultation);

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setAmount(product.getAmount());
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getName());

        return productDto;
    }

    public void sendBucketToClient(Integer consultationId, List<ProductDto> products){
        for (ProductDto productDto : products){
            Product product = productRepo.getByName(productDto.getName());
            productDto.setImage(product.getPicture());
            productDto.setPrice(product.getPrice());
        }

        Integer clientId = consultationRepo.getById(consultationId).getClient().getId();
        // Тут отправка данных на почту
        // Тут отправка данных на клиента
    }

    @Transactional
    public void changeConsultationStatus(Integer consultationId, List<ProductDto> products) {
        Consultation consultation = consultationRepo.getById(consultationId);
        consultation.setStatus("Finished");

        int cost = 0;
        for (ProductDto product : products){
            cost += product.getPrice() * product.getAmount();
        }

        consultation.setCost(cost);
        consultationRepo.save(consultation);
    }
}
