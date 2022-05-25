package com.agperezb.apiorder.repository;

import com.agperezb.apiorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByOrderUserId(UUID uuid);
}
