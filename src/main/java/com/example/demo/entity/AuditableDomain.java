package com.example.demo.entity;

import com.example.demo.common.DateUtil;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableDomain implements Serializable {

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate(){this.createdDate = DateUtil.convertToUTC(new Date());}

    @PreUpdate
    protected void onUpdate(){this.updatedDate = DateUtil.convertToUTC(new Date());}

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, updatable = false, length = 64 )
    private String id;

}
