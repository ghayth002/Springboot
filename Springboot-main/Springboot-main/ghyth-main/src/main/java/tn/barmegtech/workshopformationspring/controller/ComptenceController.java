package tn.barmegtech.workshopformationspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import tn.barmegtech.workshopformationspring.dto.Competencesdto;
import tn.barmegtech.workshopformationspring.dto.Labelvalue;
import tn.barmegtech.workshopformationspring.servics.CompetencesService;
import tn.barmegtech.workshopformationspring.servics.Departementserv;

@RestController
@RequestMapping("/api/v1/competence")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ComptenceController {
	private final CompetencesService competencesService;
@PostMapping("/ajout-comp")
	public Competencesdto ajouter(@RequestBody Competencesdto depdto) {
		return competencesService.ajouter(depdto);
	}
@DeleteMapping("/delete/{id}")
	public void deletbyid(@PathVariable Long id) {
		competencesService.deletbyid(id);
	}
@PutMapping("/update-comp")
	public Competencesdto metreajour(@RequestBody Competencesdto depdto) {
		return competencesService.metreajour(depdto);
	}
	@GetMapping("/get/{id}")
	public Competencesdto findbyid(@PathVariable Long id) {
		return competencesService.findbyid(id);
	}
@GetMapping("/listerr")
	public List<Competencesdto> lister() {
		return competencesService.lister();
	}
@GetMapping("/lister/{key}")
	public List<Competencesdto> chercherparnom(@PathVariable  String key) {
		return competencesService.chercherparnom(key);
			
	}
	@GetMapping("/listerServicesdto")
	public List<Labelvalue> listeStagiairDto() {
		// TODO Auto-generated method stub
		return competencesService.listeServicesDto();
	}


}
