package com.hdfc.accounts.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accountentity")
public class AccountEntity extends AuditAwareBaseEntity {

    private String title;
    private boolean isActive;

    public AccountEntity() {
    }

    public AccountEntity(String title, boolean isActive) {
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
