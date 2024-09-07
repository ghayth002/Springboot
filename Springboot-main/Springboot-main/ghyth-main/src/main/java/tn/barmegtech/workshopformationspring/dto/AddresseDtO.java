package tn.barmegtech.workshopformationspring.dto;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.barmegtech.workshopformationspring.entites.Addresse;
import tn.barmegtech.workshopformationspring.entites.Employee;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddresseDtO {

	private Long id;
	@NotEmpty(message = "la rue doit etre not empty")
	private String rue;
	@NotEmpty(message = "le zip doit etre not empty")
	private String zip;
	@NotEmpty(message = " ville doit etre not empty")
	private String ville;
	private Employedto employeedto;
	
	public static Addresse toentity(AddresseDtO emp )
	{
		return Addresse.builder()
		.rue(emp.getRue())
		.zip(emp.getZip())
		.ville(emp.getVille())
		//.employee(Employedto.toentity(emp.getEmployeedto()))
		.build();
		
	}	
	public static AddresseDtO fromentity(Addresse emp )
	{
		return AddresseDtO.builder()
				.rue(emp.getRue())
				.zip(emp.getZip())
				.ville(emp.getVille())
				//.employeedto(Employedto.fromentity(emp.getEmployee()))
				.build();
		
		
		
	}	
	
}
