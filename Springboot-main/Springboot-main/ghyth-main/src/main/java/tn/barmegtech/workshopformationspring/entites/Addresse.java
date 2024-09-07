package tn.barmegtech.workshopformationspring.entites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Addresse {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	private String rue;
	private String zip;
	private String ville;
	@OneToOne(mappedBy = "addresse")
	@JsonIgnore
	private Employee employee;
	
	
	

}
