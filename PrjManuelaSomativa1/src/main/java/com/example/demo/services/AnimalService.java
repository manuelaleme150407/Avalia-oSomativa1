package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Animais;
import com.example.demo.repositories.AnimalRepository;

@Service
public class AnimalService {
	private final AnimalRepository animalrepository;

	@Autowired
	public AnimalService(AnimalRepository animalrepository) {
		this.animalrepository = animalrepository;
	}


	public AnimalService saveAnimal(AnimalService animal) {
		return animalrepository.save(animal);
	}

	
	public AnimalService getAnimalById(Long id) {
		return animalrepository.findById(id).orElse(null);
	}

	
	public List<AnimalService> getAllAnimal() {
		return animalrepository.findAll();
	}

	
	public void deleteAnimal(Long id) {
		animalrepository.deleteById(id);
	}
}
