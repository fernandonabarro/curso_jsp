package servlets;

import beans.BeanProduto;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoProduto;

@WebServlet("/salvarProduto")
public class SalvarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalvarProduto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String produto = request.getParameter("produto");
		String acao = request.getParameter("acao") != null ? request.getParameter("acao"): "listartodos";

		DaoProduto daoProduto = new DaoProduto();

		try {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");

			if (acao.equalsIgnoreCase("delete")) {
				daoProduto.delete(produto);
				request.setAttribute("produtos", daoProduto.listar());
			} else if (acao.equalsIgnoreCase("editar")) {
				BeanProduto beanProduto = daoProduto.consultar(produto);
				request.setAttribute("produto", beanProduto);
			} else if (acao.equalsIgnoreCase("Listartodos")) {
				request.setAttribute("produtos", daoProduto.listar());
			}
			request.setAttribute("categorias", daoProduto.listarCategorias());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
	    Integer quantidade;
	    Double valor;
		String produtoId = request.getParameter("produto") != null? request.getParameter("produto"): null ;
		String categoria_id = request.getParameter("categoria_id");
		if (request.getParameter("quantidade").isEmpty()||request.getParameter("quantidade")==null){
			quantidade = null;
		}else{
			quantidade = Integer.valueOf(request.getParameter("quantidade"));
		}
		if (request.getParameter("valor").isEmpty()||request.getParameter("valor")==null){
			valor = null;
		}else{
			String valorParse = request.getParameter("valor").replaceAll("\\.", "");//10500,20
			valorParse = valorParse.replaceAll("\\,", "."); //10500.20
			valor = Double.parseDouble(valorParse);
		}
		
		String acao = request.getParameter("acao");
		DaoProduto daoProduto = new DaoProduto();

		if (acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("produtos", daoProduto.listar());
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			BeanProduto produto = new BeanProduto();
			produto.setId(!id.isEmpty()||id==null? Long.parseLong(id) : null);
			produto.setNome(nome);
			produto.setQuantidade(quantidade);
			produto.setValor(valor);
			produto.setCategoria_id(Long.parseLong(categoria_id));
			
			String msg = null;
			boolean podeInserir = true;

			if((nome.isEmpty()||(nome == null)) && ((quantidade == null) && (valor == null))) {
				request.setAttribute("msg", "Os dados devem ser informados!!!!!");
			} else {
				if (nome.isEmpty() || (nome == null)) {
					msg = "Nome de ser informado!!!! ";
				}
				if ((quantidade == null)&&(msg==null)) {
					msg = "Quantidade deve ser informada!!!!! ";
				}else if(quantidade == null){
					msg = msg+"Quantidade deve ser informada!!!!! ";
				}
				if (valor == null){
					msg = msg + "Valor deve ser informado!!!!! ";
				}
				if (msg == null) {
					request.setAttribute("msg", msg);
				}
				if ((id == null||id.isEmpty())&&(!daoProduto.validarProduto(nome))&&produtoId==null){
					request.setAttribute("msg", "Produto já cadastrado!!!!");
					podeInserir = false;
				}else if ((id== null||id.isEmpty())&&(daoProduto.validarProduto(nome))) {
					daoProduto.salvar(produto);
				} else if (daoProduto.validarProdutoUpdate(nome, id)) {
					daoProduto.update(produto);
				}
			}
			if (!podeInserir){
				request.setAttribute("produto", produto);
			}

			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("produtos", daoProduto.listar());
				request.setAttribute("categorias", daoProduto.listarCategorias());
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
