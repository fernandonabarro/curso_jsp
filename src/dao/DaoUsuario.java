package dao;

import beans.BeanUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanUsuario login) {

		String sql = "insert into usuario(login, senha, nome, fone, cep, rua, bairro, cidade,"
				+ " estado, ibge, foto, contenttype, curriculobase64, contenttypecurriculo, fotoBase64Miniatura, ativo, sexo, perfil) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login.getLogin());
			statement.setString(2, login.getSenha());
			statement.setString(3, login.getNome());
			statement.setString(4, login.getFone());
			statement.setString(5, login.getCep());
			statement.setString(6, login.getRua());
			statement.setString(7, login.getBairro());
			statement.setString(8, login.getCidade());
			statement.setString(9, login.getEstado());
			statement.setString(10, login.getIbge());
			statement.setString(11, login.getFotoBase64());
			statement.setString(12, login.getContentType());
			statement.setString(13, login.getCurriculoBase64());
			statement.setString(14, login.getContentTypeCurriculo());
			statement.setString(15, login.getFotoBase64Miniatura());
			statement.setBoolean(16, login.isAtivo());
			statement.setString(17, login.getSexo());
			statement.setString(18, login.getPerfil());

			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<BeanUsuario> listar(String descricaoconsulta) {
		String sql = "select * from usuario where login <> 'admin' and nome like '%"+descricaoconsulta+"%'";
		return consultarUsuarios(sql);

	}

	public List<BeanUsuario> listar() {
		String sql = "select * from usuario where login <> 'admin'";
		return consultarUsuarios(sql);

	}

	private List<BeanUsuario> consultarUsuarios(String sql) {
		List<BeanUsuario> lista = new ArrayList<BeanUsuario>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				BeanUsuario beanlogin = new BeanUsuario();

				beanlogin.setId(resultSet.getLong("id"));
				beanlogin.setLogin(resultSet.getString("login"));
				beanlogin.setSenha(resultSet.getString("senha"));
				if (resultSet.getString("nome") != null) {
					beanlogin.setNome(!resultSet.getString("nome").isEmpty()
							? resultSet.getString("nome").substring(0, 1).toUpperCase()
									+ (resultSet.getString("nome").length() > 1
											? (resultSet.getString("nome")
													.substring(1, (resultSet.getString("nome").length())).toLowerCase())
											: "")
							: "");
				}
				beanlogin.setFone(resultSet.getString("fone"));
				beanlogin.setCep(resultSet.getString("cep"));
				beanlogin.setRua(resultSet.getString("rua"));
				beanlogin.setBairro(resultSet.getString("bairro"));
				beanlogin.setCidade(resultSet.getString("cidade"));
				beanlogin.setEstado(resultSet.getString("estado"));
				beanlogin.setIbge(resultSet.getString("ibge"));
				// beanlogin.setFotoBase64(resultSet.getString("foto"));
				beanlogin.setFotoBase64Miniatura(resultSet.getString("fotoBase64Miniatura"));
				beanlogin.setContentType(resultSet.getString("contenttype"));
				beanlogin.setIbge(resultSet.getString("ibge"));
				beanlogin.setFotoUser(beanlogin.getFotoUser());
				beanlogin.setCurriculoBase64(resultSet.getString("curriculobase64"));
				beanlogin.setContentTypeCurriculo(resultSet.getString("contenttypecurriculo"));
				beanlogin.setAtivo(resultSet.getBoolean("ativo"));
				beanlogin.setSexo(resultSet.getString("sexo"));
				beanlogin.setPerfil(resultSet.getString("perfil"));

				lista.add(beanlogin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void delete(String id) {
		String sql = "delete from usuario where id = '" + id + "'and login <> 'admin'";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void update(BeanUsuario beanlogin) {

		StringBuilder sql = new StringBuilder();
		sql.append(" update usuario set login = ?, senha = ?, nome = ?, fone = ?, cep = ?, ");
		sql.append(" rua = ?, bairro = ?, cidade = ?, estado = ?, ibge = ?, ativo =? , sexo = ?, perfil = ? ");
		if (beanlogin.isAtualizarImage()) {
			sql.append(", foto = ?, contenttype = ? ");
		}
		if (beanlogin.isAtualizarPdf()) {
			sql.append(", curriculobase64 = ?, contenttypecurriculo = ? ");
		}
		if (beanlogin.isAtualizarImage()) {
			sql.append(", fotoBase64Miniatura = ? ");
		}
		sql.append(" where id ='" + beanlogin.getId() + "'");

		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, beanlogin.getLogin());
			statement.setString(2, beanlogin.getSenha());
			statement.setString(3, beanlogin.getNome());
			statement.setString(4, beanlogin.getFone());
			statement.setString(5, beanlogin.getCep());
			statement.setString(6, beanlogin.getRua());
			statement.setString(7, beanlogin.getBairro());
			statement.setString(8, beanlogin.getCidade());
			statement.setString(9, beanlogin.getEstado());
			statement.setString(10, beanlogin.getIbge());
			statement.setBoolean(11, beanlogin.isAtivo());
			statement.setString(12, beanlogin.getSexo());
			statement.setString(13, beanlogin.getPerfil());
			if (beanlogin.isAtualizarImage()) {
				statement.setString(14, beanlogin.getFotoBase64());
				statement.setString(15, beanlogin.getContentType());
			}
			if (beanlogin.isAtualizarPdf()&&beanlogin.isAtualizarImage()) {
				statement.setString(16, beanlogin.getCurriculoBase64());
				statement.setString(17, beanlogin.getContentTypeCurriculo());
			} else if(beanlogin.isAtualizarPdf()){
				statement.setString(14, beanlogin.getCurriculoBase64());
				statement.setString(15, beanlogin.getContentTypeCurriculo());				
			}
			if (beanlogin.isAtualizarImage() && !beanlogin.isAtualizarPdf()) {
				statement.setString(16, beanlogin.getFotoBase64Miniatura());
			} else if (beanlogin.isAtualizarImage() && beanlogin.isAtualizarPdf()){
				statement.setString(18, beanlogin.getFotoBase64Miniatura());
			}
			statement.executeUpdate();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public BeanUsuario consultar(String id) throws SQLException {
		String sql = "select * from usuario where id='" + id + "' and login <> 'admin'";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		BeanUsuario beanlogin = new BeanUsuario();

		while (resultSet.next()) {
			beanlogin.setId(resultSet.getLong("id"));
			beanlogin.setLogin(resultSet.getString("login"));
			beanlogin.setSenha(resultSet.getString("senha"));
			if (resultSet.getString("nome") != null) {
				beanlogin
						.setNome(!resultSet.getString("nome").isEmpty() ? resultSet.getString("nome").substring(0, 1)
								.toUpperCase()
								+ (resultSet.getString("nome").length() > 1
										? (resultSet.getString("nome")
												.substring(1, (resultSet.getString("nome").length())).toLowerCase())
										: "")
								: "");
			}
			beanlogin.setFone(resultSet.getString("fone"));
			beanlogin.setCep(resultSet.getString("cep"));
			beanlogin.setRua(resultSet.getString("rua"));
			beanlogin.setBairro(resultSet.getString("bairro"));
			beanlogin.setCidade(resultSet.getString("cidade"));
			beanlogin.setEstado(resultSet.getString("estado"));
			beanlogin.setIbge(resultSet.getString("ibge"));
			beanlogin.setContentType(resultSet.getString("contenttype"));
			beanlogin.setFotoBase64(resultSet.getString("foto"));
			beanlogin.setContentTypeCurriculo(resultSet.getString("contenttypecurriculo"));
			beanlogin.setCurriculoBase64(resultSet.getString("curriculobase64"));
			beanlogin.setAtivo(resultSet.getBoolean("ativo"));
			beanlogin.setSexo(resultSet.getString("sexo"));
			beanlogin.setPerfil(resultSet.getString("perfil"));
		}
		return beanlogin;

	}

	public boolean validarLogin(String login) {
		String sql = "select count(1) as qtd from usuario where login='" + login + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt("qtd") <= 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean validarLoginUpdate(String login, String id) {
		String sql = "select count(1) as qtd from usuario where login='" + login + "'and id <>'" + id + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt("qtd") <= 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean validarSenha(String senha) {
		String sql = "select count(1) as qtd from usuario where senha='" + senha + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt("qtd") <= 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
