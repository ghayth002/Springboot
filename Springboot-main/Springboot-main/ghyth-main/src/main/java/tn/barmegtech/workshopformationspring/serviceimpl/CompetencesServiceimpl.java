package tn.barmegtech.workshopformationspring.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.barmegtech.workshopformationspring.dto.Competencesdto;
import tn.barmegtech.workshopformationspring.dto.Labelvalue;
import tn.barmegtech.workshopformationspring.entites.Competences;
import tn.barmegtech.workshopformationspring.repository.CompetencesRepository;
import tn.barmegtech.workshopformationspring.servics.CompetencesService;
import tn.barmegtech.workshopformationspring.validation.ObjectsValidator;

@RequiredArgsConstructor
@Service
public class CompetencesServiceimpl implements CompetencesService{
private final CompetencesRepository competencesRepository;
private final   ObjectsValidator<Competencesdto> objectsValidator;
@Override
public Competencesdto ajouter(Competencesdto compdto) {
	objectsValidator.validate(compdto);
	Competences comp =Competencesdto.toentity(compdto);
	
	Competences compadd=competencesRepository.save(comp);
	Competencesdto compadddto=Competencesdto.fromentity(compadd);
	return compadddto;
}

@Override
public void deletbyid(Long id) {
	Optional<Competences> optcomp=competencesRepository.findById(id);
    if (optcomp.isPresent()) {

    	competencesRepository.deleteById(id);
    }
    else{
        throw new RuntimeException("competences n'existe pas" +id);
    }
	
}

@Override
public Competencesdto metreajour(Competencesdto cmopdto) {
	Competences compfind =competencesRepository.findById(cmopdto.getId()).get();
	compfind.setTitreCopmt(cmopdto.getTitreCopmt());
	compfind.setGradCompt(cmopdto.getGradCompt());
	return Competencesdto.fromentity(competencesRepository.save(compfind));
}

@Override
public Competencesdto findbyid(Long id) {
	Optional<Competences> optcomp=competencesRepository.findById(id);
    if (optcomp.isPresent()) {

    	return Competencesdto.fromentity(optcomp.get());
    }
    else{
        throw new RuntimeException("competences n'existe pas" +id);
    }
	
}

@Override
public List<Competencesdto> lister() {
	// TODO Auto-generated method stub
	return competencesRepository.findAll().stream().map(Competencesdto::fromentity).collect(Collectors.toList());
}

@Override
public List<Competencesdto> chercherparnom(String key) {
	return competencesRepository.findComptByname(key).stream().map(Competencesdto::fromentity).collect(Collectors.toList());
}

	@Override
	public List<Labelvalue> listeServicesDto() {
		return competencesRepository.findAll()
				.stream()
				.map(Labelvalue::fromEntity)
				.collect(Collectors.toList());
	}

}
/*
 	
	@Override
	public MissionDtoSavemany saveMission (MissionDtoSavemany missionDtoSavemany) {
		Mission mission=MissionDtoSavemany.toentitie(missionDtoSavemany);
		/*for(Long id:missionDtoSavemany.getEmployeId()) {
			Employee employee= new Employee();
			employee.setId(id);
			mission.addempl(employee);
		}
	Set<Long> strEmps= missionDtoSavemany.getEmployeesdto();
        Set<Employee> emps = new HashSet<>();
        strEmps.forEach(ids -> {
        	Employee enmp = employeeRepository.findById(ids)
                    .orElseThrow(() -> new RuntimeException("not found."));
            emps.add(enmp);

            
    });
        mission.setEmployees(emps);

		missionRepository.save(mission);
		MissionDtoSavemany MissionDTOsaved=MissionDtoSavemany.fromentitie(mission);
			return MissionDTOsaved;
		}
	*/

