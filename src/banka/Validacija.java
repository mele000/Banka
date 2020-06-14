package banka;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Validacija implements Serializable {

	// methods

	public boolean postojiLiRacunSaIstimBrojem(int racun) {

		for (int i = 0; i < Main.pohranjeniRacuni.size(); i++) {
			if (Main.pohranjeniRacuni.get(i).getBrojRacuna() == racun) {
				return true;
			}
		}

		return false;
	}

	public void postaviIznosNaRacunima(int brojPrvogRacuna, int brojDrugogRacuna, double iznosKojiSePrebacuje) {
		vratiRacun(brojPrvogRacuna).setIznosNaPrvomRacunu(iznosKojiSePrebacuje);
		vratiRacun(brojDrugogRacuna).setIznosNaDrugomRacunu(iznosKojiSePrebacuje);
	}

	public boolean jeLiMogucePrebaciti(int brojPrvog, int iznosKojiSePrebacuje) {

		if (vratiRacun(brojPrvog).getIznosNaRacunu() < iznosKojiSePrebacuje) {
			return false;
		} else
			return true;

	}

	public boolean jesuLiRacuniIsti(int brojPrvog, int brojDrugog) {
		if (brojPrvog == brojDrugog) {
			return true;
		} else
			return false;

	}

	public boolean postojiLiRacun(int brojRacuna) {

		for (int i = 0; i < Main.pohranjeniRacuni.size(); i++) {
			if (Main.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return true;
			}
		}

		return false;
	}

	public Racun vratiRacun(int brojRacuna) {

		for (int i = 0; i < Main.pohranjeniRacuni.size(); i++) {
			if (Main.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return Main.pohranjeniRacuni.get(i);
			}
		}

		return null;

	}

	public void procitajSveIzBaze() throws IOException, ClassNotFoundException {

		try {
			FileInputStream fi = new FileInputStream("racuni.txt");
			ObjectInputStream input = new ObjectInputStream(fi);

			try {
				while (true) {

					Racun racun = (Racun) input.readObject();
					Main.pohranjeniRacuni.add(racun);
					System.out.println(Main.pohranjeniRacuni.toString());
				}
			} catch (EOFException e) {
			}
		} catch (EOFException e1) {

		}
	}
	
	public void upisiSveUBazu() throws IOException  {
		FileOutputStream fo = new FileOutputStream("racuni.txt");
		ObjectOutputStream output = new ObjectOutputStream(fo);

		for (Racun racun : Main.pohranjeniRacuni) {
			output.writeObject(racun);
		}
		output.close();
		fo.close();

		for (Racun racun : Main.pohranjeniRacuni) {
			System.out.println(racun.toString());
		}
	}
	
	public void pokaziKorisnikuMenu() {
		
		System.out.println("Unesite" + "\n1 ako hocete kreirati racun," + "\n2 ako hocete prebaciti sredstva,"
				+ "\n3 ako hocete pregledati racun," + "\nbilo koji drugi broj ako hocete zavrsiti program");

	}

}
