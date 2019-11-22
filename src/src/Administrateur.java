package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrateur extends Employe{
	
	private String cle;

	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param cle
	 */
	public Administrateur(String nom, String prenom, String adresse, String cle) {
		super(nom, prenom, adresse);
		this.cle = cle;
	}

	/**
	 * @return the cle
	 */
	public String getCle() {
		return cle;
	}

	/**
	 * @param cle the cle to set
	 */
	public void setCle(String cle) {
		this.cle = cle;
	}
	
	/**
	 * 	
	 */
	public void consulter_Statistique() {
		
	}
	
	
	public void Ajouter_Film_Catalogue() {
		System.out.println("------------Bonjour------------");
		System.out.println("Entrer le Titulaire de Film");
		Scanner sc = new Scanner(System.in);
		String TitulaireFilm ;
		TitulaireFilm = sc.nextLine();
		ArrayList<String> acteurs= new ArrayList();
		System.out.println("Entrer les Acteurs de Cet film ");
		boolean Test = true;
		String Acteur , T;
		while (Test =true) {
			Acteur =sc.nextLine();
			acteurs.add(Acteur);
			System.out.println("Si vous aves Terminer Taper ' F ' Sinon Taper ' P ' ");
				T =sc.nextLine();
				if (T=="F") {
					Test = false;
				}	
		}
		ArrayList<String> Realisateurs= new ArrayList();
		System.out.println("Entrer les Realisateurs de Cet film ");
		Test = true;
		String realisateur ;
		while (Test =true) {
			realisateur =sc.nextLine();
			Realisateurs.add(realisateur);
			System.out.println("Si vous aves Terminer Taper ' F ' Sinon Taper ' P ' ");
				T =sc.nextLine();
				if (T=="F") {
					Test = false;
				}	
		}
		
		

	}
	public void AjouterDVD(ArrayList<DVD> Ldvd,DVD newDVD){
		int QTTdvd=0;
		for(DVD dvd : Ldvd) {                   
			QTTdvd=QTTdvd+dvd.getQuantite();
		}
		if (QTTdvd<100) {
			Ldvd.add(newDVD);
		}
	}
	
	public void supprimerDVD(ArrayList<DVD> Ldvd,Film FDvdToDelet) {
		for(DVD dvd : Ldvd) {                  
			if (dvd.getFilm()==FDvdToDelet) {
			dvd.setExiste(false);
			}
		}
	}

	


	

}
