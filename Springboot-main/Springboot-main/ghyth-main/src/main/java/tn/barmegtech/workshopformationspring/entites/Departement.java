package tn.barmegtech.workshopformationspring.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String responsable;
@OneToMany(mappedBy = "departement")
@JsonIgnore
private List<Employee> emps;
}
