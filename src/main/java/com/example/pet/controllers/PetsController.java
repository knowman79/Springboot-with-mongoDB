package com.example.pet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.models.Pets;
import com.example.pet.repositories.PetsRepository;

@RestController
@RequestMapping("/api/pets")
public class PetsController {
	@Autowired
	private PetsRepository repository;
	
	@RequestMapping(value = "/readAll", method = RequestMethod.GET)
	  public List<Pets> getAllPets() {
	    return repository.findAll();
	}
	
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	  public Pets getPetById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
	    pets.set_id(id);
	    repository.save(pets);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	  public Pets createPet(@Valid @RequestBody Pets pets) {
	    pets.set_id(ObjectId.get());
	    repository.save(pets);
	    return pets;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	  public void deletePet(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	}
}
