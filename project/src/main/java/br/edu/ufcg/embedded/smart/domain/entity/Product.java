package br.edu.ufcg.embedded.smart.domain.entity;

import java.util.List;

public class Product {

	private String id;
	private String name;
	private String density;
	private String parcialNumber;
	private List<FactoryProcess> factoryProcess;

	public Product(String id, String name, String density,
			String parcialNumber) {
		setId(id);
		setName(name);
		setDensity(density);
		setParcialNumber(parcialNumber);
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

	public String getDensity() {
		return density;
	}

	public void setDensity(String density) {
		this.density = density;
	}

	public String getParcialNumber() {
		return parcialNumber;
	}

	public void setParcialNumber(String parcialNumber) {
		this.parcialNumber = parcialNumber;
	}

	public List<FactoryProcess> getFactoryProcess() {
		return factoryProcess;
	}

	public void setFactoryProcess(List<FactoryProcess> factoryProcess) {
		this.factoryProcess = factoryProcess;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
