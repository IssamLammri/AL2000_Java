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
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Calendar cal1 = Calendar.getInstance();
		Date Dd = cal1.getTime();

		cal1.set(2019, 11, 25);
		Date uneDate2 = cal1.getTime();


		UpdateArrayListClients();
		UpdateArrayListLocations();
		UpdateArrayListDVD();
		UpdateArrayListFilm();
		UpdateArrayListDemandesFilm();

//		// pour Technicien 
		boolean TestTech=true;
		while(TestTech==true) {
			Technicien Te = new Technicien("Dib","Mohammed","Lyon",15);
			System.out.println("Voici la liste des foncationnalité que vous avez droit en tant que Administrateur");
			System.out.println("	1 =>  Récupérer la mise a jour des dvd 	");
			System.out.println("	2 =>  Appliquer la mise a jour			");
			System.out.println("	3 =>  Revenir au menu Principal		");
			int choixTech = Integer.parseInt(sc.nextLine());
			switch(choixTech)
			{
			case 1:
				Te.Récupéré_mise_a_jour();
				break;
			case 2:
				Te.appliquer_jour_mise_a_jour();
				break;
			case 3:
				TestTech=false;
				break;
			default :
				System.out.println(" ooooops Perdu");
				break;
			}		
		}
		
		
		
		
			// pour Administrateur 
			 
			boolean TestG =true;
			Catalogue catalogue =new Catalogue(1);
			while (TestG ==true) {
				Administrateur Ad = new Administrateur(" ISSAM", "Lammri ", " BBA ", "34000");
				System.out.println("Voici la liste des foncationnalité que vous avez droit en tant que Administrateur");
				System.out.println("	1 =>  Consulter la liste des Demandes des Films ");
				System.out.println("	2 =>  Géré le Catalogue		");
				System.out.println("	3 =>  Géré La machine AL2000		");
				System.out.println("	4 =>  Géré Les Statistiques	 	");
				System.out.println("	5 =>  Revenir au menu Principal		");
				int choix1 = Integer.parseInt(sc.nextLine());
				switch(choix1)
				{
				case 1:
					Ad.ConsulterDemandesFilms();
					Ad.SupprimerFilmDemnder();
					break;
				case 2:
					boolean Test4 = true;
					while(Test4==true) {
						
						System.out.println("Vous voulez faire quoi ???");
						System.out.println("	1 =>  Consulter les Film Existé dans Cataloue ");
						System.out.println("	2 =>  Ajouter un Film  Dans Catalogue");
						System.out.println("	3 =>  Supprimer un film dans catalogue");
						System.out.println("	4 =>  Revenir au menu Principal	 ");
						choix1 = Integer.parseInt(sc.nextLine());
						switch(choix1)
						{
						case 1:
							catalogue.AfficherFicherFilm();
							break;
						case 2:
							Ad.Ajouter_Film_Catalogue(catalogue);
							break;
						case 3:
							Ad.Supprimer_Film_Catalogue(catalogue);
							break;
						case 4:
							Test4=false;
							break;
						default:
							System.out.println("	Vous avez perdu hhhhh ");
							break;
						}
					}
					break;
				case 3:
					AL2000 Al = new AL2000(2,"Grenoble","14 rue Capitaine camine");
					boolean Test2 = true;
					ArrayList<DVD> dvd = new ArrayList<>();
					while(Test2==true) {
						System.out.println("Vous voulez faire quoi ???");
						System.out.println("	1 =>  Consulter les DVD Existé dans AL2000 ");
						System.out.println("	2 =>  Ajouter un DVD et passer la commande pour faire la Mise à Jour");
						System.out.println("	3 =>  Changer la Quantité d'un DVD et passer la commande pour faire la Mise à Jour");
						System.out.println("	4 =>  Supprimer un DVD et passer la commande pour faire la Mise à Jour");
						System.out.println("	5 =>  Valider La Mise AJour	");
						System.out.println("	6 =>  Quitter le Mode AL2000 ");
						choix1 = Integer.parseInt(sc.nextLine());
						switch(choix1)
						{
						case 1:
							System.out.println("	Voila la liste des DVD dans AL2000");
							dvd=Al.GetLaListeDVDExist();
							break;
						case 2:
							System.out.println("	Voila la liste des DVD dans AL2000");
							dvd=Al.GetLaListeDVDExist();
							int a = 100-(Al.GetNombreDVDTotal()+Ad.RécupérerNombreDVDLouerAc());
							System.out.println("	vous avez le droit d'ajoute "+a+"  DVD");
							System.out.println("	quelle film vous voulez Ajouter");
							 
							catalogue.AfficherFicherFilm();
							ArrayList<Film> Films = new ArrayList<>();
							Films=catalogue.getFilms();
							System.out.print(" ---  film N° ------>    ");
							int N_Film = Integer.parseInt(sc.nextLine());
							boolean Existe = false;boolean Entre = false;
							int index =0;int indexR=0;
							for(DVD e:dvd) {
								if(e.getFilm().getTitre_Film().equals(Films.get(N_Film-1).getTitre_Film()) && e.isExiste()==true) {
									Existe =true;
									System.out.println("__________________________________________________________________________________________");
									System.out.println("|  Remarque :                                                                            |");
									System.out.println("|	        Ce Film existe dija dans AL2000 vous pouvez juste Modifier sa quantité   |");
									System.out.println("|________________________________________________________________________________________|");
								}else if(e.getFilm().getTitre_Film().equals(Films.get(N_Film-1).getTitre_Film()) && e.isExiste()==false) {
									Existe =true;
									Entre = true;
									indexR =index;
								}
								index++;
							}
							if(Entre==true) {
								System.out.println(" Vous voulez mettre combien de copie dans AL2000 ");
								int QANE_DVD = Integer.parseInt(sc.nextLine());
								while(QANE_DVD>a ||0>=QANE_DVD ) {
									System.out.println(" Merci d'ajouter un quantité compatible avec le nombre max de AL2000 ");
									QANE_DVD = Integer.parseInt(sc.nextLine());
								}
								dvd.get(indexR).setQuantite(QANE_DVD);
								dvd.get(indexR).setExiste(true);
								dvd.get(indexR).setDVD(dvd);
								dvd.get(indexR).SerializableDVD();
							}else if(Existe==false) {
								System.out.println(" Vous voulez mettre combien de copie dans AL2000 ");
								int Q_DVD = Integer.parseInt(sc.nextLine());
								while(Q_DVD>a ||0>=Q_DVD ) {
									System.out.println(" Merci d'ajouter un quantité compatible avec le nombre max de AL2000 ");
									Q_DVD = Integer.parseInt(sc.nextLine());
								}
								DVD NewDVD = new DVD(Films.get(N_Film-1),true,Q_DVD); 
								System.out.println(" Vous avez bien Ajouter Votre DVD .. Le technicien Vas faire la mise a jour en place");
							}
							break;


						case 3:
							System.out.println("	Voila la liste des DVD dans AL2000");
							dvd=Al.GetLaListeDVDExist();
							int b = 100-(Al.GetNombreDVDTotal()+Ad.RécupérerNombreDVDLouerAc());
							System.out.println("	vous avez le droit d'ajoute "+b+"  DVD");
							System.out.println("	quelle DVD vous voulez Changer sa quantité");
							System.out.print(" ---  DVD N° ------>    ");
							int N_DVD = Integer.parseInt(sc.nextLine());
							DVD Mdvd =dvd.get(N_DVD-1);
							System.out.println(" Vous voulez mettre combien de copie dans AL2000 ");
							int QN_DVD = Integer.parseInt(sc.nextLine());
							int Tee=0;
							if(QN_DVD>Mdvd.getQuantite()) {
								Tee = QN_DVD -Mdvd.getQuantite();
								while(Tee>b ) {
									System.out.println(" Merci d'ajouter un quantité compatible avec le nombre max de AL2000 ");
									QN_DVD = Integer.parseInt(sc.nextLine());
									Tee = QN_DVD -Mdvd.getQuantite();
								}
							}else {
								Tee = Mdvd.getQuantite() - QN_DVD;
								b = b +Tee;
							}
							dvd.get(N_DVD-1).setQuantite(QN_DVD);
							dvd.get(N_DVD-1).setDVD(dvd);
							dvd.get(N_DVD-1).SerializableDVD();
							System.out.println(" Vous avez bien Ajouter Votre DVD .. Le technicien Vas faire la mise a jour en place");
							break;
						case 4:
							System.out.println("	Voila la liste des DVD dans AL2000");
							dvd=Al.GetLaListeDVDExist();
							int c = 100-(Al.GetNombreDVDTotal()+Ad.RécupérerNombreDVDLouerAc());
							System.out.println("	vous avez le droit d'ajoute "+c+"  DVD");
							System.out.println("	quelle DVD vous voulez supprimer");
							System.out.print(" ---  DVD N° ------>    ");
							int NS_DVD = Integer.parseInt(sc.nextLine());
							c= c+dvd.get(NS_DVD-1).getQuantite();
							dvd.get(NS_DVD-1).setExiste(false);
							dvd.get(NS_DVD-1).setDVD(dvd);
							dvd.get(NS_DVD-1).SerializableDVD();
							System.out.println(" Vous avez bien Ajouter Votre DVD .. Le technicien Vas faire la mise a jour en place");
							break;
						case 5:
							Ad.ValiderLaMiseAJour();
							break;
						case 6:
							Test2=false;
							break;
						default:
							System.out.println("	Vous avez perdu hhhhh ");
							break;
						}
					}

					break;
				case 4:
					boolean Test3 = true;
					//				ArrayList<DVD> dvd = new ArrayList<>();
					while(Test3==true) {
						System.out.println("Vous voulez Consulter quoi ??");
						System.out.println("	1 =>   Voir Tous les locatios actuelle ");
						System.out.println("	2 =>  Consulter le Nombre DVD  Loué par jour ");
						System.out.println("	3 =>  Consulter le Nombre DVD  Loué par Mois");
						System.out.println("	4 =>  Consulter le Nombre DVD  Loué par ans");
						System.out.println("	5 =>  Quitter le Mode Administrateur ");
						choix1 = Integer.parseInt(sc.nextLine());
						switch(choix1)
						{
						case 1:
							Ad.RécupérerDVDLouerActuelement();
							break;
						case 2:
							System.out.println("	Entrer Année : ");
							int année = Integer.parseInt(sc.nextLine());
							System.out.println("	Entrer le némuro de mois : ");
							int mois = Integer.parseInt(sc.nextLine());
							System.out.println("	Entrer le jour : ");
							int jour = Integer.parseInt(sc.nextLine());
							cal1.set(année, mois,jour);
							Date uneDate1 = cal1.getTime();
							Ad.ConsulterFilmLouéParJour(uneDate1);
							break;
						case 3:
							System.out.println("	Entrer Année : ");
							année = Integer.parseInt(sc.nextLine());
							System.out.println("	Entrer le némuro de mois : ");
							mois = Integer.parseInt(sc.nextLine());
							Ad.ConsulterFilmLouéParMois(année, mois);
							break;
						case 4:
							System.out.println("	Entrer Année : ");
							année = Integer.parseInt(sc.nextLine());
							Ad.ConsulterFilmLouéParAns(année);
							break;
						case 5:
							Test3=false;
							break;
						default:
							System.out.println("	Vous avez perdu hhhhh ");
							break;
						}
					}
					break;
				case 5:
					TestG=false;
					break;
				default:
					System.out.println("	Vous avez perdu hhhhh ");
					break;
				}

			}




			//		AL2000 A = new AL2000(1,"bba","kdksldqs");
			//		
			//		System.out.println("-----------  la quntité des dvd est :  "+A.GetNombreDVDTotal());


			// pour tester La Location 

			//		Date date_R = null ;
			//		Date date_L ;
			//		String S ="22/12/1210";
			//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			//		date_L = formatter.parse(S);
			//		Carte_Bleu cBC = new Carte_Bleu("ISSAM LAMMRI", 553, date_L, 100);
			//		Client client = new Client("Issam","lammrii","kkkkkkkkk",date_L,cBC);
			//		Carte_Bleu cBC1 = new Carte_Bleu("IzSSAM LAMMRI", 553, date_L, 100);
			//		Client client1 = new Client("Issam","lammrii","kkkkkkkkk",uneDate2,cBC1);
			//		DVD dvd = new DVD();
			//		
			//		Location L = new Location(date_L,date_R,false,5,client,dvd);
			//	
			//		Location L1 = new Location(uneDate1,uneDate2,false,5,client1,dvd);
			// pour tester la methode de damnde de film pour abooner 
			//		Catalogue C = new Catalogue(1);
			//		Administrateur Ad = new Administrateur(" ISSAM", "Lammri ", " BBA ", "34000");
			//		Ad.RécupérerNombreDVDLouerAc();

			//Ad.Ajouter_Film_Catalogue(C);

