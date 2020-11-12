package proyecto2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
	static Jugador turnoPJ ;
	
	static Enemigo zombie1= new Enemigo (11,6,8); //HABILIDAD ESPECIAL DOBLE VIDA
	static Enemigo zombie2= new Enemigo (22,7,8); //HABILIDAD ESPECIAL DOBLE FUERZA
	static Enemigo zombie3= new Enemigo (33,8,8); //HABILIDAD ESPECIAL DOBLE VISION
	
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
	
	static Jugador j1= new Jugador (1,3,1,especial);
	static Jugador j2= new Jugador (2,3,0,especial);
	static Jugador j3= new Jugador (3,8,1,katana2);
	
	static Jugador jugadores[] = {j1,j2,j3};
	
	//*********************************************************************************************************
	//LISTAS DE ZOMBIES ********************************************************************************
	
	static List<Enemigo> zombies = new ArrayList<>();
	static int contZombies = 0; 
	
	//CONTADOR DEL TURNO (MAXIMO 10)
	static int turno = 1;
	
	

	
	public static void secuenciaDeTurno () {
		
		while (turno<=10) {
			JOptionPane.showMessageDialog(null, "INICIA EL TURNO: "+ turno);
			if (turno == 1) {
					Interfaz.init();
				}
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
		Item itemExp = new Item(10, "experiencia");
		
		j2.inventarioItems.add(itemExp);
		j3.inventarioItems.add(itemCura);
		/*
		j3.inventarioItems.add(itemCura2);
		j3.inventarioItems.add(itemExp);*/
		
		//ARMAS INICIALES
		j1.inventarioArmas.add(katanaInicial);
		j2.inventarioArmas.add(katanaInicial);
		j3.inventarioArmas.add(katanaInicial);
		
		
		
		
		j2.inventarioArmas.add(catapultaInicial);
		j1.inventarioArmas.add(especial);
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
