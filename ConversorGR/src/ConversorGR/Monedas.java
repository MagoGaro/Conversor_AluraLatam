package ConversorGR;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;


import javax.swing.SwingConstants;

public class Monedas {

	private JFrame frame;
	private JButton btn;
	private JTextField txt;
	private JComboBox cmb;
	private JComboBox cmb2;
	private JLabel lbl;
	

       public String [] Moneditas = {
                                "Pesos a Dolar",
                                "Pesos a Euros",
                                "Pesos a Libra",
                                "Pesos a Yuan",
                                "Dolar a Pesos",
                                "Euros a Pesos",
                                "Libra a Pesos",
                                "Yuan a Pesos"};

	
	public double dolar = 548.50;
	public double euro = 390.19;
	public double libra = 270.89;
	public double yuan = 260.30;
	
	public double valorInput = 0.00;
	private JButton btnVolverAlMenu;
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monedas window = new Monedas();
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
	public Monedas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setBounds(67, 81, 114, 19);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<String>();
		cmb.setModel(new DefaultComboBoxModel<>(Moneditas));
		cmb.setBounds(122, 32, 189, 24);
		frame.getContentPane().add(cmb);
		
		//evento boton
		btn = new JButton("Convertir");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(161, 134, 117, 25);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("0");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(233, 83, 182, 15);
		frame.getContentPane().add(lbl);
		
		btnVolverAlMenu = new JButton("Volver al Menu");
		btnVolverAlMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu oforma = new Menu();

				   oforma.setVisible(true);
				   frame.setVisible(false);
			}
		});
		btnVolverAlMenu.setBounds(283, 233, 145, 25);
		frame.getContentPane().add(btnVolverAlMenu);
		
	}
	
	public void Convertir() {
		if (ValidarEntrada(txt.getText())) {
		String moneda = (String)cmb.getSelectedItem();
		
		switch(moneda) {
		case "Pesos a Dolar" :
			Pesos_A_Moneda(dolar);
			break;
		case "Pesos a Euros" :
			Pesos_A_Moneda(euro);
			break;
		case "Pesos a Libra" :
			Pesos_A_Moneda(libra);
			break;
		case "Pesos a Yuan" :
			Pesos_A_Moneda(yuan);
			break;
		case "Dolar a Pesos" :
			Moneda_A_Pesos(dolar);
			break;
		case "Euros a Pesos" :
			Moneda_A_Pesos(euro);
			break;
		case "Libra a Pesos" :
			Moneda_A_Pesos(libra);
			break;
		case "Yuan a Pesos" :
			Moneda_A_Pesos(yuan);
			break;
			default:
				throw new IllegalArgumentException("Valor Inesperado: " + moneda);
		}
		}
	}
	
	
	
	public boolean ValidarEntrada(String texto) {
		try {
			double n = Double.parseDouble(texto);
			if(n>0) {
				valorInput = n;
			}
			return true;
		}catch(NumberFormatException e) {
			lbl.setText("Ingresar Solo Números.");
			lbl.setForeground(Color.RED);
			return false;
		}
	}
	
	public void Pesos_A_Moneda(double n) {
		double r = valorInput / n;
		lbl.setText("" + Redondear(r));
	}
	
	public void Moneda_A_Pesos(double n) {
		double r = valorInput * n;
		lbl.setText("" + Redondear(r));
	}
	
	public String Redondear(double n) {
		DecimalFormat v = new DecimalFormat("0.00");
		v.setRoundingMode(RoundingMode.HALF_UP);
		return v.format(n);
	}

	public void setVisible(boolean b) {	
		frame.setVisible(b);
	}

}
