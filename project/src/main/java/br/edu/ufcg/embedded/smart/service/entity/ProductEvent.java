package br.edu.ufcg.embedded.smart.service.entity;

import br.edu.ufcg.embedded.smart.domain.entity.Product;

public class ProductEvent implements IDomainEvent<ProductEvent, Product> {

	private String id;
	private String name;
	private String density;
	private String parcialNumber;

	public ProductEvent() {
	}

	public ProductEvent(String id, String name, String density,
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

	@Override
	public Product toDomain() {
		return new Product(getId(), getName(), getDensity(), getParcialNumber());
	}

	public static ProductEvent toEvent(Product product) {
		return new ProductEvent(product.getId(), product.getName(),
				product.getDensity(), product.getParcialNumber());
	}

}
