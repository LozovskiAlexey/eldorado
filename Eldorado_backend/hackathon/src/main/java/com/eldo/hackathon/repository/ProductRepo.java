package com.eldo.hackathon.repository;

import com.eldo.hackathon.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    public Product getByName(String Name);
}
