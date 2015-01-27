package br.edu.ufcg.embedded.smart.domain.entity;

import java.util.HashMap;
import java.util.Map;

public class Equipment {

	private String id;
	private String name;
	private FactoryProcess process;
	private Map<Product, Integer> capabilities;
	
	public Equipment(){
		capabilities = new HashMap<Product, Integer>();
	}
	
	public Equipment(String id, String name, FactoryProcess process) {
		setId(id);
		setName(name);
		setProcess(process);
		capabilities = new HashMap<Product, Integer>();
	}

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

	public Map<Product, Integer> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Map<Product, Integer> capabilities) {
		this.capabilities = capabilities;
	}
	
}
