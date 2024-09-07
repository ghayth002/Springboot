package tn.barmegtech.workshopformationspring.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.barmegtech.workshopformationspring.dto.Departementdto;
import tn.barmegtech.workshopformationspring.dto.Employedto;
import tn.barmegtech.workshopformationspring.entites.Departement;

import tn.barmegtech.workshopformationspring.repository.DepartementRepos;
import tn.barmegtech.workshopformationspring.servics.Departementserv;
import tn.barmegtech.workshopformationspring.validation.ObjectsValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartementServimpl  implements Departementserv {
    private final DepartementRepos departementRepos;
    private final   ObjectsValidator<Departementdto> objectsValidator;
    @Override
    public Departementdto ajouter(Departementdto depdto) {
    	objectsValidator.validate(depdto);
        Departement dep= Departementdto.toentity(depdto);
        Departement depsaved=departementRepos.save(dep);
        Departementdto depsaveddto=Departementdto.fromentity(depsaved);
        return depsaveddto;
    }

    @Override
    public void deletbyid(Long id) {
        Optional<Departement> optdep=departementRepos.findById(id);
        if (optdep.isPresent()) {

            departementRepos.deleteById(id);
        }
        else{
            throw new RuntimeException("Departement n'existe pas" +id);
        }

    }

    @Override
    public Departementdto metreajour(Departementdto depdto) {
        Optional<Departement> optdep =departementRepos.findById(depdto.getId());
        if (optdep.isPresent())
        {
            optdep.get().setNom(depdto.getNom());
            optdep.get().setResponsable(depdto.getResponsable());

            return Departementdto.fromentity(departementRepos.save(optdep.get()));
        }
        else
        {
            throw new RuntimeException(" not exist" + depdto.getId());

        }

    }

    @Override
    public Departementdto findbyid(Long id) {
        Optional<Departement> optdep =departementRepos.findById(id);
        if (optdep.isPresent())
        {
            return Departementdto.fromentity(optdep.get());

        }
        else
        {
            throw new RuntimeException(" not exist" + id);

        }
    }

    @Override
    public List<Departementdto> lister() {
        return departementRepos.findAll().stream().map(Departementdto::fromentity).collect(Collectors.toList());
    }

    @Override
    public List<Departementdto> chercherparnom(String key) {
        return departementRepos.findDepartementByname(key).stream().map(Departementdto::fromentity).collect(Collectors.toList());
    }
}
