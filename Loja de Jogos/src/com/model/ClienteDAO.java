package com.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.classes.Cliente;

public class ClienteDAO {
	private Statement statement;
	private ResultSet result;
	private Connection connection;
	public ClienteDAO () {
		
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
	
	public boolean create (Cliente cliente) {
		String query = "INSERT INTO clientes VALUES (default , '" +cliente.getNomeCliente()+"','"+cliente.getUsuarioCliente()+"','"+cliente.getSenha() + "','" + cliente.getComprasFeitas()+ "','" + cliente.getDinheiroGasto() +"')";
		try {
			this.statement.executeUpdate(query);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean existeCliente (String usuario) {
		String query = "SELECT * FROM clientes WHERE usuarioCliente= '"+usuario+"'";
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				return true;
			}
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public Cliente read (String usuario) {
		Cliente clienteRetornado = null;
		String query = "SELECT * FROM clientes WHERE usuarioCliente= '"+usuario+"'";
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				clienteRetornado = new Cliente(this.result.getInt("idCliente") , this.result.getString("nomeCliente") , this.result.getString("usuarioCliente") , this.result.getString("senhaCliente") , this.result.getInt("comprasFeitas") , this.result.getDouble("dinheiroGasto") );
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return clienteRetornado;
	}
	public Cliente[] readAll () {
		Cliente clientes [] = new Cliente[218_530];
		String query = "SELECT * FROM clientes";
		int posicao =0;
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				clientes[posicao] = new Cliente(this.result.getInt("idCliente"), this.result.getString("nomeCliente") , this.result.getString("usuarioCliente") , this.result.getString("senhaCliente") ,  this.result.getInt("comprasFeitas") , this.result.getDouble("dinheiroGasto") );
				posicao++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public boolean update (int idCliente , Cliente novoCliente) {
		String query = "UPDATE clientes SET comprasFeitas = '" + novoCliente.getComprasFeitas()+ "', dinheiroGasto = '"+novoCliente.getDinheiroGasto()+ "' WHERE  idCliente = '"+ novoCliente.getIdCliente()+"'";
		try {
			this.statement.executeUpdate(query);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean validarLogin (String usuario , String senha) {
		String query = "SELECT * FROM clientes WHERE usuarioCliente = '"+ usuario +"' and senhaCliente = '" + senha+ "'";
		try {
			this.result= this.statement.executeQuery(query);
			if(this.result.next()) {
				String usuarioSistema = this.result.getString("usuarioCliente");
				String senhaSistema = this.result.getString("senhaCliente");
				if(usuario.equals(usuarioSistema) && senha.equals(senhaSistema)) {
					return true;
				}
			}
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
