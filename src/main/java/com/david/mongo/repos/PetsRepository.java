/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.mongo.repos;

import com.david.mongo.domains.Pets;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DMwangi
 */
public interface PetsRepository extends MongoRepository<Pets, String>{
    Pets findBy_id(String _id);
}
