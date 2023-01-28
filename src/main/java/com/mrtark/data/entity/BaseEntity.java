package com.mrtark.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
//Auditing
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_date,updated_date" },allowGetters = true)
@MappedSuperclass
abstract public class BaseEntity implements Serializable {
    public static final Long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,insertable = true, nullable = false,unique = true)
    private Long id;
    @Column(name="system_created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;
    @CreatedBy
    @Column(name="created_user")
    private String createdBy;
    @Column(name="created_date")
    @CreatedDate
    private Date createdUserDate;
    @LastModifiedBy
    @Column(name="updated_user")
    private String updatedBy;
    @Column(name="updated_date")
    @LastModifiedDate
    private Date updatedUserDate;
}
