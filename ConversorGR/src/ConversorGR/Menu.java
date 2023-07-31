package ConversorGR;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton menu1 = new JButton("Conversor Monedas");
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Monedas oforma = new Monedas();

				   oforma.setVisible(true);
				   frame.setVisible(false);
			}
		});
		menu1.setBounds(104, 112, 226, 25);
		frame.getContentPane().add(menu1);
		
		JButton menu3 = new JButton("Conversor Temperaturas");
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Temperaturas oforma = new Temperaturas();

				   oforma.setVisible(true);
				   frame.setVisible(false);
			}
		});
		menu3.setBounds(104, 186, 226, 25);
		frame.getContentPane().add(menu3);
		
		JTextPane txtpnMenu = new JTextPane();
		txtpnMenu.setFont(new Font("FreeMono", Font.BOLD, 25));
		txtpnMenu.setEditable(false);
		txtpnMenu.setText(" Menu Pincipal");
		txtpnMenu.setBounds(104, 22, 226, 36);
		frame.getContentPane().add(txtpnMenu);
		
		JButton menu2 = new JButton("Conversor Longitud");
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Longitud oforma = new Longitud();

				   oforma.setVisible(true);
				   frame.setVisible(false);
			}
		});
		menu2.setBounds(104, 149, 226, 25);
		frame.getContentPane().add(menu2);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
