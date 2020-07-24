package br.com.minami.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.minami.model.ExamStatus;

public interface ExamStatusDAO extends CrudRepository<ExamStatus, Long> {

}
