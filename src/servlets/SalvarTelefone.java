package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.RealTimeSequencerProvider;

import beans.BeanCursoJsp;
import beans.BeanUsuario;
import beans.Telefone;
import dao.DaoTelefone;
import dao.DaoUsuario;

@WebServlet("/salvarTelefone")
public class SalvarTelefone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoTelefone daoTelefone = new DaoTelefone();
	private String numero;

	public SalvarTelefone() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String userId = request.getParameter("user");
		String acao = request.getParameter("acao");

		try {
			DaoUsuario daoUsuario = new DaoUsuario();

			if (userId == null || userId.isEmpty()) {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);				
			} else {

				BeanUsuario usuario = daoUsuario.consultar(userId);

				if (acao.equalsIgnoreCase("addFone")) {
					request.getSession().setAttribute("userEsc" + "olhido", usuario);
					request.setAttribute("userEscolhido", usuario);

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefones.jsp");
					request.setAttribute("telefones", daoTelefone.listar(usuario.getId()));
					view.forward(request, response);
				} else if (acao.equalsIgnoreCase("delete")) {
					String foneId = request.getParameter("foneId");

					daoTelefone.delete(foneId);
					request.setAttribute("msg", "Usuário excluído com sucesso!!!!");

					usuario = (BeanUsuario) request.getSession().getAttribute("userEscolhido");

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefones.jsp");
					request.setAttribute("userEscolhido", usuario);
					request.setAttribute("telefones", daoTelefone.listar(Long.parseLong(userId)));
					view.forward(request, response);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// BeanUsuario usuario = (BeanUsuario)
			// request.getSession().getAttribute("userEscolhido");
			String userId = request.getParameter("user");
			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");

			String acao = request.getParameter("acao");

			if (acao == null || (acao != null && !acao.equalsIgnoreCase("voltar"))) {

				if (numero == null || numero.isEmpty()) {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefones.jsp");
					request.setAttribute("telefones", daoTelefone.listar(Long.parseLong(userId)));
					request.setAttribute("msg", "Informe o número do telefone!!!!");
					view.forward(request, response);
					return;

				} else {

					DaoUsuario daoUsuario = new DaoUsuario();
					BeanUsuario usuario = daoUsuario.consultar(userId);

					Telefone fone = new Telefone();

					fone.setNumero(numero);
					fone.setTipo(tipo);
					fone.setUsuario(Long.parseLong(userId));

					daoTelefone.salvar(fone);
					request.setAttribute("msg", "Usuário cadastrado com sucesso!!!!");

					request.getSession().setAttribute("userEscolhido", usuario);
					request.setAttribute("userEscolhido", usuario);

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefones.jsp");
					request.setAttribute("telefones", daoTelefone.listar(usuario.getId()));
					view.forward(request, response);
				}
			} else {
				DaoUsuario daoUsuario = new DaoUsuario();

				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
