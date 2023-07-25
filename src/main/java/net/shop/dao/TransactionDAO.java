package net.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import net.shop.connectionManager.ConnectionManager;
import net.shop.model.Transaction;


public class TransactionDAO {
	
	private static final String INSERT_Transaction_SQL ="INSERT INTO TRANSACTION ( TYPE,item_id,item_name,employee_name,DATE,price) VALUES (?,?,?,?,CURDATE(),?)";
	private static final String SELECT_ALL_Transaction ="SELECT * FROM TRANSACTION ";
	private static final String SELECT_ALL_Transaction_BY_NAME ="SELECT * FROM TRANSACTION WHERE employee_name =?";
	
	
	
	
	ConnectionManager con = new ConnectionManager();

	//insert User
		public boolean insertTransaction(Transaction transaction) throws SQLException {
			boolean rowUpdated = false;
			try(Connection connection = con.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Transaction_SQL)){
				preparedStatement.setString(1, transaction.getType());
				preparedStatement.setInt(2, transaction.getItem_id());
				preparedStatement.setString(3, transaction.getItem_name());
				preparedStatement.setString(4, transaction.getEmployee_name());
				preparedStatement.setDouble(5, transaction.getPrice());
				rowUpdated = preparedStatement.executeUpdate() > 0;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return rowUpdated;
		}
		
		public List<Transaction> selectAllTransaction() {
			List<Transaction> transactions = new ArrayList<>();
			try {
				Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Transaction);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					int id =  rs.getInt("id");
					String type =  rs.getString("type");
					int item_id =  rs.getInt("item_id");
					String item_name =  rs.getString("item_name");
					String employee_name =  rs.getString("employee_name");
					Date date =rs.getDate("date");
					Double price =  rs.getDouble("price");
					transactions.add(new Transaction(id,type, item_id, item_name,employee_name,date,price));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return transactions;
		}
		
		public List<Transaction> selectAllTransactionByName(String name) {
			List<Transaction> transactions = new ArrayList<>();
			try {
				Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Transaction_BY_NAME);
				preparedStatement.setString(1, name);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					int id =  rs.getInt("id");
					String type =  rs.getString("type");
					int item_id =  rs.getInt("item_id");
					String item_name =  rs.getString("item_name");
					String employee_name =  rs.getString("employee_name");
					Date date =rs.getDate("date");
					Double price =  rs.getDouble("price");
					transactions.add(new Transaction(id,type, item_id, item_name,employee_name,date,price));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return transactions;
		}

}
