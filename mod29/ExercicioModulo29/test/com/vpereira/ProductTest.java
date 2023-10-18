package com.vpereira;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vpereira.dao.generic.jdbc.dao.ProductDAO;
import com.vpereira.dao.generic.jdbc.dao.IProductDAO;
import com.vpereira.domin.Product;

public class ProductTest {
	
	private IProductDAO productDAO;
	
	@Test
	public void registerTest() throws Exception {
		productDAO = new ProductDAO();
		
		Product product = new Product(null,"TV","52 Polegadas", 123l, 50d);
		Integer countCad = productDAO.register(product);
		assertTrue(countCad == 1);
		
		Product productBD = productDAO.search(123l);
		assertNotNull(productBD);
		assertEquals(product.getName(), productBD.getName());
		assertEquals(product.getDescription(), productBD.getDescription());
		assertEquals(product.getPrice(), productBD.getPrice());
		
		Integer countDel = productDAO.delete(productBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void searchTest() throws Exception {
		productDAO = new ProductDAO();
		
		Product product = new Product(null,"TV","52 Polegadas", 123l, 50d);
		Integer countCad = productDAO.register(product);
		assertTrue(countCad == 1);
		
		Product productBD = productDAO.search(123l);
		assertNotNull(productBD);
		assertEquals(product.getName(), productBD.getName());
		assertEquals(product.getDescription(), productBD.getDescription());
		assertEquals(product.getPrice(), productBD.getPrice());
		
		Integer countDel = productDAO.delete(productBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void deleteTest() throws Exception {
		productDAO = new ProductDAO();
		
		Product product = new Product(null,"TV","52 Polegadas", 123l, 50d);
		Integer countCad = productDAO.register(product);
		assertTrue(countCad == 1);
		
		Product productBD = productDAO.search(123l);
		assertNotNull(productBD);
		assertEquals(product.getName(), productBD.getName());
		assertEquals(product.getDescription(), productBD.getDescription());
		assertEquals(product.getPrice(), productBD.getPrice());
		
		Integer countDel = productDAO.delete(productBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void searchAllTest() throws Exception {
		productDAO = new ProductDAO();
		
		Product product = new Product(null,"TV","52 Polegadas", 123l, 50d);
		Integer countCad = productDAO.register(product);
		assertTrue(countCad == 1);
		
		Product product2 = new Product(null,"Monitor","23 Polegadas", 456l, 120d);
		Integer countCad2 = productDAO.register(product2);
		assertTrue(countCad2 == 1);
		
		List<Product> list = productDAO.searchAll();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int countDel = 0;
		for (Product pro : list) {
			productDAO.delete(pro);
			countDel++;
		}
		assertEquals(list.size(), countDel);
		
		list = productDAO.searchAll();
		assertEquals(list.size(), 0);
		
	}
	
	@Test
	public void updateTest() throws Exception {
		productDAO = new ProductDAO();
		
		Product product = new Product(null,"TV","52 Polegadas", 123l, 50d);
		Integer countCad = productDAO.register(product);
		assertTrue(countCad == 1);
		
		Product productBD = productDAO.search(123l);
		System.out.println(productBD);
		assertNotNull(productBD);
		assertEquals(product.getName(), productBD.getName());
		assertEquals(product.getDescription(), productBD.getDescription());
		assertEquals(product.getPrice(), productBD.getPrice());
		
		productBD.setName("Monitor");
		productBD.setDescription("23 Polegadas");
		Integer countUpdate = productDAO.update(productBD);
		System.out.println(countUpdate);
		System.out.println(productBD);
		assertTrue(countUpdate == 1);
		
		Product productUpdate = productDAO.search(123l);
		System.out.println(productUpdate);
		assertNotNull(productUpdate);
		assertEquals(productBD.getName(), productUpdate.getName());
		assertEquals(productBD.getDescription(), productUpdate.getDescription());
		assertEquals(productBD.getPrice(), productUpdate.getPrice());
		
		List<Product> list = productDAO.searchAll();
		for (Product pro : list) {
			productDAO.delete(pro);
		}
	}
}
