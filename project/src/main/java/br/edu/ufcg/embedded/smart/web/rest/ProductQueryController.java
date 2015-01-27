package br.edu.ufcg.embedded.smart.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.embedded.smart.service.ProductService;
import br.edu.ufcg.embedded.smart.service.entity.ProductEvent;

@RestController
@RequestMapping("/rest/v1/product/")
public class ProductQueryController {

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductEvent>> getAll() {
		return new ResponseEntity<List<ProductEvent>>(
				productService.getAllProducts(), HttpStatus.CREATED);
	}
}
