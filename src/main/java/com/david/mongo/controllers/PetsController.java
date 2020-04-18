/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.mongo.controllers;

import com.david.mongo.domains.Pets;
import com.david.mongo.repos.PetsRepository;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DMwangi
 */
@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsRepository petsRepository;

    //Get All
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }

    //Get one by Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") String id) {
        return petsRepository.findBy_id(id);
    }

    //Put
    @RequestMapping(value = "/manage/{id}", method = RequestMethod.PUT)
    public Pets modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Pets pets) {
        pets.set_id(id);
        return  petsRepository.save(pets);
    }

    //Post
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public Pets createPet(@Valid @RequestBody Pets pets) {
        pets.set_id(UUID.randomUUID().toString());
        petsRepository.save(pets);
        return pets;
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable String id) {
        petsRepository.delete(petsRepository.findBy_id(id));
    }
}
