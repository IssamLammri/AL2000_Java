package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DVD implements Serializable {

	private static final long serialVersionUID = 1L;
	private Film Film;
	private boolean Existe;
	private int quantite;
	public static ArrayList<DVD> dvd = new ArrayList<>();

	/**
	 * @param film
	 * @param existe
	 * @param quantite
	 */
	public DVD(src.Film film, boolean existe, int quantite) {
		Film = film;
		Existe = existe;
		this.quantite = quantite;
		dvd.add(this);
		SerializableDVD();
	}

	public DVD() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the DVD
	 */
	public ArrayList<DVD> getDVD() {
		return dvd;
	}

	/**
	 * set the arraylist
	 */
	public void setDVD(ArrayList<DVD> dvdExi) {
		dvd = dvdExi;
	}

	/**
	 * @return the film
	 */
	public Film getFilm() {
		return Film;
	}

	/**
	 * @param film the film to set
	 */
	public void setFilm(Film film) {
		Film = film;
	}

	/**
	 * @return the existe
	 */
	public boolean isExiste() {
		return Existe;
	}

	/**
	 * @param existe the existe to set
	 */
	public void setExiste(boolean existe) {
		Existe = existe;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void SerializableDVD() {
		try {
			FileOutputStream fos = new FileOutputStream("./DVD.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dvd);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ArrayList<DVD> GetAlldvd() {
		ArrayList<DVD> Listes_dvd = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("./DVD.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Listes_dvd = (ArrayList) ois.readObject();

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

		return Listes_dvd;
	}

	@Override
	public String toString() {
		return "DVD [Film=" + Film + ", Existe=" + Existe + ", quantite=" + quantite + "]";
	}
}
