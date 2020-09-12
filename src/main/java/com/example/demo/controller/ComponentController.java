package com.example.demo.controller;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.form.ComponentForm;
import com.example.demo.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/components")
public class ComponentController {

    private final ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @PostMapping("/add")
    public Long add(@RequestBody ComponentForm componentForm) {
        return componentService.save(componentForm);
    }

    @PatchMapping("/set-state/{id}")
    public void enable(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false") Boolean enable) {
        componentService.enable(id, enable);
    }
}
