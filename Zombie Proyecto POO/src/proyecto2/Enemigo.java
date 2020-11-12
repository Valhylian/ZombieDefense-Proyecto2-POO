package proyecto2;

import javax.swing.JOptionPane;

public class Enemigo extends Personaje {
	public int vision;
	public int fuerza;

	public Enemigo(int _tipo, int x, int y){
		this.tipo=_tipo;
		this.posicionX=x;
		this.posicionY=y;
		//HABILIDAD DOBLE VIDA
		if (_tipo==11) {
			this.vida=200;
			this.vision = 2;
			this.fuerza = 10;
		}
		else if (_tipo==22) {
			this.vida=100;
			this.vision = 2;
			this.fuerza = 20;
		}
		else if (_tipo==33) {
			this.vida=100;
			this.vision = 4;
			this.fuerza = 20;
		}
		
		
		Tablero.matriz[x][y]=tipo;
    }
	
	//ATACAR A PERSONAJE (SOLO SI ESTA A LA PAR)
	public boolean atacar (int range, int x, int y, int fuerza) {
		//NORTE
		if (validarFueraRango(posicionX-range, posicionY)) {

    		if (Tablero.matriz[x-range][y] == 1 || Tablero.matriz[x-range][y] == 2 || Tablero.matriz[x-range][y] == 3) { 
    			Celda.botonesMatriz[x-range][y].jugador.vida -= fuerza;
    			JOptionPane.showMessageDialog(null, "ZOMBIE ATACA AL PERSONAJE: "+ Celda.botonesMatriz[x-range][y].jugador.tipo + "CON UN ATACQUE DE: "+fuerza);
    			if (Celda.botonesMatriz[x-range][y].jugador.vida <= 0) {
    				JOptionPane.showMessageDialog(null, "LA VIDA DEL PJ LLEGO A 0, MURIO");
    				Tablero.matriz[x-range][y] = 0;
    				Celda.botonesMatriz[x-range][y].jugador = null;
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "NUEVA VIDA DEL PERSONAJE: "+Celda.botonesMatriz[x-range][y].jugador.vida);
    			}
    			return true;}
		}
		//SUR
		if (validarFueraRango(posicionX+range, posicionY)) {
    		if (Tablero.matriz[x+range][y] == 1 || Tablero.matriz[x+range][y] == 2 || Tablero.matriz[x+range][y] == 3) {		
    			Celda.botonesMatriz[x+range][y].jugador.vida -= fuerza;
    			JOptionPane.showMessageDialog(null, "ZOMBIE ATACA AL PERSONAJE: "+ Celda.botonesMatriz[x+range][y].jugador.tipo + "CON UN ATACQUE DE: "+fuerza);
    			if (Celda.botonesMatriz[x+range][y].jugador.vida <= 0) {
    				JOptionPane.showMessageDialog(null, "LA VIDA DEL PJ LLEGO A 0, MURIO");
    				Tablero.matriz[x+range][y] = 0;
    				Celda.botonesMatriz[x+range][y].jugador = null;
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "NUEVA VIDA DEL PERSONAJE: "+Celda.botonesMatriz[x+range][y].jugador.vida);
    			}
    			
    			return true;}
    	}
		//ESTE
		if (validarFueraRango(posicionX, posicionY+range)) {
    		if (Tablero.matriz[x][y+range] == 1 || Tablero.matriz[x][y+range] == 2 || Tablero.matriz[x][y+range] == 3) {		
    			Celda.botonesMatriz[x][y+range].jugador.vida -= fuerza;
    			JOptionPane.showMessageDialog(null, "ZOMBIE ATACA AL PERSONAJE: "+ Celda.botonesMatriz[x][y+range].jugador.tipo + "CON UN ATACQUE DE: "+fuerza);
    			if (Celda.botonesMatriz[x][y+range].jugador.vida <= 0) {
    				JOptionPane.showMessageDialog(null, "LA VIDA DEL PJ LLEGO A 0, MURIO");
    				Tablero.matriz[x][y+range] = 0;
    				Celda.botonesMatriz[x][y+range].jugador = null;
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "NUEVA VIDA DEL PERSONAJE: "+Celda.botonesMatriz[x][y+range].jugador.vida);
    			}
    			return true;}
    	}
		//OESTE
		if (validarFueraRango(posicionX, posicionY-range)) {
    		if (Tablero.matriz[x][y-range] == 1 || Tablero.matriz[x][y-range] == 2 || Tablero.matriz[x][y-range] == 3) {
    			Celda.botonesMatriz[x][y-range].jugador.vida -= fuerza;
    			JOptionPane.showMessageDialog(null, "ZOMBIE ATACA AL PERSONAJE: "+ Celda.botonesMatriz[x][y-range].jugador.tipo + "CON UN ATACQUE DE: "+fuerza);
    			if (Celda.botonesMatriz[x][y-range].jugador.vida <= 0) {
    				JOptionPane.showMessageDialog(null, "LA VIDA DEL PJ LLEGO A 0, MURIO");
    				Tablero.matriz[x][y-range] = 0;
    				Celda.botonesMatriz[x][y-range].jugador = null;
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "NUEVA VIDA DEL PERSONAJE: "+Celda.botonesMatriz[x][y-range].jugador.vida);
    			}
    		
    			return true;}
    	}
		return false;
	}
	
	public static void turnoZombie () {
		for (int i=0; i<Main.zombies.size(); i++) {
			//Interfaz.refrescar();
			if (Main.zombies.get(i).atacar (1, Main.zombies.get(i).posicionX, Main.zombies.get(i).posicionY, Main.zombies.get(i).fuerza) ) {
				System.out.println("ATACA");}
			else if (Main.zombies.get(i).avanzarAPJ()) {
				System.out.println("AVANZA A PJ");}
			else if (Main.zombies.get(i).moverAlRuido(4)) {
				System.out.println("AVANZA A RUIDO 4");}
			else if (Main.zombies.get(i).moverAlRuido(3)) {
				System.out.println("AVANZA A RUIDO 3");}
			else if (Main.zombies.get(i).moverAlRuido(2)) {
				System.out.println("AVANZA A RUIDO 2");}
			else if (Main.zombies.get(i).moverAlRuido(1)) {
				System.out.println("AVANZA A RUIDO 1");}
			else if (Main.zombies.get(i).avanzarBase()) {
				
				System.out.println("AVANZA A LA BASE");}
				
		}
		ResumeTurnoZombie.init();
		if (Tablero.matriz[4][0] != 4) {
			JOptionPane.showMessageDialog(null, "ZOMBIE LLEGA A LA BASE. GAME OVER! ");
		}
	}
	
	/*
	public static Enemigo buscarZombieBorrar (int tipo, int pos_i, int pos_j) {
		
		if (tipo==11) {
			for (int i=0; i<Main.zombies11.size(); i++) {
				if (Main.zombies11.get(i).posicionX == pos_i && Main.zombies11.get(i).posicionY == pos_j) {
					System.out.print(Main.zombies11.get(i).vida);
					return Main.zombies11.get(i);}
			}	
		}
		if (tipo==22) {
			for (int i=0; i<Main.zombies11.size(); i++) {
				if (Main.zombies22.get(i).posicionX == pos_i && Main.zombies22.get(i).posicionY == pos_j) {
					return Main.zombies22.get(i);}
			}	
		}
		if (tipo==33) {
			for (int i=0; i<Main.zombies33.size(); i++) {
				if (Main.zombies33.get(i).posicionX == pos_i && Main.zombies33.get(i).posicionY == pos_j) {
					return Main.zombies33.get(i);}
			}	
		}
		
		return null;
	}*/
	
