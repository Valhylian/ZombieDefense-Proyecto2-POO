package proyecto2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Jugador extends Personaje {
	public Arma armaEquipada;
	public boolean modoAtaque;
	public int contMovimienetos;//PARA LA HABILIDAD "MOVERSE 2 VECES"
	
	public String habilidad1;
	public String habilidad2;
	public String habilidad3;
	
	//INVENTARIOS****************************************
	public List<Arma> inventarioArmas = new ArrayList<>();
	public List<Item> inventarioItems = new ArrayList<>();
	//***************************************************
	
	public Jugador(int _tipo, int x, int y, Arma _arma){
		this.tipo=_tipo;
		this.nivel = 1;
		this.vida=100;
		this.posicionX=x;
		this.posicionY=y;
		this.exp = 0;
		this.armaEquipada = _arma;
		this.modoAtaque = false;
		this.contMovimienetos =0;
		
		Tablero.matriz[x][y]=tipo;
		
		if (_tipo == 1) {
			habilidad1 = "DESTRUIR OBSTACULOS"; //LVL 2
			habilidad2 = "MOVERSE 2 VECES";     //LVL 3
			habilidad3 = "MOVERSE EN DIAGONAL"; //LVL 4
		}
		else if (_tipo == 2) {
			habilidad1 = "PUEDE USAR ARMA DE FUEGO";
			habilidad2 = "PUEDE USAR SUPER GUN";
			habilidad3 = "REINICIA SU VIDA AL FINAL DE CADA TURNO";
		}
		else {
			habilidad1 = "DUPLICA EL EFECTO DE CURACION DE ITEMS";
			habilidad2 = "DUPLICA EL EFECTO DE EXPERIENCIA DE ITEMS";
			habilidad3 = "DOBLE DAMAGE CON ARMAS DE CORTO ALCANCE";
		}
			
		
    }
	
	//USAR ITEM ********************************
	public boolean usarItem (Jugador jugador, String _item) { //tipo = curacion o experencia
		int size=inventarioItems.size();
		int anterior = vida;
		int expAnterior = exp;
		
		for (int i=0; i<size; i++) {
			System.out.println(inventarioItems.get(i).tipo);
			
			if (inventarioItems.get(i).tipo == _item) {
				
				///////////////CURATIVO////////////////////////////////////////
				if (inventarioItems.get(i).tipo == "curativo") {
					
					//HABILIDAD ESPECIAL
					if (tipo == 3 && nivel >= 2) 
						usarCurativoDoble (inventarioItems.get(i));
						
					//VIDA +10 
					else if (vida +  inventarioItems.get(i).puntosEfecto <=90) {
						vida+=inventarioItems.get(i).puntosEfecto;
						JOptionPane.showMessageDialog(null, "ITEM APLICADO! VIDA ATERIOR: "+ anterior +" NUEVA VIDA: "+vida);
					}
						
					//TIENE MAS DE 90 (VIDA + (100-VIDA))
					else {
						vida += (100-vida);
						JOptionPane.showMessageDialog(null, "ITEM APLICADO! VIDA ATERIOR: "+ anterior +" NUEVA VIDA: "+vida);
					}
						
				}
				///////////////EXPERIENCIA////////////////////////////////////////
				
				else if (inventarioItems.get(i).tipo == "experiencia") {
					
					if (tipo == 3 && nivel >= 3) {
						exp+=inventarioItems.get(i).puntosEfecto*2;
						JOptionPane.showMessageDialog(null, "ITEM APLICADO! DUPLICA SU EFECTO POR HABILIDAD ESPECIAL EXP ATERIOR: "+ expAnterior +" NUEVA EXP: "+exp);
					}
						
					
					else{
						exp+=inventarioItems.get(i).puntosEfecto;
						JOptionPane.showMessageDialog(null, "ITEM APLICADO! EXP ATERIOR: "+ expAnterior +" NUEVA EXP: "+exp);
					}
					
					
				}
				establecerLvl ();
				inventarioItems.remove(i);
				Tablero.timingJugador+=1;
				Inventario.refrescarInventario();
				System.out.println("aquii Final" + jugador.tipo);
				Emergente.usarItem = false;
				Emergente.desactivarBotones(jugador.tipo-1, jugador);
				
				
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "EL JUGADOR NO POSEE EL ITEM");
		return false;
	}
	
	
	public void usarCurativoDoble (Item item) { //tipo = curacion o experencia
		int anterior = vida;
		
		if (vida +  item.puntosEfecto * 2 <=90) {
			vida+=item.puntosEfecto * 2;
			}
		//TIENE MAS DE 90 (VIDA + (100-VIDA))
		else {
			vida += (100-vida);
		}
		JOptionPane.showMessageDialog(null, "ITEM APLICADO! DUPLICA SU EFECTO POR HABILIDAD ESPECIAL VIDA ATERIOR: "+ anterior +" NUEVA VIDA: "+vida);			
	}
			
	
	//*********************************************
	
	public String cantItem (String _item) { //curativo o experiencia
		int size=inventarioItems.size();
		int cont = 0;
		
		for (int i=0; i<size; i++) {
			System.out.println(inventarioItems.get(i).tipo);
			if (inventarioItems.get(i).tipo == _item) 
				cont ++;
		}
		String total = Integer.toString(cont); 
		return total;
	}
	//*********************************************
	public String cantArma (String _arma) { //curativo o experiencia
		int size=inventarioArmas.size();
		int cont = 0;
		
		for (int i=0; i<size; i++) {
			
			if (inventarioArmas.get(i).name == _arma) 
				cont ++;
		}
		String total = Integer.toString(cont); 
		return total;
	}
	//RETURN ARMA*********************************
	public Arma returnArma (String _arma) { //curativo o experiencia
		int size=inventarioArmas.size();
		
		for (int i=0; i<size; i++) {
			
			if (inventarioArmas.get(i).name == _arma) 
				return inventarioArmas.get(i);
		}

		return null;
	}
	//EQUIPAR ARMA ********************************
	public boolean equiparArma(String _arma) {
		int cant = Integer.parseInt(cantArma (_arma));
		
		//NO POSEE EL ARMA
		if (cant == 0) {
			JOptionPane.showMessageDialog(null, "NO POSSE EL ARMA");
			return false;
		}
		
		//POSEE EL ARMA
		else {
			Arma arma= returnArma (_arma);
			
			if (_arma == "Catapulta Inicial" || _arma == "Catapulta 2" || _arma == "Super Gun") {
				if (tipo != 2) { //PJ 1 Y 2
					JOptionPane.showMessageDialog(null, "ESTE JUGADOR NO POSEE LA HABILIDAD DE USAR ARMAS DE FUEGO");
					return false;}
				if (nivel <2) { //PJ2
					JOptionPane.showMessageDialog(null, "ESTE JUGADOR NO POSEE LA HABILIDAD DE USAR ARMAS DE FUEGO \t HASTA EL NIVEL 2");
					return false;}
				if (nivel<3 && _arma == "Super Gun") {
					JOptionPane.showMessageDialog(null, "ESTE JUGADOR NO POSEE LA HABILIDAD DE USAR SUPER GUN \t HASTA EL NIVEL 3");
					return false;}
					
				armaEquipada = arma;
				
				JOptionPane.showMessageDialog(null, "ARMA EQUIPADA");
				Emergente.usarItem = false;
				Emergente.desactivarBotones(Main.turnoPJ.tipo-1, Main.turnoPJ);
				Inventario.refrescarInventario();
				Tablero.timingJugador+=1;
				
				return true;}
			
			armaEquipada = arma;
			Inventario.refrescarInventario();
			JOptionPane.showMessageDialog(null, "ARMA EQUIPADA");
			Emergente.usarItem = false;
			Emergente.desactivarBotones(Main.turnoPJ.tipo-1, Main.turnoPJ);
			Tablero.timingJugador+=1;
			return true;}
			
			}

	//*********************************************

	
	//MOVERSE ********************************
	public void mover( String direccion,int desplazamiento) {
		
		//MOVERSE 2 VECES
		//DESTRUIR OBSTACULOS
		//DIAGONAL
		if (tipo == 1 && nivel >= 4) {
			System.out.println("entra");
			if (contMovimienetos == 0) {
				if (moverEspecial(direccion,desplazamiento)) {
					Tablero.timingJugador --;
					contMovimienetos ++;
				}
			}
			else if (contMovimienetos == 1) {
				JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL MOVERSE DOS VECES");
				//Tablero.timingJugador --;
				if (moverEspecial(direccion,desplazamiento)){
					Emergente.desactivarBotonMovimiento(0, Main.j1);}
			}
				
		}
		
		else if (tipo == 1 && Jugador.this.nivel >= 3) {
			System.out.println("entra22");
			if (contMovimienetos == 0) {
				if (moverObstaculos(direccion,desplazamiento)) {
					Tablero.timingJugador --;
					contMovimienetos ++;
				}
			}
			else if (contMovimienetos == 1) {
				JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL MOVERSE DOS VECES");
				//Tablero.timingJugador --;
				if (moverObstaculos(direccion,desplazamiento)){
					Emergente.desactivarBotonMovimiento(0, Main.j1);}
			}
				
		}
		
		else if (tipo == 1 && Jugador.this.nivel >= 2) {
    		if (moverObstaculos(direccion,desplazamiento)){ //DESTRUIR OBSTACULOS
    			Emergente.desactivarBotonMovimiento(0, Main.j1);
    		}
    		
    	}
    	else if (tipo == 2) {
    		if (moverDefault(direccion,desplazamiento)) {
    			Emergente.desactivarBotonMovimiento(1, Main.j2);
    		}
    		
    		
    	}
    	else if (tipo == 3) {
    		if (moverDefault(direccion,desplazamiento)) {
    			Emergente.desactivarBotonMovimiento(2, Main.j3);
    		}
    		
    	}
    	else if (tipo == 1) {
    		if (moverDefault(direccion,desplazamiento)) {
    			Emergente.desactivarBotonMovimiento(0, Main.j1);
    		}
    		
    	}
    }
	
	public static void turnoJugador() {
		for (int i=0; i<3; i++) {
			Emergente.moverse = true;
			Emergente.atacar = true;
			Emergente.usarItem = true;
			Main.turnoPJ = Main.jugadores[i];
			Main.turnoPJ.modoAtaque = false;
			Main.jugadores[i].contMovimienetos = 0;
			if (Main.turnoPJ.vida <= 0) {
				JOptionPane.showMessageDialog(null, "EL PERSONAJE: "+Main.jugadores[i].tipo + " MURIO");
				Tablero.timingJugador=3;
			}
			else {
				Emergente.init(i,Main.jugadores[i]);
			}
			
			while (Tablero.timingJugador < 3) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
			Tablero.timingJugador=0;
			JOptionPane.showMessageDialog(null, "TURNO DEL SIGUIENTE PJ");
			Emergente.cerrarEmergente();
		}
	}

	public static Jugador buscarPj (int pos_i, int pos_j) {
		for (int i=0; i<Main.jugadores.length; i++) {
			if (Main.jugadores[i].posicionX == pos_i && Main.jugadores[i].posicionY == pos_j) {
				System.out.print(Main.jugadores[i].vida);
				return Main.jugadores[i];}
		}
		return null;			
	}
	
	public void establecerLvl () {
		if (exp >= 10 && exp < 30 && nivel != 2) {
			nivel = 2;
			JOptionPane.showMessageDialog(null, "SUBE A LVL 2!");
			JOptionPane.showMessageDialog(null, "NUEVA HABILIDAD: " +habilidad1);
			inventarioArmas.add(Main.catapultaInicial);
			JOptionPane.showMessageDialog(null, "ADQUIERE EL ARMA 'CATAPULTA INICIAL'");
		}
		else if (exp >= 30 && exp <60 && nivel != 3) {
			nivel = 3;
			JOptionPane.showMessageDialog(null, "SUBE A LVL 3!");
			JOptionPane.showMessageDialog(null, "NUEVA HABILIDAD: " +habilidad2);
			inventarioArmas.add(Main.catapulta2);
			inventarioArmas.add(Main.katana2);
			JOptionPane.showMessageDialog(null, "ADQUIERE LAS ARMAS 'CATAPULTA 2' Y 'KATANA 2'");
		}
		else if (exp >= 60 && nivel != 4){
			nivel = 4;
			JOptionPane.showMessageDialog(null, "SUBE A LVL 4!");
			JOptionPane.showMessageDialog(null, "NUEVA HABILIDAD: "+ habilidad3);
			inventarioArmas.add(Main.especial);
			JOptionPane.showMessageDialog(null, "ADQUIERE EL ARMA 'CATAPULA SUPER GUN'");
		}
		
			
	}
	
	public void atacar() {
		Main.turnoPJ.modoAtaque = true;
		JOptionPane.showMessageDialog(null, "SELECCIONE AL ZOMBIE QUE DESEA ATACAR");
		Interfaz.refrescar();
	}
	
	public static boolean  allDead() {
		for (int i=0; i<3; i++) {
			if (Main.jugadores[i].vida > 0 ) 
				return false;
		}
		return true;
	}

	
}
