package br.edu.ufcg.embedded.smart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.embedded.smart.domain.entity.Product;
import br.edu.ufcg.embedded.smart.domain.repository.ProductRepository;
import br.edu.ufcg.embedded.smart.domain.repository.exception.ObjectNotPersistableException;
import br.edu.ufcg.embedded.smart.service.entity.ProductEvent;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public ProductEvent createProduct(ProductEvent productEvent) {
		Product product = productEvent.toDomain();
		try {
			productRepository.create(product);
		} catch (ObjectNotPersistableException e) {
			e.printStackTrace();
			return null;
		}
		return ProductEvent.toEvent(product);
	}

	public List<ProductEvent> getProducts(HashMap<String, String> filtro) {
		List<ProductEvent> productEvents = new ArrayList<ProductEvent>();
		for (Product product : productRepository.get(filtro)) {
			productEvents.add(ProductEvent.toEvent(product));
		}
		return productEvents;
	}

	public List<ProductEvent> getAllProducts() {
		return getProducts(null);
	}

}
