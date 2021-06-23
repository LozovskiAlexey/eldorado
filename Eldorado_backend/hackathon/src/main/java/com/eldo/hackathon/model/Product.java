package com.eldo.hackathon.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
 * В текущей версии будет создавать своя база продуктов
 * На самом деле, данный класс должен быть объектом DTO, в который записываются
 * данные, полученные из базы приложения Эльдорадо
 */

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "picture")
    private String picture;

    @Column(name = "category")
    private String category;

    @Column(name="amount")
    private Integer amount;

    @ManyToMany(mappedBy = "busket", fetch = FetchType.EAGER)
    private List<Consultation> consultations;
}
