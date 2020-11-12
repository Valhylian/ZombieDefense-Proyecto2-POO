package proyecto2;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Celda extends JButton {
	public static Celda botonesMatriz[][] = new Celda [10][10];
	private int ruido;
	private int x;
	private int y;
	public Enemigo zombie;
	public Jugador jugador;
	
	//constructor
	Celda (int _x, int _y){
		this.x = _x;
		this.y = _y;
		this.ruido=0;
	}
	
	public boolean ataqueAZombie () {
		int experiencia = zombie.tipo;
		Main.turnoPJ.modoAtaque = false;
		if (validarAtaque (Main.turnoPJ.armaEquipada.alcance, Main.turnoPJ.posicionX,  Main.turnoPJ.posicionY)) { //ESTA DENTRO DEL ALCANCE
			
			if (Main.turnoPJ.tipo == 3 && Main.turnoPJ.nivel >=4) {
				zombie.vida -= Main.turnoPJ.armaEquipada.damage * 2; //BAJA VIDA A ZOMBIE
				JOptionPane.showMessageDialog(null, "HABILIDAD DOBLE DAÑO CON ARMAS DE CORTO ALCANCE! DAÑO: "+ Main.turnoPJ.armaEquipada.damage * 2);
			}
			else {
				zombie.vida -= Main.turnoPJ.armaEquipada.damage; //BAJA VIDA A ZOMBIE
			}
			if (zombie.vida <=0) {
				//SOLTAR ITEM
				Tablero.matriz[x][y] = Enemigo.soltarItem(zombie.tipo);
				Main.turnoPJ.exp += experiencia; //SUBE EXPERRIENCIA SEGUN EL TIPO DE ZOMBIE
				Main.zombies.remove(Enemigo.buscarZombie(zombie.tipo, x, y));
				zombie=null;
				JOptionPane.showMessageDialog(null, "EL ZOMBIE MURIO, SUBE EXPERIENCIA + "+ experiencia);
			}
			else{
				JOptionPane.showMessageDialog(null, "ATAQUE EXITOSO. NUEVA VIDA DEL ZOMBIE: "+zombie.vida);
			}
			Tablero.ruido[Main.turnoPJ.posicionX][Main.turnoPJ.posicionY]= Main.turnoPJ.armaEquipada.lvlRuido;
			Tablero.timingJugador ++;
			Emergente.atacar = false;
			Emergente.desactivarBotones(Main.turnoPJ.tipo-1, Main.turnoPJ);
			return true;
			
		}
		return false;
	}
	
	public boolean validarAtaque (int rango, int xPJ, int yPJ) {
		for (int i = 1; i <= rango; i++) {
			if ((xPJ + i == x || xPJ - i == x) && y == yPJ) {
				return true;
			}
			if ((yPJ + i == y || yPJ - i == y) && x == xPJ) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "FUERA DE RANGO");
		return false;
	}
}
