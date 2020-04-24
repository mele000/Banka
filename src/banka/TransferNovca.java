package banka;

public class TransferNovca {

	// polja

	double iznosKojiSePrebacuje;
	int brojPrvogRacuna;
	int brojDrugogRacuna;

	// constructors

	public TransferNovca() {
	}

	public TransferNovca(double iznosKojiSePrebacuje, int brojPrvogRacuna, int brojDrugogRacuna) {

		this.iznosKojiSePrebacuje = iznosKojiSePrebacuje;
		this.brojPrvogRacuna = brojPrvogRacuna;
		this.brojDrugogRacuna = brojDrugogRacuna;

		if (jesuLiRacuniIsti(brojPrvogRacuna, brojDrugogRacuna) == true) {
			System.out.println("Ne mozete vrsiti transfer novca sa jednog te istog racuna");
		} else if (postojiLiRacun(brojPrvogRacuna) == true && postojiLiRacun(brojDrugogRacuna) == true) {

			if (vratiRacun(brojPrvogRacuna).getIznosNaRacunu() >= iznosKojiSePrebacuje) {

				postaviIznosNaRacunima(brojPrvogRacuna, brojDrugogRacuna,iznosKojiSePrebacuje);

				System.out.println("Iznos je prebacen");

			} else
				System.out.println("Ne postoji dovoljno sredstava");
		} else
			System.out.println("U sistemu ne postoje racuni, ili jedan od ta dva");

	}
	// methods

	public void postaviIznosNaRacunima(int brojPrvogRacuna, int brojDrugogRacuna,double iznosKojiSePrebacuje) {
		vratiRacun(brojPrvogRacuna).setIznosNaPrvomRacunu(iznosKojiSePrebacuje);
		vratiRacun(brojDrugogRacuna).setIznosNaDrugomRacunu(iznosKojiSePrebacuje);
	}

	public boolean jeLiMogucePrebaciti(int brojPrvog, int iznosKojiSePrebacuje) {

		if (vratiRacun(brojPrvogRacuna).getIznosNaRacunu() < iznosKojiSePrebacuje) {
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

	public boolean postojiLiRacun(int racun) {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == racun) {
				return true;
			}
		}

		return false;
	}

	public Racun vratiRacun(int brojRacuna) {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
				return Racun.pohranjeniRacuni.get(i);
			}
		}

		return null;
	}

}
