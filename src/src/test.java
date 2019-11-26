package src;

import java.io.File;
import java.text.DateFormat;
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

		UpdateArrayListClients();
		UpdateArrayListLocations();
		UpdateArrayListDVD();

		int choix = 0;

		System.out.println("------------Bonjour------------");
		System.out.println("Veuillez choisir votre moyen d'accés à notre application ");

		System.out.println("	1 =>  Client ");
		System.out.println("	2 =>  Abonné ");
		System.out.println("	3 =>  Clients(Abonnés) ");
		System.out.println("	4 =>  Les Locations ");
		System.out.println("	5 =>  Les DVD(s) ");
		System.out.println("	6 =>  Les Films ");
		System.out.println("	7 =>  Administrateur ");
		System.out.println("	8 =>  Technicien ");
		System.out.println("	99 =>  Quitter l'application ");

		choix = Integer.parseInt(sc.nextLine());
		int choix1 = 0;
		while (choix != 99) {
			if (choix == 1) {
				System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
				System.out.println("Voici la liste des foncationnalité que vous avez droit en tant que client");
				System.out.println("	1 =>  Rechercher un film 	");
				System.out.println("	2 =>  Louer un film		");
				System.out.println("	3 =>  S'abonner	");
				System.out.println("	4 =>  Rendre un film		");
				System.out.println("	5 =>  Revenir au menu Principal		");

				choix1 = Integer.parseInt(sc.nextLine());
				if (choix1 == 5) {
					System.out.println(choix);
					System.out.println("------------Bonjour------------");
					System.out.println("Veuillez choisir votre moyen d'accés à notre application ");

					System.out.println("	1 =>  Client ");
					System.out.println("	2 =>  Abonné ");
					System.out.println("	3 =>  Clients(Abonnés) ");
					System.out.println("	4 =>  Les Locations ");
					System.out.println("	5 =>  Les DVD(s) ");
					System.out.println("	6 =>  Les Films ");
					System.out.println("	7 =>  Administrateur ");
					System.out.println("	8 =>  Technicien ");
					System.out.println("	99 =>  Quitter l'application ");

					choix = Integer.parseInt(sc.nextLine());
				}
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
								"  Afin de louer un Film , il faut tout d'abord que vous remplissez vos données  :: ");
						System.out.println("  Commençant par la carte Bancaire :: ");

						Client cl = NvClient(sc);

						DVD dvd = new DVD();

						ArrayList<DVD> DVD = dvd.getDVD();

						int NumDVD = GetFilmsALouer(sc, DVD);

						cl.Louer(DVD.get(NumDVD - 1));
						DVD = dvd.getDVD();
						dvd.SerializableDVD();
						cl.SerializableClients();
						choix1 = 5;
					} else if (choix1 == 3) {
						System.out.println(
								"  Afin de S'abonner, il faut tout d'abord que vous remplissez vos données  :: ");
						System.out.println("  Commençant par la carte Bancaire :: ");
						Client cl = NvClient(sc);
						cl.Sabonner();
						cl.SerializableClients();
						choix1 = 5;
					} else if (choix1 == 4) {
						Client cl = new Client();
						System.out.println("entrez le numéro de votre location : ");
						int NumeroLoca = Integer.parseInt(sc.nextLine());
						cl.Rendre_DVD(NumeroLoca);
						choix1 = 5;
					} else if (choix1 == 5) {

					} else {
						System.out.println(
								"Veuillez avez entrer un choix invalide :/ , Veuillez réessayer encore une fois : ");
						choix1 = sc.nextInt();
					}
				}

			} else if (choix == 2) {
				int choix3 = 0;
				System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
				System.out.println("	1 =>  Nouveau Abonné 	");
				System.out.println("	2 =>  Deja Abonné	");
				System.out.println("	3 =>  Retour menu précédent	");
				choix3 = Integer.parseInt(sc.nextLine());

				if (choix3 == 3) {
					System.out.println("------------Bonjour------------");
					System.out.println("Veuillez choisir votre moyen d'accés à notre application ");

					System.out.println("	1 =>  Client ");
					System.out.println("	2 =>  Abonné ");
					System.out.println("	3 =>  Clients(Abonnés) ");
					System.out.println("	4 =>  Les Locations ");
					System.out.println("	5 =>  Les DVD(s) ");
					System.out.println("	6 =>  Les Films ");
					System.out.println("	99 =>  Quitter l'application ");

					choix = Integer.parseInt(sc.nextLine());
				}

				while (choix3 != 3) {
					if (choix3 == 1) {
						Abonne ab = NvAbonne(sc);
						ab.SerializableClients();
						choix3 = 3;
					} else if (choix3 == 2) {
						System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
						System.out.println(
								"Veuillez saisir vos identifiants afin d'avoir les différents fonctionnalités :  ");

						String username, password;
						System.out.println("Veuillez saisir votre Nom");
						username = sc.nextLine();
						System.out.println(" Veuillez saisir votre password");
						password = sc.nextLine();

						Abonne ab = new Abonne();
						ArrayList<Object> abns = ab.getClients();
						boolean etatTAb = false;
						int indAb = 0;
						if (abns != null) {
							for (Object Ab : abns) {
								if (Ab instanceof Abonne) {
									if (((Abonne) Ab).getUsername().equals(username)
											&& ((Abonne) Ab).getPassword().equals(password)) {
										etatTAb = true;
										indAb = abns.indexOf(Ab);
										break;
									}
								}

							}
						}

						if (etatTAb) {
							System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
							System.out.println(
									"Voici la liste des foncationnalité que vous avez droit en tant qu'un Abonné");
							System.out.println("	1 =>  Rechercher un film 	");
							System.out.println("	2 =>  Louer un film		");
							System.out.println("	3 =>  Rendre un film		");
							System.out.println("	4 =>  Consulter MES LOCATIONS		");
							System.out.println("	5 =>  Consulte La liste des FILM DANS CATALOGUE		");
							System.out.println("	6 =>  Faire une Demande pour un FILM	");
							System.out.println("	6 =>  Ajouter de l'argent dans la carte	");
							System.out.println("	7 =>  Revenir au menu Précédent		");

							int choix4 = 55;

							choix4 = Integer.parseInt(sc.nextLine());

							if (choix4 == 7) {
								System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
								System.out.println("	1 =>  Nouveau Abonné 	");
								System.out.println("	2 =>  Deja Abonné	");
								System.out.println("	3 =>  Retour menu précédent	");

								choix3 = Integer.parseInt(sc.nextLine());
							}

							while (choix4 != 7) {
								if (choix4 == 0) {
									System.out.println("------Bienvenu chez vous Dans notre Application AL2000------");
									System.out.println(
											"Voici la liste des foncationnalité que vous avez droit en tant qu'un Abonné");
									System.out.println("	1 =>  Rechercher un film 	");
									System.out.println("	2 =>  Louer un film		");
									System.out.println("	3 =>  Rendre un film		");
									System.out.println("	4 =>  Consulter MES LOCATIONS		");
									System.out.println("	5 =>  Consulte La liste des FILM DANS CATALOGUE		");
									System.out.println("	6 =>  Faire une Demande pour un FILM	");
									System.out.println("	7 =>  Revenir au menu Précédent		");

									choix4 = Integer.parseInt(sc.nextLine());
								} else if (choix4 == 1) {
									String FilmRecherche;
									System.out.println("  Veuillez Entre le nom du film que vous voulez  :: ");
									FilmRecherche = sc.nextLine();
									Abonne abT = new Abonne();
									System.out.println(ab.Rechercher(FilmRecherche));
									choix4 = 0;

								} else if (choix4 == 2) {

									DVD dvd = new DVD();

									ArrayList<DVD> DVD = dvd.getDVD();

									int NumDVD = GetFilmsALouer(sc, DVD);
									System.out.println(indAb + " " + NumDVD);
									((Abonne) abns.get(indAb)).Louer(DVD.get(NumDVD - 1));

									DVD = dvd.getDVD();
									dvd.SerializableDVD();

									choix4 = 0;

								} else if (choix4 == 3) {
									System.out.println("entrez le numéro de votre location : ");
									int NumeroLoca = Integer.parseInt(sc.nextLine());
									((Abonne) abns.get(indAb)).Rendre_DVD_A(NumeroLoca);
									((Abonne) abns.get(indAb)).setClients(abns);
									((Abonne) abns.get(indAb)).SerializableClients();

									choix4 = 0;
								} else if (choix4 == 4) {
									System.out.println("Vos locations sont : ");
									((Abonne) abns.get(indAb)).Consulter_Liste_Location();
									choix4 = 0;
								} else if (choix4 == 5) {
									System.out.println("La liste des films dans Catalogue  : ");
									Catalogue c = new Catalogue(1);
									c.AfficherFicherFilm();
									choix4 = 0;
								} else if (choix4 == 6) {
									Catalogue c = new Catalogue(1);
									((Abonne) abns.get(indAb)).DemanderFilm(c);
									choix4 = 0;
								} else {
									System.out.println(
											"Veuillez avez entrer un choix invalide :/ , Veuillez réessayer encore une fois : ");
									choix4 = Integer.parseInt(sc.nextLine());
								}
							}

						} else {
							System.out.println("Abonné Introuvable , Veuillez Réessayer encore une fois  ");
							choix3 = 3;
						}

					} else {
						System.out.println(
								"Veuillez avez entrer un choix invalide :/ , Veuillez réessayer encore une fois : ");
						choix3 = Integer.parseInt(sc.nextLine());
					}
				}

			} else if (choix == 3) {
				System.out.println("La liste des Clients Abonnés ");
				Client mohammed = new Client();

				ArrayList<Object> Clients = mohammed.GetAllClients();

				for (Object client : Clients) {
					if (client instanceof Abonne)
						System.out.println(((Abonne) client).afficherA());
					else
						System.out.println(((Client) client).afficher());
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
			} else if (choix == 7) {

				boolean TestG = true;
				Catalogue catalogue = new Catalogue(1);
				while (TestG == true) {
					Administrateur Ad = new Administrateur(" ISSAM", "Lammri ", " BBA ", "34000");
					System.out.println(
							"Voici la liste des foncationnalité que vous avez droit en tant que Administrateur");
					System.out.println("	1 =>  Consulter la liste des Demandes des Films ");
					System.out.println("	2 =>  Géré le Catalogue		");
					System.out.println("	3 =>  Géré La machine AL2000		");
					System.out.println("	4 =>  Géré Les Statistiques	 	");
					System.out.println("	5 =>  Revenir au menu Principal		");
					int choix1II = Integer.parseInt(sc.nextLine());
					switch (choix1II) {
					case 1:
						System.out.println(" On a un problème ici dans l'itegration des deux projets	");
						 Ad.ConsulterDemandesFilms();
						 Ad.SupprimerFilmDemnder();
						break;
					case 2:
						boolean Test4 = true;
						while (Test4 == true) {

							System.out.println("Vous voulez faire quoi ???");
							System.out.println("	1 =>  Consulter les Film Existé dans Cataloue ");
							System.out.println("	2 =>  Ajouter un Film  Dans Catalogue");
							System.out.println("	3 =>  Supprimer un film dans catalogue");
							System.out.println("	4 =>  Revenir au menu Principal	 ");
							choix1II = Integer.parseInt(sc.nextLine());
							switch (choix1II) {
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
								Test4 = false;
								break;
							default:
								System.out.println("	Vous avez perdu hhhhh ");
								break;
							}
						}
						break;
					case 3:
						AL2000 Al = new AL2000(2, "Grenoble", "14 rue Capitaine camine");
						Catalogue CA = new Catalogue(1);
						boolean Test2 = true;
						ArrayList<DVD> dvd = new ArrayList<>();
						while (Test2 == true) {
							System.out.println("Vous voulez faire quoi ???");
							System.out.println("	1 =>  Consulter les DVD Existé dans AL2000 ");
							System.out
									.println("	2 =>  Ajouter un DVD et passer la commande pour faire la Mise à Jour");
							System.out.println(
									"	3 =>  Changer la Quantité d'un DVD et passer la commande pour faire la Mise à Jour");
							System.out.println(
									"	4 =>  Supprimer un DVD et passer la commande pour faire la Mise à Jour");
							System.out.println("	5 =>  Valider La Mise AJour	");
							System.out.println("	6 =>  Quitter le Mode AL2000 ");
							choix1II = Integer.parseInt(sc.nextLine());
							switch (choix1II) {
							case 1:
								System.out.println("	Voila la liste des DVD dans AL2000");
								dvd = Al.GetLaListeDVDExist();
								break;
							case 2:
								System.out.println("	Voila la liste des DVD dans AL2000");
								dvd = Al.GetLaListeDVDExist();
								int a = 100 - (Al.GetNombreDVDTotal() + Ad.RécupérerNombreDVDLouerAc());
								System.out.println("	vous avez le droit d'ajoute " + a + "  DVD");
								System.out.println("	quelle film vous voulez Ajouter");

								CA.AfficherFicherFilm();
								ArrayList<Film> Films = new ArrayList<>();
								Films = CA.getFilms();
								System.out.print(" ---  film N° ------>    ");
								int N_Film = Integer.parseInt(sc.nextLine());
								boolean Existe = false;
								boolean Entre = false;
								int index = 0;
								int indexR = 0;
								for (DVD e : dvd) {
									if (e.getFilm().getTitre_Film().equals(Films.get(N_Film - 1).getTitre_Film())
											&& e.isExiste() == true) {
										Existe = true;
										System.out.println(
												"__________________________________________________________________________________________");
										System.out.println(
												"|  Remarque :                                                                            |");
										System.out.println(
												"|	        Ce Film existe dija dans AL2000 vous pouvez juste Modifier sa quantité   |");
										System.out.println(
												"|________________________________________________________________________________________|");
									} else if (e.getFilm().getTitre_Film().equals(Films.get(N_Film - 1).getTitre_Film())
											&& e.isExiste() == false) {
										Existe = true;
										Entre = true;
										indexR = index;
									}
									index++;
								}
								if (Entre == true) {
									System.out.println(" Vous voulez mettre combien de copie dans AL2000 ");
									int QANE_DVD = Integer.parseInt(sc.nextLine());
									while (QANE_DVD > a || 0 >= QANE_DVD) {
										System.out.println(
												" Merci d'ajouter un quantité compatible avec le nombre max de AL2000 ");
										QANE_DVD = Integer.parseInt(sc.nextLine());
									}
									dvd.get(indexR).setQuantite(QANE_DVD);
									dvd.get(indexR).setExiste(true);
									dvd.get(indexR).setDVD(dvd);
									dvd.get(indexR).SerializableDVD();
								} else if (Existe == false) {
									System.out.println(" Vous voulez mettre combien de copie dans AL2000 ");
									int Q_DVD = Integer.parseInt(sc.nextLine());
									while (Q_DVD > a || 0 >= Q_DVD) {
										System.out.println(
												" Merci d'ajouter un quantité compatible avec le nombre max de AL2000 ");
										Q_DVD = Integer.parseInt(sc.nextLine());
									}
									DVD NewDVD = new DVD(Films.get(N_Film - 1), true, Q_DVD);
									System.out.println(
											" Vous avez bien Ajouter Votre DVD .. Le technicien Vas faire la mise a jour en place");
								}
								break;

							case 3:
								System.out.println("	Voila la liste des DVD dans AL2000");
								dvd = Al.GetLaListeDVDExist();

								int b = 100 - (Al.GetNombreDVDTotal() + Ad.RécupérerNombreDVDLouerAc());
								System.out.println("	vous avez le droit d'ajoute " + b + "  DVD");
								System.out.println("	quelle DVD vous voulez Changer sa quantité");
								System.out.print(" ---  DVD N° ------>    ");
								int N_DVD = Integer.parseInt(sc.nextLine());
								DVD Mdvd = dvd.get(N_DVD - 1);
								System.out.println(" DVD de Titre :" + Mdvd.getFilm().getTitre_Film());
								System.out.println(" Vous voulez mettre combien de copie dans AL2000 ");
								int QN_DVD = Integer.parseInt(sc.nextLine());
								int Tee = 0;
								if (QN_DVD > Mdvd.getQuantite()) {
									Tee = QN_DVD - Mdvd.getQuantite();
									while (Tee > b) {
										System.out.println(
												" Merci d'ajouter un quantité compatible avec le nombre max de AL2000 ");
										QN_DVD = Integer.parseInt(sc.nextLine());
										Tee = QN_DVD - Mdvd.getQuantite();
									}
								} else {
									Tee = Mdvd.getQuantite() - QN_DVD;
									b = b + Tee;
								}
								dvd.get(N_DVD - 1).setQuantite(QN_DVD);
								dvd.get(N_DVD - 1).setDVD(dvd);
								dvd.get(N_DVD - 1).SerializableDVD();
								System.out.println(
										" Vous avez bien Modifier Votre DVD .. Le technicien Vas faire la mise a jour en place");
								break;
							case 4:
								System.out.println("	Voila la liste des DVD dans AL2000");
								dvd = Al.GetLaListeDVDExist();
								int c = 100 - (Al.GetNombreDVDTotal() + Ad.RécupérerNombreDVDLouerAc());
								System.out.println("	vous avez le droit d'ajoute " + c + "  DVD");
								System.out.println("	quelle DVD vous voulez supprimer");
								System.out.print(" ---  DVD N° ------>    ");
								int NS_DVD = Integer.parseInt(sc.nextLine());
								c = c + dvd.get(NS_DVD - 1).getQuantite();
								dvd.get(NS_DVD - 1).setExiste(false);
								dvd.get(NS_DVD - 1).setDVD(dvd);
								dvd.get(NS_DVD - 1).SerializableDVD();
								System.out.println(
										" Vous avez bien supprimer Votre DVD .. Le technicien Vas faire la mise a jour en place");
								break;
							case 5:
								Ad.ValiderLaMiseAJour();
								break;
							case 6:
								Test2 = false;
								break;
							default:
								System.out.println("	Vous avez perdu hhhhh ");
								break;
							}
						}

						break;
					case 4:
						boolean Test3 = true;
						// ArrayList<DVD> dvd = new ArrayList<>();
						while (Test3 == true) {
							System.out.println("Vous voulez Consulter quoi ??");
							System.out.println("	1 =>   Voir Tous les locatios actuelle ");
							System.out.println("	2 =>  Consulter le Nombre DVD  Loué par jour ");
							System.out.println("	3 =>  Consulter le Nombre DVD  Loué par Mois");
							System.out.println("	4 =>  Consulter le Nombre DVD  Loué par ans");
							System.out.println("	5 =>  Quitter le Mode Administrateur ");
							choix1 = Integer.parseInt(sc.nextLine());
							switch (choix1) {
							case 1:
								Ad.RécupérerDVDLouerActuelement();
								break;
							case 2:
								System.out.println("Saisissez une date (JJ/MM/AAAA) :");
								String str = sc.nextLine();

								boolean etat = true;
								Date date = null;
								;
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
								Ad.ConsulterFilmLouéParJour(date);
								break;
							case 3:

								System.out.println("Saisissez une date (MM/yyyy) :");
								String strr = sc.nextLine();

								boolean etatt = true;
								Date datee = null;
								;
								while (etatt) {
									if (strr.matches("[0-9]{2}/[0-9]{4}")) {

										SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
										format.setLenient(false);
										try {
											datee = format.parse(strr);
											etatt = false;
										} catch (ParseException e) { // TODO Auto-generated catch block
											e.printStackTrace();
										}
									} else {
										System.out.println("Erreur format");
										strr = sc.nextLine();
									}
								}

								Ad.ConsulterFilmLouéParMois(datee);
								break;
							case 4:
								System.out.println(" Entrer Année : ");
								int année = Integer.parseInt(sc.nextLine());
								Ad.ConsulterFilmLouéParAns(année);
								break;
							case 5:
								Test3 = false;
								break;
							default:
								System.out.println("	Vous avez perdu hhhhh ");
								break;
							}
						}
						break;
					case 5:
						TestG = false;
						break;
					default:
						System.out.println("	Vous avez perdu hhhhh ");
						break;
					}

				}

				System.out.println("Veuillez Saisir une nouvelle option :  ");
				choix = Integer.parseInt(sc.nextLine());
			} else if (choix == 8) {

				boolean TestTech = true;
				while (TestTech == true) {
					Technicien Te = new Technicien("Dib", "Mohammed", "Lyon", 15);
					System.out.println(
							"Voici la liste des foncationnalité que vous avez droit en tant que Administrateur");
					System.out.println("	1 =>  Récupérer la mise a jour des dvd 	");
					System.out.println("	2 =>  Appliquer la mise a jour			");
					System.out.println("	3 =>  Revenir au menu Principal		");
					int choixTech = Integer.parseInt(sc.nextLine());
					switch (choixTech) {
					case 1:
						Te.Récupéré_mise_a_jour();
						break;
					case 2:
						Te.appliquer_jour_mise_a_jour();
						break;
					case 3:
						TestTech = false;
						break;
					default:
						System.out.println(" ooooops Perdu");
						break;
					}
				}

				System.out.println("Veuillez Saisir une nouvelle option :  ");
				choix = Integer.parseInt(sc.nextLine());
			}

			else {
				System.out.println("Veuillez avez entrer un choix invalide :/ , Veuillez réessayer encore une fois : ");
				choix = sc.nextInt();
			}
		}

	}

	/**
	 * @param sc
	 * @param DVD
	 * @return
	 */
	public static int GetFilmsALouer(Scanner sc, ArrayList<DVD> DVD) {
		System.out.println("vous trouvez ici tous les DVD Disponible dans AL2000");
		int i = 1;
		for (DVD dvd2 : DVD) {
			System.out.println("option " + i + " : " + dvd2);
			i++;
		}
		System.out.println("veuillez introduire le numero de DVD que vous voulez louer");
		int NumDVD = Integer.parseInt(sc.nextLine());
		while (NumDVD > DVD.size() || NumDVD < 1) {
			System.out.println("choix invalide , veuillez réessayer ");
			NumDVD = Integer.parseInt(sc.nextLine());
		}
		return NumDVD;
	}

	/**
	 * @param sc
	 * @param uneDate1
	 * @return
	 */
	public static Client NvClient(Scanner sc) {
		String TitulaireCarte;
		int cvv;
		Date date = null;
		Double Montant;
		System.out.println(" Veuillez Insérer Le titulaire de la carte ");
		TitulaireCarte = sc.nextLine();

		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, 7, 21);
		Date DateValidCB = cal1.getTime();

		System.out.println(" Veuillez Insérer son CVV");
		cvv = Integer.parseInt(sc.nextLine());
		System.out.println(" Veuillez Insérer Le Montant de cette Carte ");
		Montant = Double.parseDouble(sc.nextLine());

		Carte_Bleu cBC = new Carte_Bleu(TitulaireCarte, cvv, date, Montant);

		System.out.println("  Passant à vos propres informations :: ");
		String Nom;
		String Prenom;
		String Adresse;
		Date DuneDate1;
		System.out.println(" Veuillez Insérer Votre Nom ");
		Nom = sc.nextLine();
		System.out.println(" Veuillez Insérer Votre Prenom ");
		Prenom = sc.nextLine();
		System.out.println(" Veuillez Insérer Votre Adresse ");
		Adresse = sc.nextLine();

		Client cl = new Client(Nom, Prenom, Adresse, DateValidCB, cBC);
		return cl;
	}

	/**
	 * @param sc
	 * @param uneDate1
	 * @return
	 */
	public static Abonne NvAbonne(Scanner sc) {
		String TitulaireCarte;
		int cvv;
		Date date = null;
		Double Montant;
		System.out.println(" Veuillez Insérer Le titulaire de la carte ");
		TitulaireCarte = sc.nextLine();
		/*
		 * System.out.println("Saisissez une date (JJ/MM/AAAA) :"); String str =
		 * sc.nextLine(); boolean etat = false;
		 * 
		 * while (etat) { if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
		 * 
		 * SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy"); try { date =
		 * f.parse(str); etat = true; } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } else {
		 * System.out.println("Erreur format"); str = sc.nextLine(); } }
		 */

		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, 7, 21);
		Date DateValidCB = cal1.getTime();

		System.out.println(" Veuillez Insérer son CVV");
		cvv = Integer.parseInt(sc.nextLine());
		System.out.println(" Veuillez Insérer Le Montant de cette Carte ");
		Montant = Double.parseDouble(sc.nextLine());

		Carte_Bleu cBA = new Carte_Bleu(TitulaireCarte, cvv, date, Montant);

		System.out.println("  Passant à vos propres informations :: ");
		String Nom;
		String Prenom;
		String Adresse;
		String username, password;
		Date DuneDate1;
		System.out.println(" Veuillez Insérer Votre Nom ");
		Nom = sc.nextLine();
		System.out.println(" Veuillez Insérer Votre Prenom ");
		Prenom = sc.nextLine();
		System.out.println(" Veuillez Insérer Votre Adresse ");
		Adresse = sc.nextLine();
		System.out.println(" Veuillez Insérer Votre username");
		username = sc.nextLine();
		Abonne ab = new Abonne();
		ArrayList<Object> abns = ab.GetAllClients();
		if (abns != null) {
			boolean etat1 = false;
			while (!etat1) {
				boolean etat2 = true;
				for (Object Ab : abns) {
					if (Ab instanceof Abonne) {
						if (((Abonne) Ab).getUsername().equals(username)) {
							etat2 = false;
							break;
						}
					}
				}
				if (!etat2) {
					System.out.println("Username existe deja , Veuillez Insérer un autre username");
					username = sc.nextLine();
				} else
					etat1 = true;
			}
		}

		System.out.println(" Veuillez Insérer Votre Password");
		password = sc.nextLine();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dateCre = new Date();

		ArrayList<String> genre = new ArrayList<String>();
		Carte_Abonnement CarteAbon = new Carte_Abonnement(genre, 0);

		Abonne Ab = new Abonne(Nom, Prenom, Adresse, DateValidCB, cBA, username, password, dateCre, CarteAbon);
		return Ab;
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

}
