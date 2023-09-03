package valerko.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import valerko.lgs.domain.User;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.UserServiceImpl;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserServiceImpl.getUserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");


		User user = userService.read(login);

		if (user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		if (user.getPassword().equals(password)) {
			request.setAttribute("userEmail", login);
			request.setAttribute("userAction", "авторизувалися");
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
