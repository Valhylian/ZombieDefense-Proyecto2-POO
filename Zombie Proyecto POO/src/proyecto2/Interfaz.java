package proyecto2;

import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz {

	static ImageIcon zombie1=new ImageIcon("imagenes"+File.separator+"zombie1.png");
	static ImageIcon zombie2=new ImageIcon("imagenes"+File.separator+"zombie2.png");
	static ImageIcon zombie3=new ImageIcon("imagenes"+File.separator+"zombie3.png");
	static ImageIcon fondo=new ImageIcon("imagenes"+File.separator+"fondo.jpg");
	static ImageIcon refugio=new ImageIcon("imagenes"+File.separator+"base.png");
	static ImageIcon pj1=new ImageIcon("imagenes"+File.separator+"personaje1.png");
	static ImageIcon pj2=new ImageIcon("imagenes"+File.separator+"personaje2.png");
	static ImageIcon pj3=new ImageIcon("imagenes"+File.separator+"personaje3.png");
	static ImageIcon obstaculo=new ImageIcon("imagenes"+File.separator+"obstaculo.png");
	static ImageIcon pocimaExp=new ImageIcon("imagenes"+File.separator+"pocimaExp.png");
	static ImageIcon pocimaCurativa=new ImageIcon("imagenes"+File.separator+"pocimaCurativa.png");
	static ImageIcon catapulta2=new ImageIcon("imagenes"+File.separator+"catapulta2.png");
	static ImageIcon catapulta=new ImageIcon("imagenes"+File.separator+"catapulta.png");
	
	private static JFrame frame;
	static JPanel panel_1 = new JPanel();
	static JPanel panel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void playSound(String soundName)
	 {
	   try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    clip.start( );
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }
	
	static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1066, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		cargarBotones ();
		
	
		
	
		
		
		
        
		
	}
	static void cargarBotones () {
		
		panel_1.setBounds(256, 43, 727, 601);
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0,0,0,0));
		panel_1.setLayout(new GridLayout(10,10));
		frame.getContentPane().add(panel_1);
		
		
		panel.setBounds(10, 11, 236, 660);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel j1 = new JLabel(pj1);
		j1.setBounds(10, 141, 62, 62);
		panel.add(j1);
		
		JLabel j2 = new JLabel(pj2);
		j2.setBounds(10, 285, 62, 56);
		panel.add(j2);
		
		JLabel j3 = new JLabel(pj3);
		j3.setBounds(10, 402, 62, 56);
		panel.add(j3);
		
		JLabel NivelPj1 = new JLabel("Nivel: " + Main.j1.nivel);
		NivelPj1.setHorizontalAlignment(SwingConstants.LEFT);
		NivelPj1.setBounds(82, 141, 99, 26);
		panel.add(NivelPj1);
		
		JLabel VidaPj1 = new JLabel("Vida:  "+ Main.j1.vida);
		VidaPj1.setHorizontalAlignment(SwingConstants.LEFT);
		VidaPj1.setBounds(82, 164, 99, 26);
		panel.add(VidaPj1);
		
		JLabel expPj1 = new JLabel("EXP: "+ Main.j1.exp);
		expPj1.setHorizontalAlignment(SwingConstants.LEFT);
		expPj1.setBounds(82, 188, 99, 26);
		panel.add(expPj1);
		
		JLabel lblNewLabel = new JLabel("Zombie Defense.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 0, 165, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("10 turnos por juego.");
		lblNewLabel_1.setBounds(50, 24, 124, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(""+Main.turno+"/10");
		lblNewLabel_2.setBounds(77, 39, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("INICIAR TURNO");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.siguienteTurno();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(34, 64, 124, 23);
		panel.add(btnNewButton_1);
		
		JLabel armaPj1 = new JLabel("Arma: " + Main.j1.armaEquipada.name);
		armaPj1.setHorizontalAlignment(SwingConstants.LEFT);
		armaPj1.setBounds(82, 211, 144, 26);
		panel.add(armaPj1);
		
		JLabel nivelPj2 = new JLabel("Nivel: " + Main.j2.nivel);
		nivelPj2.setHorizontalAlignment(SwingConstants.LEFT);
		nivelPj2.setBounds(82, 268, 99, 26);
		panel.add(nivelPj2);
		
		JLabel vidaPj2 = new JLabel("Vida:  "+ Main.j2.vida);
		vidaPj2.setHorizontalAlignment(SwingConstants.LEFT);
		vidaPj2.setBounds(82, 291, 99, 26);
		panel.add(vidaPj2);
		
		JLabel expPj2 = new JLabel("EXP: "+ Main.j2.exp);
		expPj2.setHorizontalAlignment(SwingConstants.LEFT);
		expPj2.setBounds(82, 315, 99, 26);
		panel.add(expPj2);
		
		JLabel armaPj2 = new JLabel("Arma: " + Main.j2.armaEquipada.name);
		armaPj2.setHorizontalAlignment(SwingConstants.LEFT);
		armaPj2.setBounds(82, 338, 144, 26);
		panel.add(armaPj2);
		
		JLabel nivelPj3 = new JLabel("Nivel: " + Main.j3.nivel);
		nivelPj3.setHorizontalAlignment(SwingConstants.LEFT);
		nivelPj3.setBounds(82, 385, 99, 26);
		panel.add(nivelPj3);
		
		JLabel vidaPj3 = new JLabel("Vida:  "+ Main.j3.vida);
		vidaPj3.setHorizontalAlignment(SwingConstants.LEFT);
		vidaPj3.setBounds(82, 408, 99, 26);
		panel.add(vidaPj3);
		
		JLabel expPj3 = new JLabel("EXP: "+ Main.j3.exp);
		expPj3.setHorizontalAlignment(SwingConstants.LEFT);
		expPj3.setBounds(82, 432, 99, 26);
		panel.add(expPj3);
		
		JLabel armaPj3 = new JLabel("Arma: " + Main.j3.armaEquipada.name);
		armaPj3.setHorizontalAlignment(SwingConstants.LEFT);
		armaPj3.setBounds(82, 455, 144, 26);
		panel.add(armaPj3);
		
		
		
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				Celda btnNewButton = new Celda(i , j);
				Celda.botonesMatriz[i][j]=btnNewButton;
				btnNewButton.setBackground(new Color(0,0,0,0));
				
				if (Tablero.matriz[i][j]==1) {
					btnNewButton.setIcon(pj1);
					System.out.println("Prueba");
					System.out.println(Jugador.buscarPj (i, j).tipo);
					btnNewButton.jugador = Jugador.buscarPj (i, j);
				}
				else if (Tablero.matriz[i][j]==2) {
					btnNewButton.setIcon(pj2);
					btnNewButton.jugador = Jugador.buscarPj (i, j);
				}
					
				else if (Tablero.matriz[i][j]==3) {
					btnNewButton.setIcon(pj3);
					btnNewButton.jugador = Jugador.buscarPj (i, j);
				}
				else if (Tablero.matriz[i][j]==4) 
					btnNewButton.setIcon(refugio);
				
				else if (Tablero.matriz[i][j]==100) 
					btnNewButton.setIcon(pocimaExp);
				
				else if (Tablero.matriz[i][j]==101) 
					btnNewButton.setIcon(pocimaCurativa);
				
				else if (Tablero.matriz[i][j]==200) 
					btnNewButton.setIcon(catapulta2);
				
				else if (Tablero.matriz[i][j]==201) 
					btnNewButton.setIcon(catapulta);
				
				else if (Tablero.matriz[i][j]==11) {
					btnNewButton.setIcon(zombie1);
					btnNewButton.zombie = Enemigo.buscarZombie (11, i, j);
					Main.contZombies++;
					if (Main.turnoPJ.modoAtaque) {
						btnNewButton.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								btnNewButton.ataqueAZombie();
								Interfaz.refrescar();
							}
						});
					}
					else {
						btnNewButton.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								InfoZombie.iniInfoZombie(btnNewButton.zombie);
								Interfaz.refrescar();
							}
						});
					}
				}
				else if (Tablero.matriz[i][j]==22) {
					btnNewButton.setIcon(zombie2);
					btnNewButton.zombie = Enemigo.buscarZombie (22, i, j);
					Main.contZombies++;
					if (Main.turnoPJ.modoAtaque) {
						btnNewButton.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								btnNewButton.ataqueAZombie();
								Interfaz.refrescar();
							}
						});
					}
					else {
						btnNewButton.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								InfoZombie.iniInfoZombie(btnNewButton.zombie);
								Interfaz.refrescar();
							}
						});
					}
				}
				//ZOMBIE 33
				else if (Tablero.matriz[i][j]==33) {
					btnNewButton.setIcon(zombie3);
					btnNewButton.zombie = Enemigo.buscarZombie (33, i, j);
					Main.contZombies++;
					if (Main.turnoPJ.modoAtaque) {
						btnNewButton.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								btnNewButton.ataqueAZombie();
								Interfaz.refrescar();
							}
						});
					}
					else {
						btnNewButton.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								InfoZombie.iniInfoZombie(btnNewButton.zombie);
								Interfaz.refrescar();
							}
						});
					}
				}
				
				else if (Tablero.matriz[i][j]==5) 
                    btnNewButton.setIcon(obstaculo);
				
				btnNewButton.setOpaque(false);
				
				if (Tablero.ruido[i][j]==1) {
					btnNewButton.setBackground(Color.GREEN);
					btnNewButton.setOpaque(true);
				}
				if (Tablero.ruido[i][j]==2) {
					btnNewButton.setBackground(Color.YELLOW);
					btnNewButton.setOpaque(true);
				}
				if (Tablero.ruido[i][j]==3) {
					btnNewButton.setBackground(Color.RED);
					btnNewButton.setOpaque(true);
				}
				if (Tablero.ruido[i][j]==4) {
					btnNewButton.setBackground(Color.BLACK);
					btnNewButton.setOpaque(true);
				}
				
				
				if (j == 9) {
					if (i == 0) {
						btnNewButton.setBackground(Color.CYAN);
						btnNewButton.setOpaque(true);
					}
					if (i == 2) {
						btnNewButton.setBackground(Color.CYAN);
						btnNewButton.setOpaque(true);
					}
					if (i == 4) {
						btnNewButton.setBackground(Color.CYAN);
						btnNewButton.setOpaque(true);
					}
					if (i == 5) {
						btnNewButton.setBackground(Color.CYAN);
						btnNewButton.setOpaque(true);
					}
					if (i == 7) {
						btnNewButton.setBackground(Color.CYAN);
						btnNewButton.setOpaque(true);
					}
					if (i == 9) {
						btnNewButton.setBackground(Color.CYAN);
						btnNewButton.setOpaque(true);
					}
				}
				
				
				panel_1.add(btnNewButton); 
				
				
			}
		}
		
		
		
	}
	static void refrescar() {
		panel_1.removeAll();
		panel_1.setVisible(false);
		panel.removeAll();
		panel.setVisible(false);
		cargarBotones ();
		panel_1.setVisible(true);
		panel.setVisible(true);
		
		
	}
}
