package com.patclinic.patclinic.rest;


import com.patclinic.patclinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.patclinic.patclinic.service.ClinicService;

@RestController
@RequestMapping("api")
public class PetRestController {

    private ClinicService clinicService;
    @Autowired
    public PetRestController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
    @GetMapping("pet/{petId}")
    public ResponseEntity<Pet> getPets(@PathVariable("petId") Integer petId) {
        Pet pet = this.clinicService.findPetById(petId);
        if (pet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }




}
