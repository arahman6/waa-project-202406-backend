package com.example.ecommerce.controller.generic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface GenericController<T, CreateDTO, FindDTO, ID> {

    @GetMapping
    List<FindDTO> getAll() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    @GetMapping("/{id}")
    FindDTO getById(@PathVariable ID id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    @PostMapping
    T create(@RequestBody CreateDTO createDTO);

    @PutMapping("/{id}")
    T update(@PathVariable ID id, @RequestBody CreateDTO createDTO);

    @DeleteMapping("/{id}")
    void delete(@PathVariable ID id);
}
