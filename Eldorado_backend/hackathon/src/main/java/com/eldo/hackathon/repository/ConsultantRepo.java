package com.eldo.hackathon.repository;

import com.eldo.hackathon.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepo extends JpaRepository<Consultant, Integer> {
}
