package com.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.classes.Cliente;
import com.classes.Compra;
import com.model.ClienteDAO;
import com.model.CompraDAO;
import com.view.InterfacePainel;

public class DesfazerCompraControler implements ActionListener {
	private int idCompraDesfeita;
	private Cliente clienteLogado;
public DesfazerCompraControler (int idCompraDesfeita , Cliente clienteLogado) {
	this.idCompraDesfeita = idCompraDesfeita;
	this.clienteLogado = clienteLogado;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CompraDAO crudCompras = new CompraDAO();
		Compra compraDesfeita = crudCompras.desfazerCompra(idCompraDesfeita);
		if(compraDesfeita != null ) {
			clienteLogado.desfazerCompra(compraDesfeita.getReferences().getPreco());
			ClienteDAO crudClientes = new ClienteDAO();
			crudClientes.update(clienteLogado.getIdCliente(), clienteLogado);
			JOptionPane.showMessageDialog(null, "Compra Desfeita com Sucesso !!!");
			InterfacePainel reiniciarPainel = new InterfacePainel(clienteLogado);
			reiniciarPainel.inicializar();
			crudCompras.desfazerConexao();
		}
	}

}
