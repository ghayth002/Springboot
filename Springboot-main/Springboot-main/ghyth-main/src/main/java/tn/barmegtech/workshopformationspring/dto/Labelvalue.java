package tn.barmegtech.workshopformationspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tn.barmegtech.workshopformationspring.entites.Competences;
@Builder
@Data
@AllArgsConstructor
public class Labelvalue {


        private Long value;
        private String label;
        public static Labelvalue fromEntity(Competences competences) {
            return Labelvalue.builder()
                    .value(competences.getId())
                    .label(competences.getTitreCopmt())

                    .build();
        }
    }


