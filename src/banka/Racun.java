
package banka;


import java.io.Serializable;


public class Racun implements Serializable {

	// polja

	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double iznosNaRacunu;
	protected boolean validacija = true;

	// constructors

	public Racun() {

	}

	public Racun(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {

		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.iznosNaRacunu = iznosNaRacunu;

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
