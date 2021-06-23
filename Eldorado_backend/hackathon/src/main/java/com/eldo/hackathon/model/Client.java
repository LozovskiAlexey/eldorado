package com.eldo.hackathon.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import com.eldo.hackathon.model.Tag;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "avg_price")
    private int avgOrderPrice;

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private List<Tag> Tags;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;
}
