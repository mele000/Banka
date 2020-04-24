package banka;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Serializable {

	public static void main(String[] args)
			throws EOFException, IOException, ClassNotFoundException, FileNotFoundException {

		try {
			FileInputStream fi = new FileInputStream("racuni.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {

					Racun racun = (Racun) input.readObject();
					Racun.pohranjeniRacuni.add(racun);
					System.out.println(Racun.pohranjeniRacuni.toString());
				}
			} catch (EOFException e) {
			}
		} catch (EOFException e1) {

		}

		Scanner unos = new Scanner(System.in);

		System.out.println("Unesite" + "\n1 ako hocete kreirati racun," + "\n2 ako hocete prebaciti sredstva,"
				+ "\n3 ako hocete pregledati racun," + "\nbilo koji drugi broj ako hocete zavrsiti program");

		int broj = 0;

		try {

			broj = unos.nextInt();

			while (true) {

				if (broj == 1) {

					System.out.println("\nUnesite broj racuna");
					int brojRacuna = unos.nextInt();
					System.out.println("\nUnesite svoje ime");
					String imeVlasnikaRacuna;
					unos.nextLine();
					imeVlasnikaRacuna = unos.nextLine();

					System.out.println("\nUnesite iznos na racunu");
					double iznosNaRacunu = unos.nextDouble();

					Racun racun = new Racun(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu);

					if (racun.getValidacija() == true) {
						racun.pohranjeniRacuni.add(racun);
					}

					System.out.println(racun.pohranjeniRacuni);

				}

				else if (broj == 2) {

					System.out.println("\nUnesite broj prvog racuna");
					int brojPrvogRacuna = unos.nextInt();
					System.out.println("\nUnesite broj drugog racuna");
					int brojDrugogRacuna = unos.nextInt();
					System.out.println("\nUnesite iznos koji zelite prebaciti");
					double iznosKojiSePrebacuje = unos.nextDouble();

					TransferNovca transferNovca = new TransferNovca(iznosKojiSePrebacuje, brojPrvogRacuna,
							brojDrugogRacuna);

				}

				else if (broj == 3) {

					System.out.println("\nUnesite broj racuna");
					int brojRacuna = unos.nextInt();

					Pregled pregled = new Pregled(brojRacuna);

				}

				else
					break;

				System.out.println("\nUnesite" + "\n1 ako hocete kreirati racun," + "\n2 ako hocete prebaciti sredstva,"
						+ "\n3 ako hocete pregledati racun," + "\nbilo koji drugi broj ako hocete zavrsiti program");

				broj = unos.nextInt();

			}

		} catch (InputMismatchException e) {
			System.out.println("Trebate unjeti broj");
		}

//////////////////////////////////////////////////
		FileOutputStream fo = new FileOutputStream("racuni.txt");
		ObjectOutputStream output = new ObjectOutputStream(fo);

		for (Racun racun : Racun.pohranjeniRacuni) {
			output.writeObject(racun);
		}
		output.close();
		fo.close();

		for (Racun racun : Racun.pohranjeniRacuni) {
			System.out.println(racun.toString());
		}

	}

}
