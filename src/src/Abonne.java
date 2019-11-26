package src;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Abonne extends Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ID_Abonne;
	private String Password;
	private String Username;
	private int NB_location = 0;
	private Date Date_Abonment;
	private static int count = 0;
	public ArrayList<Carte_Abonnement> CartesAbonnements = new ArrayList<>();

	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param date_N
	 * @param cB
	 * @param iD_Abonne
	 * @param password
	 * @param nB_location
	 * @param date_Abonment
	 */
	public Abonne(String nom, String prenom, String adresse, Date date_N, Carte_Bleu cB, String Usename,
			String password, Date date_Abonment, Carte_Abonnement CarteAbon) {
		super(nom, prenom, adresse, date_N, cB);
		ID_Abonne = count++;
		Username = Usename;
		Password = password;
		Date_Abonment = date_Abonment;
		CartesAbonnements.add(CarteAbon);
		this.getCB().setMontant(this.getCB().getMontant() - CarteAbon.getMontant());
	}

	public Abonne() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}

	public void Add_CarteAbon(Carte_Abonnement CarAbon) {
		CartesAbonnements.add(CarAbon);
	}

	/**
	 * @return the cartesAbonnements
	 */
	public ArrayList<Carte_Abonnement> getCartesAbonnements() {
		return CartesAbonnements;
	}

	/**
	 * @param cartesAbonnements the cartesAbonnements to set
	 */
	public void setCartesAbonnements(ArrayList<Carte_Abonnement> cartesAbonnements) {
		CartesAbonnements = cartesAbonnements;
	}

	/**
	 * @return the iD_Abonne
	 */
	public int getID_Abonne() {
		return ID_Abonne;
	}

	/**
	 * @param iD_Abonne the iD_Abonne to set
	 */
	public void setID_Abonne(int iD_Abonne) {
		ID_Abonne = iD_Abonne;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the nB_location
	 */
	public int getNB_location() {
		return NB_location;
	}

	/**
	 * @param nB_location the nB_location to set
	 */
	public void setNB_location(int nB_location) {
		NB_location = nB_location;
	}

	/**
	 * @return the date_Abonment
	 */
	public Date getDate_Abonment() {
		return Date_Abonment;
	}

	/**
	 * @param date_Abonment the date_Abonment to set
	 */
	public void setDate_Abonment(Date date_Abonment) {
		Date_Abonment = date_Abonment;
	}

	/**
	 * Consulter la liste des locations
	 */
	public void Consulter_Liste_Location() {

		Location l = new Location();
		ArrayList<Location> Locations = l.GetAllLocations();
		System.out.println("les locations en cours : ");
		for (Location location : Locations) {
			if (location.getClient().getNom().equals(this.getNom())
					&& location.getClient().getPrenom().equals(this.getPrenom()) && location.isAbonne() == true
					&& location.getDate_Rendu() == null) {
				System.out.println(location);
			}
		}
		System.out.println("les anciencs locations  : ");
		for (Location location : Locations) {
			if (location.getClient().getNom().equals(this.getNom())
					&& location.getClient().getPrenom().equals(this.getPrenom()) && location.isAbonne() == true
					&& location.getDate_Rendu() != null) {
				System.out.println(location);
			}
		}
	}

	/**
	 * Demande un film
	 */
	public void DemanderFilm(Catalogue C) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Film> FilmEx = new ArrayList();
		ArrayList<Film> FilmDemander = new ArrayList();
		FilmEx = C.getFilms();
		boolean Test = true;
		while (Test == true) {
			System.out.println("Vous Voulez Demander quel Films ? ");
			for (int i = 0; i < FilmEx.size(); i++) {
				System.out.println("Film N° --  " + (i + 1) + "  --   " + FilmEx.get(i).getTitre_Film());
			}
			System.out.println(" --- ");
			System.out.println("Taper Le N° de Film ");
			int NFilmTest = Integer.parseInt(sc.nextLine());
			while (0 >= NFilmTest || NFilmTest > FilmEx.size()) {
				System.out.println("Merci d'avoir choisi le bon numéro ");
				NFilmTest = Integer.parseInt(sc.nextLine());
			}
			System.out.println("Vous Voulez Demander le Film : " + FilmEx.get(NFilmTest - 1).getTitre_Film());
			System.out.println("Si OUI Taper ---  ' 1 ' Sinon Taper ' 0 ' ");
			int T = Integer.parseInt(sc.nextLine());
			if (T == 1) {
				FilmDemander.add(FilmEx.get(NFilmTest - 1));
				FilmEx.get(NFilmTest - 1).AjouterDansDemandesFilms(FilmDemander);
				Test = false;
			} else {
				System.out.println("Merci d'avoir choisi le bon numéro ");
			}
		}
	}

	public void Louer(DVD dvd) {
		super.Louer(dvd);
		this.setNB_location(NB_location + 1);
		if (this.NB_location % 10 == 0) {
			this.CartesAbonnements.get(0).setMontant(this.CartesAbonnements.get(0).getMontant() + 10);
		}
		this.SerializableClients();
	}

	/**
	 * fonction qui rend le film dans l'AL2000
	 */
	public void Rendre_DVD_A(int NumeroLoca) {
		Scanner sc = new Scanner(System.in);
		Location l = new Location();
		DVD dvd = new DVD();
		ArrayList<DVD> dvds = dvd.GetAlldvd();
		ArrayList<Object> abs = this.getClients();
		ArrayList<Location> Locations = l.getLocations();
		for (Location location : Locations) {
			if (location.getNumero_Location() == NumeroLoca) {
				Date date = new Date();
				double prix = location.Calcule_Prix();
				location.setDate_Rendu(date);
				System.out.println("Choisissez votre méthode de paiement : ");
				System.out.println("1 => Carte bancaire : ");
				System.out.println("2 => Carte Abonnement : ");
				int choix = sc.nextInt();
				while (choix != 1 && choix != 2) {
					System.out.println("Vous etes en train d'introduire un choix inexistent :");
					choix = sc.nextInt();
				}
				if (choix == 1) {
					System.out.println("vous avez choisit paiement par Carte Bancaire ");
					((Client) this).Rendre_DVD(NumeroLoca);
				} else {
					System.out.println("vous avez choisit paiement par Carte Abonnement");
					if (CartesAbonnements.size() == 1) {
						this.CartesAbonnements.get(0).setMontant(this.CartesAbonnements.get(0).getMontant() - prix);
						System.out.println(this.CartesAbonnements.get(0));
					}

					else {
						System.out.println(
								"vous possedez plus d'une carte abonnement , vous inserez l'ID votre Carte Abonnement");
						int CarteAbonn = sc.nextInt();
						Boolean test = true;
						while (test) {
							CarteAbonn = sc.nextInt();
							for (Carte_Abonnement CarteAbonne : CartesAbonnements) {
								if (CarteAbonn == CarteAbonne.getId_Carte()) {
									if (Function_MontantCarte_Abonnement(CarteAbonne)) {
										CarteAbonne.setMontant(CarteAbonne.getMontant() - prix);
									} else {
										this.getCB().setMontant(this.getCB().getMontant() - prix);
									}
									test = false;
									break;
								}
							}
						}
					}

					dvd.setDVD(dvds);
					location.getDvd().setQuantite(location.getDvd().getQuantite() + 1);
					location.SerializableLocations();
					this.SerializableClients();
					dvd.SerializableDVD();
				}
				// functionUpdateAL2000();
			}

		}
	}

	public void ConsulterLesFilmsCatalogie(Catalogue c) {
		c.AfficherFicherFilm();
	}

	public boolean Function_MontantCarte_Abonnement(Carte_Abonnement Carte_Abone) {
		if (Carte_Abone.getMontant() > 5) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String afficherA() {
		return "Abonne [ID_Abonne=" + ID_Abonne + ", Username=" + Username + " , Password=" + Password
				+ ",  NB_location=" + NB_location + ", Date_Abonment=" + Date_Abonment + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getAdresse()=" + getAdresse() + ", getDate_N()=" + getDate_N()
				+ ", getCB()=" + getCB() + ", getCartesAbonnement()=" + CartesAbonnements.toString() + "]";
	}

}
