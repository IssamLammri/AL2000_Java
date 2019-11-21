package src;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		int choix = 0;

		System.out.println("------------Bonjourjj------------");
		System.out.println("Veuillez choisir votre moyen d'acc閟 � notre application ");

		System.out.println("	1 =>  Client ");
		System.out.println("	2 =>  Abonn� ");
		System.out.println("	3 =>  Clients(Abonn閟) ");
		System.out.println("	4 =>  Les Locations ");
		System.out.println("	5 =>  Les DVD(s) ");
		System.out.println("	6 =>  Les Films ");
		System.out.println("	99 =>  Quitter l'application ");

		choix = Integer.parseInt(sc.nextLine());
		int choix1 = 0;
		while (choix != 99) {
			if (choix == 1) {
				System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
				System.out.println("Voici la liste des foncationnalit� que vous avez droit en tant que client");
				System.out.println("	1 =>  Rechercher un film 	");
				System.out.println("	2 =>  Louer un film		");
				System.out.println("	3 =>  S'abonner un film		");
				System.out.println("	4 =>  Rendre un film		");
				System.out.println("	5 =>  Revenir au menu Principal		");

				choix1 = Integer.parseInt(sc.nextLine());
				while (choix1 != 5) {
					System.out.println(choix1);
					if (choix1 == 1) {
						String FilmRecherche;
						System.out.println("  Veuillez Entre le nom du film que vous voulez  :: ");
						FilmRecherche = sc.nextLine();
						Client cl = new Client();
						System.out.println(cl.Rechercher(FilmRecherche));
						choix1 = 5;
					} else if (choix1 == 2) {
						System.out.println(
								"  Afin de louer un Film , il faut tout d'abord que vous remplissez vos donn閑s  :: ");
						System.out.println("  Commen鏰nt par la carte Bancaire :: ");
						String TitulaireCarte;
						int cvv;
						Date date = null;
						Double Montant;
						System.out.println(" Veuillez Ins閞er Le titulaire de la carte ");
						TitulaireCarte = sc.nextLine();
						System.out.println("Saisissez une date (JJ/MM/AAAA) :");
						String str = sc.nextLine();
						boolean etat = false;

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
						System.out.println(" Veuillez Ins閞er son CVV");
						cvv = Integer.parseInt(sc.nextLine());
						System.out.println(" Veuillez Ins閞er Le Montant de cette Carte ");
						Montant = Double.parseDouble(sc.nextLine());

						Carte_Bleu cBC = new Carte_Bleu(TitulaireCarte, cvv, date, Montant);

						System.out.println("  Passant � vos propres informations :: ");
						String Nom;
						String Prenom;
						String Adresse;
						Date DuneDate1;
						System.out.println(" Veuillez Ins閞er Votre Nom ");
						Nom = sc.nextLine();
						System.out.println(" Veuillez Ins閞er Votre Prenom ");
						Prenom = sc.nextLine();
						System.out.println(" Veuillez Ins閞er Votre Adresse ");
						Adresse = sc.nextLine();

						UpdateArrayListClients();
						UpdateArrayListLocations();

						Client cl = new Client(Nom, Prenom, Adresse, uneDate1, cBC);

						DVD dvd = new DVD();

						ArrayList<DVD> DVD = dvd.GetAlldvd();

						System.out.println("vous trouvez ici tous les DVD Disponible dans AL2000");
						int i = 1;
						for (DVD dvd2 : DVD) {
							System.out.println("option " + i + " : " + dvd2);
							i++;
						}
						System.out.println("veuillez introduire le numero de DVD que vous voulez louer");
						int NumDVD = Integer.parseInt(sc.nextLine());
						while (NumDVD > DVD.size() || NumDVD < 1) {
							System.out.println("choix invalide , veuillez r閑ssayer ");
							NumDVD = Integer.parseInt(sc.nextLine());
						}

						cl.Louer(DVD.get(NumDVD - 1));

						choix1 = 5;
					} else if (choix1 == 3) {

					} else if (choix1 == 4) {

					} else if (choix1 == 5) {
						break;
					} else {
						System.out.println(
								"Veuillez avez entrer un choix invalide :/ , Veuillez r閑ssayer encore une fois : ");
						choix1 = sc.nextInt();
					}
				}

			} else if (choix == 2) {

			} else if (choix == 3) {
				System.out.println("La liste des Clients Abonn閟 ");
				Client mohammed = new Client();

				ArrayList<Object> Clients = mohammed.GetAllClients();

				for (Object client : Clients) {
					System.out.println(client);
				}
				System.out.println("Veuillez Saisir une nouvelle option :  ");
				choix = Integer.parseInt(sc.nextLine());
			} else if (choix == 4) {
				System.out.println("La liste des Locations ");
				Location l = new Location();
				ArrayList<Location> Locations = l.GetAllLocations();

				for (Location location : Locations) {
					System.out.println(location);
				}
				System.out.println("Veuillez Saisir une nouvelle option :  ");
				choix = Integer.parseInt(sc.nextLine());
			} else if (choix == 5) {
				System.out.println("La liste DVD ");
				DVD dvd = new DVD();

				ArrayList<DVD> DVD = dvd.GetAlldvd();

				for (DVD dvd2 : DVD) {
					System.out.println(dvd2);
				}
				System.out.println("Veuillez Saisir une nouvelle option :  ");
				choix = Integer.parseInt(sc.nextLine());
			} else if (choix == 6) {
				System.out.println("La liste FILMS ");
				Film film = new Film();

				ArrayList<Film> films = film.GetAllFilms();

				for (Film film2 : films) {
					System.out.println(film2);
				}
				System.out.println("Veuillez Saisir une nouvelle option :  ");
				choix = Integer.parseInt(sc.nextLine());
			}

			else {
				System.out.println("Veuillez avez entrer un choix invalide :/ , Veuillez r閑ssayer encore une fois : ");
				choix = sc.nextInt();
			}
		}

	}

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

}
