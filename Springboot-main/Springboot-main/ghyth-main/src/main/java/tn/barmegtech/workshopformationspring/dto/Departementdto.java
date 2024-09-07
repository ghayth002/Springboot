package tn.barmegtech.workshopformationspring.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tn.barmegtech.workshopformationspring.entites.Departement;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  Departementdto   {

    private Long id;
    @NotEmpty(message = "le det doit etre not empty")
    private String nom;
    @NotEmpty(message = "le resp doit etre not empty")
    private String responsable;

    public static Departement toentity(Departementdto dep) {
        return Departement.builder()
                .id(dep.getId())
                .nom(dep.getNom())
                .responsable(dep.getResponsable())
                .build();
    }

    public static Departementdto fromentity(Departement dep) {
        return Departementdto.builder()
                .id(dep.getId())
                .nom(dep.getNom())
                .responsable(dep.getResponsable())
                .build();
    }
}

