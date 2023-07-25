package net.shop.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.shop.connectionManager.ConnectionManager;
import net.shop.model.User;

public class UserDAO {
	
	private static final String INSERT_USER_SQL ="INSERT INTO USER (name,password,is_admin) values (?,?,?)";
	private static final String SELECT_ALL_USERS_BY_ID ="SELECT * FROM USER WHERE id=? ";
	private static final String SELECT_ALL_USERS ="SELECT * FROM USER ";
	private static final String DELETE_USERS_SQL ="DELETE FROM USER WHERE id=?";
	private static final String UPDATE_USERS_SQL ="UPDATE  USER SET name=? ,password=?,is_admin=? WHERE id=?";
	private static final String LOGIN_USERS_SQL ="SELECT * FROM USER WHERE name=? AND password=?";
	
	ConnectionManager con = new ConnectionManager();
	
	//insert User
	public void insertUser(User user) throws SQLException {
		try(Connection connection = con.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getIs_admin());
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//update user
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try(Connection connection = con.getConnection();
			PreparedStatement Statement = connection.prepareStatement(UPDATE_USERS_SQL)){
			Statement.setString(1, user.getName());
			Statement.setString(2, user.getPassword());
			Statement.setInt(3, user.getIs_admin());
			Statement.setInt(4, user.getId());
			rowUpdated = Statement.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
		
	}
	
	//select user by id
	public User selectuser(int id) {
		User user = null;
		try {
			Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				
				String name =  rs.getString("name");
				String password =  rs.getString("password");
				int is_admin =  rs.getInt("is_admin");
				user = new User(id,name, password, is_admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//login
	public Boolean login(String name , String password) {
		Boolean isLogin = false;
		try {
			Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				isLogin = true;
			} else {
				isLogin = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isLogin;
	}
	//select All User
	public List<User> selectAllUser() {
		List<User> user = new ArrayList<>();
		try {
			Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id =  rs.getInt("id");
				String name =  rs.getString("name");
				String password =  rs.getString("password");
				int is_admin =  rs.getInt("is_admin");
				user.add(new User(id,name, password, is_admin));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//delete User 
	public boolean deleteUser(int id) throws SQLException {
	
		boolean rowDeleted;
		Connection connection = con.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
		preparedStatement.setInt(1, id);
		rowDeleted = preparedStatement.executeUpdate()>0;
		return rowDeleted;
	} 

}
