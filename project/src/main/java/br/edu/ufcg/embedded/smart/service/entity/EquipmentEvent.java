package br.edu.ufcg.embedded.smart.service.entity;

import br.edu.ufcg.embedded.smart.domain.entity.Equipment;
import br.edu.ufcg.embedded.smart.domain.entity.FactoryProcess;

public class EquipmentEvent implements IDomainEvent<EquipmentEvent, Equipment> {

	private String id;
	private String name;
	private FactoryProcess process;

	public EquipmentEvent(String id, String name, FactoryProcess process) {
		setId(id);
		setName(name);
		setProcess(process);
	}

	public EquipmentEvent() {
	};

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FactoryProcess getProcess() {
		return process;
	}

	public void setProcess(FactoryProcess process) {
		this.process = process;
	}

	public static EquipmentEvent toEvent(Equipment model) {
		if (model == null)
			return null;
		return new EquipmentEvent(model.getId(), model.getName(),
				model.getProcess());
	}

	@Override
	public Equipment toDomain() {
		return new Equipment(getId(), getName(), getProcess());
	}

}
