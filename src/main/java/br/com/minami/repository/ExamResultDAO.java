package br.com.minami.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.minami.model.ExamResult;

public interface ExamResultDAO extends CrudRepository<ExamResult, Long> {

}
