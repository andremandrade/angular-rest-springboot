package br.edu.ufcg.embedded.smart.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.embedded.smart.service.EquipmentService;
import br.edu.ufcg.embedded.smart.service.entity.CapabilityEvent;
import br.edu.ufcg.embedded.smart.service.entity.EquipmentEvent;
import br.edu.ufcg.embedded.smart.service.exception.EquipmentServiceException;

@RestController
@RequestMapping("/rest/v1/equip/")
public class EquimentManagerController {

	@Autowired
	EquipmentService equipmentService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EquipmentEvent> create(
			@RequestBody EquipmentEvent equipmentEvent) {
		EquipmentEvent created = equipmentService
				.createEquipment(equipmentEvent);
		return new ResponseEntity<EquipmentEvent>(created, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<EquipmentEvent> update(
			@RequestBody EquipmentEvent equipmentEvent) {
		EquipmentEvent updated = equipmentService
				.updateEquipment(equipmentEvent);
		return updated == null ? new ResponseEntity<EquipmentEvent>(
				HttpStatus.NOT_FOUND) : new ResponseEntity<EquipmentEvent>(
				updated, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/capability/")
	public ResponseEntity<CapabilityEvent> addCapability(
			@PathVariable String id,
			@RequestBody CapabilityEvent capabilityEvent) {
		capabilityEvent.setAdded(false);
		CapabilityEvent added;
		try {
			added = equipmentService.addCapabilityToEvent(id, capabilityEvent);
		} catch (EquipmentServiceException e) {
			e.printStackTrace();
			return new ResponseEntity<CapabilityEvent>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CapabilityEvent>(
				added, HttpStatus.CREATED);
	}
}
