package com.classes;

public class JogoPlataforma {
	private int idRegistro;
	private int id_jogo;
	private int id_plataforma;
	private double preco;
	
	public JogoPlataforma (int idRegistro , int idJogo , int idPlataforma , double preco) {
		this.idRegistro = idRegistro;
		this.id_jogo = idJogo;
		this.id_plataforma = idPlataforma;
		this.preco = preco;
	}

	public int getIdRegistro() {
		return this.idRegistro;
	}

	public int getId_jogo() {
		return this.id_jogo;
	}

	public int getId_plataforma() {
		return this.id_plataforma;
	}

	public double getPreco() {
		return this.preco;
	}
	

}
