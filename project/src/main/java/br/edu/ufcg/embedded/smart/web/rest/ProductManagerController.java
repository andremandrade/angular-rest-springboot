package br.edu.ufcg.embedded.smart.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.embedded.smart.service.ProductService;
import br.edu.ufcg.embedded.smart.service.entity.ProductEvent;

@RestController
@RequestMapping("/rest/v1/product/")
public class ProductManagerController {

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProductEvent> create(
			@RequestBody ProductEvent productEvent) {
		ProductEvent created = productService
				.createProduct(productEvent);
		return new ResponseEntity<ProductEvent>(created, HttpStatus.CREATED);
	}
}
