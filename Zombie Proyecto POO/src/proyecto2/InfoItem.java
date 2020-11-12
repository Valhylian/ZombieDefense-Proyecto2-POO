package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoItem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void iniciarItem (Jugador jugador, String tipo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoItem window = new InfoItem(jugador,tipo);
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
	public InfoItem(Jugador jugador, String tipo) {
		initialize(jugador, tipo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Jugador jugador, String tipo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 262, 255);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		if (tipo == "curativo") {
			JLabel name = new JLabel("Posion Curativa");
			name.setHorizontalAlignment(SwingConstants.CENTER);
			name.setFont(new Font("Tahoma", Font.BOLD, 16));
			name.setBounds(10, 11, 237, 40);
			frame.getContentPane().add(name);
			
			JLabel type = new JLabel("Curativo");
			type.setBounds(91, 64, 65, 14);
			frame.getContentPane().add(type);
			
			JButton usar = new JButton("Usar Item.");
			usar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jugador.usarItem(jugador, "curativo");
					frame.dispose();
					Interfaz.refrescar();
				}
			});
			usar.setBounds(10, 163, 100, 23);
			frame.getContentPane().add(usar);
		}
		
		else {
			JLabel name = new JLabel("Posion Experiencia");
			name.setHorizontalAlignment(SwingConstants.CENTER);
			name.setFont(new Font("Tahoma", Font.BOLD, 16));
			name.setBounds(10, 11, 237, 40);
			frame.getContentPane().add(name);
			
			JLabel type = new JLabel("Experiencia");
			type.setBounds(91, 64, 65, 14);
			frame.getContentPane().add(type);
			
			JButton usar = new JButton("Usar Item.");
			usar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					jugador.usarItem(jugador, "experiencia");
					System.out.println("aquii" + jugador.tipo);
					frame.dispose();
					Interfaz.refrescar();
				}
			});
			usar.setBounds(10, 163, 100, 23);
			frame.getContentPane().add(usar);
		}
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 62, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Puntos +:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 103, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel points = new JLabel("10");
		points.setBounds(91, 105, 46, 14);
		frame.getContentPane().add(points);
		
		
	}

}
