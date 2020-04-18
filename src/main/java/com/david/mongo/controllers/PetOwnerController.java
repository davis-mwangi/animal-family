/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.mongo.controllers;

import com.david.mongo.domains.PetOwner;
import com.david.mongo.domains.Pets;
import com.david.mongo.repos.PetOwnerRepository;
import com.david.mongo.repos.PetsRepository;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DMwangi
 */
@RestController
@RequestMapping("/owners")
public class PetOwnerController {

    @Autowired
    private PetOwnerRepository petOwnerRepository;
    
    @Autowired
    private PetsRepository petsRepository;

    //Post
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public PetOwner createPet(@Valid @RequestBody PetOwner petOwner) {
        petOwner.set_id(UUID.randomUUID().toString());
        petOwnerRepository.save(petOwner);
        
        petOwner.getPets().stream().forEach(pet ->  pet.set_id(UUID.randomUUID().toString()));
        petsRepository.saveAll(petOwner.getPets());
        return petOwner;
    }
}
