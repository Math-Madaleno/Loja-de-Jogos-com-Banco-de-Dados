package com.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.classes.Cliente;
import com.classes.Compra;
import com.classes.Jogo;
import com.classes.JogoPlataforma;
import com.classes.ResultCompra;
import com.model.ClienteDAO;
import com.model.CompraDAO;
import com.model.PlataformaDAO;
import com.view.InterfaceJogoSelecionado;
import com.view.InterfacePainel;

public class RealizarCompraControler implements ActionListener {
	private InterfaceJogoSelecionado context;
	
	public RealizarCompraControler(InterfaceJogoSelecionado context) {
		this.context = context;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		Jogo jogoSelecionado = this.context.getJogoSelecionado();
		JogoPlataforma reference = this.context.getReference();
		String precoJogo = this.context.getPrecoJogo();
		Cliente clienteLogado = this.context.getClienteLogado();
		JFrame frameJogoSelecionado = this.context.getFrameJogoSelecionado();

		if(!precoJogo.isEmpty()) {
			Compra newCompra = criarCompra(clienteLogado , reference);
			CompraDAO crudCompra = new CompraDAO();
			boolean confirmacao = crudCompra.create(newCompra);
			if(confirmacao) {
				frameJogoSelecionado.dispose();		
				PlataformaDAO crudPlataforma = new PlataformaDAO();
				String nomePlataforma = crudPlataforma.read(newCompra.getReferences().getId_plataforma()).getNomePlataforma();
				JOptionPane.showMessageDialog(null, jogoSelecionado.getNomeJogo() + " - " + nomePlataforma + " comprado com sucesso !!!");
				clienteLogado.comprar(newCompra.getReferences().getPreco());
				ClienteDAO crudClientes = new ClienteDAO();
				crudClientes.update(clienteLogado.getIdCliente(), clienteLogado);
				InterfacePainel reiniciarPainel = new InterfacePainel (clienteLogado);
				reiniciarPainel.inicializar();
				crudPlataforma.desfazerConexao();
				crudClientes.desfazerConexao();
				
			}
			else {
				frameJogoSelecionado.dispose();
				JOptionPane.showMessageDialog(null, "Erro ao Finalizar Compra !!!");
				
			}
			crudCompra.desfazerConexao();
		}
		else {
			JOptionPane.showMessageDialog(null, "Selecione uma Plataforma para Comprar o Jogo");
		}
	}
	private Compra criarCompra (Cliente clienteLogado , JogoPlataforma reference) {
		Date dataAtual = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dataFormatada = format.format(dataAtual);
		Compra newCompra = new Compra(-1 , clienteLogado.getIdCliente() , reference , dataFormatada);
		return newCompra;
	}


}
