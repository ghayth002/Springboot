package tn.barmegtech.workshopformationspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tn.barmegtech.workshopformationspring.entites.Role;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class RegisterRequeste {
	private Long id;
	private String fullname;
	private String email;
	private String password;
	private Long age;
	private Role role;
	private boolean activate;
}
