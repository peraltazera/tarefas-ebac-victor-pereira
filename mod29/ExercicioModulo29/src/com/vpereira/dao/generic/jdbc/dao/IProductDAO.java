package com.vpereira.dao.generic.jdbc.dao;

import java.util.List;

import com.vpereira.domin.Product;

public interface IProductDAO {
	
	public Integer register(Product product) throws Exception;
	
	public Integer update(Product product) throws Exception;
	
	public Product search(Long codeProduct) throws Exception;
	
	public List<Product> searchAll() throws Exception;
	
	public Integer delete(Product product) throws Exception;
}
