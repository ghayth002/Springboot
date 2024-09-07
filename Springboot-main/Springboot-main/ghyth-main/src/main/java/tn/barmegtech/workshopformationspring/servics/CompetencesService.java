package tn.barmegtech.workshopformationspring.servics;

import java.util.List;

import tn.barmegtech.workshopformationspring.dto.Competencesdto;
import tn.barmegtech.workshopformationspring.dto.Labelvalue;

public interface CompetencesService {
	Competencesdto ajouter(Competencesdto depdto);
    void deletbyid(Long id);
    Competencesdto metreajour(Competencesdto depdto);
    Competencesdto findbyid(Long id);
    List<Competencesdto> lister();
    List<Competencesdto> chercherparnom(String key);

    List<Labelvalue> listeServicesDto();
}
