package com.classes;

public class ResultCompra {
	private int idCompra;
	private String nomeJogo;
	private String plataformaJogo;
	private String dataDeCompra;
	private double preco;

	
	public ResultCompra (int idCompra , String nomeJogo , String dataDeCompra , String plataformaJogo ,double preco ) {
		this.idCompra = idCompra;
		this.nomeJogo = nomeJogo;
		this.plataformaJogo=plataformaJogo;
		this.dataDeCompra=dataDeCompra;
		this.plataformaJogo=plataformaJogo;
		this.preco=preco;
	
	}

	public int getIdCompra() {
		return this.idCompra;
	}

	public String getNomeJogo() {
		return this.nomeJogo;
	}

	public String getDataDeCompra() {
		String dataFormatada = "";
		String date [] = this.dataDeCompra.split("-");
		dataFormatada = date[2]+"/"+date[1]+ "/"+date[0];
		return dataFormatada;
	}

	public String getPlataforma () {
		return this.plataformaJogo;
	}
	public double getPreco() {
		return this.preco;
	}

}
