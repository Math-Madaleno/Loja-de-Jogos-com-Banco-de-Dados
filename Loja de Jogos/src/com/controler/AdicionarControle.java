package com.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.classes.Cliente;
import com.model.ClienteDAO;
import com.view.InterfaceCadastro;
import com.view.InterfaceLogin;

public class AdicionarControle implements ActionListener {

private InterfaceCadastro context;
	public AdicionarControle (InterfaceCadastro context) {
		this.context = context;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ClienteDAO crudCliente = new ClienteDAO();
		String nome = this.context.getInputNomeCadastro().getText();
		String usuario = this.context.getInputUsuarioCadastro().getText();
		char caracteres [] = this.context.getPassword().getPassword();
		String senha = "";
		for(int i =0;i < caracteres.length; ++i) {
			senha+= caracteres[i];
		}
		if(!nome.isEmpty() && !usuario.isEmpty() && !senha.isEmpty()) {
			boolean validarNome = validarNome(nome);
			boolean validarUsuario = validarUsuario(usuario);
			boolean validarSenha = validarSenha(senha);
			if(validarNome && validarUsuario && validarSenha) {
			
				boolean existeCliente = crudCliente.existeCliente(usuario);
				
				if(!existeCliente) {
					
					Cliente novoCliente = new Cliente(-1 , nome , usuario , senha , 0  , 0);
				    boolean validarCreate = crudCliente.create(novoCliente);
				    if(validarCreate) {
				    	
				    	JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso !!!");
				    	this.context.getFrameCadastro().dispose();
				    	InterfaceLogin login = new InterfaceLogin();
				    	login.inicializar();
				    }
				    
				    else {
				    	
				    	JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente");
				    	this.context.getFrameCadastro().dispose();
				    	InterfaceLogin login = new InterfaceLogin();
				    	login.inicializar();
				    	
				    }
				}

			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Preencha Todos os Campos !!!");
		}
		crudCliente.desfazerConexao();
	}
	
	private boolean validarNome (String nome) {
		if(nome.length() <=50) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Nome deve possuir no Máximo 50 Caracteres \n" + "Nome Atual tem " + nome.length()+ " caracteres");
			return false;
		}
	}
	private boolean validarUsuario (String usuario) {
		if(usuario.length() <=20) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario deve possuir no Máximo 20 Caracteres \n" + "Usuario Atual tem " + usuario.length()+ " caracteres");
			return false;
		}
	}
	
	private boolean validarSenha (String senha) {
		if(senha.length() <=25) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Senha deve possuir no Máximo 25 Caracteres \n" + "Senha Atual tem " + senha.length()+ " caracteres");
			return false;
		}
	}
}
