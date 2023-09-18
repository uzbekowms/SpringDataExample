package com.example.springmvcexample.domain.repository;

import com.example.springmvcexample.domain.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
