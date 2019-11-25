package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numero_Location;
	private Date Date_Location;
	private Date Date_Rendu;
	private boolean Abonne;
	private int Prix_Location;
	private Client Client;
	private DVD dvd;
	public static ArrayList<Location> Locations = new ArrayList<>();
	private static int count ;

	/**
	 * @param numero_Location
	 * @param date_Location
	 * @param date_Rendu
	 * @param abonne
	 * @param prix_Location
	 */
	public Location(Date date_Location, Date date_Rendu, boolean abonne, int prix_Location, Client clie, DVD dvd_l) {
		count = Locations.size();
		this.numero_Location = ++count;
		Date_Location = date_Location;
		Date_Rendu = date_Rendu;
		Abonne = abonne;
		Prix_Location = prix_Location;
		Client = clie;
		dvd = dvd_l;
		Locations.add(this);
		SerializableLocations();
	}

	public Location() {

	}

	public void SerializableLocations() {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("./Locations.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Locations);
			oos.close();
			fos.close();
		} catch (IOException ioe)

		{
			ioe.printStackTrace();
		}
	}

	public ArrayList<Location> GetAllLocations() {
		ArrayList<Location> Listes_Locations = new ArrayList<>();
		try {
			File newFile = new File("./Locations.ser");
			if (newFile.length() == 0) {
				return null;
			} else {
			FileInputStream fis = new FileInputStream("./Locations.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Listes_Locations = (ArrayList) ois.readObject();

			ois.close();
			fis.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
		return Listes_Locations;
	}

	/**
	 * @return the locations
	 */
	public ArrayList<Location> getLocations() {
		return Locations;
	}

	/**
	 * set the arraylist
	 */
	public void setLocations(ArrayList<Location> LocationsExi) {
		Locations = LocationsExi;
	}

	/**
	 * @return the numero_Location
	 */
	public int getNumero_Location() {
		return numero_Location;
	}

	/**
	 * @param numero_Location the numero_Location to set
	 */
	public void setNumero_Location(int numero_Location) {
		this.numero_Location = numero_Location;
	}

	/**
	 * @return the date_Location
	 */
	public Date getDate_Location() {
		return Date_Location;
	}

	/**
	 * @param date_Location the date_Location to set
	 */
	public void setDate_Location(Date date_Location) {
		Date_Location = date_Location;
	}

	/**
	 * @return the date_Rendu
	 */
	public Date getDate_Rendu() {
		return Date_Rendu;
	}

	/**
	 * @param date_Rendu the date_Rendu to set
	 */
	public void setDate_Rendu(Date date_Rendu) {
		Date_Rendu = date_Rendu;
	}

	/**
	 * @return the abonne
	 */
	public boolean isAbonne() {
		return Abonne;
	}

	/**
	 * @param abonne the abonne to set
	 */
	public void setAbonne(boolean abonne) {
		Abonne = abonne;
	}

	/**
	 * @return the prix_Location
	 */
	public int getPrix_Location() {
		return Prix_Location;
	}

	/**
	 * @param prix_Location the prix_Location to set
	 */
	public void setPrix_Location(int prix_Location) {
		Prix_Location = prix_Location;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return Client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		Client = client;
	}

	/**
	 * @return the dvd
	 */
	public DVD getDvd() {
		return dvd;
	}

	/**
	 * @param dvd the dvd to set
	 */
	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	/**
	 * function calcul prix
	 */
	public double Calcule_Prix() {
		Date date = new Date();
		Date date_location = this.getDate_Location();

		long diff = date_location.getTime() - date.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		double prix = 0.0;

		if (diffDays == 0 || diffDays == 1) {
			if (this.getClient() instanceof Abonne) {
				prix = 1 * 4;
			} else {
				prix = 1 * 5;
			}
		} else {
			if (this.getClient() instanceof Abonne) {
				prix = diffDays * 4;
			} else {
				prix = diffDays * 5;
			}
		}

		return prix;
	}

	@Override
	public String toString() {
		return "Location [numero_Location=" + numero_Location + ", Date_Location=" + Date_Location + ", Date_Rendu="
				+ Date_Rendu + ", Abonne=" + Abonne + ", Prix_Location=" + Prix_Location + ", Client=" + Client
				+ ", dvd=" + dvd + "]";
	}

}
