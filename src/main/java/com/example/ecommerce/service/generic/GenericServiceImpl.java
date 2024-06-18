package com.example.ecommerce.service.generic;

import com.example.ecommerce.configuration.ModelMapperConfiguration;
import com.example.ecommerce.repository.generic.GenericRepository;
import com.example.ecommerce.util.ListMapper;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


public class GenericServiceImpl<T, CreateDTO, FindDTO, ID> implements GenericService<T, CreateDTO, FindDTO, ID> {

    private final GenericRepository<T, ID> repository;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    public GenericServiceImpl(GenericRepository<T, ID> repository,
                              ModelMapper modelMapper,
                              ListMapper listMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;

    }

    @SuppressWarnings("unchecked")
    private FindDTO createFindDtoClass() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        return ((Class<FindDTO>) type).getDeclaredConstructor().newInstance();
    }

    @SuppressWarnings("unchecked")
    private Class<FindDTO> getFindDtoClass() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        return (Class<FindDTO>) type;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getEntityClass() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return (Class<T>) type;
    }

    @Override
    public List<FindDTO> findAll() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FindDTO findDtoInstance = createFindDtoClass();
        return (List<FindDTO>) listMapper.mapList(repository.findAll(), findDtoInstance);
    }

    @Override
    public FindDTO findById(ID id) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        T entity = repository.findById(id).orElse(null);
        System.out.println(entity);
        if(entity!=null){
             return modelMapper.map(entity, getFindDtoClass());
        }
        return null;

    }

    @Override
    public T add(CreateDTO createDTO) {
        T entity = modelMapper.map(createDTO, getEntityClass());
        return repository.save(entity);
    }

    @Override
    public T update(ID id,CreateDTO createDTO) {
        T entity = repository.findById(id).orElse(null);
        if(entity!= null){
            modelMapper.map(createDTO, entity);
            return repository.save(entity);
        }
        return null;
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
