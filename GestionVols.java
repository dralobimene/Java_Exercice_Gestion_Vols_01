package org.exercice_gestion_vols_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Javadoc de classe: GestionVols<br>
 * @author laurent<br>
 * Descript°:<br>
 * Exercice de gestion des vols d'1 cpie aerienne.
 */
public class GestionVols {
	
	/*
	 * Les attributs de classe
	 */
	
	/*
	 * Les constantes
	 */
	
	// MAX_PLACES = 340: le nbre max de places ds 1 avion
	public final static int MAX_PLACES = 340;
	
	// MAX_vols = 8: le nbre max de vol permis
	public final static int MAX_VOLS = 8;
	
	/*
	 * Les attributs d'instance
	 */
	
	/*
	 * Autres variables
	 */
	
	// le tableau qui stockera les vols en fct°
	// du fichier lu.
	public static List<Vol> vols = new ArrayList<Vol>();
	
	// variables qui stockent les infos du vol que
	// l'utilisateur a selectionne.
	// ou les infos que l'utilisateur a entré
	// pr inserer le vol
	public static int scanNumeroVolSelectionne_ = 0;
	public static String scanDestinationVolSelectionne_ = "";
	public static Date scanDateVolSelectionne_ = null;
	public static int scanJourVolSelectionne_ = 0;
	public static int scanMoisVolSelectionne_ = 0;
	public static int scanAnneeVolSelectionne_ = 0;
	public static int scanNombreTotalReservationsVolSlectionne_ = 0;
	public static int scanIndexArrayList_ = 0;
	
	/*
	 * Les methodes
	 */	
	
