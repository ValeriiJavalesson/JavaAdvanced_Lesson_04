package valerko.lgs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import valerko.lgs.domain.User;
import valerko.lgs.service.UserService;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserService.getUserService();

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
		String accessLevel = request.getParameter("accessLevel");

		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			userService.saveUser(new User(firstName, lastName, email, password, accessLevel));
			request.setAttribute("userEmail", email);
			request.setAttribute("userName", firstName);
			request.setAttribute("accessLevel", accessLevel);
			request.setAttribute("userAction", "зареєструвалися");

			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		}

		else
			request.getRequestDispatcher("registration.jsp").forward(request, response);

	}

}
