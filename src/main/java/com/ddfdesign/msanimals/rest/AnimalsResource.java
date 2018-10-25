package com.ddfdesign.msanimals.rest;

import com.ddfdesign.msanimals.rest.dto.AnimalDTO;
import com.ddfdesign.msanimals.service.IGestionAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Stream;

@RestController("/")
public class AnimalsResource {

    @Autowired
    IGestionAnimals gestionAnimals;

    @RequestMapping(value = "animal", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<AnimalDTO> listaAnimals = gestionAnimals.getAllAnimals();
        return ResponseEntity.ok(listaAnimals);
    }

    @RequestMapping(value = "animal/{idAnimal}", method = RequestMethod.GET)
    public ResponseEntity<AnimalDTO> getAnimalByIdAnimal(@PathVariable Long idAnimal) {
        AnimalDTO listaAnimal = gestionAnimals.getAnimalById(idAnimal);
        return ResponseEntity.ok(listaAnimal);
    }

    @RequestMapping(value = "animal", method = RequestMethod.POST)
    public ResponseEntity<Void> createAnimal(@RequestBody AnimalDTO animalDTO) {
        AnimalDTO resultado = gestionAnimals.createAnimalById(animalDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "animal/{idAnimal}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAnimal(@PathVariable Long idAnimal) {
        String resultado = "";
        if (gestionAnimals.deleteAnimalById(idAnimal))
            resultado = "El animal con id " + idAnimal + " Ha sido eliminado correctamente";
        else
            resultado = "El animal con id " + idAnimal + " No se ha podido borrar";
        return ResponseEntity.ok(resultado);
    }

    @RequestMapping(value = "animal", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAnimal(@RequestBody AnimalDTO animalDTO) {
        boolean resultado = gestionAnimals.updateAnimalById(animalDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "animal/animal/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalDTO>> getAnimalByName(@PathVariable String name) {
        List<AnimalDTO> listaAnimal = gestionAnimals.getAnimalByName(name);
        return ResponseEntity.ok(listaAnimal);
    }

    @RequestMapping(value = "animal/breed/{breed}", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalDTO>> getAnimalByBreed(@PathVariable Long breed) {
        List<AnimalDTO> listaAnimal = gestionAnimals.getAnimalByBreed(breed);
        return ResponseEntity.ok(listaAnimal);
    }

    @RequestMapping(value = "animal/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalDTO>> getAnimalByStatus(@PathVariable String status) {
        List<AnimalDTO> listaAnimal = gestionAnimals.getAnimalByStatus(status);
        return ResponseEntity.ok(listaAnimal);
    }

    @RequestMapping(value = "animal/{father}/{mother}", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalDTO>> getAnimalByFatherMother(@PathVariable Long father, @PathVariable Long mother) {
        List<AnimalDTO> listaAnimal = gestionAnimals.getAnimalByFatherMother(father, mother);
        return ResponseEntity.ok(listaAnimal);
    }

    @RequestMapping(value = "animal/client/{client}", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalDTO>> getAnimalByClient(@PathVariable Long client) {
        List<AnimalDTO> listaAnimal = gestionAnimals.getAnimalByClient(client);
        return ResponseEntity.ok(listaAnimal);
    }

}