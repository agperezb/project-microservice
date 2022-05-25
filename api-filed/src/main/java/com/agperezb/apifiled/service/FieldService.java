package com.agperezb.apifiled.service;

import com.agperezb.apifiled.entity.Field;
import com.agperezb.apifiled.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field save(Field field) {
        return this.fieldRepository.save(field);
    }

    public List<Field> getAll() {
        return this.fieldRepository.findAll();
    }

    public Optional<Field> getById(UUID id) {
        return this.fieldRepository.findById(id);
    }

    public Boolean existUserById(UUID id) {
        return fieldRepository.existsById(id);
    }


}
