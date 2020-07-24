package br.com.minami.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.minami.model.Pacient;

public interface PacientDAO extends CrudRepository<Pacient, Long>{

}
