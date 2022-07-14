package org.exercice_gestion_vols_01;


/**
 * Javadoc de classe: Vol<br>
 * @author laurent<br>
 * Descript°:<br>
 * Les attributs de classe:<br>
 * - nombreVols<br>
 * <br>
 * Les attributs d'instance:<br>
 * - numeroDuVol<br>
 * - destinationDuVol<br>
 * - dateDeDepartDuVol<br>
 * - nombreTotalDeReservations<br>
 * <br>
 * 1 Constructeur permettant d'initialiser<br>
 * les 4 attributs d'instance.<br>
 * <br>
 * 2 Setters:<br>
 * - pr dateDepartDuVol<br>
 * - pr nombreTotalDeReservations<br>
 * <br>
 * 5 getters (TOUS les attributs)<br>
 * <br>
 * La methode toString.
 */
public class Vol {

	/*
	 * Les attributs de classe
	 */
	
	public static int nombreVols = 0;
	
	/*
	 * Les attributs d'instance
	 */
	
	public int numeroDuVol;
	public String destinationDuVol;
	public Date dateDeDepartDuVol;
	public int nombreTotalDeReservations;
	
	public Vol(int p_numeroDuVol,
				String p_destinationDuVol,
				Date p_dateDeDepartDuVol,
				int p_nombreTotalDeReservations) {
		
		/*
		 * Correspondance entre les attributs
		 * et
		 * les parametres constructeur
		 */
		
		this.numeroDuVol = p_numeroDuVol;
		this.destinationDuVol = p_destinationDuVol;
		this.dateDeDepartDuVol = p_dateDeDepartDuVol;
		this.nombreTotalDeReservations = p_nombreTotalDeReservations;
	}
	
	/*
	 * Getter - Setter
	 */

	public Date getDateDeDepartDuVol() {
		return dateDeDepartDuVol;
	}

	public void setDateDeDepartDuVol(Date dateDeDepartDuVol) {
		this.dateDeDepartDuVol = dateDeDepartDuVol;
	}

	public int getNombreTotalDeReservations() {
		return nombreTotalDeReservations;
	}

	public void setNombreTotalDeReservations(int nombreTotalDeReservations) {
		this.nombreTotalDeReservations = nombreTotalDeReservations;
	}

	public static int getNombreVols() {
		return nombreVols;
	}

	public int getNumeroDuVol() {
		return numeroDuVol;
	}

	public String getDestinationDuVol() {
		return destinationDuVol;
	}
	
	/*
	 * Les methodes
	 */
	
	@Override
	public String toString() {
		return ("Numero du vol: "
				+ this.getNumeroDuVol()
				+ "\n"
				+ "Destination du vol: "
				+ this.getDestinationDuVol()
				+ "\n"
				+ "date de départ du vol: "
				+ this.getDateDeDepartDuVol()
				+ "\n"
				+ "Nombre total de reservations: "
				+ this.getNombreTotalDeReservations());
	}
	
}
