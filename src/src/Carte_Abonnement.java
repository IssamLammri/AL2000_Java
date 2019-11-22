package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Carte_Abonnement implements Serializable {

	private static int Id_Carte = 0;
	ArrayList<String> Genre;
	private double Montant;

	/**
	 * @param id_Carte
	 * @param genre
	 * @param montant
	 */
	public Carte_Abonnement(ArrayList<String> genre, double montant) {
		Id_Carte = Id_Carte++;
		Genre = genre;
		Montant = GetMontantCarteAbonn();
	}

	/**
	 * @return the id_Carte
	 */
	public int getId_Carte() {
		return Id_Carte;
	}

	/**
	 * @param id_Carte the id_Carte to set
	 */
	public void setId_Carte(int id_Carte) {
		Id_Carte = id_Carte;
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
	 * @return the montant
	 */
	public double getMontant() {
		return Montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		Montant = montant;
	}

	public int GetMontantCarteAbonn() {
		System.out.println("Vous voulez mettre combien dans votre carte :");
		Scanner sc = new Scanner(System.in);
		int montant = sc.nextInt();
		while (montant < 15) {
			System.out.println("Vous essayez de saisir un montant inférieur à 15e :");
			montant = sc.nextInt();
		}
		return montant;
	}

	@Override
	public String toString() {
		return "Carte_Abonnement [Id_Carte=" + Id_Carte + ", Montant=" + Montant + "]";
	}

}
