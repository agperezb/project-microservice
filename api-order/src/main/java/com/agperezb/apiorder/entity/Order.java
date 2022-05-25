package com.agperezb.apiorder.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "order", schema = "main")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "order_user_id")
    private UUID orderUserId;

    @Column(name = "order_field_id")
    private UUID orderFieldId;

    @Column(name = "order_reference")
    private String orderReference;

    @Column(name = "order_section_date")
    private String orderSectionDate;

    @Column(name = "order_value")
    private String orderValue;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(UUID orderUserId) {
        this.orderUserId = orderUserId;
    }

    public UUID getOrderFieldId() {
        return orderFieldId;
    }

    public void setOrderFieldId(UUID orderFieldId) {
        this.orderFieldId = orderFieldId;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getOrderSectionDate() {
        return orderSectionDate;
    }

    public void setOrderSectionDate(String orderSectionDate) {
        this.orderSectionDate = orderSectionDate;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
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
