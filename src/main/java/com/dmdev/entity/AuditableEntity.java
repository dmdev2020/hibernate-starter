package com.dmdev.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AuditableEntity<T extends Serializable> implements BaseEntity<T> {

    private Instant createdAt;
    private String createdBy;

    private Instant updatedAt;
    private String updatedBy;

    @PrePersist
    public void prePersist() {
        setCreatedAt(Instant.now());
//        setCreatedBy(SecurityContext.getUser());
    }

    @PreUpdate
    public void preUpdate() {
        setUpdatedAt(Instant.now());
//        setUpdatedBy(SecurityContext.getUser());
    }
}
