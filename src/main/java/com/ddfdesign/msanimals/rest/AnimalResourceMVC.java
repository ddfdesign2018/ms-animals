package com.ddfdesign.msanimals.rest;

import com.ddfdesign.msanimals.feign.IBreed;
import com.ddfdesign.msanimals.feign.IClient;
import com.ddfdesign.msanimals.feign.ISale;
import com.ddfdesign.msanimals.feign.ISpecy;
import com.ddfdesign.msanimals.feign.dto.BreedDTO;
import com.ddfdesign.msanimals.feign.dto.ClientDTO;
import com.ddfdesign.msanimals.feign.dto.SaleDTO;
import com.ddfdesign.msanimals.feign.dto.SpecyDTO;
import com.ddfdesign.msanimals.rest.dto.AnimalDTO;
import com.ddfdesign.msanimals.service.IGestionAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.PathParam;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("app")
public class AnimalResourceMVC {

    @Autowired
    IGestionAnimals gestionAnimals;

    @Autowired
    ISpecy iSpecy;

    @Autowired
    IBreed iBreed;

    @Autowired
    IClient iClient;

    @Autowired
    ISale iSale;

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

    @GetMapping("breed")
    public ModelAndView getAnimalByBreed(@PathParam ("breed") String breed) {
        Long breed2 = Long.valueOf(breed);
        List<AnimalDTO> listaAnimal = gestionAnimals.getAnimalByBreed(breed2);
        ModelAndView mav = new ModelAndView();
        mav.addObject("animalsList", listaAnimal);
        mav.setViewName("animals");
        return mav;
    }

    @GetMapping("all")
    public ModelAndView getAllMVC() {
        List<AnimalDTO> listaAnimals = gestionAnimals.getAllAnimals();
        List<SpecyDTO> listaSpecies = iSpecy.getAllSpeciesList();
        List<BreedDTO> listaBreeds = iBreed.getAllBreedsList();
        List<ClientDTO> listaClients = iClient.getAllClientsList();
        List<SaleDTO> listaSales = iSale.getAllSalesList();
        ModelAndView mav = new ModelAndView();
        mav.addObject("animalsList", listaAnimals);
        mav.addObject("speciesList", listaSpecies);
        mav.addObject("breedsList",listaBreeds);
        mav.addObject("clientsList",listaClients);
        mav.addObject("salesList",listaSales);
        mav.setViewName("all");
        return mav;
    }

}
