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
import br.com.minami.model.ExamResult;
import br.com.minami.repository.ExamResultDAO;

@RestController
@RequestMapping("exams/examresult")
public class ExamResultRest {

	private final ExamResultDAO examResultDAO;
	
	@Autowired
	public ExamResultRest(ExamResultDAO examResultDAO) {
		this.examResultDAO = examResultDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(examResultDAO.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save (@RequestBody ExamResult examResult) {
		return new ResponseEntity<> (examResultDAO.save(examResult), HttpStatus.OK);
	}
	
	@GetMapping (path="/{id}")
	public ResponseEntity<?> getExamResultById(@PathVariable Long id){
		examResultExists(id);
		Optional<ExamResult> examResult = examResultDAO.findById(id);
		return new ResponseEntity<>(examResult, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ExamResult examResult){
		examResultExists(examResult.getExamId());
		return new ResponseEntity<>(examResultDAO.save(examResult), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable Long id) {
		examResultExists(id);
		examResultDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void examResultExists(Long id) {
		Optional<ExamResult> examResult = examResultDAO.findById(id);
		
		if (examResult == null || !examResult.isPresent()) {
			throw new ResourceNotFoundException("Resulta do exame não encontrado !");
		}
		
	}
}
