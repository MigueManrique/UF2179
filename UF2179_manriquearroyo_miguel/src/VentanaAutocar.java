import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAutocar extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textKilometros;
	private JTextField textModelo;
	private ArrayList<Autocar> listaAutocares;
	private JSpinner spinnerPlazas;
	private JTextArea textAreaVista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocar frame = new VentanaAutocar();
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
	public VentanaAutocar() {
		listaAutocares = new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestinAutocares = new JLabel("Gesti\u00F3n Autocares");
		lblGestinAutocares.setForeground(Color.WHITE);
		lblGestinAutocares.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestinAutocares.setBackground(Color.BLACK);
		lblGestinAutocares.setBounds(10, 0, 585, 60);
		contentPane.add(lblGestinAutocares);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 1, 595, 60);
		contentPane.add(panel);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatricula.setBounds(10, 79, 84, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(10, 116, 84, 14);
		contentPane.add(lblMarca);
		
		JLabel lblKilometros = new JLabel("Kilometros:");
		lblKilometros.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilometros.setBounds(10, 156, 84, 14);
		contentPane.add(lblKilometros);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setBounds(269, 116, 84, 14);
		contentPane.add(lblModelo);
		
		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlazas.setBounds(269, 156, 84, 14);
		contentPane.add(lblPlazas);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(104, 76, 155, 17);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(104, 113, 155, 17);
		contentPane.add(textMarca);
		
		textKilometros = new JTextField();
		textKilometros.setColumns(10);
		textKilometros.setBounds(104, 153, 155, 17);
		contentPane.add(textKilometros);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(363, 113, 84, 17);
		contentPane.add(textModelo);
		
		textAreaVista = new JTextArea();
		textAreaVista.setBounds(10, 240, 542, 148);
		contentPane.add(textAreaVista);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAutocar();
			}
		});
		btnInsertar.setBounds(104, 206, 89, 23);
		contentPane.add(btnInsertar);
		
		JButton btnMostrarDatos = new JButton("Mostrar Datos");
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarLista();
			}
		});
		btnMostrarDatos.setBounds(238, 206, 131, 23);
		contentPane.add(btnMostrarDatos);
		
		spinnerPlazas = new JSpinner();
		spinnerPlazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		spinnerPlazas.setBounds(363, 153, 50, 20);
		contentPane.add(spinnerPlazas);
	}
	public void mostrarLista() {
		textAreaVista.setText("");
		for (Autocar a : listaAutocares) {
			textAreaVista.setText(textAreaVista.getText() + a.toString() + System.lineSeparator());
		}
	}
	
	public void addAutocar() {
		Autocar a = new Autocar(textMatricula.getText(), textMarca.getText(), textModelo.getText(),  Integer.parseInt(textKilometros.getText()), (int)spinnerPlazas.getValue());
		listaAutocares.add(a);
	}
}
