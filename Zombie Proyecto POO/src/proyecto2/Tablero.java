package proyecto2;

public class Tablero {
	public static int turno;
	public static boolean continuarZombie = false;
	public static boolean sigTurno = false;
	public static boolean spawning = false;
	public static int matriz[][] = {{0,0,0,5,0,0,0,0,0,0},
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
	public static boolean colocarZombie (int tipo) {
		for (int i=0;i<10;i++) {
			for (int j=9;j>7;j--) {
				
				if (matriz[i][j]==0) {
					Main.zombies.add(new Enemigo(tipo,i,j));
					matriz[i][j] = tipo;
					spawning = true;
					return true;}
						
			}}
		return false;
	}
	
	public static boolean colocarZombieAbajo (int tipo) {
		for (int i=9;i>=0;i++) {
			for (int j=9;j>7;j--) {
				
				if (matriz[i][j]==0) {
					Main.zombies.add(new Enemigo(tipo,i,j));
					matriz[i][j] = tipo;
					spawning = true;
					return true;}
						
			}}
		return false;
	}
	public static void spawningPoints (int turno) {
		if (turno == 1) {
			colocarZombie (11);
		}
		if (turno == 2) {
			colocarZombieAbajo (11);
		}
		if (turno == 3) {
			colocarZombie (11);
			colocarZombieAbajo (22);
		}
		if (turno == 4) {
			colocarZombie (11);
			colocarZombie (22);
		}
		if (turno == 5) {
			colocarZombieAbajo (22);
			colocarZombie (33);
		}
		if (turno == 6) {
			colocarZombie (11);
			colocarZombie (22);
			colocarZombieAbajo (33);
		}
		
		if (turno == 7) {
			colocarZombie (11);
			colocarZombieAbajo (22);
			colocarZombie (33);
		}
		
		if (turno == 8) {
			colocarZombie (11);
			colocarZombie (22);
			colocarZombieAbajo (33);
			colocarZombieAbajo (22);
		}
		
		if (turno == 9) {
			colocarZombie (11);
			colocarZombieAbajo (22);
			colocarZombieAbajo (33);
			colocarZombie (22);
		}
		
		if (turno == 10) {
			colocarZombieAbajo (11);
			colocarZombieAbajo (22);
			colocarZombie (33);
			colocarZombie (22);

		}
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
