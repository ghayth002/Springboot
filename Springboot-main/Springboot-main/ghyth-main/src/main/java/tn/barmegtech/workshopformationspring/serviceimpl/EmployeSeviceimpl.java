package tn.barmegtech.workshopformationspring.serviceimpl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import tn.barmegtech.workshopformationspring.configimage.ImageStorage;
import tn.barmegtech.workshopformationspring.dto.AddresseDtO;
import tn.barmegtech.workshopformationspring.dto.Employedto;
import tn.barmegtech.workshopformationspring.entites.Addresse;
import tn.barmegtech.workshopformationspring.entites.Competences;
import tn.barmegtech.workshopformationspring.entites.Departement;
import tn.barmegtech.workshopformationspring.entites.Employee;
import tn.barmegtech.workshopformationspring.repository.AddresseRepository;
import tn.barmegtech.workshopformationspring.repository.CompetencesRepository;
import tn.barmegtech.workshopformationspring.repository.DepartementRepos;
import tn.barmegtech.workshopformationspring.repository.EmployeRepository;
import tn.barmegtech.workshopformationspring.servics.EmployeSevice;
import tn.barmegtech.workshopformationspring.validation.ObjectsValidator;



@Service
@RequiredArgsConstructor
public class EmployeSeviceimpl implements EmployeSevice {
	private final EmployeRepository employeRepository;
	private final DepartementRepos departementRepos;
	private final AddresseRepository addresseRepository;
	private final CompetencesRepository competencesRepository;
	 private final   ObjectsValidator<Employedto> objectsValidator;
	 private final   ObjectsValidator<AddresseDtO> objectsValidatoradr;
	 private final ImageStorage imageStorage;
	 @Override
	public Employedto ajouter(Employedto empdto) {
		System.err.println(empdto.getFullname());
		objectsValidator.validate(empdto);
		Employee emp = Employedto.toentity(empdto);
		System.err.println(emp.getFullname());
		
      
		Optional<Departement> optiodep = departementRepos.findById(empdto.getIddept());
		if (optiodep.isPresent()) {
			objectsValidatoradr.validate(empdto.getAddrdto());
			Addresse adrss = AddresseDtO.toentity(empdto.getAddrdto());
			Addresse addsaved = addresseRepository.save(adrss);
			emp.setAddresse(addsaved);
			emp.setDepartement(optiodep.get());
			Set<Long> intcompts= empdto.getCompts();
	        Set<Competences> compset = new HashSet<>();
	        intcompts.forEach(ids -> {
	        	Competences compsetbyid = competencesRepository.findById(ids)
	                    .orElseThrow(() -> new RuntimeException("not found."));
	        	compset.add(compsetbyid);

	            
	    });
	        emp.setCompetencs(compset);
			Employee empsaved = employeRepository.save(emp);
			Employedto empsaveddto = Employedto.fromentity(empsaved);
			return empsaveddto;
		}

		else {
			throw new RuntimeException("no dept");
		}

	}
	


	@Override
	public void deletbyid(Long id) {
		Optional<Employee> optemp = employeRepository.findById(id);
		if (optemp.isPresent()) {
			employeRepository.deleteById(id);

		} else {
			throw new RuntimeException(" not exist" + id);

		}

	}

	@Override
	public Employedto metreajour(Employedto empdto) {
		Optional<Employee> optemp = employeRepository.findById(empdto.getId());
		if (optemp.isPresent()) {
			optemp.get().setFullname(empdto.getFullname());
			optemp.get().setAge(empdto.getAge());
			optemp.get().setDateRecrutement(empdto.getDateRecrutement());
			Optional<Departement> optiodep = departementRepos.findById(empdto.getIddept());
			if (optiodep.isPresent()) {
				optemp.get().setDepartement(optiodep.get());
			} else {
				throw new RuntimeException("no dept");
			}
			objectsValidatoradr.validate(empdto.getAddrdto());
			Addresse adrss = AddresseDtO.toentity(empdto.getAddrdto());
			Addresse addsaved = addresseRepository.save(adrss);
			optemp.get().setAddresse(addsaved);
			Set<Long> intcompts= empdto.getCompts();
	        Set<Competences> compset = new HashSet<>();
	        intcompts.forEach(ids -> {
	        	Competences compsetbyid = competencesRepository.findById(ids)
	                    .orElseThrow(() -> new RuntimeException("not found."));
	        	compset.add(compsetbyid);


	    });
	        optemp.get().setCompetencs(compset);
			return Employedto.fromentity(employeRepository.save(optemp.get()));
		} else {
			throw new RuntimeException(" not exist" + empdto.getId());

		}
	}

	@Override
	public Employedto findbyid(Long id) {
		Optional<Employee> optemp = employeRepository.findById(id);
		if (optemp.isPresent()) {
			return Employedto.fromentity(optemp.get());

		} else {
			throw new RuntimeException(" not exist" + id);

		}
	}

	@Override
	public List<Employedto> lister() {
		return employeRepository.findAll().stream().map(Employedto::fromentity).collect(Collectors.toList());
	}
	@Override
	public List<Employee> employees() {
		return employeRepository.findAll();
	}


	@Override
	public List<Employee> chercherparnom(String key) {
		return employeRepository.findemployebyname(key);
	}

	@Override
	public List<Employee> chercherparRespEmp(String key) {
		// TODO Auto-generated method stub
		return employeRepository.findemployebymanager(key);
	}
	 public ResponseEntity<Employee> findbyId(Long id) {
	        if (id == null) {
	          //  log.error("student ID is null");
	            return null;
	        }
	        return ResponseEntity.ok(employeRepository.findById(id).get());
	                
	    }
	@Override
	public Employee uploadImageEmployee(Long empId, MultipartFile image) {
		 ResponseEntity<Employee> employeeResponse = this.findbyId(empId);
	        String imageName=imageStorage.store(image);
	        String fileImageDownloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/employe/downloadempltImage/").path(imageName).toUriString();
	        Employee empl = employeeResponse.getBody();
	        if (empl!=null)
	        	empl.setImg(fileImageDownloadUrl);
	        return employeRepository.save(empl);
	}
	@Override
	public List<Employee> findByDate(Date startDate, Date endDate) {
		return employeRepository.findBydate(startDate, endDate);
	}

}
