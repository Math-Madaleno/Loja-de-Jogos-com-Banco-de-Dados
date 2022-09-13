package com.classes;

public class Compra {
	private int idCompra;
	private int idComprador;
	private JogoPlataforma references;
	private String dataDeCompra;
	

	
	public Compra (int idCompra , int idComprador , JogoPlataforma references, String dataDeCompra) {
		this.idCompra = idCompra;
		this.idComprador = idComprador;
		this.references = references;
		this.dataDeCompra = dataDeCompra;
		
		
	}

	public int getIdCompra() {
		return this.idCompra;
	}

	public int getIdComprador() {
		return this.idComprador;
	}

	public JogoPlataforma getReferences() {
		return this.references;
	}

	public String getDataDeCompra() {
		return this.dataDeCompra;
	}


	
}
