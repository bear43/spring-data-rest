package com.example.demo.service.tree.components;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.service.ComponentService;
import com.example.demo.service.tree.TreePartBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(0)
public class ComponentPartBuilderImpl implements TreePartBuilder {

    private final ComponentService componentService;

    @Autowired
    public ComponentPartBuilderImpl(ComponentService componentService) {
        this.componentService = componentService;
    }

    @Override
    public void build(ExtTreeDTO root) {
        root.getChildren().add(componentService.getComponentTree());
    }
}
