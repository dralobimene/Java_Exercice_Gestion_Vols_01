package org.exercice_gestion_vols_01;

/**
 * Javadoc de classe: Date<br>
 * @author laurent<br>
 * Descript°:<br>
 * Creer des instances de type Date.<br>
 * 3 attributs:<br>
 * - jour: String de 2 caractères.<br>
 * - mois: String de 2 caractères.<br>
 * - annee: String de 4 caractères.<br>
 * <br>
 * 2 constructeurs:<br>
 * - celui par défaut.<br>
 * - celui avec les 3 paramètres.<br>
 * <br>
 * Les 3 Getter.<br>
 * <br>
 * Methode toString qui retourne la chaine<br>
 * contenant les attributs séparés par "/"
 */
public class Date {

	/*
	 * Les attributs de classe:
	 * Aucun
	 */
	
	/*
	 * Les attributs d'instance
	 */
	
	public int jour;
	public int mois;
	public int annee;
	
	/*
	 * Les constructeurs
	 */
	
	public Date() {}
	
	public Date(int p_jour,
				int p_mois,
				int p_annee) {
		
		this.jour = p_jour;
		this.mois = p_mois;
		this.annee = p_annee;
	}

	/*
	 * les Getter
	 */
	
	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}
	
	/*
	 * Les methodes
	 */
	
	@Override
	public String toString() {
		return (this.getJour()
				+ "/"
				+ this.getMois()
				+ "/"
				+ this.getAnnee());
	}
	
}
