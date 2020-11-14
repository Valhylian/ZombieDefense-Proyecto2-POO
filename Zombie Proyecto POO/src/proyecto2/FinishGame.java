package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinishGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void initGameOver(String message) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishGame window = new FinishGame(message);
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
	public FinishGame(String message) {
		initialize(message);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String message) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(30, 44, 376, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GAME OVER!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(120, 91, 175, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("TERMINAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Interfaz.salir();
				frame.dispose();
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(144, 184, 151, 30);
		frame.getContentPane().add(btnNewButton);
	}
}
