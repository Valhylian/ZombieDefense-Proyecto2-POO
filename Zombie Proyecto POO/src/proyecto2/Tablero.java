package proyecto2;

public class Tablero {
	public static int turno;
	public static boolean continuarZombie = false;
	public static boolean sigTurno = false;
	public static boolean spawning = false;
	public static int matriz[][] = {{0,0,0,5,0,0,0,0,0,100},
									{0,0,0,5,0,0,0,0,0,101},
									{100,100,0,200,0,0,0,0,0,0},
									{0,0,0,201,5,0,0,0,0,0},
									{4,0,0,0,5,0,0,0,0,0},
									{0,0,0,0,5,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,100,0,5,0,0,0,0,0,0},
									{0,0,0,5,0,0,0,0,0,0},
									{0,0,0,5,0,0,0,0,0,0}};
	
	public static int ruido[][] =  {{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,0,0,0,0,0}};
	
	public static int timingJugador = 0;
	public static int timingZombies = 0;
	
	public static void imprimeMatriz () {
		System.out.println();
		for (int i=0;i<9;i++) {
			for (int j=0;j<10;j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
	}}
	
	public static void reiniciarRuido () {
		
		int ruido2[][] = {{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0}};
		
		ruido = ruido2;
	}
	
	public static boolean spawningPoints (int turno) {
		for (int i=0;i<10;i++) {
			for (int j=9;j<10;j++) {
				if (matriz[i][j]==0) {
					Enemigo zombie = new Enemigo(11,i,j);
					matriz[i][j] = 11;
					spawning = true;
					return true;
				}
			}
		}
		spawning = true;
	return false;
	}
	

        
	
	//1 Jugador 1
	//2 Jugador 2
	//3 Jugador 3
	
	//11 Zombie 1
	//22 Zombie 2
	//33 Zombie 3
	
	//4 Refugio
	//5 Obstaculo
	
	
}
