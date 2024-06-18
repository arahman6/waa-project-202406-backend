package com.example.ecommerce.controller.generic;

import com.example.ecommerce.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericControllerImpl<T, CreateDTO, FindDTO, ID> implements GenericController<T, CreateDTO, FindDTO, ID> {

    private GenericService<T,CreateDTO, FindDTO, ID> genericService;

    @Autowired
    public GenericControllerImpl(GenericService<T,CreateDTO, FindDTO, ID> genericService){
        this.genericService = genericService;
    }

    @Override
    public List<FindDTO> getAll() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return genericService.findAll();
    }

    @Override
    public FindDTO getById(ID id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return genericService.findById(id);
    }

    @Override
    public T create(CreateDTO createDTO) {
        return genericService.add(createDTO);
    }

    @Override
    public T update(ID id, CreateDTO createDTO) {
        return genericService.update(id, createDTO);
    }

    @Override
    public void delete(ID id) {
        genericService.deleteById(id);
    }
}
