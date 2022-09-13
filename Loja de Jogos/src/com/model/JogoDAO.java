package com.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.classes.Jogo;

public class JogoDAO {
	private Statement statement;
	private ResultSet result;
	private Connection connection;
	public JogoDAO () {
		
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
	
	public Jogo read (int idJogo) {
		String query = "SELECT * FROM jogos WHERE idJogo = '" + idJogo + "'";

		Jogo jogoLocalizado = null;
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				jogoLocalizado = new Jogo(this.result.getInt("idJogo") , this.result.getString("nomeJogo") , this.result.getString("dataLancamento") , this.result.getString("desenvolvedora") , this.result.getString("distribuidora"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return jogoLocalizado;
	}
	
	public Jogo [] readAll () {
		Jogo jogos [] = new Jogo[20];
		String query = "SELECT * FROM jogos";
		int i =0;
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				jogos [i] = new Jogo(this.result.getInt("idJogo") , this.result.getString("nomeJogo") , this.result.getString("dataLancamento") , this.result.getString("desenvolvedora") , this.result.getString("distribuidora") );
				++i;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return jogos;
	}
	public int getComprasFeitas (int idJogo) {
		String query = "SELECT count(*) as quantidadeDeVendas FROM compras AS c INNER JOIN jogos_plataformas AS jp ON c.reference_jogo_plataforma = jp.idRegistro INNER JOIN jogos AS j ON jp.id_jogo = j.idJogo WHERE idJogo = '" + idJogo + "'";
		int quantidadeDeVendas = 0;
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				quantidadeDeVendas = this.result.getInt("quantidadeDeVendas");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return quantidadeDeVendas;
	}
	public ArrayList<Jogo> jogosMaisVendidos(){
		ArrayList<Jogo> listaJogos = new ArrayList<>();
		String query = "SELECT j.idJogo , j.nomeJogo , j.dataLancamento , j.desenvolvedora , j.distribuidora , count(*) AS numeroDeVendas FROM compras AS c INNER JOIN jogos_plataformas AS jp ON c.reference_jogo_plataforma = jp.idRegistro INNER JOIN jogos AS j ON jp.id_jogo = j.idJogo GROUP BY j.idJogo ORDER BY count(*)DESC;";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				Jogo newJogo = new Jogo(this.result.getInt("j.idJogo") , this.result.getString("j.nomeJogo") , this.result.getString("j.dataLancamento") , this.result.getString("j.desenvolvedora") , this.result.getString("j.distribuidora"));
				listaJogos.add(newJogo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaJogos;
	}
	
	public ArrayList<Jogo> ordemAlfabetica(){
		ArrayList<Jogo> listaJogos = new ArrayList<>();
		String query = "SELECT * FROM jogos ORDER BY  nomeJogo ASC";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				Jogo newJogo = new Jogo(this.result.getInt("idJogo") , this.result.getString("nomeJogo") , this.result.getString("dataLancamento") , this.result.getString("desenvolvedora") , this.result.getString("distribuidora") );
				listaJogos.add(newJogo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaJogos;
	}
	
	public ArrayList<Jogo> ordemAlfabeticaInversa(){
		ArrayList<Jogo> listaJogos = new ArrayList<>();
		String query = "SELECT * FROM jogos ORDER by nomeJogo DESC";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				Jogo newJogo = new Jogo(this.result.getInt("idJogo") , this.result.getString("nomeJogo") , this.result.getString("dataLancamento") , this.result.getString("desenvolvedora") , this.result.getString("distribuidora") );
				listaJogos.add(newJogo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaJogos;
	}
	
	
	public ArrayList<Jogo> dataDeLancamento(){
		ArrayList<Jogo> listaJogos = new ArrayList<>();
		String query = "SELECT * FROM jogos ORDER BY dataLancamento DESC";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				Jogo newJogo = new Jogo(this.result.getInt("idJogo") , this.result.getString("nomeJogo") , this.result.getString("dataLancamento") , this.result.getString("desenvolvedora") , this.result.getString("distribuidora"));
				listaJogos.add(newJogo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaJogos;
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
