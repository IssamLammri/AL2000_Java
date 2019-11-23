/**
 * 
 * @author FLOWBID
 *
 */

package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Titre_Film;
	private ArrayList<String> Acteurs;
	private ArrayList<String> Realisateur;
	private LocalTime Duree;
	private ArrayList<String> Genre;
	private int Note;
	private String Nationalite;
	private Date Date_Sortie;
	public static ArrayList<Film> Films = new ArrayList<>();

	/**
	 * @param titre_Film
	 * @param acteurs
	 * @param realisateur
	 * @param duree
	 * @param genre
	 * @param note
	 * @param nationalite
	 * @param date_Sortie
	 */
	public Film(String titre_Film, ArrayList<String> acteurs, ArrayList<String> realisateur, LocalTime duree,
			ArrayList<String> genre, int note, String nationalite, Date date_Sortie) {
		Titre_Film = titre_Film;
		Acteurs = acteurs;
		Realisateur = realisateur;
		Duree = duree;
		Genre = genre;
		Note = note;
		Nationalite = nationalite;
		Date_Sortie = date_Sortie;
		Films.add(this);
		SerializableFilms();
	}

	public Film() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the FILMS
	 */
	public ArrayList<Film> getDVD() {
		return Films;
	}
	
	/**
	 * set the arraylist
	 */
	public void setFilms(ArrayList<Film> FilmsExi) {
		Films = FilmsExi;
		SerializableFilms();
	}

	/**
	 * @return the titre_Film
	 */
	public String getTitre_Film() {
		return Titre_Film;
	}

	/**
	 * @param titre_Film the titre_Film to set
	 */
	public void setTitre_Film(String titre_Film) {
		Titre_Film = titre_Film;
	}

	/**
	 * @return the acteurs
	 */
	public ArrayList<String> getActeurs() {
		return Acteurs;
	}

	/**
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(ArrayList<String> acteurs) {
		Acteurs = acteurs;
	}

	/**
	 * @return the realisateur
	 */
	public ArrayList<String> getRealisateur() {
		return Realisateur;
	}

	/**
	 * @param realisateur the realisateur to set
	 */
	public void setRealisateur(ArrayList<String> realisateur) {
		Realisateur = realisateur;
	}

	/**
	 * @return the duree
	 */
	public LocalTime getDuree() {
		return Duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(LocalTime duree) {
		Duree = duree;
	}

	/**
	 * @return the genre
	 */
	public ArrayList<String> getGenre() {
		return Genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(ArrayList<String> genre) {
		Genre = genre;
	}

	/**
	 * @return the note
	 */
	public int getNote() {
		return Note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		Note = note;
	}

	/**
	 * @return the nationalite
	 */
	public String getNationalite() {
		return Nationalite;
	}

	/**
	 * @param nationalite the nationalite to set
	 */
	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}

	/**
	 * @return the date_Sortie
	 */
	public Date getDate_Sortie() {
		return Date_Sortie;
	}

	/**
	 * @param date_Sortie the date_Sortie to set
	 */
	public void setDate_Sortie(Date date_Sortie) {
		Date_Sortie = date_Sortie;
	}

	public void SerializableFilms() {
		try {
			FileOutputStream fos = new FileOutputStream("./Films.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Films);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ArrayList<Film> GetAllFilms() {
		ArrayList<Film> Listes_Films = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("./Films.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Listes_Films = (ArrayList) ois.readObject();

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

		return Listes_Films;
	}

	@Override
	public String toString() {
		return "Film [Titre_Film=" + Titre_Film + ", Acteurs=" + Acteurs + ", Realisateur=" + Realisateur + ", Duree="
				+ Duree + ", Genre=" + Genre + ", Note=" + Note + ", Nationalite=" + Nationalite + ", Date_Sortie="
				+ Date_Sortie + "]";
	}

}
