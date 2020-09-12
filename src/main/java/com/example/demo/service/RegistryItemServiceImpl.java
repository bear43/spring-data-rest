package com.example.demo.service;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.form.ComponentForm;
import com.example.demo.model.ext.Component;
import com.example.demo.model.ext.RegistryItem;
import com.example.demo.repo.RegistryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistryItemServiceImpl implements RegistryItemService {

    private final RegistryItemRepository registryItemRepository;

    private final ComponentService componentService;

    @Autowired
    public RegistryItemServiceImpl(RegistryItemRepository registryItemRepository, ComponentService componentService) {
        this.registryItemRepository = registryItemRepository;
        this.componentService = componentService;
    }

    private ExtTreeDTO convertComponentRegistryToExtTreeDTO(RegistryItem registryItem) {
        final Component component = registryItem.getComponent();
        ExtTreeDTO node = new ExtTreeDTO();
        node.setId(registryItem.getId());
        node.setLeaf(true);
        node.setDisabled(!registryItem.getEnabled());
        node.setText(component.getName() + " : " + component.getExtClass());
        return node;
    }

    private List<ExtTreeDTO> getComponentsTree() {
        return registryItemRepository.findAll().stream().map(this::convertComponentRegistryToExtTreeDTO).collect(Collectors.toList());
    }

    private ExtTreeDTO wrapWithRoot(Collection<ExtTreeDTO> nodes) {
        ExtTreeDTO root = new ExtTreeDTO();
        root.setText("root");
        root.getChildren().addAll(nodes);
        return root;
    }

    private ExtTreeDTO wrapWithRoot(ExtTreeDTO node) {
        return wrapWithRoot(Collections.singletonList(node));
    }

    private void decideLeafState(ExtTreeDTO allNode) {
        allNode.setLeaf(allNode.getChildren().isEmpty());
    }

    @Override
    public ExtTreeDTO getComponentTree() {
        ExtTreeDTO allNode = new ExtTreeDTO();
        allNode.setText("All");
        allNode.getChildren().addAll(getComponentsTree());
        return wrapWithRoot(allNode);
    }

    @Override
    public Long save(ComponentForm componentForm) {
        final Long componentId = componentService.save(componentForm);
        RegistryItem registryItem = new RegistryItem();
        Component component = new Component();
        component.setId(componentId);
        registryItem.setComponent(component);
        registryItem.setEnabled(componentForm.getEnabled());
        return registryItemRepository.save(registryItem).getId();
    }

    @Override
    public void enable(Long id, Boolean enable) {
        registryItemRepository.setState(id, enable);
    }
}
