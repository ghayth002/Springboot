package tn.barmegtech.workshopformationspring.entites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Competences {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String titreCopmt;
	private String gradCompt;
	@ManyToMany(mappedBy = "competencs")
	@JsonIgnore
	private List<Employee> empls;

}
