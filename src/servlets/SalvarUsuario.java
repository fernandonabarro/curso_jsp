package servlets;

import java.io.InputStream;
import java.io.OutputStream;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import beans.BeanUsuario;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
@MultipartConfig
public class SalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalvarUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String userId = request.getParameter("user");
		String acao = request.getParameter("acao");

		DaoUsuario daoUsuario = new DaoUsuario();

		try {

			if (acao != null && acao.equalsIgnoreCase("delete") && userId != null) {
				daoUsuario.delete(userId);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("editar")) {
				BeanUsuario beanLogin = daoUsuario.consultar(userId);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", beanLogin);
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("Listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("download")) {
				BeanUsuario usuario = daoUsuario.consultar(userId);

				String tipo = request.getParameter("tipo");
				byte[] fileByte = null;

				if (tipo.equalsIgnoreCase("imagem")) {
					response.setHeader("Content-Disposition",
							"attachment;arquivo." + usuario.getContentType().split("\\/")[1]);
					fileByte = new Base64().decodeBase64(usuario.getFotoBase64().getBytes());
				} else if (tipo.equalsIgnoreCase("curriculoPdf")) {
					response.setHeader("Content-Disposition",
							"attachment;arquivo." + usuario.getContentTypeCurriculo().split("\\/")[1]);
					fileByte = new Base64().decodeBase64(usuario.getCurriculoBase64().getBytes());
				}

				InputStream isFile = new ByteArrayInputStream(fileByte);

				OutputStream os = response.getOutputStream();

				byte[] bytes = new byte[1024];
				int count = 0;

				while ((count = isFile.read(bytes)) != -1) {
					os.write(bytes, 0, count);
				}

				os.flush();
				os.close();

			} else {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BeanUsuario usuario = new BeanUsuario();

		try {
			// inicio file upload de imagens e pdf
			if (ServletFileUpload.isMultipartContent(request)) {
				// List<FileItem> fileItens =
				// new ServletFileUpload(new
				// DiskFileItemFactory()).parseRequest(request);
				// for(FileItem fileItem: fileItens){
				// if(fileItem.getFieldName().equalsIgnoreCase("foto")){
				// String foto = Base64.encode(fileItem.get());
				// String contentType = fileItem.getContentType();
				// usuario.setFotoBase64(foto);
				// usuario.setContentType(contentType);

				// processa imagem
				Part imagemFoto = request.getPart("foto");
				if (imagemFoto != null && imagemFoto.getInputStream().available() > 0) {

					byte[] fotoBase64 = new Base64().encode(converteStreamParaByte(imagemFoto.getInputStream()));
					usuario.setFotoBase64(new String(fotoBase64));
					usuario.setContentType(imagemFoto.getContentType());

					/* Início miniatura imagem */

					/* transformar em bufferedImage */
					byte[] imageByteDecode = new Base64().decode(fotoBase64);

					BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageByteDecode));

					/* Pegar o tipo da imagem */

					int type = bufferedImage.getType() == 0 ? bufferedImage.TYPE_INT_ARGB : bufferedImage.getType();

					/* Cria imagem em miniatura */

					BufferedImage resizedImage = new BufferedImage(100, 100, type);
					Graphics2D g = resizedImage.createGraphics();
					g.drawImage(bufferedImage, 0, 0, 100, 100, null);
					g.dispose();

					/* Escreve imagem novamente */

					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(resizedImage, "png", baos);

					String miniaturaBase64 = "data:image/png;base64,"
							+ DatatypeConverter.printBase64Binary(baos.toByteArray());

					usuario.setFotoBase64Miniatura(miniaturaBase64);
					/* Fim miniatura imagem */

				} else {
					usuario.setAtualizarImage(false);
					;
				}

				// processo pdf

				Part curriculoPdf = request.getPart("curriculo");

				if (curriculoPdf != null && curriculoPdf.getInputStream().available() > 0) {
					byte[] curriculoBase64 = new Base64().encode(converteStreamParaByte(curriculoPdf.getInputStream()));
					usuario.setCurriculoBase64(new String(curriculoBase64));
					usuario.setContentTypeCurriculo(curriculoPdf.getContentType());
				} else {
					usuario.setAtualizarPdf(false);
				}
			}

			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");
			String sexo = request.getParameter("sexo");
			String perfil = request.getParameter("perfil");

			String acao = request.getParameter("acao");
			String usuarioId = request.getParameter("usuario") != null ? request.getParameter("usuario") : null;
			DaoUsuario daoUsuario = new DaoUsuario();

			if (acao.equalsIgnoreCase("reset")) {

				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);

			} else {
				usuario.setId(!id.isEmpty() ? Long.parseLong(id) : null);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				usuario.setNome(nome);
				usuario.setCep(cep);
				usuario.setRua(rua);
				usuario.setBairro(bairro);
				usuario.setCidade(cidade);
				usuario.setEstado(estado);
				usuario.setIbge(ibge);
				usuario.setSexo(sexo);
				usuario.setPerfil(perfil);

				if (request.getParameter("ativo") != null && request.getParameter("ativo").equalsIgnoreCase("on")) {
					usuario.setAtivo(true);
				} else {
					usuario.setAtivo(false);
				}

				boolean salvou = false;
				String msg = null;

				boolean podeInserir = true;
				if ((login.isEmpty() && senha.isEmpty() && nome.isEmpty())
						|| ((login == null) && (nome == null) && (senha == null))) {
					request.setAttribute("msg", "Os dados devem ser informados!!!!!");
				} else {
					if (login.isEmpty() || (login == null)) {
						msg = "Login de ser informado!!!! ";
					}
					if ((senha.isEmpty() || (senha == null)) && (msg == null)) {
						msg = "Senha deve ser informada!!!!! ";
					} else if (senha.isEmpty() || senha == null) {
						msg = msg + "Senha deve ser informada!!!!! ";
					}
					if (nome.isEmpty() || (nome == null)) {
						msg = msg + "Nome deve ser informado!!!!! ";
					}
					if (msg != null) {
						request.setAttribute("msg", msg);
					}
					if ((id.isEmpty() || (id == null)) && (!daoUsuario.validarLogin(login)) && (!login.isEmpty())) {
						request.setAttribute("msg", "Usuário já cadastrado!!!!");
						podeInserir = false;
					} else if ((!daoUsuario.validarSenha(senha) && (!senha.isEmpty() || (senha == null)))
							&& usuarioId == null) {
						request.setAttribute("msg", "Senha já existente!!!!");
						podeInserir = false;
					} else if ((id.isEmpty() || (id == null)) && (daoUsuario.validarLogin(login))) {
						salvou = true;
						daoUsuario.salvar(usuario);
					} else if (daoUsuario.validarLoginUpdate(login, id)) {
						salvou = true;
						daoUsuario.update(usuario);
					}
				}
				if (!podeInserir) {
					request.setAttribute("user", usuario);
				}

				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				if (salvou == true) {
					request.setAttribute("msg", "Usuário salvo com sucesso!!!!!");
				}
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] converteStreamParaByte(InputStream imagem) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(imagem);
		return baos.toByteArray();
	}
}
