package com.desaextremo.retodos.repository;

import com.desaextremo.retodos.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,Integer> {
    public List<Order> findAllBySalesMan_Zone(String zone);

    //Otro Metodo con Query
    /*
    @Query("{'salesman.zone': ?0}")
    public List<Order> findBySalesmanZone(String zona);
    */
}
