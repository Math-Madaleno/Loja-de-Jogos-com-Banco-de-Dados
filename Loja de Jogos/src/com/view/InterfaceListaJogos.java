package com.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.*;

import com.classes.Cliente;
import com.classes.Jogo;
import com.model.JogoDAO;

public class InterfaceListaJogos {
	private JFrame frameListaDeJogos;
	private JTable listaDeJogos;
	private JButton btnComprar;
	private Cliente clienteLogado;
	private DefaultTableModel modelCliente;
	/**
	 * Launch the application.
	 */
	public InterfaceListaJogos (Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
		
	}
	public void inicializar (){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceListaJogos window = new InterfaceListaJogos(clienteLogado);
					window.create();
					window.frameListaDeJogos.setVisible(true);
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
	private void create () {
		initialize();
	}



	private  void initialize() {
		JogoDAO crudJogos = new JogoDAO();
		frameListaDeJogos = new JFrame();
		frameListaDeJogos.setAutoRequestFocus(false);
		frameListaDeJogos.setAlwaysOnTop(true);
		frameListaDeJogos.setTitle("Loja de Jogos");
		frameListaDeJogos.setBackground(new Color(28 , 28, 28	));
		frameListaDeJogos.getContentPane().setBackground(new Color(28 , 28, 28	));
		frameListaDeJogos.setResizable(false);
		frameListaDeJogos.setBounds(300, 150, 1100, 570);
		frameListaDeJogos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameListaDeJogos.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 1030, 350);
		frameListaDeJogos.getContentPane().add(scrollPane);
		
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		cellRender.setBackground(new Color(28 , 28, 28	));
		listaDeJogos = new JTable();
		
		listaDeJogos.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
		listaDeJogos.setBackground(new Color(28,28,28));
		listaDeJogos.setForeground(Color.WHITE);
		listaDeJogos.setModel((TableModel) new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id :", "Nome :", "Lançamento :", "Desenvolvedora :", "Distribuidora :"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		listaDeJogos.getColumnModel().getColumn(0).setPreferredWidth(80);
		listaDeJogos.getColumnModel().getColumn(0).setMinWidth(80);
		listaDeJogos.getColumnModel().getColumn(0).setMaxWidth(80);
		listaDeJogos.getColumnModel().getColumn(0).setResizable(false);
		
		listaDeJogos.getColumnModel().getColumn(1).setPreferredWidth(300);
		listaDeJogos.getColumnModel().getColumn(1).setMinWidth(300);
		listaDeJogos.getColumnModel().getColumn(1).setMaxWidth(300);
		listaDeJogos.getColumnModel().getColumn(1).setResizable(false);

		listaDeJogos.getColumnModel().getColumn(2).setPreferredWidth(120);
		listaDeJogos.getColumnModel().getColumn(2).setMinWidth(120);
		listaDeJogos.getColumnModel().getColumn(2).setMaxWidth(120);
		listaDeJogos.getColumnModel().getColumn(2).setResizable(false);

		listaDeJogos.getColumnModel().getColumn(3).setPreferredWidth(250);
		listaDeJogos.getColumnModel().getColumn(3).setMinWidth(250);
		listaDeJogos.getColumnModel().getColumn(3).setMaxWidth(250);
		listaDeJogos.getColumnModel().getColumn(3).setResizable(false);
		
		listaDeJogos.getColumnModel().getColumn(4).setPreferredWidth(300);
		listaDeJogos.getColumnModel().getColumn(4).setMinWidth(300);
		listaDeJogos.getColumnModel().getColumn(4).setMaxWidth(300);
		listaDeJogos.getColumnModel().getColumn(4).setResizable(false);
		
		listaDeJogos.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		
		
		for (int i =0; i < 5; ++i) {
			listaDeJogos.getColumnModel().getColumn(i).setCellRenderer(cellRender);
			listaDeJogos.getColumnModel().getColumn(i).setHeaderRenderer(cellRender);;
		}
		Jogo jogos[] = crudJogos.readAll();
		DefaultTableModel model = (DefaultTableModel)listaDeJogos.getModel();
		for(int i =0; i < jogos.length; ++i) {
			Jogo jogo = jogos[i];
			String desenvolvedoras[] = jogo.getDesenvolvedora().split(",");
			String distribuidoras [] = jogo.getDistribuidora().split(",");
			model.addRow(new Object[] {jogos[i].getIdJogo() , jogos[i].getNomeJogo() , jogos[i].getDataLancamento() , desenvolvedoras[0] , distribuidoras[0]});
		}
		scrollPane.setViewportView(listaDeJogos);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnComprar.setBackground(new Color(0, 153, 51));
		btnComprar.setBounds(370, 440, 300, 60);
		btnComprar.addMouseListener((MouseListener) new MouseListener () {
			
			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnComprar.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnComprar.setBackground(new Color(0, 51, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnComprar.setBackground(new Color(0, 153, 51));
			}
			
		});
		
		btnComprar.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					int row = listaDeJogos.getSelectedRow();
					if(row >=0) {
						int idJogoSelecionado = (int) model.getValueAt(row, 0);
						Jogo jogo = crudJogos.read(idJogoSelecionado);
						if(jogo != null) {
							frameListaDeJogos.dispose();
							InterfaceJogoSelecionado jogoSelecionado = new InterfaceJogoSelecionado(clienteLogado ,jogo);
							jogoSelecionado.inicializar();
						}
					}
					
				}
			

				
		});
		
		frameListaDeJogos.getContentPane().add(btnComprar);
		
