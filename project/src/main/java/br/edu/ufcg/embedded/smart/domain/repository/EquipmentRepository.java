package br.edu.ufcg.embedded.smart.domain.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ufcg.embedded.smart.domain.entity.Equipment;
import br.edu.ufcg.embedded.smart.domain.repository.exception.ObjectNotPersistableException;

/**
 * Very dummy repository
 * 
 * @author andremeireles
 *
 */
@Repository
public class EquipmentRepository implements IRepository<Equipment> {

	private Map<String, Equipment> dataBase = new HashMap<String, Equipment>();

	@Override
	public List<Equipment> get(Map<String, String> filter) {
		if (filter == null || filter.isEmpty())
			return new ArrayList<Equipment>(dataBase.values());

		// Dummy filter
		return new ArrayList<Equipment>();
	}

	@Override
	public void create(Equipment object) throws ObjectNotPersistableException {
		if(object == null)
			throw new ObjectNotPersistableException("Null object can not be persisted");
		object.setId(UUID.randomUUID().toString());
		dataBase.put(object.getId(), object);
		System.out.println("Equipment created: " + object.getId());
	}

	@Override
	public void update(Equipment object) throws ObjectNotPersistableException {
		if(object == null)
			throw new ObjectNotPersistableException("Null object can not be persisted");
		if(dataBase.containsKey(object))
			throw new ObjectNotPersistableException("Object not found to update");
		dataBase.put(object.getId(), object);
		System.out.println("Equipment updated: " + object.getId());
	}

	@Override
	public void delete(Equipment object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Equipment getById(String id) {
		return dataBase.get(id);
	}


}
