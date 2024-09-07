package tn.barmegtech.workshopformationspring.entites;

import java.util.Date;
import java.util.List;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DiscriminatorValue("EMPLOYEE")
public class Employee  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long age;
	private String fullname;
	private String img;
	private String Poste;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateRecrutement;
	@ManyToOne()

	private Departement departement;
	@OneToOne()

	private Addresse addresse;
	@ManyToMany()
	private Set<Competences> competencs;

}
