package tn.barmegtech.workshopformationspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import tn.barmegtech.workshopformationspring.entites.Responsableadmen;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ResponsableDto extends RegisterRequeste {
    private String grade;

    public static Responsableadmen Toentite(ResponsableDto responsableDto) {
        return Responsableadmen.builder()
                .id(responsableDto.getId())
                .fullname(responsableDto.getFullname())
                .email(responsableDto.getEmail())
                .password(responsableDto.getPassword())
                .grade(responsableDto.getGrade())
                .build();
    }

    public static ResponsableDto fromentite(Responsableadmen responsable) {
        return ResponsableDto.builder()
                .id(responsable.getId())
                .fullname(responsable.getFullname())
                .email(responsable.getEmail())
                .password(responsable.getPassword())
                .grade(responsable.getGrade())
                .build();
    }
}