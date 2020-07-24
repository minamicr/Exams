package br.com.minami.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.minami.model.Gender;

public interface GenderDAO extends PagingAndSortingRepository <Gender, Integer> {

}
