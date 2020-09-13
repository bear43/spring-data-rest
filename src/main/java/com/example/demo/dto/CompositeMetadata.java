package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeMetadata {
    protected Collection<Object> content = new ArrayList<>();

    public Collection<Object> getContent() {
        return content;
    }

    public void setContent(Collection<Object> content) {
        this.content = content;
    }
}
