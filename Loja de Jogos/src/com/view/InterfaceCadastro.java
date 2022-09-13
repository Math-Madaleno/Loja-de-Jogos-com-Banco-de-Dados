package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.controler.AdicionarControle;
import com.model.ClienteDAO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

public class InterfaceCadastro {

	private JFrame frameCadastro;
	private JTextField inputNomeCadastro;
	private JLabel lblUsuarioCadastro;
	private JTextField inputUsuarioCadastro;
	private JLabel lblSenhaCadastro;
	private JButton btnCadastrar;
	private JTextField inputSenhaCadastro;
	private JPasswordField passwordSenhaCadastro;
	/**
	 * Launch the application.
	 */
	public InterfaceCadastro () {
		
	}
	
	public void inicializar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastro window = new InterfaceCadastro();
					window.create();
					window.frameCadastro.setVisible(true);
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
		
		frameCadastro = new JFrame();
		frameCadastro.setTitle("Sistema de Cadastro");
		frameCadastro.setBackground(new Color(28,28,28));
		frameCadastro.getContentPane().setBackground(new Color(28,28,28));
		frameCadastro.setResizable(false);
		frameCadastro.setBounds(570, 150, 500, 401);
		frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastro.getContentPane().setLayout(null);
		
		JLabel lblNomeCadastro = new JLabel("Nome :");
		lblNomeCadastro.setBackground(Color.WHITE);
		lblNomeCadastro.setForeground(Color.WHITE);
		lblNomeCadastro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNomeCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCadastro.setBounds(145, 10, 200, 30);
		frameCadastro.getContentPane().add(lblNomeCadastro);
		
		inputNomeCadastro = new JTextField();
		inputNomeCadastro.setForeground(Color.BLACK);
		inputNomeCadastro.setFont(new Font("Arial", Font.PLAIN, 16));
		inputNomeCadastro.setBackground(Color.WHITE);
		inputNomeCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		inputNomeCadastro.setBounds(45, 50, 400, 30);
		inputNomeCadastro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputNomeCadastro.setColumns(10);
		frameCadastro.getContentPane().add(inputNomeCadastro);
		
		
		lblUsuarioCadastro = new JLabel("Usuario :");
		lblUsuarioCadastro.setForeground(Color.WHITE);
		lblUsuarioCadastro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsuarioCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioCadastro.setBounds(145, 100, 200, 30);
		frameCadastro.getContentPane().add(lblUsuarioCadastro);
		
		inputUsuarioCadastro = new JTextField();
		inputUsuarioCadastro.setForeground(Color.BLACK);
		inputUsuarioCadastro.setFont(new Font("Arial", Font.PLAIN, 16));
		inputUsuarioCadastro.setBackground(Color.WHITE);
		inputUsuarioCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		inputUsuarioCadastro.setColumns(10);
		inputUsuarioCadastro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inputUsuarioCadastro.setBounds(45, 140, 400, 30);
		frameCadastro.getContentPane().add(inputUsuarioCadastro);
		
		lblSenhaCadastro = new JLabel("Senha :");
		lblSenhaCadastro.setForeground(Color.WHITE);
		lblSenhaCadastro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSenhaCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaCadastro.setBounds(145, 190, 200, 30);
		frameCadastro.getContentPane().add(lblSenhaCadastro);
		
		btnCadastrar = new JButton("Cadastrar");		
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(0, 153, 0));
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 25));
		btnCadastrar.addActionListener(new AdicionarControle(this));
		btnCadastrar.setBounds(120, 290, 250, 50);
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
		
		frameCadastro.getContentPane().add(btnCadastrar);
		
		JPanel panelPasswordCadastro = new JPanel();
		panelPasswordCadastro.setBackground(Color.WHITE);
		panelPasswordCadastro.setBounds(45, 230, 400, 30);
		panelPasswordCadastro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		frameCadastro.getContentPane().add(panelPasswordCadastro);
		panelPasswordCadastro.setLayout(null);
		
		inputSenhaCadastro = new JTextField();
		inputSenhaCadastro.setBorder(null);
		inputSenhaCadastro.setBackground(Color.WHITE);
		inputSenhaCadastro.setVisible(false);
		inputSenhaCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		inputSenhaCadastro.setForeground(Color.BLACK);
		inputSenhaCadastro.setFont(new Font("Arial", Font.PLAIN, 16));
		inputSenhaCadastro.setBounds(60, 1, 280, 28);
		panelPasswordCadastro.add(inputSenhaCadastro);
		inputSenhaCadastro.setColumns(10);
		
		passwordSenhaCadastro = new JPasswordField();
		passwordSenhaCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		passwordSenhaCadastro.setForeground(Color.BLACK);
		passwordSenhaCadastro.setFont(new Font("Arial", Font.BOLD, 16));
		passwordSenhaCadastro.setVisible(true);
		passwordSenhaCadastro.setBorder(null);
		passwordSenhaCadastro.setBounds(60, 1, 280, 28);
		panelPasswordCadastro.add(passwordSenhaCadastro);
		JButton btnVerSenha = new JButton("(o)");
		btnVerSenha.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnVerSenha.setForeground(Color.BLACK);
		btnVerSenha.setBackground(Color.WHITE);
		btnVerSenha.addMouseListener((MouseListener) new MouseListener () {

			public void mouseClicked(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				passwordSenhaCadastro.setVisible(false);
				inputSenhaCadastro.setVisible(true);
				char caracteres [] = passwordSenhaCadastro.getPassword();
				String senha = "";
				for(int i = 0; i < caracteres.length; ++i) {
					senha+= caracteres[i];
				}
				inputSenhaCadastro.setText(senha);
			}

			public void mouseReleased(MouseEvent e) {
				passwordSenhaCadastro.setVisible(true);
				inputSenhaCadastro.setVisible(false);
				inputSenhaCadastro.setText(null);
			}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
			
		});
		
		btnVerSenha.setBounds(344, 1, 55, 28);
		panelPasswordCadastro.add(btnVerSenha);
		
		
		frameCadastro.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent evt) { 
				InterfaceLogin login = new InterfaceLogin();
				login.inicializar();
			} 
		});
	}

	public JFrame getFrameCadastro() {
		return frameCadastro;
	}

	public JTextField getInputNomeCadastro() {
		return inputNomeCadastro;
	}

	public JTextField getInputUsuarioCadastro() {
		return inputUsuarioCadastro;
	}

	public JTextField getInputSenhaCadastro() {
		return inputSenhaCadastro;
	}

	public JPasswordField getPassword () {
		return this.passwordSenhaCadastro;
	}
}
