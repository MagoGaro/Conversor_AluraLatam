package ConversorGR;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class Longitud {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Longitud window = new Longitud();
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
	public Longitud() {
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
		
		JButton btnVolverAlMenu = new JButton("Volver al Menu");
		btnVolverAlMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu oforma = new Menu();

				   oforma.setVisible(true);
				   frame.setVisible(false);
			}
		});
		btnVolverAlMenu.setBounds(302, 233, 138, 25);
		frame.getContentPane().add(btnVolverAlMenu);
		
		JTextPane txtpnProximamente = new JTextPane();
		txtpnProximamente.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnProximamente.setForeground(Color.BLUE);
		txtpnProximamente.setText("PROXIMAMENTE");
		txtpnProximamente.setEditable(false);
		txtpnProximamente.setBounds(132, 100, 155, 21);
		frame.getContentPane().add(txtpnProximamente);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