//
//
//					Catalogue C = new Catalogue(2);
//					C.AfficherFicherFilm();
//					System.out.println("----------- ");
//			
//					Carte_Bleu cBC = new Carte_Bleu("ISSAM LAMMRI", 553, Dd, 100);
//					ArrayList<String> genre = new ArrayList();
//					genre.add("enfant");
//					genre.add("Action");
//					Carte_Abonnement CA = new Carte_Abonnement(genre,100);
//					
//					Abonne A =new Abonne("Lammrii","Issaml","bba logemnet",Dd,cBC,"KKKK",Dd,CA);
//					A.DemanderFilm(C);
//
//
//
//
//
//			Catalogue C3 = new Catalogue(2,2);
//					C3.AfficherFicherFilm();
//
//					Administrateur Ad = new Administrateur(" ISSAM", "Lammri ", " BBA ", "34000");
			//		Ad.Ajouter_Film_Catalogue(C);
			//Ad.Supprimer_Film_Catalogue(C);
//					Ad.ConsulterDemandesFilms();
//			Ad.SupprimerFilmDemnder();
			//		C.AfficherFicherFilm();
			//		ArrayList<Film> FilmDemander = new  ArrayList();
			//		System.out.println(FilmDemander);

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

		public static void UpdateArrayListDemandesFilm() {
			File newFile = new File("./DemandesFilms.ser");
			if (newFile.length() == 0) {

			} else {
				Film film= new Film();
				ArrayList<Film> films = film.GetAllDemandesFilms();
				if (films.size() != 0) {
					film.setDemandesFilms(films);
				}		
			}
		}

	}
