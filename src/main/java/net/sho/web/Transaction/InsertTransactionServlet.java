package net.sho.web.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shop.dao.ItemDAO;
import net.shop.dao.TransactionDAO;
import net.shop.model.Item;
import net.shop.model.Transaction;



@WebServlet("/InsertTransactionServlet")
public class InsertTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionDAO transactionDAO;
	private ItemDAO itemDAO;
    
    public InsertTransactionServlet() {
    	this.transactionDAO = new TransactionDAO();
    	this.itemDAO = new ItemDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = "Add Stock";
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		String employee_name = request.getParameter("employee_name");
		double price = Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("quantity"));
		Item itm = itemDAO.selectItem(item_id);
		String item_name = itm.getName();
		int id = itm.getId();
		
		System.out.println(item_name+" " + id);

		Transaction transaction = new Transaction(type,item_id,item_name,employee_name,price);
		Item itemupdate = new Item(item_id,item_name, price,qty, employee_name,id);
		try {
			boolean update= itemDAO.updateItemFromStock(itemupdate);
			boolean insert = transactionDAO.insertTransaction(transaction);
			
			System.out.println(update+" "+ insert );
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ShowTarnsactionListServelet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
