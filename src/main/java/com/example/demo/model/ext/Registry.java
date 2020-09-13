package com.example.demo.model.ext;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Registry {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    protected Attribute attribute;

    @ManyToOne
    protected Component component;

    @ManyToOne(fetch = FetchType.LAZY)
    protected Registry parent;

    @OneToMany(mappedBy = "parent")
    protected List<Registry> items = new ArrayList<>();

    protected Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Registry getParent() {
        return parent;
    }

    public void setParent(Registry parent) {
        this.parent = parent;
    }

    public List<Registry> getItems() {
        return items;
    }

    public void setItems(List<Registry> items) {
        this.items = items;
    }
}
