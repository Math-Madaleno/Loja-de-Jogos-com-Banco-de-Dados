package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.classes.Jogo;
import com.classes.JogoPlataforma;

public class JogoPlataformaDAO {
	private Statement statement;
	private ResultSet result;
	private Connection connection;
	public JogoPlataformaDAO () {
	
		
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
	public JogoPlataforma read (int idRegistro) {
		JogoPlataforma jogo_plataforma = null;
		String query = "SELECT * FROM jogos_plataformas WHERE idRegistro = '" + idRegistro + "'";
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				jogo_plataforma = new JogoPlataforma(this.result.getInt("idRegistro") , this.result.getInt("id_jogo") , this.result.getInt("id_plataforma") , this.result.getDouble("preco"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return jogo_plataforma;
	}
	public JogoPlataforma read (int idJogo ,int idPlataforma) {
		JogoPlataforma jogo_plataforma = null;
		String query = "SELECT * FROM jogos_plataformas WHERE id_jogo = '" + idJogo + "' AND id_plataforma = '" + idPlataforma+ "'";
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				jogo_plataforma = new JogoPlataforma(this.result.getInt("idRegistro") , this.result.getInt("id_jogo") , this.result.getInt("id_plataforma") , this.result.getDouble("preco"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return jogo_plataforma;
	}
	public ArrayList<JogoPlataforma> readAll (int idJogo){
		ArrayList<JogoPlataforma> list = new ArrayList<>();
		String query = "SELECT * FROM jogos_plataformas WHERE id_jogo = '"+ idJogo + "'";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				JogoPlataforma jogo_plataforma= new JogoPlataforma(this.result.getInt("idRegistro") , this.result.getInt("id_jogo") , this.result.getInt("id_plataforma") , this.result.getDouble("preco"));
				list.add(jogo_plataforma);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private boolean verificarExistenciaRegistroDisponivel (JogoPlataforma jp , Object vetor[]) {
		for(int i =0; i < vetor.length; ++i) {
			JogoPlataforma object = (JogoPlataforma)vetor[i];
			if(jp.getIdRegistro() == object.getIdRegistro()) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<JogoPlataforma> retornarRegistrosDisponiveis (Object registrosCliente[] , Jogo jogoSelecionado){
		ArrayList<JogoPlataforma> list = new ArrayList<>();
		Object registrosJogo [] = readAll(jogoSelecionado.getIdJogo()).toArray();
		for(int i =0; i < registrosJogo.length; ++i) {
			JogoPlataforma registroJogo = (JogoPlataforma)registrosJogo[i];
			if(!verificarExistenciaRegistroDisponivel(registroJogo , registrosCliente)) {
				list.add(registroJogo);
			}
		}
		return list;
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
