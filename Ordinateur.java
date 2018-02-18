import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author taserface
 *
 */
public class Ordinateur extends Joueur{
	private Random r;
	
	public Ordinateur(String nom) {
		super(nom);
	}

	@Override
	public Carte choisirCarte() {
		// TODO Auto-generated method stub
		
		r = new Random();
		int indice = r.nextInt(paquet.getNombreCarte());
		return this.paquet.getCarte(indice);
	}
	
}
