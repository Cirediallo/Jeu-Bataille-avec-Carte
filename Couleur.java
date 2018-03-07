public enum Couleur{
	PIQUE,
	CARREAU,
	COEUR,
	TREFLE;
	
	public boolean couleurSuperieur(Couleur c2) {
		/*
		if(this.ordinal() > c2.ordinal()) {
			
			return true;
		}else {
			
			return false;
		}
		*/
		return this.ordinal() > c2.ordinal();
	}
	
}
