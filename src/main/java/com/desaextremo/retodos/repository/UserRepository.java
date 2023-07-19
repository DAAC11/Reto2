package com.desaextremo.retodos.repository;

import com.desaextremo.retodos.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> getUserByZoneAndType(String zone, String type);

    List<User> findAllByZoneAndType(String zone, String type);
}
