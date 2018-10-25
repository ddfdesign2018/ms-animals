package com.ddfdesign.msanimals.service;

import com.ddfdesign.msanimals.rest.dto.AnimalDTO;

import java.util.List;

public interface IGestionAnimals {

    List<AnimalDTO> getAllAnimals();
    AnimalDTO getAnimalById(Long idAnimal);
    AnimalDTO createAnimalById(AnimalDTO animalDTO);
    boolean deleteAnimalById(Long idAnimal);
    boolean updateAnimalById(AnimalDTO animalDTO);
    List<AnimalDTO> getAnimalByName(String name);
    List<AnimalDTO> getAnimalByBreed (Long breed);
    List<AnimalDTO> getAnimalByStatus (String status);
    List<AnimalDTO> getAnimalByFatherMother (Long father, Long mother);
    List<AnimalDTO> getAnimalByClient (Long client);
}
