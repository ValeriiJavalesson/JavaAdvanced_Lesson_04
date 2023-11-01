package valerko.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import valerko.lgs.domain.User;
import valerko.lgs.dto.UserLogin;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.UserServiceImpl;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = userService.read(email);

		if (user != null && user.getPassword().equals(password)) {
			
			UserLogin userLogin = new UserLogin();
			userLogin.destinationUrl = "cabinet.jsp";
			userLogin.userEmail = user.getEmail();
			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
}
