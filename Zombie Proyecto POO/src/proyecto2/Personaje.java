package proyecto2;

import javax.swing.JOptionPane;

//SUPER CLASS
public class Personaje {
	protected int vida;
    protected int nivel;
    protected int posicionX;
    protected int posicionY;
    protected int tipo;
    protected int exp;
    
    
    //MOVER
    public boolean moverDefault(String direccion,int desplazamiento) {
    	Tablero.imprimeMatriz();
        
        if (direccion == "N") {
        	if (validarPosicion(posicionX-desplazamiento, posicionY)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		 posicionX -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "S") {
        	if (validarPosicion(posicionX+desplazamiento, posicionY)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionX += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "E") {
        	if (validarPosicion(posicionX, posicionY+desplazamiento)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionY += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "O") {
        	if (validarPosicion(posicionX, posicionY-desplazamiento)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionY -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else {
        	JOptionPane.showMessageDialog(null, "NO POSEE LA HABILIDAD DE MOVERSE EN DIAGONAL");
        }
        Tablero.imprimeMatriz();
        return false;
    }
    
    //VALIDAR POSICION
    public boolean validarPosicion(int x, int y) {
    	if (x>9 || y>9 || x<0 || y<0) {
    		JOptionPane.showMessageDialog(null, "Fuera del tablero");
    		return false;
    	}
    	if (Tablero.matriz[x][y]==100) {
    		JOptionPane.showMessageDialog(null, "RECOGE UN ITEM DE EXPERIENCIA");
    		obtenerItem("experiencia");
    		return true;}
    	if (Tablero.matriz[x][y]==101) {
    		JOptionPane.showMessageDialog(null, "RECOGE UN ITEM CURATIVO");
    		obtenerItem("curativo");
    		return true;}
    	else if (Tablero.matriz[x][y]!=0) {
    		JOptionPane.showMessageDialog(null, "Posicion Ocupada");
    		return false;
    	}
    	
    	return true;
    }
    
    //VALIDAR FUERA DE RANGO
    public boolean validarFueraRango(int x, int y) {
    	if (x>9 || y>9 || x<0 || y<0) {
    		//JOptionPane.showMessageDialog(null, "Fuera del tablero");
    		return false;
    	}
    	return true;
    }
    
    
    
    
    //MOVER HABILIDAD ESPECIAL (DESTRUIR OBSTACULOS Y MOVERSE EN DIAGONAL)
    //ZOMBIE 1 LVL 4+
    public boolean moverEspecial(String direccion,int desplazamiento) {
    	Tablero.imprimeMatriz();
        
        if (direccion == "N") {
        	if (validarPosicionEspecial(posicionX-desplazamiento, posicionY)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		 posicionX -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "S") {
        	if (validarPosicionEspecial(posicionX+desplazamiento, posicionY)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionX += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "E") {
        	if (validarPosicionEspecial(posicionX, posicionY+desplazamiento)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionY += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "O") {
        	if (validarPosicionEspecial(posicionX, posicionY-desplazamiento)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionY -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "NE") {
        	if (validarPosicionEspecial(posicionX-desplazamiento, posicionY+desplazamiento)) {
        		JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL: MOVERSE EN DIAGONAL");
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionX -= desplazamiento;
                posicionY += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "NO") {
        	if (validarPosicionEspecial(posicionX-desplazamiento, posicionY-desplazamiento)) {
        		JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL: MOVERSE EN DIAGONAL");
        		Tablero.matriz[posicionX][posicionY] = 0;
        		 posicionX -= desplazamiento;
                 posicionY -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "SE") {
        	if (validarPosicionEspecial(posicionX+desplazamiento, posicionY+desplazamiento)) {
        		JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL: MOVERSE EN DIAGONAL");
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionX += desplazamiento;
                posicionY += desplazamiento;
                Tablero.matriz[posicionX][posicionY] = tipo;
                Tablero.timingJugador+=1;
                return true;
        	}
            
        }
        else if (direccion == "SO") {
        	if (validarPosicionEspecial(posicionX+desplazamiento, posicionY-desplazamiento)) {
        		JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL: MOVERSE EN DIAGONAL");
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionX += desplazamiento;
                posicionY -= desplazamiento;
                Tablero.matriz[posicionX][posicionY] = tipo;
                Tablero.timingJugador+=1;
                return true;
        	}
            
        }
        Tablero.imprimeMatriz();
        return false;
    }
    
    public boolean moverObstaculos(String direccion,int desplazamiento) {
    	Tablero.imprimeMatriz();
        
        if (direccion == "N") {
        	if (validarPosicionEspecial(posicionX-desplazamiento, posicionY)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		 posicionX -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "S") {
        	if (validarPosicionEspecial(posicionX+desplazamiento, posicionY)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionX += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "E") {
        	if (validarPosicionEspecial(posicionX, posicionY+desplazamiento)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionY += desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else if (direccion == "O") {
        	if (validarPosicionEspecial(posicionX, posicionY-desplazamiento)) {
        		Tablero.matriz[posicionX][posicionY] = 0;
        		posicionY -= desplazamiento;
        		Tablero.matriz[posicionX][posicionY] = tipo;
        		Tablero.timingJugador+=1;
        		return true;
        	}
        }
        
        else {
        	JOptionPane.showMessageDialog(null, "NO POSEE LA HABILIDAD DE MOVERSE EN DIAGONAL HASTA EL LVL 4");
        }
        Tablero.imprimeMatriz();
        return false;
    }

    public void obtenerItem (String tipo) {
    	if (tipo == "curativo") {
    		Item itemCurativo = new Item(10, "curativo");
    		Main.turnoPJ.inventarioItems.add(itemCurativo);
    	}
    	else {
    		Item itemExp = new Item(10, "experiencia");
    		Main.turnoPJ.inventarioItems.add(itemExp);
    	}
    	
	}

  //VALIDAR POSICION
    public boolean validarPosicionEspecial(int x, int y) {
    	if (x>8 || y>9 || x<0 || y<0) {
    		JOptionPane.showMessageDialog(null, "Fuera del tablero");
    		return false;}
    	if (Tablero.matriz[x][y]==5) {
    		JOptionPane.showMessageDialog(null, "HABILIDAD ESPECIAL! DESTRUIR OBSTACULO");
    		return true;}
    	if (Tablero.matriz[x][y]==100) {
    		JOptionPane.showMessageDialog(null, "RECOGE UN ITEM DE EXPERIENCIA");
    		obtenerItem("experiencia");
    		return true;}
    	if (Tablero.matriz[x][y]==101) {
    		JOptionPane.showMessageDialog(null, "RECOGE UN ITEM CURATIVO");
    		obtenerItem("curativo");
    		return true;}
    	else if (Tablero.matriz[x][y]!=0) {
    		JOptionPane.showMessageDialog(null, "Posicion Ocupada");
    		return false;}
    	return true;
    }
	
}
