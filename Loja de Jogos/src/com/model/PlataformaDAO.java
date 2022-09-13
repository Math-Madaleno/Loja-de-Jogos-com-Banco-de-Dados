package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.classes.Plataforma;

public class PlataformaDAO {
	private Statement statement;
	private ResultSet result;
	private Connection connection;
	public PlataformaDAO () {
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
	public Plataforma read (int idPlataforma) {
		Plataforma plataforma = null;
		String query = "SELECT * FROM plataformas WHERE idPlataforma = '"+ idPlataforma+ "'";
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				plataforma = new Plataforma(this.result.getInt("idPlataforma") , this.result.getString("nomePlataforma"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return plataforma;
	}
	
	public Plataforma read (String nomePlataforma) {
		Plataforma plataforma = null;
		String query = "SELECT * FROM plataformas WHERE nomePlataforma = '"+ nomePlataforma+ "'";
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				plataforma = new Plataforma(this.result.getInt("idPlataforma") , this.result.getString("nomePlataforma"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return plataforma;
	}
	
	public Plataforma [] readALL (int idPlataforma) {
		Plataforma plataformas [] = new Plataforma[12];
		String query = "SELECT * FROM plataformas WHERE idPlataforma = '"+ idPlataforma+ "'";
		try {
			this.result = this.statement.executeQuery(query);
			int i =0;
			while(this.result.next()) {
				plataformas[i] = new Plataforma(this.result.getInt("idPlataforma") , this.result.getString("nome"));
				i++;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return plataformas;
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
