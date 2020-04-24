package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banka.Racun;
import banka.TransferNovca;

class TransferNovcaTest {

	TransferNovca obj;
	Racun racun;
	Racun racun2;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;
	int brojPrvogIsti;
	int brojDrugogIsti;
	int brojPrvogRazliciti;
	int brojDrugogRazliciti;
	double iznosKojiSePrebacuje;

	@BeforeEach
	public void setUp() {
		obj = new TransferNovca();

		racun = new Racun();
		racun2 = new Racun();
		racun.setBrojRacuna(1);
		racun2.setBrojRacuna(11);
		racun.setIznosNaDrugomRacunu(30);
		racun2.setIznosNaDrugomRacunu(10);

		brojRacunaKojiNePostoji = 86393;
		brojRacunaKojiPostoji = 1;
		Racun.pohranjeniRacuni.add(racun);
		Racun.pohranjeniRacuni.add(racun2);
		brojPrvogIsti = 1;
		brojDrugogIsti = 1;
		brojPrvogRazliciti = 3;
		brojDrugogRazliciti = 4;
		iznosKojiSePrebacuje = 20;
	}

	@AfterEach
	public void tearDown() {
		obj = null;
		racun = null;
		racun2 = null;
		
	}

	@Test
	public void shouldReturnFalseWhenAccountDoesntExistInAL() {
		boolean rez = obj.postojiLiRacun(brojRacunaKojiNePostoji);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenAccountExistInAL() {
		boolean rez = obj.postojiLiRacun(brojRacunaKojiPostoji);
		assertTrue(rez);
	}

	@Test
	public void shouldReturnNullWhenAccountDoesntExistInAL() {
		Racun rez = obj.vratiRacun(brojRacunaKojiNePostoji);
		assertNull(rez);
	}

	@Test
	public void shouldReturnObjectWhenAccountExistInAL() {
		Racun rez = obj.vratiRacun(brojRacunaKojiPostoji);
		assertNotNull(rez);
	}

	@Test
	public void shouldReturnExactObjectWhenAccountExistInAL() {
		Racun rez = obj.vratiRacun(brojRacunaKojiPostoji);
		assertEquals(1, rez.getBrojRacuna());
	}

	@Test
	public void shouldReturnFalseWhenTwoAccountsAreNotTheSame() {
		boolean rez = obj.jesuLiRacuniIsti(brojPrvogRazliciti, brojDrugogRazliciti);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenTwoAccountsAreTheSame() {
		boolean rez = obj.jesuLiRacuniIsti(brojPrvogIsti, brojDrugogIsti);
		assertTrue(rez);
	}

	@Test
	public void shouldReturn20WhenBalanceIsTransfered() {
		System.out.println(racun.getIznosNaRacunu());
		System.out.println(racun2.getIznosNaRacunu());

		obj.postaviIznosNaRacunima(1, 11, iznosKojiSePrebacuje);

		assertEquals(racun2.getIznosNaRacunu(), 30);
	}
	
	/*

	@Test
	public void shouldReturnFalseWhenBalanceCanNotBeTrnsfered() {
		System.out.println(racun.getIznosNaRacunu());
		System.out.println(racun2.getIznosNaRacunu());

		boolean rez = obj.jeLiMogucePrebaciti(1, 20);

		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenBalanceCanBeTrnsfered() {
		System.out.println(racun.getIznosNaRacunu());
		System.out.println(racun2.getIznosNaRacunu());

		boolean rez = obj.jeLiMogucePrebaciti(1, 10);

		assertTrue(rez);
	}
*/
}
