package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AL2000 {
	
	private int num_machine;
	private String ville;
	private String Adresse;
	private ArrayList<DVD> dvds=new ArrayList<>();
	
	/**
	 * @param num_machine
	 * @param ville
	 * @param adresse
	 */
	
	public AL2000() {};
	
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

	/**
	 * @return the dvds
	 */
	public ArrayList<DVD> getDvds() {
		return dvds;
	}

	/**
	 * @param dvds the dvds to set
	 */
	public void setDvds(ArrayList<DVD> dvds) {
		this.dvds = dvds;
	}

	public ArrayList<DVD> GetAllDVDAL2000() {
		ArrayList<DVD> DVDAL2000 = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream("./DVD.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			DVDAL2000 = (ArrayList) ois.readObject();

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
		return DVDAL2000;
	}

	void remplirDvdAL2000(ArrayList<DVD> liste){
		ArrayList<DVD> modifListe = new ArrayList<>();
		for (DVD dvd : liste) {
			if(dvd.isExiste()==true) {
				modifListe.add(dvd);
			}
		}
		setDvds(modifListe);
	}
	
}
