public class Carte implements Comparable<Carte>{
	private int valeur;
	private Couleur couleur;
	
	public Carte(int nombre,Couleur c) {
		this.valeur = nombre;
		this.couleur = c;
	}
	@Override
	public int compareTo(Carte other){
		if(this.getValeur() < other.getValeur())
			return -1;
		else if(this.getValeur() > other.getValeur()) {
			return 1;
		}else 
			return 0;
	}
	public boolean couleurSuperieur2(Carte c2) {
		if(this.getCouleur().ordinal() > c2.getCouleur().ordinal()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		String valeur = "";
		valeur += this.valeur;
		valeur += " ";
		valeur += this.couleur;		
		return valeur;
	}
	public Couleur getCouleur() {
		return this.couleur;
	}
	public int getValeur() {
		return this.valeur;
	}
	
	public String toString1() {
		String colorString = null;
		if(this.equals(Couleur.CARREAU)) {colorString = "CARREAU";}
		if(this.equals(Couleur.COEUR)) {colorString = "COEUR";}
		if(this.equals(Couleur.PIQUE)) {colorString = "PIQUE";}
		if(this.equals(Couleur.TREFLE)) {colorString = "TREFLE";}
		return colorString;
	}
}
