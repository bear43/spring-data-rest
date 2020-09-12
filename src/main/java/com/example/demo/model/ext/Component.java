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

    protected Boolean enabled = true;

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

}
