import java.io.*;
import java.util.*;

public class Humain extends Joueur {
	
	public Humain(String pseudo) {
		super(pseudo);
	}

	@Override
	public Carte choisirCarte() {
		// TODO Auto-generated method stub
		System.out.println("\n\t\t"+this.toString());
		System.out.println(" ***************  La liste des cartes en votre possession  ***************");
		for(int i = 0; i < paquet.getNombreCarte(); i++) {
			System.out.print(this.paquet.getCarte(i).toString().toUpperCase()+"  ");
		}
		System.out.println("\nQuelle carte voulez-vous jouer ?");
		System.out.print("Numéro de la carte: ");
		Scanner sc = new Scanner(System.in);
		int cardValue = sc.nextInt();
		if(cardValue > 13 || cardValue < 1) {
			throw new IllegalArgumentException("La valeur doit être comprise entre 1 et 13");
		}
		
		String colorValue = null ;
		
		Couleur color = null;
		while(color == null) {
			System.out.print("Couleur: ");
			try {
				Reader isr = new InputStreamReader(System.in) ;
				BufferedReader br = new BufferedReader(isr) ;
				colorValue = br.readLine() ;
			}catch (IOException e) {
				new IllegalArgumentException("Erreur "+e.getMessage());
			}
			if(colorValue.toUpperCase().equals("PIQUE")) {
				color = Couleur.PIQUE;
			}
			else if(colorValue.toUpperCase().equals("CARREAU")) {
				color = Couleur.CARREAU;
			}
			else if(colorValue.toUpperCase().equals("TREFLE")) {
				color = Couleur.TREFLE;
			}
			else if(colorValue.toUpperCase().equals("COEUR")) {
				color = Couleur.COEUR;
			}
			else {
				System.out.println("La couleur saisie n'existe pas dans ce Jeu de bataille");
			}
		}
		
		String concatCardValue = cardValue+" "+colorValue;
		for(int i = 0; i < paquet.getNombreCarte(); i++) {
			if(this.paquet.getCarte(i).toString().toLowerCase().equals(concatCardValue)) {
				return this.paquet.retirerCarte(this.paquet.getCarte(i));
			}
		}
		System.out.println("\n===============  La Carte n'existe pas  ===============");
		System.out.println("===============  Donc je renvoi la dernière carte de ton paquet  ===============");
		return this.paquet.retirerCarte(this.paquet.getNombreCarte()-1);
		
	}
	
}
