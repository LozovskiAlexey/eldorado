package com.eldo.hackathon.repository;

import com.eldo.hackathon.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Integer> {
}
