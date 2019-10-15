package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaoLogin daoLogin = new DaoLogin();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index_primeiro_servlet.jsp");
		requestDispatcher.forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			try {
				if (daoLogin.validarLogin(login, senha)) { // acesso ok
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("pagina-acesso-liberado.jsp");
					requestDispatcher.forward(request, response);
				} else { // acesso negado
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("pagina-acesso-negado.jsp");
					requestDispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index_primeiro_servlet.jsp");
			requestDispatcher.forward(request, response);			
		}

	}

}
