import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 
 */

/**
 * @author taserface
 *
 */
public class Paquet implements Iterable<Carte> {
	
	private ArrayList<Carte> cartes ;
	
	public static Couleur[] colorPaquet = new Couleur[] {Couleur.CARREAU,Couleur.COEUR,Couleur.PIQUE,Couleur.TREFLE};
    public static int[] valuePaquet = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	public Paquet() {
		this.cartes = new ArrayList<Carte>(52);
	}
	
	@Override
	public String toString() {
		return this.cartes.toString();	
	}
	
	public void AffichageListeCarte() {
		for(Carte c : cartes) {
			c.toString();
		}
	}
	
	@Override
    public Iterator<Carte> iterator(){
        return cartes.iterator();
    }
	
	public void ajouterCarte(Carte c) {
		this.cartes.add(c);
	}
	
	public boolean estVide() {
		if(this.cartes.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public Carte retirerCarte(int valeur) {
		return cartes.remove(valeur);
	}
	
	public Carte retirerCarte(Carte carte) {
		if(carte == null) {
			System.err.println("==================  LA CARTE SAISIE N'EXISTE PAS DANS LE PAQUET OU EST NULL  ==================");
			return null;
		}else {
			this.cartes.remove(carte);
			return carte;
		}	
	}
	
	public Carte getCarte(int index) {
		return cartes.get(index);
	}
	
	public void melanger() {
		Collections.shuffle(cartes, new Random(104));
	}

	public int getNombreCarte() {
		return this.cartes.size();
	}
	public boolean estContenu(Carte c) {
		if(this.cartes.contains(c)) {
			return true;
		}else
			return false;
	}
	
}
