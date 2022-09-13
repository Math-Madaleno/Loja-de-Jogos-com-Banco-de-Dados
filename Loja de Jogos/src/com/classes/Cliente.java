package com.classes;


public class Cliente {
	private int idCliente;
	private String nomeCliente;
	private String usuarioCliente;
	private String senha;
	private int comprasFeitas;
	private double dinheiroGasto;
	public Cliente (int idCliente ,String nomeCliente , String usuarioCliente , String senha , int comprasFeitas , double dinheiroGasto ) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.usuarioCliente= usuarioCliente;
		this.senha = senha;
		this.comprasFeitas =comprasFeitas;
		this.dinheiroGasto = dinheiroGasto;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getUsuarioCliente() {
		return usuarioCliente;
	}

	public String getSenha() {
		return senha;
	}

	public int getComprasFeitas() {
		return comprasFeitas;
	}


	public double getDinheiroGasto() {
		return dinheiroGasto;
	}
	
	public void comprar (double dinheiroJogo) {
		this.dinheiroGasto = this.dinheiroGasto + dinheiroJogo;
		this.comprasFeitas = this.comprasFeitas + 1;
	}
	
	public void desfazerCompra (double dinheiroJogo) {
		this.dinheiroGasto = this.dinheiroGasto - dinheiroJogo;
		this.comprasFeitas = this.comprasFeitas -1;
		
	}
	
	public String toString () {
		return "Identificador : " + this.idCliente + " - Nome do Cliente : " + this.nomeCliente + " - Usuario : " + this.usuarioCliente + " - Senha : "+ this.senha + " - Compras Feitas : " + this.comprasFeitas + " - Dineiro Gasto : "+ this.dinheiroGasto ;
	}
}
