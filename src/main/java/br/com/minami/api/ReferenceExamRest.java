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
import br.com.minami.model.ReferenceExam;
import br.com.minami.repository.ReferenceExamDAO;

@RestController
@RequestMapping("exams/referenceExam")
public class ReferenceExamRest {
	private final ReferenceExamDAO referenceExamDAO;
	
	@Autowired
	public ReferenceExamRest(ReferenceExamDAO referenceExamDAO) {
		this.referenceExamDAO = referenceExamDAO;
	}
	
	private void referenceExamExists(Long id) {
		Optional<ReferenceExam> referenceExam = referenceExamDAO.findById(id);
		
		if(referenceExam == null || !referenceExam.isPresent()) {
			throw new ResourceNotFoundException("Referência do exame não encontrada !");
		}
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(referenceExamDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getReferenceExamById(@PathVariable Long id){
		referenceExamExists(id);
		return new ResponseEntity<>(referenceExamDAO.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ReferenceExam referenceExam){
		return new ResponseEntity<>(referenceExamDAO.save(referenceExam), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ReferenceExam referenceExam){
		referenceExamExists(referenceExam.getExamId());
		return new ResponseEntity<>(referenceExamDAO.save(referenceExam), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		referenceExamExists(id);
		referenceExamDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
