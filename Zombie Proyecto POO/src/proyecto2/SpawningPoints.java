package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class SpawningPoints {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void initSpawning() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpawningPoints window = new SpawningPoints();
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
	public SpawningPoints() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 189);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SE ACTIVAR\u00C1N LOS SPAWNING POINTS DE ZOMBIES.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(44, 26, 328, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tablero.spawningPoints(Main.turno);
				Interfaz.refrescar();
				frame.dispose();
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(160, 91, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblYSeReinicia = new JLabel("Y SE REINICIA EL NIVEL DE RUIDO.");
		lblYSeReinicia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYSeReinicia.setBounds(90, 52, 328, 15);
		frame.getContentPane().add(lblYSeReinicia);
	}
}
