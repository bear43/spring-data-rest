package com.example.demo.service;

import com.example.demo.dto.ExtTreeDTO;
import com.example.demo.service.tree.TreeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeServiceImpl implements TreeService {

    private final TreeBuilder treeBuilder;

    @Autowired
    public TreeServiceImpl(TreeBuilder treeBuilder) {
        this.treeBuilder = treeBuilder;
    }

    @Override
    public ExtTreeDTO getTree() {
        return treeBuilder.build();
    }
}
