package ConversorGR;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Temperaturas {

	private JFrame frame;

	
	public String [] Grados = {
            "Celsius a Fahrenheit",
            "Celsius a Kelvin",
            "Fahrenheit a Celsius",
            "Fahrenheit a Kelvin",
            "Kelvin a Celsius",
            "Kelvin a Fahrenheit"
            };
	
	public double valorInput = 0.00;
	private JTextField txtt;
	private JLabel lblt;
	private JButton btnt;
	private JComboBox cmbt;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperaturas window = new Temperaturas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Temperaturas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Volver al Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu oforma = new Menu();

				   oforma.setVisible(true);
				   frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(268, 233, 160, 25);
		frame.getContentPane().add(btnNewButton);
		
		lblt = new JLabel("0");
		lblt.setHorizontalAlignment(SwingConstants.CENTER);
		lblt.setBounds(207, 90, 187, 15);
		frame.getContentPane().add(lblt);
		
		cmbt = new JComboBox<String>();
		cmbt.setModel(new DefaultComboBoxModel<>(Grados));
		cmbt.setBounds(131, 35, 187, 24);
		frame.getContentPane().add(cmbt);
		
		txtt = new JTextField();
		txtt.setBounds(55, 88, 114, 19);
		frame.getContentPane().add(txtt);
		txtt.setColumns(10);
		
		btnt = new JButton("Convertir");
		btnt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConvertirT();
			}
		});
		btnt.setBounds(151, 139, 117, 25);
		frame.getContentPane().add(btnt);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
	
	public boolean ValidarEntrada(String texto) {
		try {
			valorInput = Double.parseDouble(texto);
			return true;
		}catch(NumberFormatException e) {
			lblt.setText("Ingresar Solo Números.");
			lblt.setForeground(Color.RED);
			return false;
		}
	}
	
	public String Redondear(double n) {
		DecimalFormat v = new DecimalFormat("0.00");
		v.setRoundingMode(RoundingMode.HALF_DOWN);
		return v.format(n);
	}
	
	public void ConvertirT() {
		if (ValidarEntrada(txtt.getText())) {
			String grados = (String)cmbt.getSelectedItem();
			switch(grados) {
			case "Celsius a Fahrenheit" :
				double r = valorInput * 1.8+32;
				lblt.setText("" + r);
				break;
			case "Celsius a Kelvin" :
				r = valorInput + 273.15;
				lblt.setText("" + r);
				break;
			case "Fahrenheit a Celsius" :
				r = (valorInput - 32) * 0.5556;
				lblt.setText("" + Redondear(r));
				break;
			case "Fahrenheit a Kelvin" :
				r = (valorInput - 32) * 0.5556 + 273.15;
				lblt.setText("" + Redondear(r));
				break;
			case "Kelvin a Celsius" :
				r = valorInput - 273.15;
				lblt.setText("" + r);
				break;
			case "Kelvin a Fahrenheit" :
				r = (valorInput - 273.15) * 1.8+32;
				lblt.setText("" + Redondear(r));
				break;
				default:
					throw new IllegalArgumentException("Valor Inesperado: " + grados);
			}
		}
	}
}
