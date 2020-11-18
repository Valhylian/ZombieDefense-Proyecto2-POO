package proyecto2;

public class Tablero {
	public static int turno;
	public static boolean continuarZombie = false;
	public static boolean sigTurno = false;
	public static boolean spawning = false;
	public static boolean finish = false;
	public static boolean allDead = false;
	
	//200 catapulta
	//201 catapulta
	public static int matriz[][] = {{101,100,0,5,0,0,0,0,0,0},
									{0,0,0,5,0,0,0,5,0,0},
									{0,0,0,0,0,0,0,5,0,0},
									{0,0,0,0,5,0,0,0,0,0},
									{4,0,0,0,0,0,0,0,0,0},
									{0,0,0,0,5,0,0,0,0,0},
									{0,0,0,0,0,0,0,5,0,0},
									{0,0,0,5,0,0,0,5,0,0},
									{0,0,0,5,0,0,0,0,0,0},
									{101,100,0,5,0,0,0,0,0,0}};
	
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
	/*
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
	}*/
	
	public static boolean colocarZombie (int tipo, int x , int y) {
		if (matriz[x][y]==0) {
			Main.zombies.add(new Enemigo(tipo,x,y));
			matriz[x][y] = tipo;
			spawning = true;
			return true;}

		return false;
	}
	

	public static void spawningPoints (int turno) {
		if (turno == 1) {
			colocarZombie (11, 0 , 9); 
		}
		if (turno == 2) {
			colocarZombie (22, 9 , 9);
		}
		if (turno == 3) {
			colocarZombie (11, 0 , 9); 
			colocarZombie (22, 9 , 9);
		}
		if (turno == 4) {
			colocarZombie (33, 2 , 9); 
			colocarZombie (11, 9 , 9);
			colocarZombie (22, 7 , 9);
		}
		if (turno == 5) {
			colocarZombie (33, 4 , 9); 
			colocarZombie (22, 5 , 9);
			colocarZombie (11, 9 , 9);
		}
		if (turno == 6) {
			colocarZombie (11, 0 , 9); 
			colocarZombie (22, 9 , 9);
			colocarZombie (33, 5 , 9); 
		}
		
		if (turno == 7) {
			colocarZombie (11, 2 , 9); 
			colocarZombie (22, 5 , 9);
			colocarZombie (33, 7 , 9); 
		}
		
		if (turno == 8) {
			colocarZombie (33, 0 , 9); 
			colocarZombie (22, 2 , 9);
			colocarZombie (33, 7 , 9); 
			colocarZombie (11, 5 , 9); 
		}
		
		if (turno == 9) {
			colocarZombie (11, 9 , 9); 
			colocarZombie (22, 7 , 9);
			colocarZombie (33, 5 , 9);
			colocarZombie (33, 4 , 9);
		}
		
		if (turno == 10) {
			colocarZombie (11, 0 , 9);
			colocarZombie (11, 2 , 9); 
			colocarZombie (22, 4 , 9);
			colocarZombie (33, 5 , 9);
			colocarZombie (33, 7 , 9);

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
