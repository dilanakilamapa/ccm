package net.shop.web.Item;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shop.dao.ItemDAO;
import net.shop.model.Item;


@WebServlet("/InsertItemServlet")
public class InsertItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDAO;   
    
    public InsertItemServlet() {
    	this.itemDAO = new ItemDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int item_id = Integer.parseInt(request.getParameter("Item_id"));
        String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String employee =request.getParameter("employee");
		
		
		Item newItem = new Item(item_id, name,price,quantity,employee);
		try {
			itemDAO.insertItem(newItem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ShowListItemServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
