/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.mongo.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DMwangi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pets")
public class Pets {

    @Id
    public String _id;
    public String name;
    public String species;
    public String breed;



}
