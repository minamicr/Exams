package br.com.minami.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.minami.model.Exam;

public interface ExamDAO extends CrudRepository<Exam, Long> {

}
