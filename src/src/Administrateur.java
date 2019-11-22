package src;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
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
		String Acteur ;
		int T = 0;
		while (Test == true) {
			Acteur =sc.nextLine();
			acteurs.add(Acteur);
			System.out.println("Si vous aves Terminer Taper ' 1 ' Sinon Taper ' 0 ' ");
				T =Integer.parseInt(sc.nextLine());
				if (T==1) {
					Test = false;
				}	
		}
		ArrayList<String> Realisateurs= new ArrayList();
		System.out.println("Entrer les Realisateurs de Cet film ");
		Test = true;
		String realisateur ;
		T = 0;
		while (Test == true) {
			realisateur =sc.nextLine();
			Realisateurs.add(realisateur);
			System.out.println("Si vous aves Terminer Taper ' F ' Sinon Taper ' P ' ");
				T =Integer.parseInt(sc.nextLine());
				if (T== 1) {
					Test = false;
				}	
		}
		System.out.println("Entrez la durée de Filme en mode H puis Min  ");
		System.out.println("H =   ");
		int H = Integer.parseInt(sc.nextLine());
		System.out.println("M =   ");
		int M = Integer.parseInt(sc.nextLine());
		LocalTime now = LocalTime.of(H, M);
		
		ArrayList<String> Genre= new ArrayList();
		Genre.add("Enfant");
		Genre.add("Actions"); 
		
		System.out.println("Entrez les Etoiles de cet Film ");
		int E = Integer.parseInt(sc.nextLine());
		
		System.out.println("Entrez la nationalité de cet Film ");
		String N = sc.nextLine();
		
		System.out.println("Saisissez une date (JJ/MM/AAAA) :");
		String str = sc.nextLine();
		
		
		boolean etat = false;
		Date date = null;
		while (etat) {
			if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {

				SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
				try {
					date = f.parse(str);
					etat = true;
				} catch (ParseException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Erreur format");
				str = sc.nextLine();
			}
		}
		
		Film Fi = new Film(TitulaireFilm,acteurs,Realisateurs,now,Genre,E,N,date);
		Catalogue C = new Catalogue(1);
		C.ajouterFilms(Fi);
	    C.AfficherFicherFilm();
		

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
