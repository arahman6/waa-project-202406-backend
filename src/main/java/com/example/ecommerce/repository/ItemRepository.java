package com.example.ecommerce.repository;

import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends GenericRepository<Item, Long> {
}
