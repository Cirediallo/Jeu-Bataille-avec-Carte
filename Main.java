import java.util.ArrayList;

/**
 * 
 */

/**
 * @author taserface
 *
 */
public class Main {

	/**
	 * @param args
	 */
	private static Paquet paquet;
	private static Joueur[] gamers = {new Humain("Monster"),
									  new Humain("Taser")
									 } ;
	private static int tour = 1;
	
	private static Joueur jouerCoup() {
		Carte gamer1Card,gamer2Card;
		Joueur winner = null;
		Paquet partCard = new Paquet();
		System.out.println(" ~~~~~~~~  Tour "+tour+"  ~~~~~~~~~");
		do {
			gamer1Card = gamers[0].jouer();
			gamer2Card = gamers[1].jouer();
			partCard.ajouterCarte(gamer1Card);
			partCard.ajouterCarte(gamer2Card);
			//System.out.println("\n");
			System.out.println(gamers[0].toString()+" a joué "+gamer1Card.toString());
			System.out.println(gamers[1].toString()+" a joué "+gamer2Card.toString());
			if(gamer1Card.compareTo(gamer2Card) < 0) {
				winner = gamers[1];
			}else if(gamer1Card.compareTo(gamer2Card) > 0) {
				winner = gamers[0];
			}else {
	                if(gamers[0].getNombreCartesJoueur() >= 0 && gamers[1].getNombreCartesJoueur() >= 0){
	                	//if( gamer1Card.getCouleur().couleurSuperieur(gamer2Card.getCouleur()) == true) {
	                	if(gamer1Card.couleurSuperieur2(gamer2Card)) {
	                		winner = gamers[0];
	                	}else {
	                		
	                		winner = gamers[1];
	                	}
	                }
				
			}
		}while( (!gamers[0].aPerdu() && !gamers[1].aPerdu() ) && gamer1Card.compareTo(gamer2Card) == 0 );
		
		/* Le joueur gagnant recupère les cartes joués du coup*/
		for(Carte c: partCard){
            winner.gagnerCarte(c);
        }
		
		if(winner == null && gamers[0].aPerdu()){winner = gamers[1];}
        if(winner == null && gamers[1].aPerdu()){winner = gamers[0];}
        System.out.println(winner+" remporte les cartes de la partie");
        System.out.println("Il reste "+gamers[0].getNombreCartesJoueur()+" cartes avec le joueur "+gamers[0].toString());
        System.out.println("Il reste "+gamers[1].getNombreCartesJoueur()+" cartes avec le joueur "+gamers[1].toString());
        tour++;
        
        return winner;
	}
	
	/* Créer un nouveau Paquet */
	private static void creerNouveauPaquet() {
		paquet = new Paquet();
		for(int i = 0; i < Paquet.valuePaquet.length; i++) {
			for(int j = 0; j < Paquet.colorPaquet.length; j++) {
				paquet.ajouterCarte(new Carte(Paquet.valuePaquet[i],Paquet.colorPaquet[j]));
			}
		}
	}
	
	private static void distribuerPaquet() {
		paquet.melanger();
		for(int i = 0; i < paquet.getNombreCarte(); i++) {
			Carte toAdd = paquet.getCarte(i);	
			gamers[i%2].gagnerCarte(toAdd);
		}
	}
	
	private static void jouerPartie() {
		while(!gamers[0].aPerdu() && !gamers[1].aPerdu()) {
			jouerCoup();
		}
		if(gamers[0].aPerdu()) {
			System.out.println("LE VAINQUEUR EST: "+gamers[1].toString());
		}else {
			System.out.println("LE VAINQUEUR EST: "+gamers[0].toString());
		}
	}
	
	private int getNombreTour() {
		return this.tour;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------  JEU DE BATAILLE AVEC CARTE  -------------");
		creerNouveauPaquet();
		distribuerPaquet();
		System.out.println("Le joueur "+gamers[0].toString()+" a "+gamers[0].paquet.getNombreCarte()+" cartes");
		System.out.println("Le joueur "+gamers[1].toString()+" a "+gamers[1].paquet.getNombreCarte()+" cartes");
		
		jouerPartie();
	}

}
