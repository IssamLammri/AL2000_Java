package src;

import java.util.ArrayList;

public class Catalogue {

	private int num_Catalogue;
	public static ArrayList<Film> Films = new ArrayList<>();
	

	/**
	 * @param num_Catalogue
	 */
	public Catalogue(int num_Catalogue) {
		//super();
		this.num_Catalogue = num_Catalogue;
		ArrayList<Film> Films_Tous = new ArrayList<>();
		Film F = new Film();
		Films_Tous= F.GetAllFilms();
		this.Films = Films_Tous ;
	}

	/**
	 * @return the num_Catalogue
	 */
	public int getNum_Catalogue() {
		return num_Catalogue;
	}

	/**
	 * @param num_Catalogue the num_Catalogue to set
	 */
	public void setNum_Catalogue(int num_Catalogue) {
		this.num_Catalogue = num_Catalogue;
	}
	
	/**
	 * @return the Films
	 */
	public ArrayList<Film> getFilms() {
		return Films;
	}

	/**
	 * Ajouter Films
	 */
	public void ajouterFilms(Film fl) {
		this.Films.add(fl);
		Film F = new Film();
		F.Films = this.Films;
		F.SerializableFilms();
	}
	
	/**
	 * Supprimer Films
	 */
	public void supprimerFilms(Film f2) {
		this.Films.remove(f2);
	}
	
	/**
	 * Afficher tous les films dans la catalogue
	 */
	public void AfficherFicherFilm() 
	{
		for(Film e:Films)
		      System.out.println(e);
	}
}