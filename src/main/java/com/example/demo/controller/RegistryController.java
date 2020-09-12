package com.example.demo.controller;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.form.ComponentForm;
import com.example.demo.repo.RegistryItemRepository;
import com.example.demo.service.RegistryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/components")
public class RegistryController {

    private final RegistryItemRepository registryItemRepository;

    private final RegistryItemService registryItemService;

    @Autowired
    public RegistryController(RegistryItemRepository registryItemRepository, RegistryItemService registryItemService) {
        this.registryItemRepository = registryItemRepository;
        this.registryItemService = registryItemService;
    }

    @GetMapping
    public ExtTreeDTO get() {
        return registryItemService.getComponentTree();
    }

    @PostMapping("/add")
    public Long add(@RequestBody ComponentForm componentForm) {
        return registryItemService.save(componentForm);
    }

    @PatchMapping("/set-state/{id}")
    public void enable(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false") Boolean enable) {
        registryItemService.enable(id, enable);
    }
}
