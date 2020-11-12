package proyecto2;

//TIPO 1 CURACION
//TIPO 2 EXPERIENCIA

public class Item {
	protected String tipo;
	protected int puntosEfecto;
	
	public Item(int _puntos, String _tipo) {
		this.tipo = _tipo;
		this.puntosEfecto = _puntos;
	}

}
