package dao;

import beans.BeanCategoria;
import beans.BeanProduto;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;

public class DaoProduto {

	private Connection connection;

	public DaoProduto() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanProduto produto) {
		

		String sql = "insert into produto(nome, quantidade, valor, categoria_id) values (?, ?, ?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome().toLowerCase());
			statement.setInt(2, produto.getQuantidade()==null? 0 : produto.getQuantidade());
			statement.setDouble(3, produto.getQuantidade()==null? 0 : produto.getValor());
			statement.setLong(4, produto.getCategoria_id());
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

	public List<BeanProduto> listar() {

		List<BeanProduto> lista = new ArrayList<BeanProduto>();
		String sql = "select * from produto";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				BeanProduto beanProduto = new BeanProduto();
				
				beanProduto.setId(resultSet.getLong("id"));
				beanProduto.setQuantidade(resultSet.getInt("quantidade"));
				if (resultSet.getString("nome")!=null){
					beanProduto.setNome(!resultSet.getString("nome").isEmpty() ? 
							resultSet.getString("nome").substring(0, 1).toUpperCase()+
							(resultSet.getString("nome").length()>1? 
									      (resultSet.getString("nome").substring(1, (resultSet.getString("nome").length())).toLowerCase())
									      : "")
							: "");					
				}
				beanProduto.setValor(resultSet.getDouble("valor"));
				beanProduto.setCategoria_id(resultSet.getLong("categoria_id"));
				lista.add(beanProduto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public List<BeanCategoria> listarCategorias() throws SQLException{
		List<BeanCategoria> retorno = new ArrayList<BeanCategoria>();
		String sql = "select * from categoria";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()){
			BeanCategoria categoria = new BeanCategoria();
			categoria.setId(resultset.getLong("id"));
			categoria.setNome(resultset.getString("nome"));
			retorno.add(categoria);
		}
		return retorno;
		
	}

	public void delete(String id) {
		String sql = "delete from produto where id = '" + id + "'";

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

	public void update(BeanProduto BeanProduto) {

		String sql = "update produto set nome = ?, quantidade = ?, valor = ?, categoria_id = ? where id ='" + BeanProduto.getId() + "'";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, BeanProduto.getNome());
			statement.setInt(2, BeanProduto.getQuantidade());
			statement.setDouble(3, BeanProduto.getValor());
			statement.setLong(4, BeanProduto.getCategoria_id());
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

	public BeanProduto consultar(String id) throws SQLException {
		String sql = "select * from produto where id='" + id + "'";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		BeanProduto beanProduto = new BeanProduto();

		while (resultSet.next()) {
			beanProduto.setId(resultSet.getLong("id"));
			beanProduto.setQuantidade(resultSet.getInt("quantidade"));
			if (resultSet.getString("nome")!=null){
				beanProduto.setNome(!resultSet.getString("nome").isEmpty() ? 
						resultSet.getString("nome").substring(0, 1).toUpperCase()+
						(resultSet.getString("nome").length()>1? 
								      (resultSet.getString("nome").substring(1, (resultSet.getString("nome").length())).toLowerCase())
								      : "")
						: "");					
			}
			beanProduto.setValor(resultSet.getDouble("valor"));
			beanProduto.setCategoria_id(resultSet.getLong("categoria_id"));
		}
		return beanProduto;

	}

	public boolean validarProduto(String nome) {
		String sql = "select count(1) as qtd from produto where nome='" + nome + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()){
				return resultSet.getInt("qtd") <= 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean validarProdutoUpdate(String nome, String id) {
		String sql = "select count(1) as qtd from usuario where login='" + nome + "'and id <>'"+id+"'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()){
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
			while (resultSet.next()){
				return resultSet.getInt("qtd") <= 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
