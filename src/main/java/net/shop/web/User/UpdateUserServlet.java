package net.shop.web.User;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shop.dao.UserDAO;
import net.shop.model.User;


@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public UpdateUserServlet() {
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loggedInUser = (String) request.getSession().getAttribute("loggedInUser");
		  if (loggedInUser == null) {
			  response.sendRedirect(request.getContextPath() + "/ShowLoginFormServlet"); 
		  } else {
			  int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String password = request.getParameter("password");
		        int is_admin = Integer.parseInt(request.getParameter("is_admin"));

		        User book = new User(id, name, password, is_admin);
		        try {
					userDAO.updateUser(book);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        response.sendRedirect(request.getContextPath() + "/ShowListServlet");
		  }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
