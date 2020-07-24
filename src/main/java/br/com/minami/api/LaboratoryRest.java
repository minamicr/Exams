package br.com.minami.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.minami.model.Laboratory;
import br.com.minami.repository.LaboratoryDAO;

@RestController
@RequestMapping("exams/laboratory")
public class LaboratoryRest {
	
	private final LaboratoryDAO laboratoryDAO;
	
	@Autowired
	public LaboratoryRest(LaboratoryDAO laboratoryDAO) {
		this.laboratoryDAO = laboratoryDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<> (laboratoryDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getLaboratoryById(@PathVariable Long id){
		laboratoryExists(id);
		Optional<Laboratory> laboratory = laboratoryDAO.findById(id);  
		return new ResponseEntity<>(laboratory, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Laboratory laboratory) {
		return new ResponseEntity<>(laboratoryDAO.save(laboratory), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Laboratory laboratory) {
		laboratoryExists(laboratory.getId());
		return new ResponseEntity<>(laboratoryDAO.save(laboratory), HttpStatus.OK);
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		laboratoryExists(id);
		laboratoryDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void laboratoryExists (Long id) {
		Optional<Laboratory> laboratory = laboratoryDAO.findById(id);
		if (laboratory == null || !laboratory.isPresent()) {
			throw new ResourceNotFoundException("Laboratório não encontrado !");
		}
	}
}





