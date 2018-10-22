package com.ddfdesign.msanimals.rest;

import com.ddfdesign.msanimals.rest.dto.AnimalDTO;
import com.ddfdesign.msanimals.service.IGestionAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.PathParam;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("app")
public class AnimalResourceMVC {

    @Autowired
    IGestionAnimals gestionAnimals;

    @GetMapping("animal")
    public ModelAndView getAllAnimalsMVC() {
        List<AnimalDTO> listaAnimals = gestionAnimals.getAllAnimals();
        ModelAndView mav = new ModelAndView();
        mav.addObject("animalsList", listaAnimals);
        mav.setViewName("animals");
        return mav;
    }

    @GetMapping("animalId")
    public ModelAndView getAnimalByIdMVC(@PathParam ("idAnimal") String idAnimal) {
        Long idAnimal2 = Long.valueOf(idAnimal);
        AnimalDTO listaAnimal = gestionAnimals.getAnimalById(idAnimal2);
        ModelAndView mav = new ModelAndView();
        mav.addObject("animalsList", listaAnimal);
        mav.setViewName("animals");
        return mav;
    }

    @PostMapping("animalId")
    public ModelAndView createAnimalByIdMVC(@PathParam("name") String name,
                                            @PathParam("sex") String sex,
                                            @PathParam("color") String color,
                                            @PathParam("mother") String mother,
                                            @PathParam("father") String father,
                                            @PathParam("status") String status,
                                            @PathParam("born_date") Date born_date,
                                            @PathParam ("breed") String breed,
                                            @PathParam("weight") String weight)
                                                                        {
        Long breed2 = Long.valueOf(breed);
        Long mother2 = Long.valueOf(mother);
        Long father2 = Long.valueOf(father);
        Double weight2 = Double.valueOf(weight);
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setName(name);
        animalDTO.setSex(sex);
        animalDTO.setColor(color);
        animalDTO.setMother(mother2);
        animalDTO.setFather(father2);
        animalDTO.setStatus(status);
        animalDTO.setBorn_date(born_date);
        animalDTO.setBreed(breed2);
        animalDTO.setWeight(weight2);

        gestionAnimals.createAnimalById(animalDTO);
        List<AnimalDTO> listaAnimals = gestionAnimals.getAllAnimals();
        ModelAndView mav = new ModelAndView();
        mav.addObject("animalsList", listaAnimals);
        mav.setViewName("animals");
        return mav;
    }

}
