package br.edu.ufcg.embedded.smart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.embedded.smart.domain.entity.Equipment;
import br.edu.ufcg.embedded.smart.domain.entity.Product;
import br.edu.ufcg.embedded.smart.domain.repository.EquipmentRepository;
import br.edu.ufcg.embedded.smart.domain.repository.ProductRepository;
import br.edu.ufcg.embedded.smart.domain.repository.exception.ObjectNotPersistableException;
import br.edu.ufcg.embedded.smart.service.entity.CapabilityEvent;
import br.edu.ufcg.embedded.smart.service.entity.EquipmentEvent;
import br.edu.ufcg.embedded.smart.service.exception.EquipmentServiceException;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private ProductRepository productRepository;

	public EquipmentEvent createEquipment(EquipmentEvent equipmentEvent) {
		Equipment equipment = equipmentEvent.toDomain();
		try {
			equipmentRepository.create(equipment);
		} catch (ObjectNotPersistableException e) {
			e.printStackTrace();
			return null;
		}
		return EquipmentEvent.toEvent(equipment);
	}

	public List<EquipmentEvent> getEquipments(HashMap<String, String> filtro) {
		List<EquipmentEvent> equipmentEvents = new ArrayList<EquipmentEvent>();
		for (Equipment equipment : equipmentRepository.get(filtro)) {
			equipmentEvents.add(EquipmentEvent.toEvent(equipment));
		}
		return equipmentEvents;
	}

	public List<EquipmentEvent> getAllEquipments() {
		return getEquipments(null);
	}

	public EquipmentEvent getEquipmentById(String id) {
		return EquipmentEvent.toEvent(equipmentRepository.getById(id));
	}

	public EquipmentEvent updateEquipment(EquipmentEvent equipmentEvent) {
		Equipment equipment = equipmentEvent.toDomain();
		try {
			equipmentRepository.update(equipment);
		} catch (ObjectNotPersistableException e) {
			e.printStackTrace();
			return null;
		}
		return EquipmentEvent.toEvent(equipment);
	}

	public CapabilityEvent addCapabilityToEvent(String id,
			CapabilityEvent capabilityEvent) throws EquipmentServiceException {
		Equipment equipment = equipmentRepository.getById(id);
		if (equipment == null)
			throw new EquipmentServiceException(
					"Capability can't be added because equipment was not found.");
		Product product = productRepository.getById(capabilityEvent
				.getProductId());
		if (product == null)
			throw new EquipmentServiceException(
					"Capability can't be added because product was not found.");
		equipment.getCapabilities().put(product,
				capabilityEvent.getCapability());
		capabilityEvent.setAdded(true);
		System.out.println("Capability added. Equipment: " + equipment.getId()
				+ " | Product: " + product.getId() + " | Capability: "
				+ capabilityEvent.getCapability());
		return capabilityEvent;
	}

	public List<CapabilityEvent> getCapabilityByEquipmentId(String id)
			throws EquipmentServiceException {
		Equipment equipment = equipmentRepository.getById(id);
		if (equipment == null)
			throw new EquipmentServiceException(
					"Capability can't be listed because equipment was not found.");
		if (equipment.getCapabilities() == null)
			return null;
		List<CapabilityEvent> capabilityEvents = new ArrayList<CapabilityEvent>();
		for (Entry<Product, Integer> capability : equipment.getCapabilities()
				.entrySet()) {
			capabilityEvents.add(new CapabilityEvent(capability.getKey()
					.getId(), capability.getValue()));
		}
		return capabilityEvents;
	}
}
