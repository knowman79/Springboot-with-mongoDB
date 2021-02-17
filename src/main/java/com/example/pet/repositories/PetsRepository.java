package com.example.pet.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.pet.models.Pets;

public interface PetsRepository extends MongoRepository<Pets, String>{
	Pets findBy_id(ObjectId _id);
}
