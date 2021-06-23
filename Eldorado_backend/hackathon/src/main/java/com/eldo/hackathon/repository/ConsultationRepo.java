package com.eldo.hackathon.repository;

import com.eldo.hackathon.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Integer> {
}
