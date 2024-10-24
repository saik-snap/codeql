package com.hdfc.login.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "loginentity")
public class LoginEntity extends AuditAwareBaseEntity {

    private String title;
    private boolean isActive;

    public LoginEntity() {
    }

    public LoginEntity(String title, boolean isActive) {
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
