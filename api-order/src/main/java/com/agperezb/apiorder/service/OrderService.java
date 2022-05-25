package com.agperezb.apiorder.service;

import com.agperezb.apiorder.entity.Field;
import com.agperezb.apiorder.entity.Order;
import com.agperezb.apiorder.entity.User;
import com.agperezb.apiorder.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }

    public List<Order> getOrderByUser(UUID uuid) {
        return this.orderRepository.findAllByOrderUserId(uuid);
    }

    public Optional<Order> getById(UUID id) {
        return this.orderRepository.findById(id);
    }

    public HashMap<String, String> save(Order order) {
        HashMap<String, String> map = new HashMap<>();
        try {
            String urlUser = "http://localhost:8080/api_user/user/" + order.getOrderUserId();
            User user = this.restTemplate.getForObject(urlUser, User.class);
            String urlField = "http://localhost:8080/api_field/field/" + order.getOrderFieldId();
            Field field = this.restTemplate.getForObject(urlField, Field.class);

            Order order1 = orderRepository.save(order);

            map.put("status", "201");
            map.put("userName", user.getUserName() + "-" + user.getUserLastName());
            map.put("fieldName", field.getFieldName());
            map.put("orderReference", order1.getOrderReference());
            map.put("orderSectionDate", order1.getOrderSectionDate());
            map.put("orderValue", order1.getOrderReference());

            return map;
        }catch (Exception e){
            map.put("status", "400");
            map.put("message", "No existe el usuario");
            return map;
        }
    }

}
