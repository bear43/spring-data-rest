package com.example.demo.model.ext;

import javax.persistence.*;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Component {

    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    @Column(unique = true, nullable = false)
    protected String extClass;

    @ManyToOne
    protected Component owner;

    @OneToMany(mappedBy = "owner")
    protected List<Component> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtClass() {
        return extClass;
    }

    public void setExtClass(String extClass) {
        this.extClass = extClass;
    }

    public Component getOwner() {
        return owner;
    }

    public void setOwner(Component owner) {
        this.owner = owner;
    }

    public List<Component> getItems() {
        return items;
    }

    public void setItems(List<Component> items) {
        this.items = items;
    }
}
