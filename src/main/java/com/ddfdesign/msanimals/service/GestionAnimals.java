package com.ddfdesign.msanimals.service;

import com.ddfdesign.msanimals.entity.Animal;
import com.ddfdesign.msanimals.repository.IAnimalsRepository;
import com.ddfdesign.msanimals.rest.dto.AnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionAnimals implements IGestionAnimals{

    @Autowired
    IAnimalsRepository animalsRepository;

    /**
     *
     * @return Devuelve una lista con todos los Animals
     */
    @Override
    public List<AnimalDTO> getAllAnimals(){
        List<AnimalDTO> lista = animalsRepository.findAll()
                .stream()
                .map(
                        animalEntity -> new AnimalDTO(
                                animalEntity.getId(),
                                animalEntity.getName(),
                                animalEntity.getBorn_date(),
                                animalEntity.getSex(),
                                animalEntity.getWeight(),
                                animalEntity.getStatus(),
                                animalEntity.getColor(),
                                animalEntity.getFather(),
                                animalEntity.getMother(),
                                animalEntity.getDeath_date(),
                                animalEntity.getClient(),
                                animalEntity.getSale(),
                                animalEntity.getBreed()
                        )
                ).collect(Collectors.toList());
        return lista;
    }

    /**
     *
     * @param idAnimal
     * @return Devuelve los datos del animal por idAnimal
     */

    @Override
    public AnimalDTO getAnimalById(Long idAnimal){
        Optional<Animal> animalOptional = animalsRepository.findById(idAnimal);
        Animal animal = animalOptional.get();
        AnimalDTO animalDTO = new AnimalDTO(
                                animal.getId(),
                                animal.getName(),
                                animal.getBorn_date(),
                                animal.getSex(),
                                animal.getWeight(),
                                animal.getStatus(),
                                animal.getColor(),
                                animal.getFather(),
                                animal.getMother(),
                                animal.getDeath_date(),
                                animal.getClient(),
                                animal.getSale(),
                                animal.getBreed()
                        );
        return animalDTO;
    }
    @Override
    public AnimalDTO createAnimalById(AnimalDTO animalDTO){
        Animal animal = new Animal(
                null,
                animalDTO.getName(),
                animalDTO.getBorn_date(),
                animalDTO.getSex(),
                animalDTO.getWeight(),
                animalDTO.getStatus(),
                animalDTO.getColor(),
                animalDTO.getFather(),
                animalDTO.getMother(),
                animalDTO.getDeath_date(),
                animalDTO.getClient(),
                animalDTO.getSale(),
                animalDTO.getBreed()
        );
        Animal resultado = animalsRepository.save(animal);
        return new AnimalDTO(animal.getId(),
                resultado.getName(),
                resultado.getBorn_date(),
                resultado.getSex(),
                resultado.getWeight(),
                resultado.getStatus(),
                resultado.getColor(),
                resultado.getFather(),
                resultado.getMother(),
                resultado.getDeath_date(),
                resultado.getClient(),
                resultado.getSale(),
                resultado.getBreed());
    }

    @Override
    public boolean deleteAnimalById(Long idAnimal){

        boolean resultado = false;
        animalsRepository.deleteById(idAnimal);
        Optional<Animal> animalOptional = animalsRepository.findById(idAnimal);
        if (!animalOptional.isPresent())
            resultado = true;
        return resultado;
    }

    @Override
    public boolean updateAnimalById(AnimalDTO animalDTO){
        Animal animal = new Animal(
                animalDTO.getId(),
                animalDTO.getName(),
                animalDTO.getBorn_date(),
                animalDTO.getSex(),
                animalDTO.getWeight(),
                animalDTO.getStatus(),
                animalDTO.getColor(),
                animalDTO.getFather(),
                animalDTO.getMother(),
                animalDTO.getDeath_date(),
                animalDTO.getClient(),
                animalDTO.getSale(),
                animalDTO.getBreed()
        );
        animalsRepository.save(animal);
        return true;
    }
}
