package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import inicial.AnalizadorLexico;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EntradaDatos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tbTokens;
	private AnalizadorLexico al;
	private JTextArea txtrEntrada;
	private JLabel lblIds;
	private JLabel lblReales;
	private JLabel lblEnteros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntradaDatos frame = new EntradaDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EntradaDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrEntrada = new JTextArea();
		txtrEntrada.setBounds(22, 12, 253, 224);
		contentPane.add(txtrEntrada);
		
		tbTokens = new JTable();
		tbTokens.setBounds(287, 12, 214, 341);
		contentPane.add(tbTokens);
		
		JButton btnAnanalizar = new JButton("Analizar");
		btnAnanalizar.setBounds(22, 248, 117, 25);
		contentPane.add(btnAnanalizar);
		btnAnanalizar.addActionListener(this);
		
		lblIds = new JLabel("Ids:");
		lblIds.setBounds(22, 285, 253, 15);
		contentPane.add(lblIds);
		
		lblReales = new JLabel("Reales:");
		lblReales.setBounds(22, 312, 253, 15);
		contentPane.add(lblReales);
		
		lblEnteros = new JLabel("Enteros:");
		lblEnteros.setBounds(22, 339, 253, 15);
		contentPane.add(lblEnteros);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		al=new AnalizadorLexico(new StringReader(txtrEntrada.getText()));
		try {
			al.yylex();
			lblIds.setText("Ids: "+al.ids);
			lblReales.setText("Reales: "+al.reales);
			lblEnteros.setText("Enteros: "+al.enteros);
			ArrayList<String> a1=al.listaD;
			ArrayList<String> a2=al.listaT;
			DefaultTableModel d=new DefaultTableModel();
			d.addColumn("Tokens");
			d.addColumn("Descripcion");
			for(int i=0;i<a1.size();i++){
				d.addRow(new Object[]{a1.get(i),a2.get(i)});
			}
			tbTokens.setModel(d);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
