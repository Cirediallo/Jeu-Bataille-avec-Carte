import java.util.*;

public abstract class Joueur {
	private String name;
	
	protected Paquet paquet;
	
	private static int score; //Score du joueur
	
	public Joueur(String nom) {
		this.name = nom;
		this.score = 0;
		nouveauJeu();
	}
	
	public void setName(String nom) {
		this.name = nom;
	}
	
	public void nouveauJeu() {
		this.paquet = new Paquet();
	}
	
	public Carte jouer() {
		Carte aJouer = choisirCarte();
		this.paquet.retirerCarte(aJouer);
		return aJouer;
	}
	
	public abstract Carte choisirCarte();
	
	public void recupererCarte(Carte c) {
		c.toString();
	}
	
	public boolean aPerdu() {
		/*
		if(this.paquet.estVide()) {
			return true;
		}else
			return false;
		*/
		return this.paquet.estVide() ? true : false;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void aGagner() {
		this.score++;
	}
	
	public int getNombreCartesJoueur() {
		return this.paquet.getNombreCarte();
	}
	
	public void gagnerCarte(Carte c) {
		this.paquet.ajouterCarte(c);
	}
	
	public String toString() {
		return this.name;
	}
}
