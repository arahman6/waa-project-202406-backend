package com.example.ecommerce.service.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, CreateDTO, FindDTO, ID>{

    List<FindDTO> findAll() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    FindDTO findById(ID id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    T add(CreateDTO createDTO);
    T update(ID id,CreateDTO createDTO);
    void deleteById(ID id);

}
