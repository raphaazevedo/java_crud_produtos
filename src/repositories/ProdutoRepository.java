package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import factories.ConectionFactory;

// realizar operações no banco com produtos
public class ProdutoRepository {

	// cadastro no banco

	public void create(Produto produto) throws Exception {

		ConectionFactory connectiFactory = new ConectionFactory();
		Connection connection = connectiFactory.getConection();

		// executar o comando sql no banco de dados
		PreparedStatement statement = connection
				.prepareCall("insert into produto(nome,descricao,preco,quantidade) values(?,?,?,?)");
		statement.setString(1, produto.getNome());
		statement.setString(2, produto.getDescricao());
		statement.setDouble(3, produto.getPreco());
		statement.setInt(4, produto.getQuantidade());
		statement.execute();

		// fechando conexão com o banco
		connection.close();

	}

	public void update(Produto produto) throws Exception {

		ConectionFactory conectionFactory = new ConectionFactory();
		Connection connection = conectionFactory.getConection();

		PreparedStatement statement = connection
				.prepareStatement("UPDATE produto SET nome=?,descricao=?,preco=?,quantidade=?  WHERE id=?");
		statement.setString(1, produto.getNome());
		statement.setString(2, produto.getDescricao());
		statement.setDouble(3, produto.getPreco());
		statement.setInt(4, produto.getQuantidade());
		statement.setInt(5, produto.getId());
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws Exception {

		ConectionFactory conectionFactory = new ConectionFactory();
		Connection connection = conectionFactory.getConection();

		// executa comando no banco
		PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id=?");
		statement.setInt(1, id);
		statement.execute();

		connection.close();

	}

	// consultar e retornar todos os produtos
	public List<Produto> findAll() throws Exception {

		// abrir conecção com nbanco
		ConectionFactory conectionFactory = new ConectionFactory();
		Connection connection = conectionFactory.getConection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto ORDER BY id");
		// executar e capturar o retorneo da consulta
		ResultSet resultSet = statement.executeQuery();

		// declarar lista de produtos
		List<Produto> lista = new ArrayList<Produto>();

		// percorrer cada dregistro da consulta
		while (resultSet.next()) {

			// capturar produtos
			Produto produto = new Produto();
			produto.setId(resultSet.getInt("id"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));

			lista.add(produto);

		}

		connection.close();

		// retornar a lista
		return lista;
	}

	public Produto findById(Integer id) throws Exception {

		ConectionFactory conectionFactory = new ConectionFactory();
		Connection connection = conectionFactory.getConection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto WHERE id=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		// criar objeto produto vazio
		Produto produto = null;

		// verificar sem achou algo
		if (resultSet.next()) {

			//instanciando produto
			produto = new Produto();
			
			
			produto.setId(resultSet.getInt("id"));
			produto.setNome(resultSet.getString("nome"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setPreco(resultSet.getDouble("preco"));
			produto.setQuantidade(resultSet.getInt("quantidade"));

		}
		

		connection.close();
		return produto;

	}

}
