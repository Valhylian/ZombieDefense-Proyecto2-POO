package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Inventario {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void initInventario(Jugador jugador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario window = new Inventario(jugador);
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
	public Inventario(Jugador jugador) {
		initialize(jugador);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Jugador jugador) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 514, 425);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("INVENTARIO.");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		titulo.setBounds(147, 11, 128, 14);
		frame.getContentPane().add(titulo);
		
		JLabel tituloArmas = new JLabel("ARMAS:");
		tituloArmas.setFont(new Font("Tahoma", Font.BOLD, 14));
		tituloArmas.setBounds(36, 63, 128, 14);
		frame.getContentPane().add(tituloArmas);
		
		JLabel tituloItems = new JLabel("ITEMS:");
		tituloItems.setFont(new Font("Tahoma", Font.BOLD, 14));
		tituloItems.setBounds(313, 63, 128, 14);
		frame.getContentPane().add(tituloItems);
		
		JButton btnNewButton = new JButton("Katana Inicial");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//jugador.equiparArma("Katana Inicial");
				InfoArma.initArma("Katana Inicial", jugador);
				//Interfaz.refrescar();
			}
		});
		btnNewButton.setBounds(10, 122, 126, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnKatana = new JButton("Katana 2");
		btnKatana.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//jugador.equiparArma("Katana 2");
				//Interfaz.refrescar();
				InfoArma.initArma("Katana 2", jugador);
			}
		});
		btnKatana.setBounds(10, 156, 126, 23);
		frame.getContentPane().add(btnKatana);
		
		JButton btnPistolaInicial = new JButton("Catapulta Inicial");
		btnPistolaInicial.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//jugador.equiparArma("Catapulta Inicial");
				//Interfaz.refrescar();
				InfoArma.initArma("Catapulta Inicial", jugador);
			}
		});
		btnPistolaInicial.setBounds(10, 236, 126, 23);
		frame.getContentPane().add(btnPistolaInicial);
		
		JButton btnPistola = new JButton("Catapulta 2");
		btnPistola.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//jugador.equiparArma("Catapulta 2");
				//Interfaz.refrescar();
				InfoArma.initArma("Catapulta 2", jugador);
			}
		});
		btnPistola.setBounds(10, 270, 126, 23);
		frame.getContentPane().add(btnPistola);
		
		JButton btnSuper = new JButton("Super Gun");
		btnSuper.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//jugador.equiparArma("Super Gun");
				//Interfaz.refrescar();
				InfoArma.initArma("Super Gun", jugador);
			}
		});
		btnSuper.setBounds(10, 351, 126, 23);
		frame.getContentPane().add(btnSuper);
		
		JLabel lblNewLabel = new JLabel("Corto Alcance:");
		lblNewLabel.setBounds(10, 97, 154, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLargoAlcance = new JLabel("Largo Alcance:");
		lblLargoAlcance.setBounds(10, 211, 154, 14);
		frame.getContentPane().add(lblLargoAlcance);
		
		JLabel lblEspeciales = new JLabel("Especiales:");
		lblEspeciales.setBounds(10, 326, 154, 14);
		frame.getContentPane().add(lblEspeciales);
		
		JButton btnNewButton_1 = new JButton("Pocion Curativa.");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				InfoItem.iniciarItem(jugador, "curativo");
			}
		});
		btnNewButton_1.setBounds(272, 122, 147, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pocion Experiencia.");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				InfoItem.iniciarItem(jugador, "experiencia");
			}
		});
		btnNewButton_2.setBounds(272, 171, 147, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel(jugador.cantArma("Katana Inicial"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(147, 126, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(jugador.cantArma("Katana 2"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(147, 160, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(jugador.cantArma("Catapulta Inicial"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(147, 245, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(jugador.cantArma("Catapulta 2"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(147, 279, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(jugador.cantArma("Super Gun"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(147, 355, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblCant = new JLabel("Cant.");
		lblCant.setHorizontalAlignment(SwingConstants.CENTER);
		lblCant.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCant.setBounds(147, 97, 46, 14);
		frame.getContentPane().add(lblCant);
		
		JLabel label = new JLabel(jugador.cantItem("curativo"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(423, 126, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(jugador.cantItem("experiencia"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(423, 175, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Cant.");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(423, 97, 46, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblRuido = new JLabel("Ruido.");
		lblRuido.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRuido.setBounds(214, 97, 46, 14);
		frame.getContentPane().add(lblRuido);
		
		JLabel lblNewLabel_6 = new JLabel("1");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(214, 126, 37, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel label_3 = new JLabel("2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(214, 160, 37, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("2");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(214, 245, 37, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("3");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(214, 279, 37, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("4");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(214, 355, 37, 14);
		frame.getContentPane().add(label_6);
	}
	
	static void refrescarInventario() {
		frame.dispose();
		//bloquear btn de la ventana emergente (USAR ITEM)
	}
}
