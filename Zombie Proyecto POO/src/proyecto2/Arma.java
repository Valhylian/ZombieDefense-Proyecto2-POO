package proyecto2;

public class Arma {
	protected String name;
	protected int damage;
	protected int alcance; 
	protected int lvlRuido; 
	
	public Arma(String _name, int _damage, int _alcance, int _ruido) {
		this.name = _name;
		this.damage = _damage;
		this.alcance = _alcance;
		
		this.lvlRuido = _ruido;
		
	}
	
}