	/**
	 * Javadoc de fct°: main()<br>
	 * @param args<br>
	 * Descript°:<br>
	 * Execute la fct° qui fera apparaitre les<br>
	 * differents menu.<br>
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// appel de la methode f03ChargerVols()
		// pr qu'ensuite on puisse travailler a
		// partir de la ArrayList vols
		f03ChargerVols();
				
		System.out.println("----------------------------");
		f01MenuPrincipal();

	}
	
	/**
	 * Javadoc de fct°: f01MenuPrincipal()<br>
	 * Descript°:<br>
	 * Affiche le menu principal de l'applica°.
	 */
	public static void f01MenuPrincipal() {
		
		//
		System.out.println("f01MenuPrincipal");
		System.out.println("\n");
		
		System.out.println("nbre de vols ds la ArrayList");
		System.out.println(vols.size());
		System.out.println("\n");
		
		// Creat° d'1 objet de type Scanner
		Scanner scanMenuPrincipal = new Scanner(System.in);
		
		// variable pr enregistrer le choix de l'utilisateur
		int choixMenuPrincipal;
		
		// afficher la variable scanNumeroVolSelectionne_
		// si == 0, aucun vol selectionne
		// si != 0, alors doit afficher 1 n° de vol
		// entré par l'utilisateur
		f07VerifierSiVolSelectionne();
		
		// Suivant que la ArrayList est pleine ou pas
		// l'utilisateur pourra
		// si non pleine:
		// - ajouter 1 vol
		// - supprimer 1 vol
		// - modifier 1 vol
		// si pleine:
		// - supprimer 1 vol
		// - modifier 1 vol
		// si vide:
		// - ajouter 1 vol
		if(vols.size() >= 8) {
			System.out.println("Nbre de vols >= à 8");
			System.out.println("Veuillez retirer au moins 1 vol avt de pvoir en ajouter.");
			System.out.println("Voici les operat° que vs pvez effectuer:");
			System.out.println("-- Menu principal --");
			System.out.println("1. Liste des vols");
			System.out.println("2. Retrait d'un vol");
			System.out.println("3. Modification de la date de depart");
			System.out.println("4. Réservation d'un vol");
			System.out.println("5. Terminer");
			
			// traitement exception
			try {
				// Enregistre la frappe clavier de l'utilisateur
				choixMenuPrincipal = scanMenuPrincipal.nextInt();
		        
		        switch(choixMenuPrincipal) {
			    	case 1: {
			    		f06listerVols();
			    		break;
			    	}
			    	case 2: {
			    		f04RetirerVol();
			    		break;
			    	}
					case 3: {
						f09ModifierDateVol();
						break;
					}
					case 4: {
						f10AjouterReservation();
						break;
					}
					case 5: {
						System.out.println("--- Programme terminé ---");
		        		
						// scanMenuPrincipal.close();
						// scanMenuPrincipal = null;
		        		
						break;
					}
					default:
		        		System.out.println("Vs n'avez pas choisi 1 bonne opt°, recommencez svp");
		        		System.out.println("f01, M05");
		        		f01MenuPrincipal();
		        		break;
		        }
			} catch(Exception e) {
				System.out.println("Erreur de saisie");
				System.out.println("f01, M04");
				f01MenuPrincipal();
			}
	        
		} else if(vols.size() >= 1 && vols.size() < 8) {
			System.out.println("Nbre de vols entre 1 et 7, Faites votre choix.");
			System.out.println("-- Menu principal --");
			System.out.println("1. Liste des vols");
			System.out.println("2. Ajout d'un vol");
	        System.out.println("3. Retrait d'un vol");
	        System.out.println("4. Modification de la date de depart");
	        System.out.println("5. Réservation d'un vol");
	        System.out.println("6. Terminer");
	        
	        // traitement exception
	        try {
	        	// Enregistre la frappe clavier de l'utilisateur
		        choixMenuPrincipal = scanMenuPrincipal.nextInt();
		        
		        switch(choixMenuPrincipal) {
			    	case 1: {
			    		f06listerVols();
			    		break;
			    	}
			    	case 2: {
			    		f05insererVol();
			    		break;
			    	}
					case 3: {
						f04RetirerVol();
						break;
					}
					case 4: {
						f09ModifierDateVol();
						break;
					}
					case 5: {
						f10AjouterReservation();
						break;
					}
					case 6: {
						System.out.println("--- Programme terminé ---");
						// scanMenuPrincipal.close();
						// scanMenuPrincipal = null;
		        		break;
					}
					default:
		        		System.out.println("Vs n'avez pas choisi 1 bonne opt°, recommencez svp");
		        		System.out.println("f01, M03");
		        		f01MenuPrincipal();
		        		break;
		        }
	        } catch(Exception e) {
	        	System.out.println("Erreur de saisie");
	        	System.out.println("f01, M02");
	        	f01MenuPrincipal();
	        }
	        
		} else {
			System.out.println("Aucun vol, veuillez ajouter au moins 1 vol avt de porsuivre");	
			System.out.println("-- Menu principal --");
			System.out.println("1. Ajout d'un vol");
			System.out.println("2. Terminer");
			
			// traitement exception
			try {
				// Enregistre la frappe clavier de l'utilisateur
		        choixMenuPrincipal = scanMenuPrincipal.nextInt();
		        
		        switch(choixMenuPrincipal) {
			    	case 1: {
			    		f05insererVol();
			    		break;
			    	}
			    	case 2: {
			    		System.out.println("--- Programme terminé ---");
			    		// scanMenuPrincipal.close();
			    		// scanMenuPrincipal = null;
		        		break;
			    	}
			    	default:
		        		System.out.println("Vs n'avez pas choisi 1 bonne opt°, recommencez svp");
		        		f01MenuPrincipal();
		        		break;
		        }
			} catch(Exception e) {
				System.out.println("Erreur de saisie");
				System.out.println("fct f01 M01");
				f01MenuPrincipal();
			}
			
		}
		
	}
	
