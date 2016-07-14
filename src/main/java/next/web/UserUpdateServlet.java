package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserUpdateServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId =  req.getParameter("userId");
		User loginUser = DataBase.findUserById(userId);
		req.setAttribute("user", loginUser);
	        RequestDispatcher rd = req.getRequestDispatcher("/user/update.jsp");
	        rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId =  req.getParameter("userId");
		String password =  req.getParameter("password");
		String name =  req.getParameter("name");
		String email =  req.getParameter("email");
		
		User loginUser = DataBase.findUserById(userId);
		
		loginUser.setPassword(password);
		loginUser.setName(name);
		loginUser.setEmail(email);
		
		resp.sendRedirect("/user/list");
	}
}
