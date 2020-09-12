package com.example.demo.controller;

import com.example.demo.form.AttributeForm;
import com.example.demo.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/attributes")
@RestController
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping("/add")
    public Long add(@RequestBody AttributeForm attributeForm) {
        return attributeService.save(attributeForm);
    }
}
