package proyecto2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
	
	
	static Enemigo zombie1= new Enemigo (11,3,8); //HABILIDAD ESPECIAL DOBLE VIDA
	static Enemigo zombie2= new Enemigo (22,4,8); //HABILIDAD ESPECIAL DOBLE FUERZA
	static Enemigo zombie3= new Enemigo (33,5,8); //HABILIDAD ESPECIAL DOBLE VISION
	
	//DECLARACION DE ARMAS **********************************************************************************
	
	//CORTO ALCANCE
	static Arma katanaInicial = new Arma ("Katana Inicial",10, 1, 1); //damage, range, ruido
	static Arma katana2 = new Arma ("Katana 2",20, 1, 2);
	
	//LARGO ALCANCE
	static Arma catapultaInicial = new Arma ("Catapulta Inicial",30, 2, 2); 
	static Arma catapulta2 = new Arma ("Catapulta 2",50, 3, 3); 
	
	//ARMA ESPECIAL (SOLA LA OPTIENEN POR LOS ZOMBIES)
	static Arma especial = new Arma ("Super Gun",100, 5, 4); 
	
	//*********************************************************************************************************
	//DECLARACION DE JUGADORES ********************************************************************************
	//Jugador(int _tipo, int x, int y, Arma _arma)
	
	static Jugador j1= new Jugador (1,4,1,katanaInicial);
	static Jugador j2= new Jugador (2,3,0,katanaInicial);
	static Jugador j3= new Jugador (3,5,0,katanaInicial);
	
	static Jugador jugadores[] = {j1,j2,j3};
	
	static Jugador turnoPJ = j1;
	//*********************************************************************************************************
	//LISTAS DE ZOMBIES ********************************************************************************
	
	static List<Enemigo> zombies = new ArrayList<>();
	static int contZombies = 0; 
	
	//CONTADOR DEL TURNO (MAXIMO 10)
	static int turno = 1;
	
	//SECUENCIA DE CADA TURNO 
	public static void secuenciaDeTurno () {
	
		while (turno<=10) {
			
			//EN EL PRIMER TURNO INICIA LA INTERFAZ
			if (turno == 1) {
					Interfaz.init();
				}
			JOptionPane.showMessageDialog(null, "INICIA EL TURNO: "+ turno);
			
			
			
			Jugador.turnoJugador();
			Enemigo.turnoZombie ();
					
			while (Tablero.continuarZombie == false) {
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
			}
			Tablero.continuarZombie = false;
			
			if (Tablero.matriz[4][0] != 4) {
				//JOptionPane.showMessageDialog(null, "ZOMBIE LLEGA A LA BASE. GAME OVER! ");
				FinishGame.initGameOver("ZOMBIE LLEGA A LA BASE.");
				while (Tablero.finish == false) {
					try {
						Thread.sleep(1000);
						System.out.println("duermE");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}	
				}
				
			}
			
			else if (Jugador.allDead()) {
				FinishGame.initGameOver("TODOS LOS PERSONAJES MURIERON.");
				while (Tablero.allDead == false) {
					try {
						Thread.sleep(1000);
						System.out.println("duermE");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}	
				}
				
			}
			
			Tablero.reiniciarRuido();
			SpawningPoints.initSpawning();
			while (Tablero.spawning == false) {
				try {
					Thread.sleep(1000);
					System.out.println("duermE");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
			}
			
			Tablero.spawning = false;
			
			//HABILIDAD ESPECIAL REINICIAR VIDA
			if (j2.nivel >= 4) {
				j2.vida = 100;
				JOptionPane.showMessageDialog(null, "SE REINICIA LA VIDA DEL JUGADOR 2 AL INICIAR EL SIGUIENTE TURNO GRACIAS A SU HABILIDAD ESPECIAL (ADQUIRIDA EN LVL 4)");
			}
			
			
			while (Tablero.sigTurno == false) {
				try {
					Thread.sleep(1000);
					System.out.println("duermE");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
			}
			
			
			Tablero.sigTurno = false;
			
			
			
			turno ++;
		}
		System.out.println("SALI");
		}
	
	public static void siguienteTurno() {
		Interfaz.refrescar();
		Tablero.sigTurno = true;
	}

	public static void main(String[] args) {
		
		zombies.add(zombie1);
		zombies.add(zombie2);
		zombies.add(zombie3);
		
		Item itemCura = new Item(10, "curativo");
		Item itemCura2 = new Item(10, "curativo");
		Item itemCura3 = new Item(10, "curativo");
		
		Item itemExp = new Item(10, "experiencia");
		Item itemExp2 = new Item(10, "experiencia");
		Item itemExp3 = new Item(10, "experiencia");
		Item itemExp4 = new Item(10, "experiencia");
		Item itemExp5 = new Item(10, "experiencia");
		Item itemExp6 = new Item(10, "experiencia");
		
		j1.inventarioItems.add(itemExp);
		j1.inventarioItems.add(itemExp2);
		j1.inventarioItems.add(itemCura);
		
		j2.inventarioItems.add(itemExp3);
		j2.inventarioItems.add(itemExp4);
		j2.inventarioItems.add(itemCura2);
		
		j3.inventarioItems.add(itemExp5);
		j3.inventarioItems.add(itemExp6);
		j3.inventarioItems.add(itemCura3);
		
		
		//ARMAS INICIALES
		j1.inventarioArmas.add(katanaInicial);
		j2.inventarioArmas.add(katanaInicial);
		j3.inventarioArmas.add(katanaInicial);
		
		
		
		
		//j2.inventarioArmas.add(catapultaInicial);
		//j1.inventarioArmas.add(especial);
		//Inventario.initInventario(j1);
		/*
		
		Interfaz.init();
		
		
		
		
		
		//Enemigo z1 = new Enemigo(11, 0,3);
		Tablero.imprimeMatriz ();
		Tablero.imprimeMatriz ();
		*/
		
		//secuenciaDeTurno ();
		secuenciaDeTurno ();
		
		
		
		
	}

}
