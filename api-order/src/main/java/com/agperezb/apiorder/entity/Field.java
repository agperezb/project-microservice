package com.agperezb.apiorder.entity;

import java.sql.Timestamp;
import java.util.UUID;

public class Field {

    private UUID userId;
    private String fieldName;
    private String fieldDirection;
    private String fieldPlayerCapacity;
    private String fieldHourValue;
    private String fieldType;
    private Timestamp createdAt;
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
