package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Abonne extends Client implements Serializable {

	private int ID_Abonne;
	private String Password;
	private int NB_location = 0;
	private Date Date_Abonment;
	private static int count = 0;
	public ArrayList<Carte_Abonnement> CartesAbonnements = new ArrayList<>();

	// public static final ArrayList<Abonne> Abonnes = new ArrayList<>();

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
	public Abonne(String nom, String prenom, String adresse, Date date_N, Carte_Bleu cB, String password,
			Date date_Abonment, Carte_Abonnement CarteAbon) {
		super(nom, prenom, adresse, date_N, cB);
		ID_Abonne = count++;
		Password = password;
		Date_Abonment = date_Abonment;
		CartesAbonnements.add(CarteAbon);
		this.getCB().setMontant(this.getCB().getMontant() - CarteAbon.getMontant());
		// Abonnes.add(this);
	}

	/*
	 * public void SerializableAbonnes() { // TODO Auto-generated method stub try {
	 * FileOutputStream fos = new FileOutputStream("./Clients.ser");
	 * ObjectOutputStream oos = new ObjectOutputStream(fos);
	 * oos.writeObject(Abonnes); oos.close(); fos.close(); } catch (IOException ioe)
	 * 
	 * { ioe.printStackTrace(); } }
	 */

	/*
	 * public ArrayList<Client> GetAllAbonnes() { ArrayList<Client> Listes_Abonnes =
	 * new ArrayList<>(); try { FileInputStream fis = new
	 * FileInputStream("./Clients.ser"); ObjectInputStream ois = new
	 * ObjectInputStream(fis);
	 * 
	 * Listes_Abonnes = (ArrayList) ois.readObject();
	 * 
	 * ois.close(); fis.close(); } catch (IOException ioe) { ioe.printStackTrace();
	 * return null; } catch (ClassNotFoundException c) {
	 * System.out.println("Class not found"); c.printStackTrace(); return null; }
	 * return Listes_Abonnes; }
	 */

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
		ArrayList<Location> Locations = GetAllLocation();

		for (Location location : Locations) {
			if (location.getClient().equals(this)) {
				System.out.println(location);
			}
		}
	}

	private ArrayList<Location> GetAllLocation() {
		ArrayList<Location> Locations = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream("./Clients.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Locations = (ArrayList) ois.readObject();

			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
		return Locations;
	}

	/**
	 * Consulter la liste des locations
	 */
	public void DemanderFilm() {

	}

	public void Louer(DVD dvd) {
		super.Louer(dvd);
		this.setNB_location(++NB_location);
		if (this.NB_location % 10 == 0) {
			this.CartesAbonnements.get(0).setMontant(this.CartesAbonnements.get(0).getMontant() + 10);
		}
	}

	/**
	 * fonction qui rend le film dans l'AL2000
	 */
	public void Rendre_DVD_A(DVD dvd, int NumeroLoca) {
		Scanner sc = new Scanner(System.in);
		Location l = new Location();
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
					this.Rendre_DVD(dvd, NumeroLoca);
				} else {
					System.out.println("vous avez choisit paiement par Carte Abonnement");
					if (CartesAbonnements.size() == 1)
						this.CartesAbonnements.get(0).setMontant(this.CartesAbonnements.get(0).getMontant() - prix);
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
					System.out.println("dvd quantite : " + dvd.getQuantite());
					dvd.setQuantite(dvd.getQuantite() + 1);
					location.SerializableLocations();
				}
				// functionUpdateAL2000();
			}

		}
	}

	public boolean Function_MontantCarte_Abonnement(Carte_Abonnement Carte_Abone) {
		if (Carte_Abone.getMontant() > 5) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Abonne [ID_Abonne=" + ID_Abonne + ", Password=" + Password + ", NB_location=" + NB_location
				+ ", Date_Abonment=" + Date_Abonment + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getAdresse()=" + getAdresse() + ", getDate_N()=" + getDate_N() + ", getCB()=" + getCB()
				+ ", getCartesAbonnement()=" + CartesAbonnements.toString() + "]";
	}

}
