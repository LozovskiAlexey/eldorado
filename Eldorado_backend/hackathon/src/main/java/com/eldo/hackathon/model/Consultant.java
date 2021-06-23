package com.eldo.hackathon.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "consultant")
public class Consultant {
    @Id
    private Integer Id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "consultant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;
}
