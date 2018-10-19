package com.ddfdesign.msanimals.service;

import com.ddfdesign.msanimals.rest.dto.AnimalDTO;

import java.util.List;

public interface IGestionAnimals {

    List<AnimalDTO> getAllAnimals();
    AnimalDTO getAnimalById(Long idAnimal);
    AnimalDTO createAnimalById(AnimalDTO animalDTO);
    boolean deleteAnimalById(Long idAnimal);
    boolean updateAnimalById(AnimalDTO animalDTO);
}
