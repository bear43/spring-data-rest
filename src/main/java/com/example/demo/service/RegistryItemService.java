package com.example.demo.service;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.form.ComponentForm;

public interface RegistryItemService {
    ExtTreeDTO getComponentTree();

    Long save(ComponentForm componentForm);

    void enable(Long id, Boolean enable);
}
