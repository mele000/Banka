package banka;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Serializable {

	public static ArrayList<Racun> pohranjeniRacuni = new ArrayList<>();
	static Validacija val = new Validacija();

	public static void main(String[] args)
			throws EOFException, IOException, ClassNotFoundException, FileNotFoundException {

		// CITANJE I ZAPISIVNAJE U ARR LIST
		val.procitajSveIzBaze();

		Scanner unos = new Scanner(System.in);

		val.pokaziKorisnikuMenu();

		int broj = 0;

		try {

			broj = unos.nextInt();

			while (true) {

				if (broj == 1) {

					System.out.println("\nUnesite broj racuna");
					int brojRacuna = unos.nextInt();
					
					System.out.println("\nUnesite svoje ime");
					unos.nextLine();
					String imeVlasnikaRacuna = unos.nextLine();

					System.out.println("\nUnesite iznos na racunu");
					double iznosNaRacunu = unos.nextDouble();

					Racun racun = new Racun(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu);

					if (brojRacuna >= 0) {
						if (val.postojiLiRacunSaIstimBrojem(brojRacuna) == false) {
							racun.validacija = true;
						} else {
							System.out.println(
									imeVlasnikaRacuna + ", postoji vec jedan racun sa tim brojem,pokusajte neki drugi");
							racun.validacija = false;
						}
					} else if (brojRacuna < 0) {
						System.out.println(imeVlasnikaRacuna + ", broj racuna ne smije biti negativan");
						racun.validacija = false;
					}

					if (iznosNaRacunu < 0) {
						System.out.println("Iznos naracunu je negativan");
						racun.validacija = false;
					}

					if (racun.validacija) {
						System.out.println("Kreirali ste racun");
					}

					if (racun.getValidacija() == true) {
						pohranjeniRacuni.add(racun);
					}

					System.out.println(pohranjeniRacuni);

				}

				else if (broj == 2) {

					System.out.println("\nUnesite broj prvog racuna");
					int brojPrvogRacuna = unos.nextInt();
					System.out.println("\nUnesite broj drugog racuna");
					int brojDrugogRacuna = unos.nextInt();
					System.out.println("\nUnesite iznos koji zelite prebaciti");
					double iznosKojiSePrebacuje = unos.nextDouble();


					if (val.jesuLiRacuniIsti(brojPrvogRacuna, brojDrugogRacuna) == true) {
						System.out.println("Ne mozete vrsiti transfer novca sa jednog te istog racuna");
					} else if (val.postojiLiRacun(brojPrvogRacuna) == true
							&& val.postojiLiRacun(brojDrugogRacuna) == true) {

						if (val.vratiRacun(brojPrvogRacuna).getIznosNaRacunu() >= iznosKojiSePrebacuje) {

							val.postaviIznosNaRacunima(brojPrvogRacuna, brojDrugogRacuna, iznosKojiSePrebacuje);

							System.out.println("Iznos je prebacen");

						} else
							System.out.println("Ne postoji dovoljno sredstava");
					} else
						System.out.println("U sistemu ne postoje racuni, ili jedan od ta dva");

				}

				else if (broj == 3) {

					System.out.println("\nUnesite broj racuna");
					int brojRacuna = unos.nextInt();


					if (val.postojiLiRacun(brojRacuna) == true) {

						System.out.println(val.vratiRacun(brojRacuna).getIznosNaRacunu());

					} else
						System.out.println("Ne postoji racun u sistemu");

				}

				else
					break;

				val.pokaziKorisnikuMenu();

				broj = unos.nextInt();

			}

		} catch (InputMismatchException e) {
			System.out.println("Trebate unjeti broj");
		}

		// ZAPISIVANJE SVE U ARRAY LISTU
		val.upisiSveUBazu();

	}

}
