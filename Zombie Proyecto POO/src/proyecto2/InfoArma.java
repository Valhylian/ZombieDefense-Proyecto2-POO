package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class InfoArma {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void initArma(String arma, Jugador jugador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoArma window = new InfoArma(arma, jugador);
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
	public InfoArma(String arma, Jugador jugador) {
		initialize(arma, jugador);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String arma, Jugador jugador) {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 192);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nombre = new JLabel(arma);
		nombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombre.setBounds(10, 11, 348, 38);
		frame.getContentPane().add(nombre);
		
		JButton btnNewButton = new JButton("Equipar.");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jugador.equiparArma(arma);
				frame.dispose();
				Interfaz.refrescar();
			}
		});
		btnNewButton.setBounds(300, 119, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		if (arma == "Katana Inicial") {
			JLabel damage = new JLabel("Damage: 10");
			damage.setBounds(10, 72, 171, 14);
			frame.getContentPane().add(damage);
			
			JLabel alcance = new JLabel("Alcance: 1");
			alcance.setBounds(10, 97, 171, 14);
			frame.getContentPane().add(alcance);
			
			JLabel ruido = new JLabel("Nivel de Ruido: 1");
			ruido.setBounds(10, 122, 224, 14);
			frame.getContentPane().add(ruido);
		}
		else if (arma == "Katana 2") {
			JLabel damage = new JLabel("Damage: 20");
			damage.setBounds(10, 72, 171, 14);
			frame.getContentPane().add(damage);
			
			JLabel alcance = new JLabel("Alcance: 1");
			alcance.setBounds(10, 97, 171, 14);
			frame.getContentPane().add(alcance);
			
			JLabel ruido = new JLabel("Nivel de Ruido: 2");
			ruido.setBounds(10, 122, 224, 14);
			frame.getContentPane().add(ruido);
		}
		
		else if (arma == "Catapulta Inicial") {
			JLabel damage = new JLabel("Damage: 30");
			damage.setBounds(10, 72, 171, 14);
			frame.getContentPane().add(damage);
			
			JLabel alcance = new JLabel("Alcance: 2");
			alcance.setBounds(10, 97, 171, 14);
			frame.getContentPane().add(alcance);
			
			JLabel ruido = new JLabel("Nivel de Ruido: 2");
			ruido.setBounds(10, 122, 224, 14);
			frame.getContentPane().add(ruido);
		}
		else if (arma == "Catapulta 2") {
			JLabel damage = new JLabel("Damage: 50");
			damage.setBounds(10, 72, 171, 14);
			frame.getContentPane().add(damage);
			
			JLabel alcance = new JLabel("Alcance: 3");
			alcance.setBounds(10, 97, 171, 14);
			frame.getContentPane().add(alcance);
			
			JLabel ruido = new JLabel("Nivel de Ruido: 3");
			ruido.setBounds(10, 122, 224, 14);
			frame.getContentPane().add(ruido);
		}
		else if (arma == "Super Gun") {
			JLabel damage = new JLabel("Damage: 100");
			damage.setBounds(10, 72, 171, 14);
			frame.getContentPane().add(damage);
			
			JLabel alcance = new JLabel("Alcance: 5");
			alcance.setBounds(10, 97, 171, 14);
			frame.getContentPane().add(alcance);
			
			JLabel ruido = new JLabel("Nivel de Ruido: 4");
			ruido.setBounds(10, 122, 224, 14);
			frame.getContentPane().add(ruido);
		}
		
	}
}
