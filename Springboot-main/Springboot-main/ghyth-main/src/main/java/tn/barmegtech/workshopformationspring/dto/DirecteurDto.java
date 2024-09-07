package tn.barmegtech.workshopformationspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import tn.barmegtech.workshopformationspring.entites.Directeur;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class DirecteurDto extends RegisterRequeste {
    private String direction;
    public static Directeur Toentite(DirecteurDto directeurDto)
    {
        return Directeur.builder()
                .id(directeurDto.getId())
                .fullname(directeurDto.getFullname())
                .email(directeurDto.getEmail())
                .password(directeurDto.getPassword())
                .direction(directeurDto.getDirection())
                .build();
    }
    public static DirecteurDto fromentite(Directeur dir)
    {
        return DirecteurDto.builder()
                .id(dir.getId())
                .fullname(dir.getFullname())
                .email(dir.getEmail())
                .password(dir.getPassword())
                .direction(dir.getDirection())
                .build();
    }
}