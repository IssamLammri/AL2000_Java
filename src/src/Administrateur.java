package src;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.text.DateFormat;
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


	public void Ajouter_Film_Catalogue(Catalogue C) {
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
			System.out.println("Si vous aves Terminer Taper ' 1 ' Sinon Taper ' 0 ' ");
			T =Integer.parseInt(sc.nextLine());
			if (T== 1) {
				Test = false;
			}	
		}
		System.out.println("Entrez la durée de Filme en mode H puis Min  ");
		System.out.print("H =   ");
		int H = Integer.parseInt(sc.nextLine());
		System.out.print("  M =   ");
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


		boolean etat = true;
		Date date = null; ;
		while (etat) {
			if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				try {
					date = formatter.parse(str);
					etat = false;
				} catch (ParseException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Erreur format");
				str = sc.nextLine();
			}
		}

		Film Fi = new Film(TitulaireFilm,acteurs,Realisateurs,now,Genre,E,N,date);
//		C.ajouterFilms(Fi);
	}


	public void Supprimer_Film_Catalogue(Catalogue C) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Film> FilmEx = new  ArrayList();
		FilmEx = C.getFilms();
		boolean Test = true;
		while (Test == true) {
			System.out.println();
			System.out.println("Vous Voulez supprimer quel Films ? ");System.out.println();
			for (int i=0; i<FilmEx.size();i++) {
				System.out.println("Film N° --  "+(i+1)+"  --   "+FilmEx.get(i).getTitre_Film());
			}		
			System.out.println(" --- ");
			System.out.println("Taper Le N° de Film ");
			int NFilmTest = Integer.parseInt(sc.nextLine());
			while ( 0 >= NFilmTest || NFilmTest >FilmEx.size() ) {
				System.out.println("Merci d'avoir choisi le bon numéro ");
				NFilmTest = Integer.parseInt(sc.nextLine());
			}
			System.out.println("Vous Voulez supprimer le Film : "+FilmEx.get(NFilmTest-1).getTitre_Film());
			System.out.println("Si OUI Taper ---  ' 1 ' Sinon Taper ' 0 ' ");
			int T =Integer.parseInt(sc.nextLine());
			if (T==1) {
				C.supprimerFilms(FilmEx.get(NFilmTest-1));
				Test = false;
			}else {
				System.out.println("Merci d'avoir choisi le bon numéro ");
			}
		}
	}

	public ArrayList<Film> ConsulterDemandesFilms() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Film> DemandesFilm = new  ArrayList();
		ArrayList<Film> DemandesFilmTree = new  ArrayList();
		ArrayList<Integer> NombreOccurance = new  ArrayList();
		Catalogue C = new Catalogue(1,1);
		DemandesFilm = C.getFilms();
		boolean Test;
		DemandesFilmTree.add(DemandesFilm.get(0));
		
		int cmp;
		for (int i=0;i<DemandesFilm.size();i++) {
			cmp = 0;Test = true;
			for (int j=i;j<DemandesFilm.size();j++) {
				if (DemandesFilm.get(i).getTitre_Film().equals(DemandesFilm.get(j).getTitre_Film())){
					cmp =cmp+1 ;
				}
			}
			
			for (int k=0 ;k<DemandesFilmTree.size();k++) {
				if (DemandesFilm.get(i).getTitre_Film().equals(DemandesFilmTree.get(k).getTitre_Film())) {
					Test = false;
				}
			}
			if(i==0) {
				NombreOccurance.add(cmp);
			}else
			if (Test==true) {
				DemandesFilmTree.add(DemandesFilm.get(i));	
				NombreOccurance.add(cmp);
			}
		}
		int f =0;
		System.out.println("---------|---------|------------------------|");
		System.out.println("-N° Film | N° Fois |  Le Nom de Film        |");
		System.out.println("---------|---------|------------------------|");
		int a =1;
		for(Film e:DemandesFilmTree) {
			System.out.println("    "+a+"    |    "+NombreOccurance.get(f)+"    |  "+e.getTitre_Film()+"        ");
			System.out.println("---------|---------|------------------------|");		
			f++;
			a++;
		}
		return  DemandesFilmTree;
	}

	public void SupprimerFilmDemnder() {
		Catalogue C = new Catalogue(1,1);
		Scanner sc = new Scanner(System.in);
		ArrayList<Film> FilmEx = new  ArrayList();
		ArrayList<Film> Filmtree = new  ArrayList();
		ArrayList<Film> FilmEXN = new  ArrayList();
		FilmEx = C.getFilms();
		System.out.println();
		System.out.println("Si Vous Voulez supprimer un Film Taper '1' et Si cous Voulez vider la table Taper '0' ? ");System.out.println();
		int TestSup = Integer.parseInt(sc.nextLine());
		if(TestSup==1) {
			System.out.println();
			System.out.println("Vous Voulez supprimer quel Films ? ");System.out.println();
			Filmtree=this.ConsulterDemandesFilms();
			System.out.println(" --- ");
			System.out.println("Taper Le N° de Film ");
			int NFilmTest = Integer.parseInt(sc.nextLine());
			while ( 0 >= NFilmTest || NFilmTest >Filmtree.size() ) {
				System.out.println("Merci d'avoir choisi le bon numéro ");
				NFilmTest = Integer.parseInt(sc.nextLine());
			}
			System.out.println("  ----->  Vous Voulez supprimer le Film :    "+Filmtree.get(NFilmTest-1).getTitre_Film());
			System.out.println("Si OUI Taper ---  ' 1 ' Sinon Taper ' 0 ' ");
			int T =Integer.parseInt(sc.nextLine());
			if (T==1) {
				Film f= FilmEx.get(0);
					for(Film e:FilmEx) {
						if (Filmtree.get(NFilmTest-1).getTitre_Film().equals(e.getTitre_Film())) {
						}else {
							FilmEXN.add(e);
						}
					}
					f.setDemandesFilms(FilmEXN);
			}else {
				System.out.println("Merci d'avoir choisi le bon numéro ");
			}
		}else {
			System.out.println("Merci de ne pas supprimer des film ^_^ ");
		}
	}

	public void ValiderLaMiseAJour() {
		ArrayList<DVD> dvd = new  ArrayList();
		AL2000 Al = new AL2000(2,"kk","dd");
		dvd= Al.GetLaListeDVDExist();
		dvd.get(0).SerializableMiseAJourDVD();
		System.out.println("------ Votre Mise A jour Terminé---- ");
	}


	public int RécupérerNombreDVDLouerAc() {
		ArrayList<Location> Loca = new  ArrayList();
		Location L = new Location();
		Loca = L.GetAllLocations();
		int Quantite =0 ;
		for(Location e:Loca) {
			if(e.getDate_Rendu()== null) {
				Quantite= Quantite+1;
			}
		}
		return Quantite;
	}

	public ArrayList<Location> RécupérerDVDLouerActuelement(){
		ArrayList<Location> Loca = new  ArrayList();
		Location L = new Location();
		Loca = L.GetAllLocations();
		for(Location e:Loca) {
			if(e.getDate_Rendu()!= null) {
				Loca.remove(e);
			}
		}
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT);
		System.out.println("-------------|------------------------|------------------------|-------------------");
		System.out.println(" N° Location |   Date de location     |  Le Nom de Client      |   le nom de Film  ");
		System.out.println("-------------|------------------------|------------------------|-------------------");
		int a =1;
		for(Location e:Loca) {
			System.out.println("     "+e.getNumero_Location()+"       |    "+shortDateFormat.format(e.getDate_Location())+"    |  "+e.getClient().getNom()+"      |   "+e.getDvd().getFilm().getTitre_Film());
			System.out.println("--------------------------------------------------------------------------------------------");		
			a++;
		}
		return Loca;
	}

	public void  ConsulterFilmLouéParJour(Date date) {
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		ArrayList<Location> Loca = new  ArrayList();
		Location L = new Location();
		Loca = L.GetAllLocations();
		int cmpt =0;
		cal.setTime(date);

		for(Location e:Loca) {
			cal1.setTime(e.getDate_Location());
			if(cal.get(Calendar.YEAR)==cal1.get(Calendar.YEAR)&&cal.get(Calendar.MONTH)==cal1.get(Calendar.MONTH)&&cal.get(Calendar.DAY_OF_MONTH)==cal1.get(Calendar.DAY_OF_MONTH)) {
				cmpt++;
			}
		}
		System.out.println("dans cette journée on a loué "+cmpt+" films");
	}
	public void  ConsulterFilmLouéParMois(int Année,int mois) {
		Calendar cal1 = Calendar.getInstance();
		ArrayList<Location> Loca = new  ArrayList();
		Location L = new Location();
		Loca = L.GetAllLocations();
		int cmpt =0;
		for(Location e:Loca) {
			cal1.setTime(e.getDate_Location());
			if(Année==cal1.get(Calendar.YEAR)&& mois==cal1.get(Calendar.MONTH)) {
				cmpt++;
			}
		}
		System.out.println("dans cette mois on a loué "+cmpt+" films");
	}
	public void  ConsulterFilmLouéParAns(int Année) {
		Calendar cal1 = Calendar.getInstance();
		ArrayList<Location> Loca = new  ArrayList();
		Location L = new Location();
		Loca = L.GetAllLocations();
		int cmpt =0;
		for(Location e:Loca) {
			cal1.setTime(e.getDate_Location());
			if(Année==cal1.get(Calendar.YEAR)) {
				cmpt++;
			}
		}
		System.out.println("dans cette mois on a loué "+cmpt+" films");
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
