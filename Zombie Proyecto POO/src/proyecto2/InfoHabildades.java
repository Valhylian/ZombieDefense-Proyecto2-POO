package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class InfoHabildades {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void info() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoHabildades window = new InfoHabildades();
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
	public InfoHabildades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 693, 456);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INFORMACION GENERAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 11, 351, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JUGADOR 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(72, 68, 79, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("JUGADOR 2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(248, 68, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("JUGADOR 3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(430, 68, 79, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblLvl = new JLabel("LVL 2");
		lblLvl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLvl.setBounds(10, 105, 50, 14);
		frame.getContentPane().add(lblLvl);
		
		JLabel lblLvl_1 = new JLabel("LVL 3");
		lblLvl_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLvl_1.setBounds(10, 155, 50, 14);
		frame.getContentPane().add(lblLvl_1);
		
		JLabel lblLvl_2 = new JLabel("LVL 4");
		lblLvl_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLvl_2.setBounds(10, 201, 79, 14);
		frame.getContentPane().add(lblLvl_2);
		
		JLabel lblNewLabel_4 = new JLabel("ELIMINAR OBSTACULOS.");
		lblNewLabel_4.setBounds(72, 105, 145, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblMoverseVeces = new JLabel("MOVERSE 2 VECES.");
		lblMoverseVeces.setBounds(72, 155, 145, 14);
		frame.getContentPane().add(lblMoverseVeces);
		
		JLabel lblMoverseEnDiagonal = new JLabel("MOVERSE EN DIAGONAL.");
		lblMoverseEnDiagonal.setBounds(72, 201, 145, 14);
		frame.getContentPane().add(lblMoverseEnDiagonal);
		
		JLabel lblUsarArmaDe = new JLabel("USAR ARMA DE FUEGO.");
		lblUsarArmaDe.setBounds(248, 105, 145, 14);
		frame.getContentPane().add(lblUsarArmaDe);
		
		JLabel lblUsarSuperArma = new JLabel("USAR SUPER ARMA.");
		lblUsarSuperArma.setBounds(248, 155, 145, 14);
		frame.getContentPane().add(lblUsarSuperArma);
		
		JLabel lblReiniciarVida = new JLabel("REINICIAR VIDA.");
		lblReiniciarVida.setBounds(248, 201, 145, 14);
		frame.getContentPane().add(lblReiniciarVida);
		
		JLabel lblDuplicaEfectoItem = new JLabel("DUPLICA EFECTO ITEM CURATIVO.");
		lblDuplicaEfectoItem.setBounds(430, 105, 204, 14);
		frame.getContentPane().add(lblDuplicaEfectoItem);
		
		JLabel lblDuplicaEfectoItem_1 = new JLabel("DUPLICA EFECTO ITEM EXPERIENCIA.");
		lblDuplicaEfectoItem_1.setBounds(430, 155, 237, 14);
		frame.getContentPane().add(lblDuplicaEfectoItem_1);
		
		JLabel lblDobleDaoarma = new JLabel("DOBLE DA\u00D1O (ARMA CORTO ALCANCE)");
		lblDobleDaoarma.setBounds(430, 201, 237, 14);
		frame.getContentPane().add(lblDobleDaoarma);
		
		JLabel lblNiveles = new JLabel("NIVELES");
		lblNiveles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNiveles.setBounds(10, 258, 79, 14);
		frame.getContentPane().add(lblNiveles);
		
		JLabel lblExp = new JLabel("EXP");
		lblExp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExp.setBounds(99, 258, 79, 14);
		frame.getContentPane().add(lblExp);
		
		JLabel label_2 = new JLabel("LVL 2");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 325, 50, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblLvl_4 = new JLabel("LVL 3");
		lblLvl_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLvl_4.setBounds(10, 361, 50, 14);
		frame.getContentPane().add(lblLvl_4);
		
		JLabel lblLvl_5 = new JLabel("LVL 4");
		lblLvl_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLvl_5.setBounds(10, 392, 50, 14);
		frame.getContentPane().add(lblLvl_5);
		
		JLabel lblLvl_3 = new JLabel("LVL 1");
		lblLvl_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLvl_3.setBounds(10, 292, 50, 14);
		frame.getContentPane().add(lblLvl_3);
		
		JLabel label = new JLabel("0 - 9");
		label.setBounds(87, 292, 145, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("10 - 29");
		label_1.setBounds(87, 325, 145, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("30 - 59");
		label_3.setBounds(87, 361, 145, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("60 - ...");
		label_4.setBounds(87, 392, 145, 14);
		frame.getContentPane().add(label_4);
	}
}
