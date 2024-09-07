package tn.barmegtech.workshopformationspring.dto;

import java.util.List;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.barmegtech.workshopformationspring.entites.Competences;
import tn.barmegtech.workshopformationspring.entites.Employee;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Competencesdto {
	private Long id;
	private String titreCopmt;
	private String gradCompt;

	public static Competences toentity(Competencesdto emp) {
		return Competences.builder()
				.id(emp.getId())
				.titreCopmt(emp.getTitreCopmt())
				.gradCompt(emp.getGradCompt())
				.build();

	}

	public static Competencesdto fromentity(Competences emp) {
		return Competencesdto.builder()
				.id(emp.getId())
				.titreCopmt(emp.getTitreCopmt())
				.gradCompt(emp.getGradCompt())
				.build();
				

	}
	

}
