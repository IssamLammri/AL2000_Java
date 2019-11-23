package src;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Calendar cal1 = Calendar.getInstance();
		cal1.set(1997, 7, 21);
		Date uneDate1 = cal1.getTime();

		cal1.set(2022, 7, 21);
		Date uneDate2 = cal1.getTime();

		UpdateArrayListClients();
		UpdateArrayListLocations();
		UpdateArrayListDVD();
		UpdateArrayListFilm();
		
//		Catalogue C = new Catalogue(1);
//		C.AfficherFicherFilm();
//		
//		Administrateur Ad = new Administrateur(" ISSAM", "Lammri ", " BBA ", "34000");
//		Ad.Ajouter_Film_Catalogue(C);
//		//Ad.Supprimer_Film_Catalogue(C);
//		C.AfficherFicherFilm();
//		
//		
//		ArrayList<Film> FilmEx = new  ArrayList();
//		 Catalogue C = new Catalogue(1);
//		 FilmEx = C.getFilms();
//			System.out.println(FilmEx.get(1).getTitre_Film());
		
		

     

		

		
		
//		Film(String titre_Film, ArrayList<String> acteurs, ArrayList<String> realisateur, LocalTime duree,
//				ArrayList<String> genre, int note, String nationalite, Date date_Sortie);
//		
		

//		int choix = 0;
//
//		System.out.println("------------Bonjour------------");
//		System.out.println("Veuillez choisir votre moyen d'accés à notre application ");
//
//		System.out.println("	1 =>  Client ");
//		System.out.println("	2 =>  Abonné ");
//		System.out.println("	3 =>  Clients(Abonnés) ");
//		System.out.println("	4 =>  Les Locations ");
//		System.out.println("	5 =>  Les DVD(s) ");
//		System.out.println("	6 =>  Les Films ");
//		System.out.println("	99 =>  Quitter l'application ");
//
//		choix = Integer.parseInt(sc.nextLine());
//		int choix1 = 0;
//		while (choix != 99) {
//			if (choix == 1) {
//				System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
//				System.out.println("Voici la liste des foncationnalité que vous avez droit en tant que client");
//				System.out.println("	1 =>  Rechercher un film 	");
//				System.out.println("	2 =>  Louer un film		");
//				System.out.println("	3 =>  S'abonner un film		");
//				System.out.println("	4 =>  Rendre un film		");
//				System.out.println("	5 =>  Revenir au menu Principal		");
//
//				choix1 = Integer.parseInt(sc.nextLine());
//				if (choix1 == 5) {
//					System.out.println(choix);
//					System.out.println("------------Bonjour------------");
//					System.out.println("Veuillez choisir votre moyen d'accés à notre application ");
//
//					System.out.println("	1 =>  Client ");
//					System.out.println("	2 =>  Abonné ");
//					System.out.println("	3 =>  Clients(Abonnés) ");
//					System.out.println("	4 =>  Les Locations ");
//					System.out.println("	5 =>  Les DVD(s) ");
//					System.out.println("	6 =>  Les Films ");
//					System.out.println("	99 =>  Quitter l'application ");
//
//					choix = Integer.parseInt(sc.nextLine());
//				}
//				while (choix1 != 5) {
//					System.out.println(choix1);
//					if (choix1 == 1) {
//						String FilmRecherche;
//						System.out.println("  Veuillez Entre le nom du film que vous voulez  :: ");
//						FilmRecherche = sc.nextLine();
//						Client cl = new Client();
//						System.out.println(cl.Rechercher(FilmRecherche));
//						choix1 = 5;
//					} else if (choix1 == 2) {
//						System.out.println(
//								"  Afin de louer un Film , il faut tout d'abord que vous remplissez vos données  :: ");
//						System.out.println("  Commençant par la carte Bancaire :: ");
//
//						Client cl = NvClient(sc, uneDate1);
//
//						DVD dvd = new DVD();
//
//						ArrayList<DVD> DVD = dvd.getDVD();
//
//						System.out.println("vous trouvez ici tous les DVD Disponible dans AL2000");
//						int i = 1;
//						for (DVD dvd2 : DVD) {
//							System.out.println("option " + i + " : " + dvd2);
//							i++;
//						}
//						System.out.println("veuillez introduire le numero de DVD que vous voulez louer");
//						int NumDVD = Integer.parseInt(sc.nextLine());
//						while (NumDVD > DVD.size() || NumDVD < 1) {
//							System.out.println("choix invalide , veuillez réessayer ");
//							NumDVD = Integer.parseInt(sc.nextLine());
//						}
//
//						cl.Louer(DVD.get(NumDVD - 1));
//						DVD = dvd.getDVD();
//						dvd.SerializableDVD();
//						cl.SerializableClients();
//						choix1 = 5;
//					} else if (choix1 == 3) {
//						System.out.println(
//								"  Afin de S'abonner, il faut tout d'abord que vous remplissez vos données  :: ");
//						System.out.println("  Commençant par la carte Bancaire :: ");
//						Client cl = NvClient(sc, uneDate1);
//						cl.Sabonner();
//						cl.SerializableClients();
//						choix1 = 5;
//					} else if (choix1 == 4) {
//						Client cl = new Client();
//						System.out.println("entrez le numéro de votre location : ");
//						int NumeroLoca = Integer.parseInt(sc.nextLine());
//						cl.Rendre_DVD(NumeroLoca);
//						ArrayList<Object> Clients = cl.GetAllClients();
//						System.out.println("les clients test : ");
//						for (Object client : Clients) {
//							System.out.println(client);
//						}
//						cl.SerializableClients();
//						choix1 = 5;
//					} else if (choix1 == 5) {
//
//					} else {
//						System.out.println(
//								"Veuillez avez entrer un choix invalide :/ , Veuillez réessayer encore une fois : ");
//						choix1 = sc.nextInt();
//					}
//				}
//
//			} else if (choix == 2) {
//
//			} else if (choix == 3) {
//				System.out.println("La liste des Clients Abonnés ");
//				Client mohammed = new Client();
//
//				ArrayList<Object> Clients = mohammed.GetAllClients();
//
//				for (Object client : Clients) {
//					System.out.println(client);
//				}
//				System.out.println("Veuillez Saisir une nouvelle option :  ");
//				choix = Integer.parseInt(sc.nextLine());
//			} else if (choix == 4) {
//				System.out.println("La liste des Locations ");
//				Location l = new Location();
//				ArrayList<Location> Locations = l.GetAllLocations();
//
//				for (Location location : Locations) {
//					System.out.println(location);
//				}
//				System.out.println("Veuillez Saisir une nouvelle option :  ");
//				choix = Integer.parseInt(sc.nextLine());
//			} else if (choix == 5) {
//				System.out.println("La liste DVD ");
//				DVD dvd = new DVD();
//
//				ArrayList<DVD> DVD = dvd.GetAlldvd();
//
//				for (DVD dvd2 : DVD) {
//					System.out.println(dvd2);
//				}
//				System.out.println("Veuillez Saisir une nouvelle option :  ");
//				choix = Integer.parseInt(sc.nextLine());
//			} else if (choix == 6) {
//				System.out.println("La liste FILMS ");
//				Film film = new Film();
//
//				ArrayList<Film> films = film.GetAllFilms();
//
//				for (Film film2 : films) {
//					System.out.println(film2);
//				}
//				System.out.println("Veuillez Saisir une nouvelle option :  ");
//				choix = Integer.parseInt(sc.nextLine());
//			}
//
//			else {
//				System.out.println("Veuillez avez entrer un choix invalide :/ , Veuillez réessayer encore une fois : ");
//				choix = sc.nextInt();
//			}
//		}
//
	}
