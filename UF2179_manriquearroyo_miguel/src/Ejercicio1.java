import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textPrecio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxDestino;
	private JComboBox comboBoxOrigen;
	private JTextArea textVista;
	private JRadioButton rdbtnIda;
	private JRadioButton rdbtnIdaYVuelta;
	private JRadioButton rdbtnTarjetaDorada;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Venta de billetes");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setBounds(10, 11, 494, 60);
		contentPane.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 12, 514, 60);
		contentPane.add(panel);
		
		JLabel lblOrigen = new JLabel("Origen:");
		lblOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigen.setBounds(20, 103, 50, 26);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestino.setBounds(20, 140, 50, 26);
		contentPane.add(lblDestino);
		
		comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "Andujar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		comboBoxOrigen.setBounds(73, 105, 431, 22);
		contentPane.add(comboBoxOrigen);
		
		comboBoxDestino = new JComboBox();
		comboBoxDestino.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "Andujar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		comboBoxDestino.setBounds(73, 142, 431, 22);
		contentPane.add(comboBoxDestino);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(14, 180, 56, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(255, 180, 56, 14);
		contentPane.add(lblApellidos);
		
		textNombre = new JTextField();
		textNombre.setBounds(73, 177, 182, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(311, 177, 193, 22);
		contentPane.add(textApellidos);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(24, 221, 46, 14);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(73, 218, 50, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblBillete = new JLabel("Billete:");
		lblBillete.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBillete.setBounds(24, 265, 46, 14);
		contentPane.add(lblBillete);
		
		rdbtnIda = new JRadioButton("Ida");
		buttonGroup.add(rdbtnIda);
		rdbtnIda.setBounds(73, 261, 57, 23);
		contentPane.add(rdbtnIda);
		
		rdbtnIdaYVuelta = new JRadioButton("Ida y Vuelta");
		buttonGroup.add(rdbtnIdaYVuelta);
		rdbtnIdaYVuelta.setBounds(132, 261, 93, 23);
		contentPane.add(rdbtnIdaYVuelta);
		
		rdbtnTarjetaDorada = new JRadioButton("Tarjeta Dorada");
		buttonGroup.add(rdbtnTarjetaDorada);
		rdbtnTarjetaDorada.setBounds(235, 261, 109, 23);
		contentPane.add(rdbtnTarjetaDorada);
		rdbtnIda.setSelected(true);
		textVista = new JTextArea();
		textVista.setBounds(10, 324, 494, 141);
		contentPane.add(textVista);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxOrigen.getSelectedItem() == comboBoxDestino.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Debe elegir origen y destino diferentes");
				}else {
					calcular();
					pintaTexto();
				}
				
			}
		});
		btnCalcular.setBounds(207, 290, 89, 23);
		contentPane.add(btnCalcular);
	}
	
	public void calcular() {
		textVista.setText(""+comboBoxOrigen.getSelectedItem());
		double precio = calculaPrecio();	
	}
	
	public double calculaPrecio() {
		final double DESCUENTOIDAYVUELTA = 0.2;
		final double DESCUENTOTARJETADORADA = 0.3;
		
		double precio = Double.parseDouble(textPrecio.getText());
		if(rdbtnIdaYVuelta.isSelected()) {
			precio = precio * 2;	
			precio = precio  - (precio * DESCUENTOIDAYVUELTA);
		}
		
		if(rdbtnTarjetaDorada.isSelected()) {
			precio = (precio) - (precio * DESCUENTOTARJETADORADA);
		}
		return precio;
	}
	
	public void pintaTexto() {
		textVista.setText("Trayecto: "+ comboBoxOrigen.getSelectedItem() + " a " +comboBoxDestino.getSelectedItem() + System.lineSeparator() 
		
				+ "Viajero: " + textNombre.getText() + " " + textApellidos.getText() + System.lineSeparator()
				
				+ "Precio: " + calculaPrecio());
	}
}
