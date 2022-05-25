package com.agperezb.apifiled.controller;

import com.agperezb.apifiled.entity.Field;
import com.agperezb.apifiled.service.FieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/field")
    public List<Field> getAll() {
        return this.fieldService.getAll();
    }

    @PostMapping("/field")
    public ResponseEntity<Object> save(@RequestBody Field field) {
        return new ResponseEntity<>(this.fieldService.save(field), HttpStatus.CREATED);
    }

    @GetMapping("/field/exist/{id}")
    public Boolean existUserById(@PathVariable UUID id) {
        return this.fieldService.existUserById(id);
    }

    @GetMapping("/field/{id}")
    public ResponseEntity<Field> getUserById(@PathVariable UUID id) {
        return fieldService.getById(id).map(field ->
                new ResponseEntity<>(field, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
