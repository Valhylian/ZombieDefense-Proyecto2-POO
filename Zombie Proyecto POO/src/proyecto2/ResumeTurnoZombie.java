package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ResumeTurnoZombie {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumeTurnoZombie window = new ResumeTurnoZombie();
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
	public ResumeTurnoZombie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 405, 271);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TODOS LOS ZOMBIES TERMINARON SU ATAQUE!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 369, 74);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz.refrescar();
				frame.dispose();
				Tablero.continuarZombie = true;
				
			}
		});
		btnNewButton.setBounds(115, 123, 152, 40);
		frame.getContentPane().add(btnNewButton);
		frame.setLocationRelativeTo(null);
		//frame.setVisible(true);
	}
}
