
package banka;

import java.awt.SecondaryLoop;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class Racun implements Serializable {

	// polja

	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double iznosNaRacunu;
	private boolean validacija = true;
	public static ArrayList<Racun> pohranjeniRacuni = new ArrayList<>();

	// constructors

	public Racun() {

	}

	public Racun(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {

		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.iznosNaRacunu = iznosNaRacunu;

		if (brojRacuna >= 0) {
			if (postojiLiRacunSaIstimBrojem(brojRacuna) == false) {
				validacija = true;
			} else {
				System.out.println(imeVlasnikaRacuna + ", postoji vec jedan racun sa tim brojem,pokusajte neki drugi");
				validacija = false;
			}
		} else if (brojRacuna < 0) {
			System.out.println(imeVlasnikaRacuna + ", broj racuna ne smije biti negativan");
			validacija = false;
		}

		if (iznosNaRacunu < 0) {
			System.out.println("Iznos naracunu je negativan");
			validacija = false;
		}

		if (validacija) {
			System.out.println("Kreirali ste racun");
		}
	}

	// methods

	public boolean postojiLiRacunSaIstimBrojem(int racun) {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == racun) {
				return true;
			}
		}

		return false;
	}

	// getters and setters

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public boolean getValidacija() {
		return validacija;
	}

	public double getIznosNaRacunu() {
		return iznosNaRacunu;
	}

	public void setIznosNaPrvomRacunu(double iznosNaRacunu) {
		this.iznosNaRacunu = this.iznosNaRacunu - iznosNaRacunu;
	}

	public void setIznosNaDrugomRacunu(double iznosNaRacunu) {
		this.iznosNaRacunu = this.iznosNaRacunu + iznosNaRacunu;
	}

	@Override
	public String toString() {
		return "Racun [brojRacuna=" + brojRacuna + ", imeVlasnikaRacuna=" + imeVlasnikaRacuna + ", iznosNaRacunu="
				+ iznosNaRacunu + "]";
	}

}
