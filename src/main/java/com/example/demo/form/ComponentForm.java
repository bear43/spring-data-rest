package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ComponentForm {
    @NotBlank(message = "Class name cannot be blank")
    protected String className;
    @NotBlank(message = "Name cannot be blank")
    protected String name;
    @NotNull(message = "Enabled state cannot be null")
    protected Boolean enabled;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