public static Enemigo buscarZombie (int tipo, int pos_i, int pos_j) {
		
		for (int i=0; i<Main.zombies.size(); i++) {
			if (Main.zombies.get(i).posicionX == pos_i && Main.zombies.get(i).posicionY == pos_j) {
				return Main.zombies.get(i);}
		}
		
		return null;}

//SOLTAR ITEM**************************
//CUANDO MUERE
public static int soltarItem(int tipo) {
	if (tipo == 11) {
		return 100;
	}
	if (tipo == 22) {
		return 101;
	}
	if (tipo == 33) {
		//ARMA ESPECIAL??
		return 100;
	}
	return 1;
}
public static boolean dentroDeTablero(int x) {
	//FUERA DEL TABLERO
	if (x>9 || x<0 ) 
		return false;
	return true;
}

//*******************************************************************************************************************
//RETORNA UN X
public Jugador vePJNorte() {
	for (int i=1; i<=vision; i++ ) {
		if (dentroDeTablero(posicionX-i)) {
			if (Tablero.matriz[posicionX-i][posicionY]==1 || Tablero.matriz[posicionX-i][posicionY]==2 || Tablero.matriz[posicionX-i][posicionY]==3) {
				return Celda.botonesMatriz[posicionX-i][posicionY].jugador;}
		}
	}
	return null;
}

//RETORNA UN X
public Jugador vePJSur() {
	for (int i=1; i<=vision; i++ ) {
		if (dentroDeTablero(posicionX+i)) {
			if (Tablero.matriz[posicionX+i][posicionY]==1 || Tablero.matriz[posicionX+i][posicionY]==2 || Tablero.matriz[posicionX+i][posicionY]==3) {
				return Celda.botonesMatriz[posicionX+i][posicionY].jugador;}
		}
	}
	return null;
}

//RETORNA UN Y
public Jugador vePJEste() {
	for (int i=1; i<=vision; i++ ) {
		if (dentroDeTablero(posicionY+i)) {
			if (Tablero.matriz[posicionX][posicionY+i]==1 || Tablero.matriz[posicionX][posicionY+i]==2 || Tablero.matriz[posicionX][posicionY+i]==3) {
				return Celda.botonesMatriz[posicionX][posicionY+i].jugador;}
		}
	}
	return null;}