	public static void f02RechercherVol() {
		
		//
		System.out.println("f02RechercherVol");
		System.out.println("\n");
		
		// Affichage de la ArrayList vols
		// pr choisir le vol par le biais
		// du numero de vol
		System.out.println("------------------------------------------");
		for(Vol v:vols) {
			System.out.println(v);
			System.out.println("------------------------------------------");
		}
		
		// initialisat° de l'objet de type Scanner
		Scanner scanNumeroVolSelectionne = new Scanner(System.in);
		
		// declarat° variable qui enregistrera le n° de vol
		// tapé par l'utilisateur
		int choixNumeroVolSelectionne;
		
		// affichage: l'utilisateur doit entrer
		// 1 n° de vol
		System.out.println("Veuillez entrer 1 n° de vol:");
		
		// traitement exception
		// a ecrire
		
		// enregistrement de la frappe clavier
		choixNumeroVolSelectionne = scanNumeroVolSelectionne.nextInt();
		
		// affichage de la frappe clavier
		System.out.println("Vs avez entré le vol n°:");
		System.out.println(choixNumeroVolSelectionne);
		
		/*
		recherche du n° de vol entré par l'utilisateur
		ds la ArrayList
		NOTE
		on compare avec le "==" car on compare des int
		en String, il faut utiliser "contains" ou "equals"
		*/
		
		//
		boolean check = true;
		
		// exprime l'index de l'elt vol ds la ArrayList
		int countf02A = -1;
		
		while(true) {
			
            for(Vol v : vols) {
            	
            	countf02A++;
                
            	// La recherche trouve
            	if(choixNumeroVolSelectionne == v.numeroDuVol) {
            		
                    System.out.println("Voici les informations concernant le vol:");
                    
                    check = false;
                    
                    System.out.println("index ds la ArrayList: " + countf02A);
                    System.out.println("N° du vol: " + v.numeroDuVol);
                    System.out.println("Destinat°: " + v.destinationDuVol);
                    System.out.println("Date de départ: " + v.dateDeDepartDuVol);
                    System.out.println("Resa: " + v.nombreTotalDeReservations);
                    
                    // enregistre les infos du vol au
                    // niveau portee classe
                    scanNumeroVolSelectionne_ = v.numeroDuVol;
                    scanDestinationVolSelectionne_ = v.destinationDuVol;
                    scanDateVolSelectionne_ = v.dateDeDepartDuVol;
                    scanNombreTotalReservationsVolSlectionne_ = v.getNombreTotalDeReservations();
                    scanIndexArrayList_ = countf02A;
                    
                    // fermer et desallouer l'objet
                    // de type Scanner
                    // scanNumeroVolSelectionne.close();
                    // scanNumeroVolSelectionne = null;
                    
                    break;
                }
            }
            
            // La recherche ne trouve pas,
            // presente 1 nvel essai jusqu'au succes
            if(check) {
            	
            	System.out.print("Vol introuvable, réessayez SVP.");
            	choixNumeroVolSelectionne = scanNumeroVolSelectionne.nextInt();
            	continue;
            	
            }
            
            break;
            
        }
	}
	
