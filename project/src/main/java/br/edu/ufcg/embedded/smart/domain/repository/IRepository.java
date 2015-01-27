package br.edu.ufcg.embedded.smart.domain.repository;

import java.util.List;
import java.util.Map;

import br.edu.ufcg.embedded.smart.domain.repository.exception.ObjectNotPersistableException;

public interface IRepository<T> {

	T getById(String id);

	List<T> get(Map<String, String> filter);

	void create(T object) throws ObjectNotPersistableException;

	void update(T object) throws ObjectNotPersistableException;

	void delete(T object);

}