		JLabel lblJogos = new JLabel("LISTA DE JOGOS :");
		lblJogos.setHorizontalAlignment(SwingConstants.LEFT);
		lblJogos.setForeground(Color.WHITE);
		lblJogos.setBackground(Color.BLACK);
		lblJogos.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 25));
		lblJogos.setBounds(50, 10, 300, 50);
		frameListaDeJogos.getContentPane().add(lblJogos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Arial Black", Font.PLAIN, 18));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar Por :", "Mais Vendidos", "(A-Z)", "(Z-A)", "Data de Lançamento"}));
		comboBox.setBounds(400, 10, 300, 40);
		frameListaDeJogos.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener () {
			
			
			public void actionPerformed(ActionEvent e) {
				JogoDAO retornoLista = new JogoDAO();
				
				String opcaoEscolhida = (String)comboBox.getSelectedItem();
				if(!opcaoEscolhida.equals("Ordenar Por :")) {
					
					if(opcaoEscolhida.equals("Mais Vendidos")) {
						int numLinhas = model.getRowCount();
						for(int i =0; i  < numLinhas; ++i ) {
							model.removeRow(0);
							
						}
						Object jogosMaisVendidos [] = retornoLista.jogosMaisVendidos().toArray();		
						for(int i =0; i < jogosMaisVendidos.length; ++i) {
							Jogo jogo = (Jogo) jogosMaisVendidos[i];
							String desenvolvedoras[] = jogo.getDesenvolvedora().split(",");
							String distribuidoras [] = jogo.getDistribuidora().split(",");
							model.addRow(new Object[] {jogo.getIdJogo() , jogo.getNomeJogo() , jogos[i].getDataLancamento() , desenvolvedoras[0] , distribuidoras[0]});
						}
						scrollPane.setViewportView(listaDeJogos);
						retornoLista.desfazerConexao();
					}
					
					else if (opcaoEscolhida.equals("(A-Z)")) {
						
						int numLinhas = model.getRowCount();
						for(int i =0; i  < numLinhas; ++i ) {
							model.removeRow(0);
							
						}
						Object jogosOrdemAlfabetica[] = retornoLista.ordemAlfabetica().toArray();
						
						for(int i =0; i < jogosOrdemAlfabetica.length; ++i) {
							Jogo jogo = (Jogo) jogosOrdemAlfabetica[i];
							String desenvolvedoras[] = jogo.getDesenvolvedora().split(",");
							String distribuidoras [] = jogo.getDistribuidora().split(",");
							model.addRow(new Object[] {jogo.getIdJogo() , jogo.getNomeJogo() , jogos[i].getDataLancamento() , desenvolvedoras[0] , distribuidoras[0]});
						}
						scrollPane.setViewportView(listaDeJogos);
						retornoLista.desfazerConexao();
					}
					
					else if (opcaoEscolhida.equals("(Z-A)")) {
						
						int numLinhas = model.getRowCount();
						for(int i =0; i  < numLinhas; ++i ) {
							model.removeRow(0);		
						}
						
						Object jogosOrdemAlfabeticaInversa [] = retornoLista.ordemAlfabeticaInversa().toArray();		
						for(int i =0; i < jogosOrdemAlfabeticaInversa.length; ++i) {
							Jogo jogo = (Jogo) jogosOrdemAlfabeticaInversa[i];
							String desenvolvedoras[] = jogo.getDesenvolvedora().split(",");
							String distribuidoras [] = jogo.getDistribuidora().split(",");
							model.addRow(new Object[] {jogo.getIdJogo() , jogo.getNomeJogo() , jogos[i].getDataLancamento() , desenvolvedoras[0] , distribuidoras[0]});
						}
						scrollPane.setViewportView(listaDeJogos);
						retornoLista.desfazerConexao();
					}
					
					
					else if (opcaoEscolhida.equals("Data de Lançamento")) {
						
						int numLinhas = model.getRowCount();
						for(int i =0; i  < numLinhas; ++i ) {
							model.removeRow(0);					
						}
						
						Object jogosDataDeLancamento [] = retornoLista.dataDeLancamento().toArray();		
						for(int i =0; i < jogosDataDeLancamento.length; ++i) {
							Jogo jogo = (Jogo) jogosDataDeLancamento[i];
							String desenvolvedoras[] = jogo.getDesenvolvedora().split(",");
							String distribuidoras [] = jogo.getDistribuidora().split(",");
							model.addRow(new Object[] {jogo.getIdJogo() , jogo.getNomeJogo() , jogo.getDataLancamento() , desenvolvedoras[0] , distribuidoras[0]});
						}
						scrollPane.setViewportView(listaDeJogos);
						retornoLista.desfazerConexao();
					}
					
				}
				else {
					
					int numLinhas = model.getRowCount();
					for(int i =0; i  < numLinhas; ++i ) {
						model.removeRow(0);
					}
					
					Jogo jogos[] = retornoLista.readAll();
					for(int i =0; i < jogos.length; ++i) {
						Jogo jogo = jogos[i];
						String desenvolvedoras[] = jogo.getDesenvolvedora().split(",");
						String distribuidoras [] = jogo.getDistribuidora().split(",");
						model.addRow(new Object[] {jogos[i].getIdJogo() , jogos[i].getNomeJogo() , jogos[i].getDataLancamento() , desenvolvedoras[0] , distribuidoras[0]});
					}
					scrollPane.setViewportView(listaDeJogos);
					retornoLista.desfazerConexao();
				}
			}
		});
		frameListaDeJogos.addWindowListener(new WindowAdapter () {
			public void windowClosing (WindowEvent event) {
				InterfacePainel reiniciarPainel = new InterfacePainel(clienteLogado);
				reiniciarPainel.inicializar();
			}
		});
	}
}
