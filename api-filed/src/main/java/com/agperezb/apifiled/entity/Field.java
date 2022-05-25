package com.agperezb.apifiled.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "field", schema = "main")
public class Field {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "field_id")
    private UUID userId;

    @Column(name = "field_name", nullable = false, length = 100, unique = true)
    private String fieldName;

    @Column(name = "field_direction", length = 100)
    private String fieldDirection;

    @Column(name = "field_player_capacity", length = 10)
    private String fieldPlayerCapacity;

    @Column(name = "field_hour_value")
    private String fieldHourValue;

    @Column(name = "field_type")
    private String fieldType;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDirection() {
        return fieldDirection;
    }

    public void setFieldDirection(String fieldDirection) {
        this.fieldDirection = fieldDirection;
    }

    public String getFieldPlayerCapacity() {
        return fieldPlayerCapacity;
    }

    public void setFieldPlayerCapacity(String fieldPlayerCapacity) {
        this.fieldPlayerCapacity = fieldPlayerCapacity;
    }

    public String getFieldHourValue() {
        return fieldHourValue;
    }

    public void setFieldHourValue(String fieldHourValue) {
        this.fieldHourValue = fieldHourValue;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
