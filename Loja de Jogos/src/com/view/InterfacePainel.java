package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.classes.Cliente;
import com.classes.Compra;
import com.classes.ResultCompra;
import com.controler.DesfazerCompraControler;
import com.model.ClienteDAO;
import com.model.CompraDAO;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class InterfacePainel {

	private JFrame framePainelCliente;
	private JTable tableCompras;
	private Cliente clienteLogado;
	private JLabel lblComprasFeitas;
	private JTextField textComprasFeitas;
	private JTextField textDinheiroGasto;
	private JButton btnDesfazerCompra;
	private JButton btnRealizarCompra;
	/**
	 * Launch the application.
	 */
	public InterfacePainel (Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
	}
	
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePainel window = new InterfacePainel(clienteLogado);
					window.create();
					window.framePainelCliente.setVisible(true);
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
	private void create() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePainelCliente = new JFrame();
		framePainelCliente.setTitle("Painel do Cliente");
		framePainelCliente.getContentPane().setBackground(new Color(28,28,28));
		framePainelCliente.setResizable(false);
		framePainelCliente.setBounds(370, 150, 950, 450);
		framePainelCliente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePainelCliente.getContentPane().setLayout(null);
		
		JLabel lblListaDeCompras = new JLabel("LISTA DE COMPRAS " + clienteLogado.getUsuarioCliente() + " : ");
		lblListaDeCompras.setForeground(Color.WHITE);
		lblListaDeCompras.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 25));
		lblListaDeCompras.setBounds(10, 10, 850, 40);
		framePainelCliente.getContentPane().add(lblListaDeCompras);
		
		JScrollPane painelCompras = new JScrollPane();
		painelCompras.setBounds(150, 60, 750, 260);
		framePainelCliente.getContentPane().add(painelCompras);
		
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		cellRender.setForeground(Color.WHITE);
		cellRender.setBackground(new Color(28 , 28, 28	));
		cellRender.setFont(Font.getFont("Lucida Sans Unicode"));
		
		tableCompras = new JTable();
		tableCompras.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
		tableCompras.setForeground(Color.BLACK);
		tableCompras.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		tableCompras.setBackground(new Color(28,28,28));
		tableCompras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id. Compra :", "Nome do Jogo :", "Data de Compra :", "Plataforma :", "Preço R$ :"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Double.class
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
	
		tableCompras.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableCompras.getColumnModel().getColumn(0).setMinWidth(120);
		tableCompras.getColumnModel().getColumn(0).setMaxWidth(120);
		tableCompras.getColumnModel().getColumn(0).setResizable(false);
		tableCompras.getColumnModel().getColumn(1).setPreferredWidth(250);
		tableCompras.getColumnModel().getColumn(1).setMinWidth(250);
		tableCompras.getColumnModel().getColumn(1).setMaxWidth(250);
		tableCompras.getColumnModel().getColumn(1).setResizable(false);
		tableCompras.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableCompras.getColumnModel().getColumn(2).setMinWidth(120);
		tableCompras.getColumnModel().getColumn(2).setMaxWidth(120);
		tableCompras.getColumnModel().getColumn(2).setResizable(false);
		tableCompras.getColumnModel().getColumn(3).setPreferredWidth(140);
		tableCompras.getColumnModel().getColumn(3).setMinWidth(140);
		tableCompras.getColumnModel().getColumn(3).setMaxWidth(140);
		tableCompras.getColumnModel().getColumn(3).setResizable(false);
		tableCompras.getColumnModel().getColumn(4).setPreferredWidth(110);
		tableCompras.getColumnModel().getColumn(4).setMinWidth(110);
		tableCompras.getColumnModel().getColumn(4).setMaxWidth(110);
		tableCompras.getColumnModel().getColumn(4).setResizable(false);
		
		DefaultTableModel model = (DefaultTableModel)tableCompras.getModel();
		
		for(int i =0; i <5; ++i) {
			tableCompras.getColumnModel().getColumn(i).setCellRenderer(cellRender);
			tableCompras.getColumnModel().getColumn(i).setHeaderRenderer(cellRender);
		}
		
		CompraDAO crudCompras = new CompraDAO();
		
		Object compras [] = crudCompras.listaDeCompras(clienteLogado.getIdCliente()).toArray();
		
		for(int i =0; i < compras.length; ++i) {
			ResultCompra result = (ResultCompra)compras[i];
			
			model.addRow(new Object [] {result.getIdCompra() , result.getNomeJogo() , result.getDataDeCompra() , result.getPlataforma() , result.getPreco()});

		}
		painelCompras.setViewportView(tableCompras);
		
		lblComprasFeitas = new JLabel("Compras Feitas :");
		lblComprasFeitas.setForeground(Color.WHITE);
		lblComprasFeitas.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblComprasFeitas.setHorizontalAlignment(SwingConstants.LEFT);
		lblComprasFeitas.setBounds(10, 80, 120, 40);
		framePainelCliente.getContentPane().add(lblComprasFeitas);
		
		ClienteDAO crudClientes = new ClienteDAO();
		
		textComprasFeitas = new JTextField();
		textComprasFeitas.setHorizontalAlignment(SwingConstants.CENTER);
		textComprasFeitas.setForeground(Color.BLACK);
		textComprasFeitas.setEditable(false);
		textComprasFeitas.setBackground(Color.WHITE);
		textComprasFeitas.setText(""+clienteLogado.getComprasFeitas());
		textComprasFeitas.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		textComprasFeitas.setBounds(10, 130, 120, 40);
		framePainelCliente.getContentPane().add(textComprasFeitas);
		textComprasFeitas.setColumns(10);
		
		JLabel lblDinheiroGasto = new JLabel("Dinheiro Gasto :");
		lblDinheiroGasto.setForeground(Color.WHITE);
		lblDinheiroGasto.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblDinheiroGasto.setBounds(10, 190, 120, 40);
		framePainelCliente.getContentPane().add(lblDinheiroGasto);
		
		textDinheiroGasto = new JTextField();
		textDinheiroGasto.setForeground(Color.BLACK);
		textDinheiroGasto.setHorizontalAlignment(SwingConstants.LEFT);
		textDinheiroGasto.setBackground(Color.WHITE);
		textDinheiroGasto.setEditable(false);
		textDinheiroGasto.setText("R$ " + clienteLogado.getDinheiroGasto());
		textDinheiroGasto.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		textDinheiroGasto.setBounds(10, 240, 120, 40);
		framePainelCliente.getContentPane().add(textDinheiroGasto);
		textDinheiroGasto.setColumns(10);
		
		btnDesfazerCompra = new JButton("Desfazer Compra");
		btnDesfazerCompra.setForeground(Color.WHITE);
		btnDesfazerCompra.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnDesfazerCompra.setBackground(new Color(255, 0, 0));
		btnDesfazerCompra.setBounds(180, 340, 250, 50);
		btnDesfazerCompra.addMouseListener((MouseListener) new MouseListener () {
			
			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
			
				btnDesfazerCompra.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnDesfazerCompra.setBackground(new Color(102, 0, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnDesfazerCompra.setBackground(new Color(255, 0, 0));
			}
			
		});
		
		btnDesfazerCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableCompras.getSelectedRow();
				if(row >=0){
					int idCompraSelecionada =  (int) model.getValueAt(row, 0);
					String nomeJogo = (String)model.getValueAt(row, 1);
					String plataforma = (String)model.getValueAt(row, 3);
					
					if(JOptionPane.showInternalConfirmDialog(null, "Deseja desfazer a Compra de " + nomeJogo + " - " + plataforma + " ?") == 0) {
						framePainelCliente.dispose();
						DesfazerCompraControler desfazer = new DesfazerCompraControler(idCompraSelecionada , clienteLogado);
						desfazer.actionPerformed(e);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um Jogo para Desfazer a Compra !!!");
				}
			}
		});
		

		framePainelCliente.getContentPane().add(btnDesfazerCompra);
		
		btnRealizarCompra = new JButton("Comprar Jogo");
		btnRealizarCompra.setForeground(Color.WHITE);
		btnRealizarCompra.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnRealizarCompra.setBackground(new Color(0, 153, 51));
		btnRealizarCompra.setBounds(600, 340, 250, 50);
		btnRealizarCompra.addMouseListener((MouseListener) new MouseListener () {
			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnRealizarCompra.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnRealizarCompra.setBackground(new Color(0, 51, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnRealizarCompra.setBackground(new Color(0, 153, 51));
			}
			
		});
		
		btnRealizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePainelCliente.dispose();
				InterfaceListaJogos listaDeJogos = new InterfaceListaJogos(clienteLogado);
				listaDeJogos.inicializar();
			}
		});
		
		framePainelCliente.getContentPane().add(btnRealizarCompra);
		
		framePainelCliente.addWindowListener(new WindowAdapter () {
			public void windowClosing (WindowEvent event) {
				
				if(JOptionPane.showConfirmDialog(null , "Encerrar Sistema", "Deseja Deslogar ?", 1) == 0) {
					framePainelCliente.dispose();
					JOptionPane.showMessageDialog(null, clienteLogado.getNomeCliente() + " deslogado com sucesso");
					InterfaceLogin login = new InterfaceLogin ();
					login.inicializar();
				}
				
			}
		});

		
	}
}
