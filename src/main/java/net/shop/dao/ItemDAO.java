package net.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.shop.connectionManager.ConnectionManager;
import net.shop.model.Item;


public class ItemDAO {

	ConnectionManager con = new ConnectionManager();
	
	private static final String INSERT_ITEM_SQL ="INSERT INTO item (item_id,NAME,price,quantity,employee) VALUES (?,?,?,?,?)";
	private static final String SELECT_ALL_ITEM_BY_ITEM_ID ="SELECT * FROM item WHERE item_id=? ";
	private static final String SELECT_ALL_ITEM_BY_ID ="SELECT * FROM item WHERE id=? ";
	private static final String SELECT_ALL_ITEM ="SELECT * FROM item";
	private static final String DELETE_ITEM_SQL ="DELETE FROM item WHERE id=?";
	private static final String UPDATE_ITEM_SQL ="UPDATE  item SET item_id=? ,NAME=?,price=?,quantity=?,employee=?  WHERE id=?";
	private static final String UPDATE_STOCK_ITEM = "UPDATE item SET quantity = quantity + ?, price = ?, employee = ? WHERE id = ?";
	private static final String UPDATE_STOCK_ITEM_RMV = "UPDATE item SET quantity = quantity - ?, price = ?, employee = ? WHERE id = ?";
	
	
	public boolean UPDATE_STOCK_ITEM_RMV(Item item) throws SQLException {
		boolean rowUpdated = false;
		try(Connection connection = con.getConnection();
			PreparedStatement Statement = connection.prepareStatement(UPDATE_STOCK_ITEM_RMV)){
			Statement.setInt(1, item.getQuantity());
			Statement.setDouble(2, item.getPrice());
			Statement.setString(3, item.getEmployee());
			Statement.setInt(4, item.getId());
			rowUpdated = Statement.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
		
	}
	
	public boolean updateItemFromStock(Item item) throws SQLException {
		boolean rowUpdated = false;
		try(Connection connection = con.getConnection();
			PreparedStatement Statement = connection.prepareStatement(UPDATE_STOCK_ITEM)){
			Statement.setInt(1, item.getQuantity());
			Statement.setDouble(2, item.getPrice());
			Statement.setString(3, item.getEmployee());
			Statement.setInt(4, item.getId());
			rowUpdated = Statement.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
		
	}
	
	//insert Item
		public void insertItem(Item item) throws SQLException {
			try(Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM_SQL)){
				preparedStatement.setInt(1, item.getItem_id());
				preparedStatement.setString(2, item.getName());
				preparedStatement.setDouble(3, item.getPrice());
				preparedStatement.setInt(4, item.getQuantity());
				preparedStatement.setString(5, item.getEmployee());
				preparedStatement.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//update user
		public boolean updateItem(Item item) throws SQLException {
			boolean rowUpdated = false;
			try(Connection connection = con.getConnection();
				PreparedStatement Statement = connection.prepareStatement(UPDATE_ITEM_SQL)){
				Statement.setInt(1, item.getItem_id());
				Statement.setString(2, item.getName());
				Statement.setDouble(3, item.getPrice());
				Statement.setInt(4, item.getQuantity());
				Statement.setString(5, item.getEmployee());
				Statement.setInt(6, item.getId());
				rowUpdated = Statement.executeUpdate() > 0;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return rowUpdated;
			
		}
		
		
		public Item selectItemById(int id_item) {
			Item item = null;
			try {
				Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEM_BY_ID);
				preparedStatement.setInt(1, id_item);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					int item_id = rs.getInt("item_id");
					String name =  rs.getString("name");
					Double price =  rs.getDouble("price");
					int quantity =  rs.getInt("quantity");
					String employee =  rs.getString("employee");
					int id = rs.getInt("id");
					item = new Item(item_id, name, price, quantity, employee, id);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return item;
		}
		
		//select user by id
		public Item selectItem(int id_item) {
			Item item = null;
			try {
				Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEM_BY_ITEM_ID);
				preparedStatement.setInt(1, id_item);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					int item_id = rs.getInt("item_id");
					String name =  rs.getString("name");
					Double price =  rs.getDouble("price");
					int quantity =  rs.getInt("quantity");
					String employee =  rs.getString("employee");
					int id = rs.getInt("id");
					item = new Item(item_id, name, price, quantity, employee, id);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return item;
		}
		
		//select All User
		public List<Item> selectAllItem() {
			List<Item> item = new ArrayList<>();
			try {
				Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEM);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					int id =  rs.getInt("id");
					int item_id =  rs.getInt("item_id");
					String name =  rs.getString("name");
					Double price =  rs.getDouble("price");
					int quantity =  rs.getInt("quantity");
					String employee =  rs.getString("employee");
					item.add(new Item(item_id,name, price, quantity,employee,id));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return item;
		}
		
		//delete User 
		public boolean deleteItem(int id) throws SQLException {
		
			boolean rowDeleted;
			Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ITEM_SQL);
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate()>0;
			return rowDeleted;
		} 
	
}
