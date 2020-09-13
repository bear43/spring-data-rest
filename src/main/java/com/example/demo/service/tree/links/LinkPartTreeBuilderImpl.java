package com.example.demo.service.tree.links;

import com.example.demo.dto.ClassNameMetadata;
import com.example.demo.dto.CompositeMetadata;
import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.dto.PrimitiveAttributeMetadata;
import com.example.demo.model.ext.Component;
import com.example.demo.model.ext.PrimitiveAttribute;
import com.example.demo.model.ext.Registry;
import com.example.demo.repo.RegistryRepository;
import com.example.demo.service.tree.TreePartBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Order(2)
public class LinkPartTreeBuilderImpl implements TreePartBuilder {

    private final RegistryRepository registryRepository;

    @Autowired
    public LinkPartTreeBuilderImpl(RegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    private CompositeMetadata getCompositeMetadata(Registry registry) {
        final Component component = registry.getComponent();
        final ClassNameMetadata classNameMetadata = new ClassNameMetadata();
        classNameMetadata.setClassName(component.getExtClass());
        final PrimitiveAttributeMetadata primitiveAttributeMetadata = new PrimitiveAttributeMetadata();
        var primAttr = (PrimitiveAttribute)registry.getAttribute();
        primitiveAttributeMetadata.setEntity(primAttr.getEntity().getCanonicalName());
        primitiveAttributeMetadata.setId(primAttr.getEntityId());
        final CompositeMetadata compositeMetadata = new CompositeMetadata();
        compositeMetadata.getContent().add(classNameMetadata);
        compositeMetadata.getContent().add(primitiveAttributeMetadata);
        return compositeMetadata;
    }

    private void traverse(ExtTreeDTO root, Registry registry) {
        ExtTreeDTO rootNode = new ExtTreeDTO();
        final List<Registry> items = registry.getItems();
        final boolean hasItems = items.isEmpty();
        rootNode.setLeaf(hasItems);
        rootNode.setText(registry.getComponent().getName());
        final CompositeMetadata compositeMetadata = getCompositeMetadata(registry);
        rootNode.setMetadata(compositeMetadata);
        if(hasItems) {
            registry.getItems().forEach(item -> traverse(rootNode, item));
        }
        root.getChildren().add(rootNode);
    }

    @Override
    public void build(ExtTreeDTO root) {
        ExtTreeDTO subRoot = new ExtTreeDTO();
        subRoot.setText("Links");
        registryRepository.findAll().forEach(registry -> traverse(subRoot, registry));
        root.getChildren().add(subRoot);
    }
}
