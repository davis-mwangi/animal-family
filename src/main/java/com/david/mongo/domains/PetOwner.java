/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.mongo.domains;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DMwangi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="owners")
public class PetOwner {
    private String _id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    
    @DBRef
    private List<Pets> pets;
}
