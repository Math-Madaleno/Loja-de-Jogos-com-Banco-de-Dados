package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.classes.Cliente;
import com.model.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class InterfaceLogin {

	private JFrame frameLogin;
	private JTextField inputUsuarioLogin;
	private JTextField inputSenhaLogin;
	private JPasswordField passwordLogin;
	/**
	 * Launch the application.
	 */
	public InterfaceLogin () {
		
	}
	
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceLogin window = new InterfaceLogin();
					window.create();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */
	
	private void create (){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setTitle("Sistema de Login");
		frameLogin.getContentPane().setBackground( new Color(28,28,28));
		frameLogin.setBackground(new Color(28,28,28));
		frameLogin.setResizable(false);
		frameLogin.setBounds(600, 150, 450, 300);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		JLabel lblUsuarioLogin = new JLabel("Usuario :");
		lblUsuarioLogin.setForeground(Color.WHITE);
		lblUsuarioLogin.setFont(new Font("Arial", Font.PLAIN, 25));
		lblUsuarioLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioLogin.setBounds(120, 10, 200, 30);
		frameLogin.getContentPane().add(lblUsuarioLogin);
		
		inputUsuarioLogin = new JTextField();
		inputUsuarioLogin.setForeground(Color.BLACK);
		inputUsuarioLogin.setBackground(Color.WHITE);
		inputUsuarioLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputUsuarioLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		inputUsuarioLogin.setHorizontalAlignment(SwingConstants.CENTER);
		inputUsuarioLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputUsuarioLogin.setBounds(40, 50, 350, 30);
		frameLogin.getContentPane().add(inputUsuarioLogin);
		inputUsuarioLogin.setColumns(10);
		
		JLabel lblSenhaLogin = new JLabel("Senha :");
		lblSenhaLogin.setForeground(Color.WHITE);
		lblSenhaLogin.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSenhaLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaLogin.setBounds(120, 110, 200, 30);
		frameLogin.getContentPane().add(lblSenhaLogin);
		
		JPanel panelPasswordLogin = new JPanel();
		panelPasswordLogin.setForeground(Color.BLACK);
		panelPasswordLogin.setBackground(Color.WHITE);
		panelPasswordLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelPasswordLogin.setBounds(40, 150, 350, 30);
		frameLogin.getContentPane().add(panelPasswordLogin);
		panelPasswordLogin.setLayout(null);
		
		inputSenhaLogin = new JTextField();
		inputSenhaLogin.setVisible(false);
		inputSenhaLogin.setBackground(Color.WHITE);
		inputSenhaLogin.setForeground(Color.BLACK);
		inputSenhaLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		inputSenhaLogin.setHorizontalAlignment(SwingConstants.CENTER);
		inputSenhaLogin.setBorder(null);
		inputSenhaLogin.setBounds(50, 1, 240, 28);
		panelPasswordLogin.add(inputSenhaLogin);
		inputSenhaLogin.setColumns(10);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setVisible(true);
		passwordLogin.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLogin.setForeground(Color.BLACK);
		passwordLogin.setFont(new Font("Arial Black", Font.PLAIN, 16));
		passwordLogin.setBackground(Color.WHITE);
		passwordLogin.setBorder(null);
		passwordLogin.setBounds(50, 1, 240, 28);
		panelPasswordLogin.add(passwordLogin);
		
		JButton btnVerSenha = new JButton("(o)");
		btnVerSenha.setBackground(Color.WHITE);
		btnVerSenha.setForeground(Color.BLACK);
		btnVerSenha.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnVerSenha.setBounds(294, 1, 55, 28);
		btnVerSenha.addMouseListener((MouseListener) new MouseListener () {

			public void mouseClicked(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				
				inputSenhaLogin.setVisible(true);
				char caracteres[] = passwordLogin.getPassword();
				String senha = "";
				for(int i =0; i < caracteres.length; ++i) {
					senha+= caracteres[i];
				}
				inputSenhaLogin.setText(senha);
				passwordLogin.setVisible(false);
				
			}
		
			public void mouseReleased(MouseEvent e) {
				inputSenhaLogin.setVisible(false);
				passwordLogin.setVisible(true);
			}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
			
		});
		
		panelPasswordLogin.add(btnVerSenha);
		
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(0, 153, 204));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnEntrar.addMouseListener((MouseListener) new MouseListener () {

			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnEntrar.setBackground(new Color(0, 51, 102));
			}

			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(0, 153, 204));
			}
			
		});

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = inputUsuarioLogin.getText();
			    char caracteres[] = passwordLogin.getPassword();
			    String senha = "";
			    for(int i =0; i < caracteres.length; ++i) {
			    	senha+= caracteres[i];
			    }
				if(!usuario.isEmpty() && !senha.isEmpty()) {
					boolean validarUsuario  = validarUsuario(usuario);
					boolean validarSenha = validarSenha(senha);
					if(validarUsuario && validarSenha) {
						ClienteDAO crudCliente = new ClienteDAO();
						boolean validarLogin = crudCliente.validarLogin(usuario, senha);
						if(validarLogin) {	
							Cliente clienteLogado = crudCliente.read(usuario);
							frameLogin.dispose();
							JOptionPane.showMessageDialog(null , usuario + " Logado com sucesso");
							InterfacePainel painel = new InterfacePainel(clienteLogado);
							painel.inicializar();
						}
						else {
							JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Incorretos");
						}
						crudCliente.desfazerConexao();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos !!!");
				}
			}
		});
		btnEntrar.setBounds(40, 200, 150, 45);
		frameLogin.getContentPane().add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(0, 153, 0));
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameLogin.dispose();
				InterfaceCadastro cadastro = new InterfaceCadastro();
				cadastro.inicializar();
			}
		});
		btnCadastrar.setBounds(240, 200, 150, 45);
		btnCadastrar.addMouseListener((MouseListener) new MouseListener () {
			
			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnCadastrar.setBackground(new Color(0, 51, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setBackground(new Color(0, 153, 0));
			}
			
		});

		frameLogin.getContentPane().add(btnCadastrar);
		
		frameLogin.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent event) {
				JOptionPane.showMessageDialog(null, "Sistema Encerrado");
			}
		});
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
