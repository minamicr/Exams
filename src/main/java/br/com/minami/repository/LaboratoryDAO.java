package br.com.minami.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.minami.model.Laboratory;

public interface LaboratoryDAO extends CrudRepository<Laboratory, Long> {

}
