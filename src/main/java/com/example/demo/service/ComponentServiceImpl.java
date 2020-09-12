package com.example.demo.service;

import com.example.demo.form.ComponentForm;
import com.example.demo.model.ext.Component;
import com.example.demo.repo.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public Long save(ComponentForm componentForm) {
        Component component = new Component();
        component.setExtClass(componentForm.getClassName());
        component.setName(componentForm.getName());
        return componentRepository.save(component).getId();
    }
}
