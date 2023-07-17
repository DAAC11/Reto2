package com.desaextremo.retodos.repository;

import com.desaextremo.retodos.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Integer> {
}
