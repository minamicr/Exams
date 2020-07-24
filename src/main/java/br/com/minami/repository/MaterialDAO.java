package br.com.minami.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.minami.model.Material;

public interface MaterialDAO extends CrudRepository<Material, Long> {

}
