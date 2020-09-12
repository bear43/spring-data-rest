package com.example.demo.service;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.form.ComponentForm;
import com.example.demo.model.ext.Component;

public interface ComponentService {
    Long save(ComponentForm componentForm);
    ExtTreeDTO getComponentTree();
    void enable(Long id, Boolean enable);
}
