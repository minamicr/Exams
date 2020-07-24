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
import br.com.minami.model.Exam;
import br.com.minami.repository.ExamDAO;

@RestController
@RequestMapping("exams/exam")
public class ExamRest {
	private final ExamDAO examDAO;
	
	@Autowired
	public ExamRest(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<> (examDAO.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Exam exam) {
		return new ResponseEntity<> (examDAO.save(exam), HttpStatus.OK);
	}
	
	@GetMapping (path="/{id}")
	public ResponseEntity<?> getExamById(@PathVariable Long id) {
		examExists(id);
		Optional<Exam> exam = examDAO.findById(id);
		return new ResponseEntity<>(exam, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Exam exam) {
		examExists(exam.getExamId());
		return new ResponseEntity<>(examDAO.save(exam), HttpStatus.OK);
	}
	
	@DeleteMapping (path="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		examExists(id);
		examDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void examExists(Long id) {
		Optional<Exam> exam = examDAO.findById(id);
		if (exam == null || !exam.isPresent()) {
			throw new ResourceNotFoundException("Exame não encontrado !");
		}
	}
	
}
