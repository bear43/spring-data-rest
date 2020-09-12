package com.example.demo.service;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.form.ComponentForm;
import com.example.demo.model.ext.Component;
import com.example.demo.repo.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    private ExtTreeDTO convertComponentRegistryToExtTreeDTO(Component component) {
        ExtTreeDTO node = new ExtTreeDTO();
        node.setId(component.getId());
        node.setLeaf(true);
        node.setDisabled(!component.getEnabled());
        node.setText(component.getName() + " : " + component.getExtClass());
        return node;
    }

    private List<ExtTreeDTO> getComponentsTree() {
        return componentRepository.findAllByOrderByName().stream().map(this::convertComponentRegistryToExtTreeDTO).collect(Collectors.toList());
    }

    private void decideLeafState(ExtTreeDTO allNode) {
        allNode.setLeaf(allNode.getChildren().isEmpty());
    }

    @Override
    public ExtTreeDTO getComponentTree() {
        ExtTreeDTO allNode = new ExtTreeDTO();
        allNode.setText("Components");
        allNode.getChildren().addAll(getComponentsTree());
        return allNode;
    }

    @Override
    public void enable(Long id, Boolean enable) {
        componentRepository.setState(id, enable);
    }

    @Override
    public Long save(ComponentForm componentForm) {
        Component component = new Component();
        component.setExtClass(componentForm.getClassName());
        component.setName(componentForm.getName());
        component.setEnabled(componentForm.getEnabled());
        return componentRepository.save(component).getId();
    }
}
