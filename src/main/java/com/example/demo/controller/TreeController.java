package com.example.demo.controller;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trees")
@RestController
public class TreeController {

    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping
    public ExtTreeDTO get() {
        return treeService.getTree();
    }

}
