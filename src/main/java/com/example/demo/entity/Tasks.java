package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
@Entity
@Data
@Table(name = "task")
public class Tasks extends AuditableDomain implements Serializable {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "is_completed", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isCompleted = false;


}
