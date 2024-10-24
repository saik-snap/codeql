package com.mybank.daprtestservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "myentity")
public class MyEntity extends AuditAwareBaseEntity {

    private String title;
    private boolean isActive;

    public MyEntity() {
    }

    public MyEntity(String title, boolean isActive) {
        this.title = title;
        this.isActive = isActive;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return isActive;
    }
}
