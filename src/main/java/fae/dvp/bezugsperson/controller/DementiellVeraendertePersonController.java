package fae.dvp.bezugsperson.controller;

import fae.dvp.bezugsperson.models.DementiellVeraendertePerson;
import fae.dvp.bezugsperson.repositories.DementiellVeraendertePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class DementiellVeraendertePersonController {

    private final DementiellVeraendertePersonRepository dementiellVeraendertePersonRepository;

    @Autowired
    public DementiellVeraendertePersonController(DementiellVeraendertePersonRepository dementiellVeraendertePersonRepository){
        this.dementiellVeraendertePersonRepository = dementiellVeraendertePersonRepository;
    }


    @GetMapping(path = "/dvps")
    public ResponseEntity<?> getdvps(){
        final Iterable<DementiellVeraendertePerson> dementiellVeraendertePersonList = this.dementiellVeraendertePersonRepository.findAll();

        Resources<DementiellVeraendertePerson> resources = new Resources<>(dementiellVeraendertePersonList);

        resources.add(linkTo(methodOn(DementiellVeraendertePersonController.class).getdvps()).withSelfRel());

        return  ResponseEntity.ok(resources);
    }

    @PostMapping(path = "/dvps")
    DementiellVeraendertePerson neuedvp(@RequestBody DementiellVeraendertePerson neueDvp){
        return dementiellVeraendertePersonRepository.save(neueDvp);
    }


    @DeleteMapping("/dvps/{id}")
    void loeschedvp(@PathVariable Long id){
        dementiellVeraendertePersonRepository.deleteById(id);
    }

}
