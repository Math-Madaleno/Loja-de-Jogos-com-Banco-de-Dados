package com.classes;


public class Jogo {
	private int idJogo;
	private String nomeJogo;
	private String dataLancamento;
	private String desenvolvedora;
	private String distribuidora;
	
	
	public Jogo (int idJogo , String nomeJogo , String dataLancamento , String desenvolvedora , String distribuidora) {
		this.idJogo = idJogo;
		this.nomeJogo = nomeJogo;
		this.dataLancamento = dataLancamento;
		this.desenvolvedora = desenvolvedora;
		this.distribuidora = distribuidora;
		
	}

	public int getIdJogo() {
		return this.idJogo;
	}
	public String getNomeJogo() {
		return this.nomeJogo;
	}

	public String getDataLancamento() {
		String data []  = this.dataLancamento.split("-");
		String dataFormatada = data[2] + "/" + data[1] + "/" + data[0];
		return dataFormatada;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

}
