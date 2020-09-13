package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Collection;

public class ExtTreeDTO {
    private Long id;
    private String text;
    private Boolean leaf = false;
    private Boolean expanded = false;
    private Boolean disabled = false;
    private Collection<ExtTreeDTO> children = new ArrayList<>();
    private Object metadata;

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public Collection<ExtTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(Collection<ExtTreeDTO> children) {
        this.children = children;
    }
}
