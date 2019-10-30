package com.deunacabeca.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
abstract class AuditLog implements Serializable {
    private static final long serialVersionUID = 9060319419137045336L;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DT", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DT")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @UpdateTimestamp
    private Date updatedAt;
}

