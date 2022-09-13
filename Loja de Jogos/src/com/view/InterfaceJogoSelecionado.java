package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import com.classes.Cliente;
import com.classes.Jogo;
import com.classes.JogoPlataforma;
import com.classes.Plataforma;
import com.controler.RealizarCompraControler;
import com.model.CompraDAO;
import com.model.JogoDAO;
import com.model.JogoPlataformaDAO;
import com.model.PlataformaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InterfaceJogoSelecionado {

	private JFrame frameJogoSelecionado;
	private JFrame painelCliente;
	private DefaultTableModel model;
	private Cliente clienteLogado;
	private Jogo jogo;
	private JLabel lblidJogo;
	private JTextField textIdJogo;
	private JLabel lblNomeJogo;
	private JTextField textNomeJogo;
	private JLabel lblDataDeLancamento;
	private JTextField textDataDeLancamento;
	private JLabel lblDesenvolvedoraJogo;
	private JTextField textDesenvolvedoras;
	private JLabel lblDistribuidoras;
	private JTextField textDistribuidoras;
	private JComboBox plataformas;
	private JLabel lblPlataforma;
	private JTextField textComprasFeitas;
	private JTextField textPrecoJogo;
	private JogoPlataforma reference;
	private ArrayList<JogoPlataforma>registrosDisponiveis = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	
	public InterfaceJogoSelecionado (Cliente clienteLogado , Jogo jogo) {
		this.clienteLogado = clienteLogado;
		this.jogo = jogo;
		
	}
	
	public void inicializar () {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InterfaceJogoSelecionado window = new InterfaceJogoSelecionado(clienteLogado, jogo);
						
						if(window.create()) {
							window.frameJogoSelecionado.setVisible(true);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	

	private boolean create() {
		CompraDAO crudCompra = new CompraDAO();
		Object registrosCliente [] = crudCompra.retornarIdRegistros(clienteLogado.getIdCliente(), jogo.getIdJogo()).toArray();
		JogoPlataformaDAO crudJp = new JogoPlataformaDAO();
		registrosDisponiveis = crudJp.retornarRegistrosDisponiveis(registrosCliente, jogo);
		if(registrosDisponiveis.size() >0) {
			initialize();
			crudCompra.desfazerConexao();
			crudJp.desfazerConexao();
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Você Comprou Todas as Plataformas Existentes Para Este Jogo");
			InterfaceListaJogos listaJogos = new InterfaceListaJogos(clienteLogado);
			listaJogos.inicializar();
			crudCompra.desfazerConexao();
			crudJp.desfazerConexao();
			return false;
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frameJogoSelecionado = new JFrame();
		frameJogoSelecionado.setResizable(false);
		frameJogoSelecionado.setTitle(jogo.getNomeJogo());
		frameJogoSelecionado.getContentPane().setBackground(new Color(28,28,28));
		frameJogoSelecionado.setBounds(450, 200, 800, 320);
		frameJogoSelecionado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameJogoSelecionado.getContentPane().setLayout(null);
		
		lblidJogo = new JLabel("Id . Jogo :");
		lblidJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblidJogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblidJogo.setForeground(Color.WHITE);
		lblidJogo.setBounds(5, 10, 150, 40);
		frameJogoSelecionado.getContentPane().add(lblidJogo);
		
		textIdJogo = new JTextField();
		textIdJogo.setText("" + jogo.getIdJogo());
		textIdJogo.setFont(new Font("Arial", Font.BOLD, 25));
		textIdJogo.setHorizontalAlignment(SwingConstants.CENTER);
		textIdJogo.setForeground(Color.BLACK);
		textIdJogo.setBackground(Color.WHITE);
		textIdJogo.setEditable(false);
		textIdJogo.setBounds(5, 60, 150, 30);
		frameJogoSelecionado.getContentPane().add(textIdJogo);
		textIdJogo.setColumns(10);
		
		lblNomeJogo = new JLabel("Nome do Jogo :");
		lblNomeJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeJogo.setForeground(Color.WHITE);
		lblNomeJogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeJogo.setBounds(165, 10, 250, 40);
		frameJogoSelecionado.getContentPane().add(lblNomeJogo);
		
		textNomeJogo = new JTextField();
		textNomeJogo.setText(jogo.getNomeJogo());
		textNomeJogo.setFont(new Font("Arial", Font.BOLD, 14));
		textNomeJogo.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeJogo.setForeground(Color.BLACK);
		textNomeJogo.setEditable(false);
		textNomeJogo.setBackground(Color.WHITE);
		textNomeJogo.setColumns(10);
		textNomeJogo.setBounds(165, 60, 250, 30);
		frameJogoSelecionado.getContentPane().add(textNomeJogo);
		
		lblDataDeLancamento = new JLabel("Lançamento :");
		lblDataDeLancamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeLancamento.setForeground(Color.WHITE);
		lblDataDeLancamento.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataDeLancamento.setBounds(425, 10, 150, 40);
		frameJogoSelecionado.getContentPane().add(lblDataDeLancamento);
		
		textDataDeLancamento = new JTextField();
		textDataDeLancamento.setFont(new Font("Arial", Font.BOLD, 18));
		textDataDeLancamento.setText(jogo.getDataLancamento());
		textDataDeLancamento.setForeground(Color.BLACK);
		textDataDeLancamento.setHorizontalAlignment(SwingConstants.CENTER);
		textDataDeLancamento.setEditable(false);
		textDataDeLancamento.setBackground(Color.WHITE);
		textDataDeLancamento.setColumns(10);
		textDataDeLancamento.setBounds(425, 60, 150, 30);
		frameJogoSelecionado.getContentPane().add(textDataDeLancamento);
		
		lblDesenvolvedoraJogo = new JLabel("Desenvolvedora(s)");
		lblDesenvolvedoraJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesenvolvedoraJogo.setForeground(Color.WHITE);
		lblDesenvolvedoraJogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblDesenvolvedoraJogo.setBounds(5, 110, 380, 40);
		frameJogoSelecionado.getContentPane().add(lblDesenvolvedoraJogo);
		
		textDesenvolvedoras =new JTextField();
		textDesenvolvedoras.setFont(new Font("Arial", Font.BOLD, 14));
		textDesenvolvedoras.setForeground(Color.BLACK);
		textDesenvolvedoras.setHorizontalAlignment(SwingConstants.CENTER);
		textDesenvolvedoras.setText(jogo.getDesenvolvedora());
		textDesenvolvedoras.setBackground(Color.WHITE);
		textDesenvolvedoras.setEditable(false);
		textDesenvolvedoras.setColumns(10);
		textDesenvolvedoras.setBounds(5, 160, 380, 30);
		frameJogoSelecionado.getContentPane().add(textDesenvolvedoras);
		
		lblDistribuidoras = new JLabel("Distribuidora(s)");
		lblDistribuidoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistribuidoras.setForeground(Color.WHITE);
		lblDistribuidoras.setFont(new Font("Arial", Font.BOLD, 14));
		lblDistribuidoras.setBounds(400, 110, 380, 40);
		frameJogoSelecionado.getContentPane().add(lblDistribuidoras);
		
		textDistribuidoras = new JTextField();
		textDistribuidoras.setFont(new Font("Arial", Font.BOLD, 14));
		textDistribuidoras.setForeground(Color.BLACK);
		textDistribuidoras.setText(jogo.getDistribuidora());
		textDistribuidoras.setHorizontalAlignment(SwingConstants.CENTER);
		textDistribuidoras.setBackground(Color.WHITE);
		textDistribuidoras.setEditable(false);
		textDistribuidoras.setColumns(10);
		textDistribuidoras.setBounds(400, 160, 380, 30);
		frameJogoSelecionado.getContentPane().add(textDistribuidoras);
		
		
		plataformas = new JComboBox();
		plataformas.setForeground(Color.BLACK);
		plataformas.setFont(new Font("Arial", Font.BOLD, 15));
		plataformas.setBackground(Color.WHITE);
		plataformas.setBounds(585, 60, 195, 30);
		
		DefaultComboBoxModel comboModel = (DefaultComboBoxModel)plataformas.getModel();
		JogoPlataformaDAO crudJogosPlataformas = new JogoPlataformaDAO();
		PlataformaDAO crudPlataformas = new PlataformaDAO();
		comboModel.addElement("Plataforma Escolhida :");
		Object registros [] = registrosDisponiveis.toArray();
		for(int i =0; i <registros.length; ++i) {
			JogoPlataforma registro = (JogoPlataforma)registros[i];
			Plataforma  plataforma = crudPlataformas.read(registro.getId_plataforma());
			comboModel.addElement(plataforma.getNomePlataforma());
		}
	
		plataformas.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String value = (String)comboModel.getSelectedItem();
				if(!value.equals("Plataforma Escolhida :")) {
					int idPlataforma = crudPlataformas.read(value).getIdPlataforma();
					JogoPlataforma plataformaEscolhida = crudJogosPlataformas.read(jogo.getIdJogo(), idPlataforma);
					reference = plataformaEscolhida;
					textPrecoJogo.setText("Preço : R$ " + plataformaEscolhida.getPreco());
				}
				else {
					textPrecoJogo.setText(null);
				}
			}
			
		});
		frameJogoSelecionado.getContentPane().add(plataformas);
		
		lblPlataforma = new JLabel("Plataforma :");
		lblPlataforma.setFont(new Font("Arial", Font.BOLD, 14));
		lblPlataforma.setForeground(Color.WHITE);
		lblPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlataforma.setBounds(585, 10, 195, 40);
		frameJogoSelecionado.getContentPane().add(lblPlataforma);
		
		JogoDAO crudJogos = new JogoDAO();
		int comprasFeitas = crudJogos.getComprasFeitas(jogo.getIdJogo());
		textComprasFeitas = new JTextField();
		textComprasFeitas.setEditable(false);
		textComprasFeitas.setFont(new Font("Arial", Font.BOLD, 15));
		textComprasFeitas.setText("Compras Feitas : " + comprasFeitas);
		textComprasFeitas.setHorizontalAlignment(SwingConstants.LEFT);
		textComprasFeitas.setForeground(Color.BLACK);
		textComprasFeitas.setColumns(10);
		textComprasFeitas.setBackground(Color.WHITE);
		textComprasFeitas.setBounds(5, 220, 220, 30);
		frameJogoSelecionado.getContentPane().add(textComprasFeitas);
		
		textPrecoJogo = new JTextField();
		textPrecoJogo.setFont(new Font("Arial", Font.BOLD, 18));
		textPrecoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecoJogo.setForeground(Color.BLACK);
		textPrecoJogo.setEditable(false);
		textPrecoJogo.setColumns(10);
		textPrecoJogo.setBackground(Color.WHITE);
		textPrecoJogo.setBounds(240, 220, 250, 30);
		frameJogoSelecionado.getContentPane().add(textPrecoJogo);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBackground(new Color(0, 153, 0));
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnComprar.setBounds(520, 205, 250, 60);
		
		btnComprar.addMouseListener((MouseListener) new MouseListener () {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnComprar.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnComprar.setBackground(new Color(0, 51, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnComprar.setBackground(new Color(0, 153, 51));
			}
			
		});
		
		btnComprar.addActionListener(new RealizarCompraControler (this));
		
		frameJogoSelecionado.getContentPane().add(btnComprar);
		
		frameJogoSelecionado.addWindowListener((WindowListener) new WindowAdapter () {
			public void windowClosing (WindowEvent event) {
				InterfacePainel reiniciarPainel = new InterfacePainel (clienteLogado);
				reiniciarPainel.inicializar();
			}
		});
	}
	public Cliente getClienteLogado () {
		return this.clienteLogado;
	}
	public JFrame getFrameJogoSelecionado () {
		return this.frameJogoSelecionado;
	}

	public JogoPlataforma getReference () {
		return this.reference;
	}
	public Jogo getJogoSelecionado () {
		return this.jogo;
	}

	public String getPrecoJogo () {
		return this.textPrecoJogo.getText();
	}
}
