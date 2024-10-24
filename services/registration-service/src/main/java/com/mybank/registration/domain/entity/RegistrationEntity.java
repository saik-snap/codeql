package com.mybank.registration.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registrationentity")
public class RegistrationEntity extends AuditAwareBaseEntity {

    private String title;
    private boolean isActive;

    public RegistrationEntity() {
    }

    public RegistrationEntity(String title, boolean isActive) {
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
