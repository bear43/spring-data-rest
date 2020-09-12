package com.example.demo.service;

import com.example.demo.form.AttributeForm;
import com.example.demo.model.User;
import com.example.demo.model.ext.Attribute;
import com.example.demo.model.ext.PrimitiveAttribute;
import com.example.demo.repo.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    @Autowired
    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public Long save(AttributeForm attributeForm) {
        final PrimitiveAttribute primitiveAttribute = new PrimitiveAttribute();
        primitiveAttribute.setName(attributeForm.getName());
        primitiveAttribute.setEntity(User.class);
        primitiveAttribute.setEntityId(attributeForm.getUserId());
        return attributeRepository.save(primitiveAttribute).getId();
    }
}
