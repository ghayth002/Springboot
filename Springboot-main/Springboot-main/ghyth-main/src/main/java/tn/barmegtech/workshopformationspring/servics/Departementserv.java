package tn.barmegtech.workshopformationspring.servics;

import tn.barmegtech.workshopformationspring.dto.Departementdto;

import java.util.List;

public interface Departementserv {
    Departementdto ajouter(Departementdto depdto);
    void deletbyid(Long id);
    Departementdto metreajour(Departementdto depdto);
    Departementdto findbyid(Long id);
    List<Departementdto> lister();
    List<Departementdto> chercherparnom(String key);
}