//
//	/**
//	 * @param sc
//	 * @param uneDate1
//	 * @return
//	 */
//	public static Client NvClient(Scanner sc, Date uneDate1) {
//		String TitulaireCarte;
//		int cvv;
//		Date date = null;
//		Double Montant;
//		System.out.println(" Veuillez Insérer Le titulaire de la carte ");
//		TitulaireCarte = sc.nextLine();
//		System.out.println("Saisissez une date (JJ/MM/AAAA) :");
//		String str = sc.nextLine();
//		boolean etat = false;
//
//		while (etat) {
//			if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
//
//				SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
//				try {
//					date = f.parse(str);
//					etat = true;
//				} catch (ParseException e) { // TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} else {
//				System.out.println("Erreur format");
//				str = sc.nextLine();
//			}
//		}
//		System.out.println(" Veuillez Insérer son CVV");
//		cvv = Integer.parseInt(sc.nextLine());
//		System.out.println(" Veuillez Insérer Le Montant de cette Carte ");
//		Montant = Double.parseDouble(sc.nextLine());
//
//		Carte_Bleu cBC = new Carte_Bleu(TitulaireCarte, cvv, date, Montant);
//
//		System.out.println("  Passant à vos propres informations :: ");
//		String Nom;
//		String Prenom;
//		String Adresse;
//		Date DuneDate1;
//		System.out.println(" Veuillez Insérer Votre Nom ");
//		Nom = sc.nextLine();
//		System.out.println(" Veuillez Insérer Votre Prenom ");
//		Prenom = sc.nextLine();
//		System.out.println(" Veuillez Insérer Votre Adresse ");
//		Adresse = sc.nextLine();
//
//		Client cl = new Client(Nom, Prenom, Adresse, uneDate1, cBC);
//		return cl;
//	}

	public static void UpdateArrayListClients() {
		File newFile = new File("./Clients.ser");
		if (newFile.length() == 0) {

		} else {
			Client test = new Client();
			ArrayList<Object> Clients = test.GetAllClients();
			test.setClients(Clients);
		}
	}

	public static void UpdateArrayListLocations() {
		File newFile = new File("./Locations.ser");
		if (newFile.length() == 0) {

		} else {
			Location locationtest = new Location();
			ArrayList<Location> Locations = locationtest.GetAllLocations();
			if (Locations.size() != 0)
				locationtest.setLocations(Locations);
		}
	}

	public static void UpdateArrayListDVD() {
		File newFile = new File("./DVD.ser");
		if (newFile.length() == 0) {

		} else {
			DVD dvd = new DVD();
			ArrayList<DVD> dvdExi = dvd.GetAlldvd();
			if (dvdExi.size() != 0)
				dvd.setDVD(dvdExi);
		}
	}
	
	public static void UpdateArrayListFilm() {
		File newFile = new File("./Films.ser");
		if (newFile.length() == 0) {

		} else {
			Film film= new Film();
			ArrayList<Film> films = film.GetAllFilms();
			if (films.size() != 0) {
				film.setFilms(films);
			}		
		}
	}

}
