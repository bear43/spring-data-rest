package com.example.demo.repo;

import com.example.demo.model.ext.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    List<Component> findAllByEnabledIsTrue();

    List<Component> findAllByOrderByName();

    @Transactional
    @Modifying
    @Query("UPDATE Component component SET component.enabled=:#{#enable} WHERE component.id=:#{#id}")
    void setState(Long id, Boolean enable);
}
