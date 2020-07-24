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
import br.com.minami.model.ExamStatus;
import br.com.minami.repository.ExamStatusDAO;

@RestController
@RequestMapping("exams/examStatus")
public class ExamStatusRest {
	private final ExamStatusDAO examStatusDAO;
	
	@Autowired
	public ExamStatusRest(ExamStatusDAO examStatusDAO) {
		this.examStatusDAO = examStatusDAO;
	}

	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<> (examStatusDAO.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ExamStatus examStatus){
		return new ResponseEntity<> (examStatusDAO.save(examStatus), HttpStatus.OK);
	}
	
	@GetMapping (path="/{id}")
	public ResponseEntity<?> getExamStatusById(@PathVariable Long id){
		examStatusExists(id);
		Optional<ExamStatus> examStatus = examStatusDAO.findById(id);
		return new ResponseEntity<> (examStatus, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ExamStatus examStatus){
		examStatusExists(examStatus.getExamPatientId());
		return new ResponseEntity<> (examStatusDAO.save(examStatus), HttpStatus.OK);
	}
	
	@DeleteMapping (path="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		examStatusExists(id);
		examStatusDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void examStatusExists(Long id) {
		Optional<ExamStatus> examStatus = examStatusDAO.findById(id);
		if (examStatus == null || !examStatus.isPresent()) {
			throw new ResourceNotFoundException("Status do exame não encontrado !");
		}
	}
}
