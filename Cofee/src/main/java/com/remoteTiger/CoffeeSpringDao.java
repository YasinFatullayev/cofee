package com.remoteTiger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.mysql.jdbc.Connection;


import CoffeeModel.Model;
import CoffeeDaoInterfaces.CoffeeDAOInt;

public class CoffeeSpringDao implements CoffeeDAOInt {
	
	
	private DataSource datasource;
	private Model model;
	
	
	
	public void setModel(Model model) {
		this.model = model;
	}




	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}



	
	public void addCoffee(Model model){
		
	
	
		
		java.sql.Connection dbConnection = null;
		PreparedStatement statement = null;
		

		String sql = "insert into coffee1 values(" + "'" + model.getPRODUCT_NO()
				+ "','" + model.getQuantity() + "','" + model.getName()
				+ "','" + model.getCountry() + "'" + ")";

		try {
			
			dbConnection = datasource.getConnection();
			statement = dbConnection.prepareStatement(sql);
			statement.executeUpdate(sql);

			System.out
					.println("Record is inserted into Coffee table for  coffee : "
							+ model.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	@Override
	public List<Model> getCoffee() {
		
		java.sql.Connection dbConnection = null;
		PreparedStatement stmt = null;
		
		System.out.println("cofee Dao working");

		ResultSet rs = null;
		String query = "SELECT * FROM coffee1";
		List<Model> Coffeelist = new ArrayList<Model>();
		try {
			dbConnection = datasource.getConnection();
			stmt = dbConnection.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Model cfe = new Model();
				cfe.setName(rs.getString("name"));
				cfe.setPRODUCT_NO(rs.getInt("PRODUCT_NO"));
				cfe.setQuantity(rs.getInt("quantity"));
				cfe.setCountry(rs.getString("country"));
				Coffeelist.add(cfe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return Coffeelist;
	}	
}
