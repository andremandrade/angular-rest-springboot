package br.edu.ufcg.embedded.smart.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.embedded.smart.service.EquipmentService;
import br.edu.ufcg.embedded.smart.service.entity.CapabilityEvent;
import br.edu.ufcg.embedded.smart.service.entity.EquipmentEvent;
import br.edu.ufcg.embedded.smart.service.exception.EquipmentServiceException;

@RestController
@RequestMapping("/rest/v1/equip/")
public class EquimentQueryController {

	@Autowired
	EquipmentService equipmentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EquipmentEvent>> getAll() {
		return new ResponseEntity<List<EquipmentEvent>>(
				equipmentService.getAllEquipments(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<EquipmentEvent> getById(@PathVariable String id) {
		EquipmentEvent equipmentEvent = equipmentService.getEquipmentById(id);
		return equipmentEvent == null ? new ResponseEntity<EquipmentEvent>(
				HttpStatus.NOT_FOUND) : new ResponseEntity<EquipmentEvent>(
				equipmentEvent, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/capability/")
	public ResponseEntity<List<CapabilityEvent>> getCapabilities(
			@PathVariable String id) {
		try {
			return new ResponseEntity<List<CapabilityEvent>>(
					equipmentService.getCapabilityByEquipmentId(id), HttpStatus.OK);
		} catch (EquipmentServiceException e) {
			e.printStackTrace();
			return new ResponseEntity<List<CapabilityEvent>>(HttpStatus.NOT_FOUND);
		}

	}
}
