package com.eldo.hackathon.repository;

import com.eldo.hackathon.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag, Integer> {
    public List<Tag> findAllByNameIn(List<String> names);
}
