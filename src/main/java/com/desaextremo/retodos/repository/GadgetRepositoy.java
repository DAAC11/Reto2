package com.desaextremo.retodos.repository;

import com.desaextremo.retodos.entity.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GadgetRepositoy extends MongoRepository<Gadget,Integer> {
}
