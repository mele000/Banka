package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banka.Pregled;
import banka.Racun;
import banka.TransferNovca;

class PregledTest {

	Pregled obj;
	Racun racun;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;

	@BeforeEach
	public void setUp() {
		obj = new Pregled();
		racun = new Racun();
		racun.setBrojRacuna(1);
		brojRacunaKojiNePostoji = 86393;
		brojRacunaKojiPostoji = 1;
		Racun.pohranjeniRacuni.add(racun);
	}

	@AfterEach
	void tearDown() {
		obj = null;
		racun = null;
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
	
}
