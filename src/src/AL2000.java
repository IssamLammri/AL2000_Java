package src;


public class AL2000 {
	
	private int num_machine;
	private String ville;
	private String Adresse;
	
	/**
	 * @param num_machine
	 * @param ville
	 * @param adresse
	 */
	public AL2000(int num_machine, String ville, String adresse) {
		super();
		this.num_machine = num_machine;
		this.ville = ville;
		Adresse = adresse;
	}

	/**
	 * @return the num_machine
	 */
	public int getNum_machine() {
		return num_machine;
	}

	/**
	 * @param num_machine the num_machine to set
	 */
	public void setNum_machine(int num_machine) {
		this.num_machine = num_machine;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return Adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	
}
