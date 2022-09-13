
package com.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import com.classes.Compra;
import com.classes.JogoPlataforma;
import com.classes.ResultCompra;

import java.sql.ResultSet;
import java.sql.SQLException;
public class CompraDAO {
	private Statement statement;
	private ResultSet result;
	private Connection connection;
	public CompraDAO () {
		
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String servidor = "jdbc:mysql://localhost:3306/lojadejogos?useTimezone=true&serverTimezone=UTC";
		String usuario = "madaleno";
		String senha = "root12345";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(servidor , usuario , senha);
			this.statement = connection.createStatement();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public boolean create (Compra compra) {
		String query = "INSERT INTO compras VALUES (default , '"+compra.getIdComprador()+ "','"+compra.getReferences().getIdRegistro()+"','"+compra.getDataDeCompra()+"')";
		try {
			this.statement.executeUpdate(query);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<ResultCompra> listaDeCompras (int idComprador){
		ArrayList<ResultCompra>lista = new ArrayList<>();
		String query = "SELECT c.idCompra , j.nomeJogo , c.dataDeCompra , p.nomePlataforma , jp.preco FROM compras AS c INNER JOIN jogos_plataformas AS jp ON c.reference_jogo_plataforma = jp.idRegistro INNER JOIN jogos AS j ON jp.id_jogo = j.idJogo INNER JOIN plataformas AS p ON jp.id_plataforma = p.idPlataforma WHERE idComprador = '" + idComprador + "' ORDER BY dataDeCompra DESC , idCompra DESC";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				ResultCompra result = new ResultCompra(this.result.getInt("c.idCompra") , this.result.getString("j.nomeJogo"), this.result.getString("c.dataDeCompra") , this.result.getString("p.nomePlataforma") , this.result.getDouble("jp.preco") );
				lista.add(result);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	} 
	
	public int getUltimoIdCompra (int idComprador) {
		String query = "SELECT idCompra FROM compras WHERE idComprador = '"+ idComprador + "' ORDER BY idCompra DESC LIMIT 1;";
		int digitoCompra =0;
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				digitoCompra = this.result.getInt("idCompra");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return digitoCompra;
	}
	
	public Compra retornarCompra (int idCompra) {
		String query = "SELECT * FROM compras WHERE idCompra = '" + idCompra + "'";
		Compra compra = null;
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				int idReference = this.result.getInt("reference_jogo_plataforma");
				JogoPlataformaDAO jogoPlat =  new JogoPlataformaDAO();
				JogoPlataforma reference = jogoPlat.read(idReference);
				compra = new Compra(this.result.getInt("idCompra") , this.result.getInt("idComprador") , reference , this.result.getString("dataDeCompra"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return compra;
	}
	public Compra desfazerCompra (int idCompra) {
		Compra compraDesfeita = retornarCompra(idCompra);
		if(compraDesfeita != null) {
			String query = "DELETE FROM compras WHERE idCompra = '" + idCompra+ "'";
			try {
				this.statement.executeUpdate(query);

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return compraDesfeita;
		}
		return null;
	}
	
	public ArrayList<JogoPlataforma> retornarIdRegistros (int idComprador , int idJogoSelecionado) {
		ArrayList <JogoPlataforma>lista = new ArrayList<>();
		String query = "SELECT jp.idRegistro , jp.id_jogo , jp.id_plataforma , jp.preco FROM compras AS c INNER JOIN jogos_plataformas AS jp ON c.reference_jogo_plataforma = jp.idRegistro WHERE c.idComprador = '" + idComprador + "' AND jp.id_jogo = '" + idJogoSelecionado + "'";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				JogoPlataforma newJP = new JogoPlataforma(this.result.getInt("jp.idRegistro") , this.result.getInt("jp.id_jogo") , this.result.getInt("jp.id_plataforma") , this.result.getDouble("jp.preco"));
				lista.add(newJP);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void desfazerConexao () {
		try {
			
			if(this.connection != null) {
				this.connection.close();
			}
			if(this.statement!= null) {
				this.statement.close();
			}
			if(this.result != null) {
				this.result.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
