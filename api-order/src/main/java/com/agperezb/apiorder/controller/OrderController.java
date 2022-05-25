package com.agperezb.apiorder.controller;

import com.agperezb.apiorder.entity.Order;
import com.agperezb.apiorder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getAll() {
        return this.orderService.getAll();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        return orderService.getById(id).map(order ->
                new ResponseEntity<>(order, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/order")
    public ResponseEntity<?> save(@RequestBody Order order) {
        HashMap<String, String> map = new HashMap<>();
        map = this.orderService.save(order);
        String status = map.get("status");
        map.remove("status");
        if (status.equals("201")) {
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/order/{id}/users")
    public List<Order> getOrderByUserId(@PathVariable UUID id) {
        return this.orderService.getOrderByUser(id);
    }

}
