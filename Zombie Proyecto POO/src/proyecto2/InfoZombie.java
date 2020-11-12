package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class InfoZombie {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void iniInfoZombie(Enemigo zombie) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoZombie window = new InfoZombie(zombie);
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
	public InfoZombie(Enemigo zombie) {
		initialize(zombie);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Enemigo zombie) {
		frame = new JFrame();
		frame.setBounds(100, 100, 423, 252);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zombie tipo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 98, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel imagen = new JLabel("");
		
		if (zombie.tipo == 11) {
			JLabel tipo = new JLabel("BASICO (11)");
			tipo.setFont(new Font("Tahoma", Font.BOLD, 15));
			tipo.setBounds(118, 11, 147, 27);
			frame.getContentPane().add(tipo);
			
			imagen.setIcon(Interfaz.zombie1);
			
			JLabel habilidad = new JLabel("DOBLE VIDA");
			habilidad.setBounds(103, 109, 184, 14);
			frame.getContentPane().add(habilidad);
			
		}
		else if (zombie.tipo == 22) {
			JLabel tipo = new JLabel("MEDIO (22)");
			tipo.setFont(new Font("Tahoma", Font.BOLD, 15));
			tipo.setBounds(118, 11, 147, 27);
			frame.getContentPane().add(tipo);
			
			imagen.setIcon(Interfaz.zombie2);
			
			JLabel habilidad = new JLabel("DOBLE DANO");
			habilidad.setBounds(103, 109, 184, 14);
			frame.getContentPane().add(habilidad);
		}
		else {
				JLabel tipo = new JLabel("ALTO (33)");
				tipo.setFont(new Font("Tahoma", Font.BOLD, 15));
				tipo.setBounds(118, 11, 147, 27);
				frame.getContentPane().add(tipo);
				
				imagen.setIcon(Interfaz.zombie3);
				
				JLabel habilidad = new JLabel("MAYOR RANGO DE VISION");
				habilidad.setBounds (103, 109, 184, 14);
				frame.getContentPane().add(habilidad);

		}
		
		imagen.setBounds(275, 24, 104, 89);
		frame.getContentPane().add(imagen);

		JLabel lblNewLabel_1 = new JLabel("VIDA:");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HABILIDAD:");
		lblNewLabel_2.setBounds(10, 109, 72, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel vida = new JLabel(Integer.toString(zombie.vida));
		vida.setBounds(103, 71, 46, 14);
		frame.getContentPane().add(vida);
		
		JLabel lblVision = new JLabel("VISION:");
		lblVision.setBounds(10, 149, 72, 14);
		frame.getContentPane().add(lblVision);
		
		JLabel lblFuerza = new JLabel("FUERZA:");
		lblFuerza.setBounds(10, 188, 72, 14);
		frame.getContentPane().add(lblFuerza);
		
		JLabel vision = new JLabel(Integer.toString(zombie.vision));
		vision.setBounds(92, 149, 46, 14);
		frame.getContentPane().add(vision);
		
		JLabel fuerza = new JLabel(Integer.toString(zombie.fuerza)
				);
		fuerza.setBounds(92, 188, 46, 14);
		frame.getContentPane().add(fuerza);
		
	
	}
}
