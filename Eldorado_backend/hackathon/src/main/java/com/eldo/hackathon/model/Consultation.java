package com.eldo.hackathon.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "consultation")
public class Consultation {
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Column(name="status")
    private String status;

    @Column(name="cost")
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY)
    private Consultant consultant;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> busket;
}
