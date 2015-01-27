package br.edu.ufcg.embedded.smart.service.entity;

public class CapabilityEvent {

	private String productId;
	private Integer capability;
	private boolean added;

	public CapabilityEvent(){};
	
	public CapabilityEvent(String productId, Integer capability) {
		setProductId(productId);
		setCapability(capability);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getCapability() {
		return capability;
	}

	public void setCapability(Integer capability) {
		this.capability = capability;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}
}
