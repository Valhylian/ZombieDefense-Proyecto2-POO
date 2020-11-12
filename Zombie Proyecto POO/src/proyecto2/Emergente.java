package proyecto2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Color;

public class Emergente {

	public static boolean moverse = true;
	public static boolean atacar = true;
	public static boolean usarItem = true;
	private static JFrame frame;
	static ImageIcon abajo=new ImageIcon("imagenes"+File.separator+"flechaAbajo.png");
	
	
	public static void init(int type, Jugador jugador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emergente window = new Emergente(type, jugador);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Emergente(int type, Jugador jugador) {
		initialize(type, jugador);
	}

	private void initialize(int type, Jugador jugador) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		cargarDatos(type, jugador);
		
	}
	
	public static void cargarDatos(int type, Jugador jugador) {
		JLabel lblIcon = new JLabel();
		if (type==0) 
			lblIcon.setIcon(Interfaz.pj1);
		else if (type==1) 
			lblIcon.setIcon(Interfaz.pj2);
		else if (type==2) 
			lblIcon.setIcon(Interfaz.pj3);
		lblIcon.setBounds(10, 11, 72, 65);
		frame.getContentPane().add(lblIcon);
		
		JButton este = new JButton("\u2192");
		este.setBackground(Color.GRAY);
		este.setFont(new Font("Tahoma", Font.BOLD, 10));
		if (moverse == false) {
			este.setEnabled(false);
		}
		else {
			este.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("E", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		este.setBounds(116, 149, 45, 44);
		frame.getContentPane().add(este);
		
		JButton norte = new JButton("\u2191");
		norte.setForeground(Color.BLACK);
		norte.setFont(new Font("Tahoma", Font.BOLD, 14));
		norte.setBackground(Color.GRAY);
		if (moverse == false) {
			norte.setEnabled(false);
		}
		else {
			norte.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("N", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		norte.setBounds(72, 103, 45, 44);
		frame.getContentPane().add(norte);
		
		JButton sur = new JButton("\u2193");
		sur.setFont(new Font("Tahoma", Font.BOLD, 14));
		sur.setBackground(Color.GRAY);
		if (moverse == false) {
			sur.setEnabled(false);
		}
		else {
			sur.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("S", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		sur.setBounds(72, 193, 45, 44);
		frame.getContentPane().add(sur);
		
		JButton oeste = new JButton("\u2190");
		oeste.setFont(new Font("Tahoma", Font.BOLD, 10));
		oeste.setBackground(Color.GRAY);
		if (moverse == false) {
			oeste.setEnabled(false);
		}
		else {
			oeste.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("O", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		oeste.setBounds(28, 149, 45, 44);
		frame.getContentPane().add(oeste);
		
		JLabel lblNewLabel_1 = new JLabel("SAMURAI BASICO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(116, 22, 135, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton noreste = new JButton("");
		noreste.setBackground(Color.LIGHT_GRAY);
		if (moverse == false) {
			noreste.setEnabled(false);
		}
		else {
			noreste.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("NE", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		noreste.setBounds(126, 110, 28, 31);
		frame.getContentPane().add(noreste);
		
		JButton sureste = new JButton("");
		sureste.setBackground(Color.LIGHT_GRAY);
		if (moverse == false) {
			sureste.setEnabled(false);
		}
		else {
			sureste.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("SE", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		sureste.setBounds(126, 204, 28, 31);
		frame.getContentPane().add(sureste);
		
		JButton suroeste = new JButton("");
		suroeste.setBackground(Color.LIGHT_GRAY);
		if (moverse == false) {
			suroeste.setEnabled(false);
		}
		else {
			suroeste.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("SO", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		suroeste.setBounds(38, 204, 28, 31);
		frame.getContentPane().add(suroeste);
		
		JButton noroeste = new JButton("");
		noroeste.setBackground(Color.LIGHT_GRAY);
		if (moverse == false) {
			noroeste.setEnabled(false);
		}
		else {
			noroeste.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.mover("NO", 1);
					Interfaz.refrescar();
				}
			});
		}
		
		noroeste.setBounds(38, 114, 28, 31);
		frame.getContentPane().add(noroeste);
		
		JButton btnUsarItem = new JButton("USAR ITEM");
		if (usarItem == false) {
			btnUsarItem.setEnabled(false);
		}
		else {
			btnUsarItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Inventario.initInventario(jugador);
					System.out.println("aquii" + jugador.tipo);
					Interfaz.refrescar();
				}
			});
		}
		
		btnUsarItem.setBackground(Color.GRAY);
		btnUsarItem.setBounds(272, 173, 135, 23);
		frame.getContentPane().add(btnUsarItem);
		
		JButton btnNewButton_1 = new JButton("ATACAR");
		if (atacar == false) {
			btnNewButton_1.setEnabled(false);
		}
		else {
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					jugador.atacar();
				}
			});
		}
		
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(272, 129, 135, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnTerminarTurno = new JButton("TERMINAR TURNO");
		btnTerminarTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tablero.timingJugador = 3;
			}
		});
		btnTerminarTurno.setBackground(Color.GRAY);
		btnTerminarTurno.setBounds(246, 219, 161, 23);
		frame.getContentPane().add(btnTerminarTurno);
	}
	
	
	static void cerrarEmergente() {
		frame.dispose();	
	}
	
	static void desactivarBotonMovimiento(int type, Jugador jugador) {
		moverse = false;
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		cargarDatos(type,jugador) ;
		frame.setVisible(true);	
	}
	static void desactivarBotones(int type, Jugador jugador) {
		System.out.println("Main Turno"+ jugador.tipo);
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		cargarDatos(type,jugador) ;
		frame.setVisible(true);	
	}
	
	public static void cargarDatosMovimientoBloqueado(int type, Jugador jugador) {
		JLabel lblIcon = new JLabel();
		if (type==0) 
			lblIcon.setIcon(Interfaz.pj1);
		else if (type==1) 
			lblIcon.setIcon(Interfaz.pj2);
		else if (type==2) 
			lblIcon.setIcon(Interfaz.pj3);
		lblIcon.setBounds(10, 11, 72, 65);
		frame.getContentPane().add(lblIcon);
		
		JButton este = new JButton("\u2192");
		este.setBackground(Color.GRAY);
		este.setFont(new Font("Tahoma", Font.BOLD, 10));
		este.setBounds(116, 162, 45, 44);
		este.setEnabled(false);
		frame.getContentPane().add(este);
		
		JButton btnTerminarTurno = new JButton("TERMINAR TURNO");
		btnTerminarTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tablero.timingJugador = 3;
			}
		});
		btnTerminarTurno.setBackground(Color.GRAY);
		btnTerminarTurno.setBounds(246, 219, 161, 23);
		frame.getContentPane().add(btnTerminarTurno);
		
		JButton norte = new JButton("\u2191");
		norte.setForeground(Color.BLACK);
		norte.setFont(new Font("Tahoma", Font.BOLD, 14));
		norte.setBackground(Color.GRAY);
		norte.setBounds(72, 116, 45, 44);
		norte.setEnabled(false);
		frame.getContentPane().add(norte);
		
		JButton sur = new JButton("\u2193");
		sur.setFont(new Font("Tahoma", Font.BOLD, 14));
		sur.setBackground(Color.GRAY);
		sur.setBounds(72, 206, 45, 44);
		sur.setEnabled(false);
		frame.getContentPane().add(sur);
		
		
		JButton oeste = new JButton("\u2190");
		oeste.setFont(new Font("Tahoma", Font.BOLD, 10));
		oeste.setBackground(Color.GRAY);
		oeste.setBounds(28, 162, 45, 44);
		oeste.setEnabled(false);
		frame.getContentPane().add(oeste);
		
		JLabel lblNewLabel_1 = new JLabel("SAMURAI BASICO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(116, 22, 135, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton noreste = new JButton("");
		noreste.setBackground(Color.LIGHT_GRAY);
		noreste.setBounds(126, 123, 28, 31);
		noreste.setEnabled(false);
		frame.getContentPane().add(noreste);
		
		JButton sureste = new JButton("");
		sureste.setBackground(Color.LIGHT_GRAY);
		sureste.setBounds(126, 217, 28, 31);
		sureste.setEnabled(false);
		frame.getContentPane().add(sureste);
		
		JButton suroeste = new JButton("");
		suroeste.setBackground(Color.LIGHT_GRAY);
		suroeste.setBounds(38, 217, 28, 31);
		suroeste.setEnabled(false);
		frame.getContentPane().add(suroeste);
		
		JButton noroeste = new JButton("");
		noroeste.setBackground(Color.LIGHT_GRAY);
		noroeste.setBounds(38, 127, 28, 31);
		noroeste.setEnabled(false);
		frame.getContentPane().add(noroeste);
		
		JButton btnUsarItem = new JButton("USAR ITEM");
		btnUsarItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inventario.initInventario(Main.turnoPJ);
				Interfaz.refrescar();
			}
		});
		btnUsarItem.setBackground(Color.GRAY);
		btnUsarItem.setBounds(272, 173, 135, 23);
		frame.getContentPane().add(btnUsarItem);
		
		
		JButton btnNewButton_1 = new JButton("ATACAR");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugador.atacar();
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(272, 129, 135, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
