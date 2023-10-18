package com.vpereira.dao.generic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vpereira.dao.generic.jdbc.ConnectionFactory;
import com.vpereira.domin.Product;

public class ProductDAO implements IProductDAO {
	
	@Override
	public Integer register(Product product) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = createRegisterSQL();
			stm = connection.prepareStatement(sql);
			addParamRegisterSQL(stm, product);
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}


	@Override
	public Integer update(Product product) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = createUpdateSQL();
			stm = connection.prepareStatement(sql);
			addParamUpdateSQL(stm, product);
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}

	@Override
	public Product search(Long codeProduct) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
    	ResultSet rs = null;
    	Product product = null;
    	System.out.println(product);
		try {
			connection = ConnectionFactory.getConnection();
			String sql = createSearchSQL();
			stm = connection.prepareStatement(sql);
			addParamSearchSQL(stm, codeProduct);
			rs = stm.executeQuery();
			
		    if (rs.next()) {
		    	Long id = rs.getLong("ID");
		    	String name = rs.getString("Name");
		    	String description = rs.getString("Description");
		    	Long code = rs.getLong("Code");
		    	Double price = rs.getDouble("Price");
		    	product = new Product(id, name, description, code, price);
		    	//System.out.println(product);
		    }
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, rs);
		}
		return product;
	}
	
	@Override
	public List<Product> searchAll() throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
    	ResultSet rs = null;
    	List<Product> list = new ArrayList<>();
    	Product product = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = createSearchAllSQL();
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			
		    while (rs.next()) {
		    	Long id = rs.getLong("ID");
		    	String name = rs.getString("Name");
		    	String description = rs.getString("Description");
		    	Long code = rs.getLong("Code");
		    	Double price = rs.getDouble("Price");
		    	product = new Product(id, name, description, code, price);
		    	list.add(product);
		    }
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, rs);
		}
		return list;
	}
	
	@Override
	public Integer delete(Product product) throws Exception {
		Connection connection = null;
    	PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = createDeleteSQL();
			stm = connection.prepareStatement(sql);
			addParamDeleteSQL(stm, product);
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			closeConnection(connection, stm, null);
		}
	}
	
	private String createRegisterSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_product (ID, name, description, code, price) ");
		sb.append("VALUES (nextval('sequence_product'),?,?,?,?)");
		return sb.toString();
	}
	
	private void addParamRegisterSQL(PreparedStatement stm, Product product) throws SQLException {
		stm.setString(1, product.getName());
		stm.setString(2, product.getDescription());
		stm.setLong(3, product.getCode());
		stm.setDouble(4, product.getPrice());
	}
	
	private String createUpdateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tb_product ");
		sb.append("SET Name = ?, Description = ?, code = ?, Price = ? ");
		sb.append("WHERE ID = ?");
		return sb.toString();
	}
	
	private void addParamUpdateSQL(PreparedStatement stm, Product product) throws SQLException {
		stm.setString(1, product.getName());
		stm.setString(2, product.getDescription());
		stm.setLong(3, product.getCode());
		stm.setDouble(4, product.getPrice());
		stm.setLong(5, product.getId());
	}
	
	private String createSearchSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM tb_product ");
		sb.append("WHERE code = ?");
		return sb.toString();
	}
	
	private void addParamSearchSQL(PreparedStatement stm, Long code) throws SQLException {
		stm.setLong(1, code);
	}
	
	private String createSearchAllSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM tb_product");
		return sb.toString();
	}
	
	private String createDeleteSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM tb_product ");
		sb.append("WHERE id = ?");
		return sb.toString();
	}
	
	private void addParamDeleteSQL(PreparedStatement stm, Product product) throws SQLException {
		stm.setLong(1, product.getId());
	}
	
	private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
