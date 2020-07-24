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
import br.com.minami.model.Material;
import br.com.minami.repository.MaterialDAO;

@RestController
@RequestMapping("exams/material")
public class MaterialRest {
	private final MaterialDAO materialDAO;
	
	@Autowired
	public MaterialRest(MaterialDAO materialDAO) {
		this.materialDAO = materialDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(materialDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getMaterialById(@PathVariable Long id){
		materialExists(id);
		return new ResponseEntity<>(materialDAO.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save (@RequestBody Material material){
		materialExists(material.getMaterialId());
		return new ResponseEntity<>(materialDAO.save(material), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Material material) {
		materialExists(material.getMaterialId());
		return new ResponseEntity<>(materialDAO.save(material), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		materialExists(id);
		materialDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	private void materialExists(Long id) {
		Optional<Material> material = materialDAO.findById(id);
		if (material == null || !material.isPresent()) {
			throw new ResourceNotFoundException("Material não encontrado !");
		}
	}
}
