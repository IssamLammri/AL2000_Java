package src;

public class Technicien extends Employe {

	private int num_tech;

	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param num_tech
	 */
	public Technicien(String nom, String prenom, String adresse, int num_tech) {
		super(nom, prenom, adresse);
		this.num_tech = num_tech;
	}

	/**
	 * @return the num_tech
	 */
	public int getNum_tech() {
		return num_tech;
	}

	/**
	 * @param num_tech the num_tech to set
	 */
	public void setNum_tech(int num_tech) {
		this.num_tech = num_tech;
	}

	/**
	 * mettre à jour AL2000
	 */
	public void mise_a_jour() {

	}

}
