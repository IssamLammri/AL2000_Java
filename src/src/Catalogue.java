package src;

import java.util.ArrayList;

public class Catalogue {

	private int num_Catalogue;
	public static ArrayList<Film> Filmss = new ArrayList<>();
	

	/**
	 * @param num_Catalogue
	 */
	public Catalogue(int num_Catalogue) {
		//super();
		this.num_Catalogue = num_Catalogue;
		ArrayList<Film> Films_Tous = new ArrayList<>();
		Film F = new Film();
		Films_Tous= F.GetAllFilms();
		this.Filmss = Films_Tous ;
	}
	public Catalogue(int num_Catalogue,int a) {
		//super();
		this.num_Catalogue = num_Catalogue;
		ArrayList<Film> Films_Tous = new ArrayList<>();
		Film F = new Film();
		Films_Tous= F.GetAllDemandesFilms();
		this.Filmss = Films_Tous ;
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
		return Filmss;
	}

	/**
	 * Ajouter Films
	 */
	public void ajouterFilms(Film fl) {
		this.Filmss.add(fl);
	}
	
	/**
	 * Supprimer Films
	 */
	public void supprimerFilms(Film f2) {
		this.Filmss.remove(f2);
		f2.setFilms(this.Filmss);
	}
	/**
	 * Supprimer Films
	 */
	public void supprimerDemandesFilms(Film f2) {
		this.Filmss.remove(f2);
		f2.setDemandesFilms(Filmss);
	}
	
	/**
	 * Afficher tous les films dans la catalogue
	 */
	public void AfficherFicherFilm() 
	{
		System.out.println("---------||------------------------|");
		System.out.println("-N� Film ||  Le Nom de Film        |");
		System.out.println("---------||------------------------|");
		int a =1;
		for(Film e:Filmss) {
			System.out.println("    "+a+"    ||  "+e.getTitre_Film()+"        ");
			System.out.println("---------||------------------------|");		
			a++;
		}
	}
}