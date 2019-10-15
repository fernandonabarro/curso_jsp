package dao;

import beans.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;

public class DaoTelefone {

	private Connection connection;

	public DaoTelefone() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Telefone fone) {
		

		String sql = "insert into telefone(numero, tipo, usuario) values (?, ?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fone.getNumero());
			statement.setString(2, fone.getTipo());
			statement.setLong(3, fone.getUsuario());
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

	public List<Telefone> listar(Long user) {

		List<Telefone> lista = new ArrayList<Telefone>();
		String sql = "select * from telefone where usuario="+user;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Telefone fone = new Telefone();
				
				fone.setId(resultSet.getLong("id"));
				fone.setNumero(resultSet.getString("numero"));
				fone.setTipo(resultSet.getString("tipo"));
				fone.setUsuario(resultSet.getLong("usuario"));

				lista.add(fone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public void delete(String id) {
		String sql = "delete from telefone where id = '" + id + "'";

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

	public void update(Telefone fone) {

		String sql = "update telefone set numero = ?, tipo = ?, usuario = ? where id ='" + fone.getId() + "'";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fone.getNumero());
			statement.setString(2, fone.getTipo());
			statement.setLong(3, fone.getUsuario());
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

	public Telefone consultar(String id) throws SQLException {
		String sql = "select * from telefone where id='" + id + "'";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		Telefone fone = new Telefone();

		while (resultSet.next()) {
			fone.setId(resultSet.getLong("id"));
			fone.setNumero(resultSet.getString("numero"));
			fone.setUsuario(resultSet.getLong("usuario"));
		}
		return fone;

	}

}
