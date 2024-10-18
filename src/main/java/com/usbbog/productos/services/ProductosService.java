package com.usbbog.productos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.usbbog.productos.entities.ProductosEntity;

@Service
public class ProductosService {
	
	private List<ProductosEntity> products = new ArrayList<>();
	
	public ProductosService() {
		products.add(new ProductosEntity(UUID.randomUUID(), "Arroz", 10, 3500.0f, true));
		products.add(new ProductosEntity(UUID.randomUUID(), "Frijoles", 8, 4500.0f, true));
		products.add(new ProductosEntity(UUID.randomUUID(), "Aceite", 5, 12000.0f, true));
		products.add(new ProductosEntity(UUID.randomUUID(), "Azúcar", 15, 3200.0f, true));
		products.add(new ProductosEntity(UUID.randomUUID(), "Sal", 20, 2500.0f, true));
		products.add(new ProductosEntity(UUID.randomUUID(), "Harina", 12, 4000.0f, true));
	}
	
	public List<ProductosEntity> getAllProducts(){
		return products;
	}
	
	public Optional<ProductosEntity> getProductById(UUID id){
		return products.stream().filter(product -> product.getId().equals(id)).findFirst();
	}
	
	public String createProduct(Map<String, Object> newProduct){
		try {
			ProductosEntity newP = new ProductosEntity(
					UUID.randomUUID(), 
					newProduct.get("name").toString(), 
					Integer.parseInt(newProduct.get("stock").toString()), 
					Float.parseFloat(newProduct.get("price").toString()), 
					Boolean.parseBoolean(newProduct.get("state").toString()));
			products.add(newP);
			return "Producto Creado con Exito!!";
		}catch(Exception e){
			return "Ocurrió un error al crear el producto: "+e.toString();
		}
	}
	
	public String updateProduct(UUID id, Map<String, Object> newItems){
		try {
			for (ProductosEntity producto : products) {
		        if (producto.getId().equals(id)) {
		        	producto.setProductName(newItems.get("name").toString());
		        	producto.setProductPrice(Float.parseFloat(newItems.get("price").toString()));
		        	producto.setProductState(Boolean.parseBoolean(newItems.get("state").toString()));
		        	producto.setProductStock(Integer.parseInt(newItems.get("stock").toString()));
		        	return "Producto Actualizado con Exito!!";
		        }
		    }
			return "No se encuentra ningún producto con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Actualizar el producto: "+e.toString();
		}
	}
	
	public String deleteProduct(UUID id){		
		try {
			for (ProductosEntity producto : products) {
		        if (producto.getId().equals(id)) {
		        	products.remove(producto);
		        	return "Producto Eliminado con Exito!!";
		        }
		    }
			return "No se encuentra ningún producto con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Eliminar el producto: "+e.toString();
		}
	}

}
