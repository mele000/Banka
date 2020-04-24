package banka;

public class Pregled {

	// fields

	int brojRacuna;

	// constructors

	public Pregled() {
	}

	public Pregled(int brojRacuna) {

		this.brojRacuna = brojRacuna;

		if (postojiLiRacun(brojRacuna) == true) {

			System.out.println(vratiRacun(brojRacuna).getIznosNaRacunu());

		} else
			System.out.println("Ne postoji racun u sistemu");
	}

	// methods

	public boolean postojiLiRacun(int brojRacuna) {

		for (int i = 0; i < Racun.pohranjeniRacuni.size(); i++) {
			if (Racun.pohranjeniRacuni.get(i).getBrojRacuna() == brojRacuna) {
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

	@Override
	public String toString() {
		return "Pregled [brojRacuna=" + brojRacuna + "]";
	}

}
