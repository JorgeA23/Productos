package com.usbbog.productos.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbbog.productos.entities.ProductosEntity;
import com.usbbog.productos.services.ProductosService;

@RestController
@RequestMapping("/product")
public class ProductosController {
	
	private final ProductosService productosService;
	
	@Autowired
	public ProductosController(ProductosService productosService) {
		this.productosService = productosService;
	}
	
	@GetMapping("/all")
	public List<ProductosEntity> getAllProducts(){
		return productosService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Optional<ProductosEntity> getProduct(@PathVariable UUID id){
		return productosService.getProductById(id);
	}
	
	@PostMapping("/newProduct")
	public String createProduct(@RequestBody Map<String, Object> newPro){
		return productosService.createProduct(newPro);
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable UUID id, @RequestBody Map<String, Object> newItems){
		return productosService.updateProduct(id,newItems);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable UUID id){
		return productosService.deleteProduct(id);
	}

}
