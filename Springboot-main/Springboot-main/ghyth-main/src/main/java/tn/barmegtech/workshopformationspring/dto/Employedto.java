package tn.barmegtech.workshopformationspring.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.barmegtech.workshopformationspring.entites.Employee;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employedto {
	private Long id;

   @Size(min = 3, max = 20)
	 @NotEmpty(message = "le fullName doit etre not empty")
   @NotBlank(message = "le fullName doit etre not ....")
	private String fullname;
   private String img;
	private Long age;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateRecrutement;
	private Long iddept;

	private AddresseDtO addrdto;
	private Set<Long> compts;

	public static Employee toentity(Employedto emp) {
		return Employee.builder()

				.fullname(emp.getFullname())
				.age(emp.getAge())
				.img(emp.getImg())
				.dateRecrutement(emp.getDateRecrutement())
				.addresse(AddresseDtO.toentity(emp.getAddrdto())).build();

	}

	public static Employedto fromentity(Employee emp) {
		return Employedto.builder().id(emp.getId())
				.img(emp.getImg())
				.fullname(emp.getFullname()).age(emp.getAge())
				.dateRecrutement(emp.getDateRecrutement()).addrdto(AddresseDtO.fromentity(emp.getAddresse())).build();

	}
}
