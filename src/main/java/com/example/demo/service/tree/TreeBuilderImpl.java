package com.example.demo.service.tree;

import com.example.demo.dto.ExtTreeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeBuilderImpl implements TreeBuilder {
    
    private List<TreePartBuilder> treePartBuilders;

    @Autowired
    public TreeBuilderImpl(List<TreePartBuilder> treePartBuilders) {
        this.treePartBuilders = treePartBuilders;
    }

    @Override
    public ExtTreeDTO build() {
        ExtTreeDTO root = new ExtTreeDTO();
        root.setText("root");
        for (var treePartBuilder :
                treePartBuilders) {
            treePartBuilder.build(root);
        }
        return root;
    }
}
