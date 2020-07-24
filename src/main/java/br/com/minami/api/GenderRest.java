package br.com.minami.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minami.error.ResourceNotFoundException;
import br.com.minami.model.Gender;
import br.com.minami.repository.GenderDAO;

@RestController
@RequestMapping("v1")
public class GenderRest {
	
	private final GenderDAO genderDAO;
	
	@Autowired
	public GenderRest(GenderDAO genderDAO) {
		this.genderDAO = genderDAO;
	}

	@GetMapping (path="protected/exams/gender")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<> (genderDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping (path="admin/exams/gender")
	public ResponseEntity<?> save(@RequestBody Gender gender) {
		return new ResponseEntity<>(genderDAO.save(gender), HttpStatus.OK);
	}
	
	@GetMapping (path="protected/exams/gender/{id}")
	public ResponseEntity<?> getGenderById(@PathVariable Integer id){
		genderExists(id);
		Optional<Gender> gender = genderDAO.findById(id);
		return new ResponseEntity<>(gender, HttpStatus.OK);
	}
	
	@PutMapping (path="admin/exams/gender")
	public ResponseEntity<?> update(@RequestBody Gender gender) {
		genderExists(gender.getGenderId());
		return new ResponseEntity<>(genderDAO.save(gender), HttpStatus.OK);
		
	}
	
	@DeleteMapping (path="admin/exams/gender/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		genderExists(id);
		genderDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void genderExists(Integer id) {
		Optional<Gender> gender = genderDAO.findById(id);
		if (gender == null || !gender.isPresent()) {
			throw new ResourceNotFoundException("Gênero não encontrado !");
		}
	}
}
