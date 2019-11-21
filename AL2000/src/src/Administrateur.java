package src;

public class Administrateur extends Employe{
	
	private String cle;

	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param cle
	 */
	public Administrateur(String nom, String prenom, String adresse, String cle) {
		super(nom, prenom, adresse);
		this.cle = cle;
	}

	/**
	 * @return the cle
	 */
	public String getCle() {
		return cle;
	}

	/**
	 * @param cle the cle to set
	 */
	public void setCle(String cle) {
		this.cle = cle;
	}
	
	/**
	 * 	
	 */
	public void consulter_Statistique() {
		
	}

	


	

}
