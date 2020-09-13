package com.example.demo.repo;

import com.example.demo.model.ext.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {
}
