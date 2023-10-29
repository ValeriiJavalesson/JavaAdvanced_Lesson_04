package valerko.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import valerko.lgs.dao.UserRole;
import valerko.lgs.domain.User;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.UserServiceImpl;

@WebServlet(name = "registration", urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserRole role = UserRole.valueOf(request.getParameter("role").toUpperCase());

		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			if (userService.read(email) != null) {
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			} else {
				userService.create(new User(firstName, lastName, email, password, role));
				request.setAttribute("userEmail", email);
				request.setAttribute("userName", firstName);
				request.setAttribute("userRole", role);
				request.setAttribute("userAction", "зареєструвалися");

				request.getRequestDispatcher("cabinet.jsp").forward(request, response);
			}
		}

		else
			request.getRequestDispatcher("registration.jsp").forward(request, response);

	}
}
