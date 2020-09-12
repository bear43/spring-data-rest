package com.example.demo.service.tree.attributes;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.repo.AttributeRepository;
import com.example.demo.service.tree.TreePartBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class AttributePartBuilderImpl implements TreePartBuilder {

    private final AttributeRepository attributeRepository;

    @Autowired
    public AttributePartBuilderImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public void build(ExtTreeDTO root) {
        var subRoot = new ExtTreeDTO();
        subRoot.setText("Attributes");
        attributeRepository.findAllByOrderByName().forEach(attribute -> {
            var node = new ExtTreeDTO();
            node.setLeaf(true);
            node.setText(attribute.getName());
            node.setId(attribute.getId());
            subRoot.getChildren().add(node);
        });
        root.getChildren().add(subRoot);
    }
}
