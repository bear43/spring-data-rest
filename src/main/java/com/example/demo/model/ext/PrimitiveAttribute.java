package com.example.demo.model.ext;

import javax.persistence.Entity;

@Entity
public class PrimitiveAttribute extends Attribute {
    protected Class<?> entity;
    protected Long entityId;

    public Class<?> getEntity() {
        return entity;
    }

    public void setEntity(Class<?> entity) {
        this.entity = entity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}
