package tn.barmegtech.workshopformationspring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.barmegtech.workshopformationspring.dto.Departementdto;

import tn.barmegtech.workshopformationspring.servics.Departementserv;


import java.util.List;

@RestController
@RequestMapping("/api/v1/departement")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class Departementcontroller {
    private final Departementserv departementserv;
    @PostMapping("/savedep")
    public Departementdto ajouter(@RequestBody Departementdto depdto) {
        return departementserv.ajouter(depdto);
    }
    @DeleteMapping("/deletdep/{id}")
    public void deletbyid(@PathVariable("id") Long id) {
        departementserv.deletbyid(id);
    }
    @PostMapping("/updatedep")
    public Departementdto metreajour(@RequestBody Departementdto depdto) {
        return departementserv.metreajour(depdto);
    }
    @GetMapping("/findbyid/{id}")
    public Departementdto findbyid(@PathVariable("id") Long id) {
        return departementserv.findbyid(id);
    }
    @GetMapping("/lister")
    public List<Departementdto> lister() {
        return departementserv.lister();
    }
    @GetMapping("/listerr/{key}")
    public List<Departementdto> chercherparnom(@PathVariable("key") String key) {
        return departementserv.chercherparnom(key);
    }


}