//RETORNA UN Y
public Jugador vePJOeste() {
	for (int i=1; i<=vision; i++ ) {
		if (dentroDeTablero(posicionY-i)) {
			if (Tablero.matriz[posicionX][posicionY-i]==1 || Tablero.matriz[posicionX][posicionY-i]==2 || Tablero.matriz[posicionX][posicionY-i]==3) {
				return Celda.botonesMatriz[posicionX][posicionY-i].jugador;}
		}
	}
	return null;}
//*******************************************************************************************************************

public boolean avanzarAPJ () {
	if (vePJNorte() != null) {
		if(Tablero.matriz[posicionX-1][posicionY]==0) {
			JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "VE A JUGADOR "+vePJNorte().tipo + " Y AVANZA HACIA EL");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX-1][posicionY] = tipo; //AVANZA
			return true;}
	}
	if (vePJSur() != null) {
		if(Tablero.matriz[posicionX+1][posicionY]==0) {
			JOptionPane.showMessageDialog(null, "ZOMBIE:  "+tipo+ "VE A JUGADOR:  "+vePJSur().tipo + " AL SUR Y AVANZA HACIA EL");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX+1][posicionY] = tipo; //AVANZA
			return true;}
	}
	if (vePJEste() != null) {
		if(Tablero.matriz[posicionX][posicionY+1]==0) {
			JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "VE A JUGADOR "+vePJEste().tipo + " Y AVANZA HACIA EL");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX][posicionY+1] = tipo; //AVANZA
			return true;}
	}
	if (vePJOeste() != null) {
		if(Tablero.matriz[posicionX][posicionY-1]==0) {
			JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "VE A JUGADOR "+vePJOeste().tipo + " Y AVANZA HACIA EL");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX][posicionY-1] = tipo; //AVANZA
			return true;}
	}
	return false;
}

public boolean moverAlRuido(int nivel) {
	for (int i=0;i<10;i++) {
		for (int j=0;j<10;j++) {
			if (Tablero.ruido[i][j] == nivel) {
				if (i<posicionX) {
					//AL NORTE
					if (dentroDeTablero(posicionX-1)&&Tablero.matriz[posicionX-1][posicionY]==0) {
						JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "ESCUCHA UN RUIDO NIVEL: "+nivel + " Y AVANZA HACIA EL");
						Tablero.matriz[posicionX][posicionY] = 0; 
						Tablero.matriz[posicionX-1][posicionY] = tipo; //AVANZA
						return true;}}
				if (i>posicionX) {
					//AL SUR
					if (dentroDeTablero(posicionX+1)&&Tablero.matriz[posicionX+1][posicionY]==0) {
						JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "ESCUCHA UN RUIDO NIVEL: "+nivel + " Y AVANZA HACIA EL");
						Tablero.matriz[posicionX][posicionY] = 0; 
						Tablero.matriz[posicionX+1][posicionY] = tipo; //AVANZA
						return true;}}
				if (j<posicionY) {
					//AL OESTE
					if (dentroDeTablero(posicionY-1)&&Tablero.matriz[posicionX][posicionY-1]==0) {
						JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "ESCUCHA UN RUIDO NIVEL: "+nivel + " Y AVANZA HACIA EL");
						Tablero.matriz[posicionX][posicionY] = 0; 
						Tablero.matriz[posicionX][posicionY-1] = tipo; //AVANZA
						return true;}}
				if (j>posicionY) {
					//AL OESTE
					if (dentroDeTablero(posicionY+1)&&Tablero.matriz[posicionX][posicionY+1]==0) {
						JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "ESCUCHA UN RUIDO NIVEL: "+nivel + " Y AVANZA HACIA EL");
						Tablero.matriz[posicionX][posicionY] = 0; 
						Tablero.matriz[posicionX][posicionY+1] = tipo; //AVANZA
						return true;}}
			}
			
		}
	}
	return false;
}

public boolean avanzarBase() { //4,0
	if (4<posicionX) {
		//AL NORTE
		if (dentroDeTablero(posicionX-1)&& (Tablero.matriz[posicionX-1][posicionY]==0 || Tablero.matriz[posicionX-1][posicionY]==4)) {
			JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "AVANZA A LA BASE");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX-1][posicionY] = tipo; //AVANZA
			return true;}}
	if (4>posicionX) {
		//AL SUR
		if (dentroDeTablero(posicionX+1)&& (Tablero.matriz[posicionX+1][posicionY]==0 || Tablero.matriz[posicionX+1][posicionY]==4)) {
			JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "AVANZA A LA BASE");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX+1][posicionY] = tipo; //AVANZA
			return true;}}
	if (0<=posicionY) {
		//AL OESTE
		if (dentroDeTablero(posicionY-1)&& (Tablero.matriz[posicionX][posicionY-1]==0 || Tablero.matriz[posicionX][posicionY-1]==4)) {
			JOptionPane.showMessageDialog(null, "ZOMBIE "+tipo+ "AVANZA A LA BASE");
			Tablero.matriz[posicionX][posicionY] = 0; 
			Tablero.matriz[posicionX][posicionY-1] = tipo; //AVANZA
			return true;}}
	
	return false;
}

}

