package com.example.demo.repo;

import com.example.demo.model.ext.RegistryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RegistryItemRepository extends JpaRepository<RegistryItem, Long> {
    List<RegistryItem> findAllByEnabledIsTrue();

    @Transactional
    @Modifying
    @Query("UPDATE RegistryItem registryItem SET registryItem.enabled=:#{#enable} WHERE registryItem.id=:#{#id}")
    void setState(Long id, Boolean enable);

}
