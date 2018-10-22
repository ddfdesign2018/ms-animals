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
    public ResponseEntity<Void> createAnimal(@RequestBody AnimalDTO animalDTO){
        AnimalDTO resultado = gestionAnimals.createAnimalById(animalDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @RequestMapping(value = "animal/{idAnimal}",method = RequestMethod.DELETE)
    public ResponseEntity<String> elminarUsuarioYTodosSusProductos(@PathVariable Long idAnimal){
        String resultado = "";
        if (gestionAnimals.deleteAnimalById(idAnimal))
            resultado = "El animal con id " + idAnimal + " ha sido eliminado correctamente";
        else
            resultado = "El animal con id " + idAnimal + " NO SE HA PODIDO borrar";
        return ResponseEntity.ok(resultado);
    }

    @RequestMapping(value = "animal", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAnimal(@RequestBody AnimalDTO animalDTO){
        boolean resultado = gestionAnimals.updateAnimalById(animalDTO);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}