	/**
	 * Javadoc de fct°: f03ChargerVols()<br>
	 * Descript°:<br>
	 * Ouvre le fichier texte,<br>
	 * le lit,<br>
	 * extrait et traite les infos necessaires,<br>
	 * ferme le fichier.
	 */
	public static void f03ChargerVols() {
		
		System.out.println("f03ChargerVols");
		System.out.println("\n");
		
		// definir le fichier a lire
		File file = new File("/media/sambano/home_HDD_EXTERNE/Documents/java/Exercices_faits/01_gestion_des_vols/Cie_Air_Relax.txt");
		
		try {
			// cree 1 objet de type Scanner
			Scanner scanFile = new Scanner(file);
			
			// definit 1 List de type ArrayList qui n'accepte
			// que des String
			List<String> liste = new ArrayList<String>();
			
			// boucle pr lire le fichier
			while(scanFile.hasNext()) {
				
				// ajoute chaque ligne du fichier
				// ds la ArrayList
				liste.add(scanFile.nextLine());
			}
			
			// boucle pr agir sur chaque element
			// contenu desormais ds la ArrayList
			// on extrait les 4 informat° necessaires
			// - le n° du vol
			// - la destinat° du vol
			// - la date du vol
			// - le nbre de reservat° du vol
			for(int i = 0; i < liste.size(); i++) {
				
				// affichage de chaque elt complet de la ArrayList
				// 1 elt de cette liste = 1 L du fichier texte
				// System.out.println(liste.get(i));
				
				// definir la source a traiter
				// (ici, Les L 1 a 1 de la ArrayList)
				String source = liste.get(i);
				
				// variables pr pvoir modifier
				// le type (de String en int)
				// des infos extraites depuis la
				// ArrayList
				// (initialisat° des variables obligatoire?)
				int intNumeroDuVol = 0;
				String destinationDuVol = "";
				Date d = null;
				int intNombreDeReservations = 0;
				
				// variables de type Pattern regex pr extraire les donnees
				Pattern pNumeroDuVol = Pattern.compile("(^[0-9]+)");
				Pattern pDestination = Pattern.compile("([a-zA-Z-\\p{L}]+ [a-zA-Z-\\p{L}]+ [a-zA-Z-\\p{L}]+|[a-zA-Z-\\p{L}]+ [a-zA-Z-\\p{L}]+|[a-zA-Z-\\p{L}]+)");
				Pattern pDateDuVol = Pattern.compile("((?:[0-9][0-9] [0-9][0-9] [0-9][0-9][0-9][0-9]))");
				Pattern pNombreDeReservations = Pattern.compile("([0-9]+$)");
				
				// variables de type Matcher pr etablir la
				// correspondance avec les pattern regex ci-dessus
				Matcher mNumeroDuVol = pNumeroDuVol.matcher(source);
				Matcher mDestination = pDestination.matcher(source);
				Matcher mDateDuVol = pDateDuVol.matcher(source);
				Matcher mNombreDeReservations = pNombreDeReservations.matcher(source);
				
				// extrait le n° du vol de la L
				if(mNumeroDuVol.find()) {
					// System.out.println("Numero du vol: " + mNumeroDuVol.group(0));
					String numeroDuVol = mNumeroDuVol.group(0);
					
					// modificat° du type de la donnee
					intNumeroDuVol = Integer.parseInt(numeroDuVol);
				}
				// extrait la destination du vol de la L
				if(mDestination.find()) {
					// System.out.println("destination du vol: " + mDestination.group(0));
					destinationDuVol = mDestination.group(0);
				}
				// extrait la date, le jour, le mois et l'annee du vol de la L
				// modifie le type (de String en int) des 3 dernières infos
				if(mDateDuVol.find()) {
					// System.out.println("date du vol: " + mDateDuVol.group(0));
					// System.out.println("jour du vol: " + mDateDuVol.group(0).substring(0, 2));
					String jourDuVol = mDateDuVol.group(0).substring(0, 2);
					
					// modificat° du type de la donnee
					int intJourDuVol = Integer.parseInt(jourDuVol);
					
					// System.out.println("mois du vol: " + mDateDuVol.group(0).substring(3, 5));
					String moisDuVol = mDateDuVol.group(0).substring(3, 5);
					
					// modificat° du type de la donnee
					int intMoisDuVol = Integer.parseInt(moisDuVol);
					
					// System.out.println("Annee du vol: " + mDateDuVol.group(0).substring(6, 10));
					String anneeDuVol = mDateDuVol.group(0).substring(6, 10);
					
					// modificat° du type de la donnee
					int intAnneeDuVol = Integer.parseInt(anneeDuVol);
					
					// creat° d'objets de type Date
					// on est tjs ds la boucle for)
					d = new Date(intJourDuVol, intMoisDuVol, intAnneeDuVol);
				}
				// extrait le nbre de resa du vol de la L
				if(mNombreDeReservations.find()) {
					
					// System.out.println("Nbre de resas du vol: " + mNombreDeReservations.group(0));
					String nombreDeReservations = mNombreDeReservations.group(0);
					
					// modificat° du type de la donnee
					intNombreDeReservations = Integer.parseInt(nombreDeReservations);
				}
				
				// creat° d'objets de type Vol
				// (on est tjs ds la boucle for)
				Vol v = new Vol(intNumeroDuVol, destinationDuVol, d, intNombreDeReservations);
				
				// remplit la List (ArrayList) qui
				// stocke les vols
				vols.add(v);
				
			}
			
			// ferme l'objet de type Scanner
			// scanFile.close();
			
			// ferme le fichier
			// peut etre qu'il est fermé automatiquement
			// TODO: verifier si la fermeture du fichier est necessaire
			
		}
			
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Javadoc de fct° f04RetirerVol()<br>
	 * Descript°:<br>
	 * Retire 1 vol de la ArrayList.
	 */
	public static void f04RetirerVol() {
		
		//
		System.out.println("f04RetirerVol");
		System.out.println("\n");
		
		//
		f02RechercherVol();
		
		//
		f08ConfirmerRetraitVol();
	}

	/**
	 * Javadoc de fct°: listerVols()<br>
	 * Descript°:<br>
	 * 
	 */
	public static void f06listerVols() {
		
		//
		System.out.println("f06listerVols()");
		System.out.println("\n");
		
		// Affichage de la ArrayList vols
		System.out.println("------------------------------------------");
		for(Vol v:vols) {
			System.out.println(v);
			System.out.println("------------------------------------------");
		}
		
		// affichage du menu apres avoir listé les vols
		// depuis la ArrayList vols
		
		// creat° d'1 objet de type Scanner
		Scanner scanMenuListerVols = new Scanner(System.in);
		
		// declarat° de la variable qui enregistrera
		// le choix de l'utilisateur
		int choixMenuListerVols;
		
		// affichage du menu
		System.out.println("-- Menu: Lister vols --");
		System.out.println("pr retourner au menu principal: 1");
		System.out.println("pr quitter le programme: 2");
		
		// traitement exception
		try {
		
			// enregistrement de la frappe clavier
			choixMenuListerVols = scanMenuListerVols.nextInt();
			
			switch(choixMenuListerVols) {
		    	case 1: {
		    		f01MenuPrincipal();
		    		break;
		    	}
		    	case 2: {
		    		System.out.println("--- Programme terminé ---");
		    		// scanMenuListerVols.close();
		    		// scanMenuListerVols = null;
		    		break;
		    	}
		    	default:
		    		System.out.println("Vs n'avez pas choisi 1 bonne opt°, recommencez svp");
		    		// NOTE
		    		// etant donné qu'on relance la fct° qd
		    		// l'utilisateur ne choisit pas 1
		    		// opt° valide, n'y a t-il pas 1 consommat°
		    		// de ressources?
		    		f06listerVols();
		    		break;
			}
		
		} catch (Exception e) {
			System.out.println("Erreur de saisie");
			f06listerVols();
		}
		
	}
	
	/**
	 * Javadoc de fct°: insererVol()<br>
	 * Descript°:<br>
	 * Permet d'inserer 1 nveau vol si<br>
	 * la ArrayList vols a - de 8 vols.<br>
	 * Sinon, envoie 1 msg d'impossibilité.
	 */
	public static void f05insererVol() {
		
		System.out.println("f05insererVol");
		System.out.println("\n");		
		
		// verifie le nbre de vols prevus
		if(vols.size() >= MAX_VOLS) {
			
			System.out.println("WARNING: nombre maximum de vols permis: 8");
			System.out.println("Limite atteinte.");
			System.out.println("Veuillez supprimer au moins 1 vol");
			System.out.println("avant de pouvoir en ajouter 1.");
			
			// affichage du menu
			
			// creat° d'1 objet de type Scanner
			Scanner scanMenuInsererVolLimiteAtteinte = new Scanner(System.in);
			
			// declarat° variable pr enregistrer la frappe
			// clavier utilisateur
			int choixMenuInsererVolLimiteAtteinte;
			
			// Affichage du menu
			System.out.println(" Menu: inserer vols, limite atteinte");
			System.out.println("pr retourner au menu principal: 1");
			System.out.println("pr quitter le programme: 2");
			
			// traitement exception
			try {
				
				// enregistre la frappe clavier de l'utilisateur
				choixMenuInsererVolLimiteAtteinte = scanMenuInsererVolLimiteAtteinte.nextInt();
				
				switch(choixMenuInsererVolLimiteAtteinte) {
				
		        	case 1: {
		        		
		        		f01MenuPrincipal();
		        		break;
		        	}
		        	case 2: {
		        		
		        		System.out.println("--- Programme terminé ---");
		        		// scanMenuInsererVolLimiteAtteinte.close();
		        		// scanMenuInsererVolLimiteAtteinte = null;
		        		break;
		        	}
		        	default:
		        		
		        		System.out.println("Vs n'avez pas choisi 1 bonne opt°, recommencez svp");
		        		// NOTE
		        		// etant donné qu'on relance la fct° qd
		        		// l'utilisateur ne choisit pas 1
		        		// opt° valide, n'y a t-il pas 1 consommat°
		        		// de ressources?
		        		f05insererVol();
		        		break;
		        		
				}
			} catch(Exception e) {
				
				System.out.println("Erreur de saisie");
				System.out.println("Erreur L655: f05InsererVol(), F05B");
				f05insererVol();
				
			}
			
		} else if(vols.size() >= 1 && vols.size() <= MAX_VOLS) {
			
			System.out.println("Insert° d'1 vol");
			
			// creat° d'objets de type Scanner
			Scanner scanInfoNouveauVolNumero = new Scanner(System.in);
			Scanner scanInfoNouveauVolDestination = new Scanner(System.in);
			Scanner scanInfoNouveauVolJour = new Scanner(System.in);
			Scanner scanInfoNouveauVolMois = new Scanner(System.in);
			Scanner scanInfoNouveauVolAnnee = new Scanner(System.in);
			Scanner scanInfoNouveauVolNbreTotalResa = new Scanner(System.in);
						
			System.out.println("Veuillez entrer 1 n° de vol");
			System.out.println("(format: 5 chiffres)");
			
			// TODO: ecrire verifs
			// 01: le numero de vol ne peut comprendre que des chiffres
			// 02: le numero de vol est composé de 5 chiffres, ni +, ni -
			// 03: le numero de vol ne doit pas deja exister ds la
			// ArrayList
			
			// traitement exception pr n° du vol
			try {
				
				// Déclarat° variable qui enregistre
				// le n° du vol tapé par l'utilisateur
				scanNumeroVolSelectionne_ = scanInfoNouveauVolNumero.nextInt();
				
			} catch(Exception e) {
				System.out.println("Erreur saisie");
				System.out.println("erreur f05InsererVol() F05A");
				System.out.println("RESET operation F05A");
				f05insererVol();
			}
			
			System.out.println("Veuillez entrer 1 destination:");
			
			// TODO: ecrire verifs
			
			// traitement except° pr destinat°
			try {
				
				// declarat° variable qui enregistre
				// la destinat° du vol tapée par l'utilisateur
				scanDestinationVolSelectionne_ = scanInfoNouveauVolDestination.nextLine();
				
				// Affichage de la frapppe clavier
				System.out.println("La destinat° du vol que vs avez tapé");
				System.out.println(scanDestinationVolSelectionne_);
				
				
			} catch(Exception e) {
				
				System.out.println("Erreur saisie");
				System.out.println("erreur f05InsererVol F05B");
				System.out.println("RESET operation");
				f05insererVol();
				
			}
			
			System.out.println("Veuillez entrer le jour du vol");
			System.out.println("(format: 2 chiffres");
			System.out.println("(compris entre 01 et 31)");
			
			// TODO: ecrire verifs
			// le jour ne peut etre composé que de chiffres
			// le jour doit etre composé de 2 chiffres, ni +, ni -
			// le jour doit etre compris entre 01 et 31
			
			// declarat° variable qui enregistre
			// le jour du vol tapé par l'utilisateur
			scanJourVolSelectionne_ = scanInfoNouveauVolJour.nextInt();
			
			// Affichage de la frappe clavier
			System.out.println("Le jour du vol que vs avez tapé");
			System.out.println(scanJourVolSelectionne_);
			
			System.out.println("Veuillez entrer le mois du vol");
			System.out.println("(format: 2 chiffres)");
			System.out.println("(compris entre 01 et 12)");
			
			// TODO: ecrire verifs
			// le mois ne peut etre composé que de chiffres
			// le mois doit etre composé de 2 chiffres, ni +, ni -
			// le mois doit etre compris entre 01 et 12
			
			// declarat° variable qui enregistre
			// le mois du vol tapé par l'utilisateur
			scanMoisVolSelectionne_ = scanInfoNouveauVolMois.nextInt();
			
			// Affichage de la frappe clavier
			System.out.println("Le mois du vol que vs avez tapé");
			System.out.println(scanMoisVolSelectionne_);
						
			System.out.println("Veuillez entrer l'année du vol");
			System.out.println("(format: 4 chiffres)");
			
			// TODO: ecrire verifs
			// l'année ne peut etre composée que de chiffres
			// l'année doit etre composée de 4 chiffres, ni +, ni -
			// l'année ne peut etre < à l'année en cours
			
			// declarat° variable qui enregistre
			// l'année du vol tapé par l'utilisateur
			scanAnneeVolSelectionne_ = scanInfoNouveauVolAnnee.nextInt();
			
			// Affichage de la frappe clavier
			System.out.println("L'année du vol que vs avez tapé");
			System.out.println(scanAnneeVolSelectionne_);
			
			System.out.println("Veuillez entrer le nbre de resa du vol");
			System.out.println("(compris entre 0 et 340)");
			
			// TODO: ecrire les verifs
			// les resas ne pvent etre composées que de chiffres
			// les résas pvent etre composées de 1, 2 ou 3 chiffres
			// les résas st comprises entre 0 et MAX_PLACES (340)
			
			// declarat° variable qui enregistre
			// le nbre de resa du vol tapé par l'utilisateur
			scanNombreTotalReservationsVolSlectionne_ = scanInfoNouveauVolNbreTotalResa.nextInt();
			
			// Affichage de la frappe clavier
			System.out.println("Le nbre de resa du vol que vs avez tapé");
			System.out.println(scanNombreTotalReservationsVolSlectionne_);
			
			// creat° objet de type Date
			Date d01 = new Date(scanJourVolSelectionne_, scanMoisVolSelectionne_, scanAnneeVolSelectionne_);
			
			System.out.println("l'objet d01 pr insert°:");
			System.out.println(d01);
			
			// creat° objet de type vol
			Vol v01 = new Vol(scanNumeroVolSelectionne_, scanDestinationVolSelectionne_, d01, scanNombreTotalReservationsVolSlectionne_);
			
			System.out.println("l'objet v01 pr insert°:");
			System.out.println(v01);
			
			System.out.println("taille de la ArrayList avt insert°");
			System.out.println(vols.size());
			
			// insert° de l'objet de type Vol
			// ds la ArrayList
			vols.add(v01);
			
			System.out.println("Taille de la ArrayList après insert°");
			System.out.println(vols.size());
			
			System.out.println("Retour au menu principal");
			f01MenuPrincipal();
		}
		
	}
	
	/**
	 * Javadoc de fct°: verifierSiVolSelectionne<br>
	 * Descript°:<br>
	 * Verifie si l'utilisateur a selectionne<br>
	 * le n° d'1 vol pr 1 future operation.
	 */
	public static void f07VerifierSiVolSelectionne() {
		
		System.out.println("f07VerifierSiVolSelectionne");
		System.out.println("\n");		
		
		// affichage de la valeur
		System.out.println("valeur de scanNumeroVolSelectionne_");
		System.out.println(scanNumeroVolSelectionne_);
	}
	
	/**
	 * Javadoc de fct°: f08ConfirmerRetraitVol()<br>
	 * Descript°:<br>
	 * Methode qui retire le vol de la ArrayList vols.<br>
	 * Methode appellée ds f04RetirerVol().
	 */
	public static void f08ConfirmerRetraitVol() {
		
		System.out.println("f08ConfirmerRetraitVol");
		System.out.println("\n");
		
		System.out.println("taille de la ArrayList avt suppress° du vol");
		System.out.println(vols.size());
		
		System.out.println("Suppression du vol");
		vols.remove(scanIndexArrayList_);
		
		System.out.println("Taille de la ArrayList après suppress° du vol");
		System.out.println(vols.size());
		
		System.out.println("Retour au menu principal");
		f01MenuPrincipal();
		
	}
	
	/**
	 * Javadoc de fct°: f09ModifierDateVol()<br>
	 * Descript°:<br>
	 * Permet a l'utilisateur de modifier la date d'1 vol.
	 */
	public static void f09ModifierDateVol() {
		
		System.out.println("f09ModifierDateVol()");
		System.out.println("\n");
		
		//
		f02RechercherVol();
		
		System.out.println("Modifier la date de ce vol");
		
		// creat° d'1 objet de type Scanner pr modifier
		// le jour du vol
		Scanner scanModifierJourVol = new Scanner(System.in);
		
		System.out.println("Veuillez entrer le jour du vol");
		System.out.println("(format: 2 chiffres");
		System.out.println("(compris entre 01 et 31)");
		
		// TODO: ecrire verifs
		// le jour ne peut etre composé que de chiffres
		// le jour doit etre composé de 2 chiffres, ni +, ni -
		// le jour doit etre compris entre 01 et 31
		
		// declarat° variable qui enregistre
		// le jour du vol tapé par l'utilisateur
		scanJourVolSelectionne_ = scanModifierJourVol.nextInt();
		
		// Affichage de la frappe clavier
		System.out.println("Le jour du vol que vs avez tapé");
		System.out.println(scanJourVolSelectionne_);
		
		// creat° d'1 objet de type Scanner pr modifier
		// le mois du vol
		Scanner scanModifierMoisVol = new Scanner(System.in);
		
		System.out.println("Veuillez entrer le mois du vol");
		System.out.println("(format: 2 chiffres)");
		System.out.println("(compris entre 01 et 12)");
		
		// TODO: ecrire verifs
		// le mois ne peut etre composé que de chiffres
		// le mois doit etre composé de 2 chiffres, ni +, ni -
		// le mois doit etre compris entre 01 et 12
		
		// declarat° variable qui enregistre
		// le mois du vol tapé par l'utilisateur
		scanMoisVolSelectionne_ = scanModifierMoisVol.nextInt();
		
		// Affichage de la frappe clavier
		System.out.println("Le mois du vol que vs avez tapé");
		System.out.println(scanMoisVolSelectionne_);
		
		// creat° d'1 objet de type Scanner pr modifier
		// l'année du vol
		Scanner scanModifierAnneeVol = new Scanner(System.in);
		
		System.out.println("Veuillez entrer l'année du vol");
		System.out.println("(format: 4 chiffres)");
		
		// TODO: ecrire verifs
		// l'année ne peut etre composée que de chiffres
		// l'année doit etre composée de 4 chiffres, ni +, ni -
		// l'année ne peut etre < à l'année en cours
		
		// declarat° variable qui enregistre
		// l'année du vol tapé par l'utilisateur
		scanAnneeVolSelectionne_ = scanModifierAnneeVol.nextInt();
		
		// Affichage de la frappe clavier
		System.out.println("L'année du vol que vs avez tapé");
		System.out.println(scanAnneeVolSelectionne_);
		
		// creat° objet de type Date
		Date d01 = new Date(scanJourVolSelectionne_, scanMoisVolSelectionne_, scanAnneeVolSelectionne_);
		
		System.out.println("l'objet d01 pr insert°:");
		System.out.println(d01);
		
		// creat° objet de type vol
		Vol v01 = new Vol(scanNumeroVolSelectionne_, scanDestinationVolSelectionne_, d01, scanNombreTotalReservationsVolSlectionne_);
		
		System.out.println("l'objet v01 pr insert°:");
		System.out.println(v01);
		
		System.out.println("index du vol ds la ArrayList");
		System.out.println(scanIndexArrayList_);
		
		System.out.println("Modification de la date de ce vol");
		
		//
		vols.set(scanIndexArrayList_, v01);
		
		System.out.println("Retour au menu principal");
		f01MenuPrincipal();
	}
	
	/**
	 * Javadoc de fct°: f10AjouterReservation()<br>
	 * Descript°:<br>
	 * Ajoute + x au nbre de reservat° deja presentes<br>
	 * pr ce vol.<br>
	 * Le nbre max est de MAX_PLACES (340)
	 */
	public static void f10AjouterReservation() {
		
		System.out.println("f10AjouterReservation");
		System.out.println("\n");
		
		//
		f02RechercherVol();
		
		System.out.println("Ajouter x reservations a ce vol");
		
		// creat° d'1 objet de type Scanner pr ajouter
		// x reservations a ce vol
		Scanner scanAjoutReservation = new Scanner(System.in);
		
		// declarat° de la variable qui enregistrera
		// le choix de l'utilisateur
		int ajoutPlacessupplementaires;
		
		System.out.println("ATTENTION, la capacité maximale de");
		System.out.println("cet avion est de 340 places");
		System.out.println("Il y a déja");
		System.out.println(scanNombreTotalReservationsVolSlectionne_);
		System.out.println("place réservées");
		System.out.println("Nbre de places disponibles pr ce vol:");
		System.out.println(MAX_PLACES - scanNombreTotalReservationsVolSlectionne_);
		System.out.println("Veuillez ajouter le nbre de places");
		System.out.println("suplémentaires a ajouter au nbre");
		System.out.println("de places déjà réservées");
		System.out.println("(format: 1, 2 ou 3 chiffres)");
		
		// enregistrement de la frappe clavier
		ajoutPlacessupplementaires = scanAjoutReservation.nextInt();
		
		System.out.println("Vs vlez ajouter");
		System.out.println(ajoutPlacessupplementaires);
		System.out.println("places supplémentaires.");
		
		if((ajoutPlacessupplementaires + scanNombreTotalReservationsVolSlectionne_) <= MAX_PLACES) {
			
			System.out.println("Ajout des nvelles places permis");
			
			System.out.println("info inchangée: n° du vol");
			System.out.println(scanNumeroVolSelectionne_);
			
			System.out.println("info inchangée: destination");
			System.out.println(scanDestinationVolSelectionne_);
			
			System.out.println("info inchangée: date");
			System.out.println(scanDateVolSelectionne_);
			
			System.out.println("Info modifiée: nbre de resa");
			System.out.println((ajoutPlacessupplementaires + scanNombreTotalReservationsVolSlectionne_));
			scanNombreTotalReservationsVolSlectionne_ += ajoutPlacessupplementaires;
			
			System.out.println("info inchangée: index ds la ArrayList");
			System.out.println(scanIndexArrayList_);
			
			// creat° du vol qui remplacera le vol deja existant
			Vol v02 = new Vol(scanNumeroVolSelectionne_, scanDestinationVolSelectionne_, scanDateVolSelectionne_, scanNombreTotalReservationsVolSlectionne_);
			
			System.out.println("Mise a jour du nbre de resa pr ce vol");
			
			// remplacement du vol avec MAJ des resa
			vols.set(scanIndexArrayList_, v02);
			
			System.out.println("Retour au menu principal");
			
			// Affichage de la ArrayList vols
			System.out.println("------------------------------------------");
			for(Vol v:vols) {
				System.out.println(v);
				System.out.println("------------------------------------------");
			}
			
			f01MenuPrincipal();
		}
		else {
			System.out.println("CAPACITE MAX DEPASSÉE:");
			System.out.println("Ajout impossible");
			System.out.println("Retour au menu principal");
			f01MenuPrincipal();
		}
	}
	
}
