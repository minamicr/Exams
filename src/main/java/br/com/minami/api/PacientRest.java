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
import br.com.minami.model.Pacient;
import br.com.minami.repository.PacientDAO;

@RestController
@RequestMapping("exams/pacient")
public class PacientRest {
	private final PacientDAO pacientDAO;
	
	@Autowired
	public PacientRest(PacientDAO pacientDAO) {
		this.pacientDAO = pacientDAO;
	}

	private void pacientExists(Long id) {
		Optional<Pacient> pacient = pacientDAO.findById(id);
		if (pacient == null || !pacient.isPresent()) {
			throw new ResourceNotFoundException("Paciente não encontrado !");
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(pacientDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPacientById(@PathVariable Long id){
		pacientExists(id);
		return new ResponseEntity<>(pacientDAO.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Pacient pacient){
		return new ResponseEntity<>(pacientDAO.save(pacient), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Pacient pacient){
		pacientExists(pacient.getPacientId());
		return new ResponseEntity<>(pacientDAO.save(pacient), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pacientExists(id);
		pacientDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
