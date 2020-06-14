package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banka.Main;
import banka.Racun;
import banka.Validacija;

class RacunTest {

	
	Validacija obj;
	Racun racun;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;
	
	@BeforeEach
	void setUp() {
		obj = new Validacija();
		racun = new Racun();
		racun.setBrojRacuna(1);
		Main.pohranjeniRacuni.add(racun);
		brojRacunaKojiNePostoji = 5;
		brojRacunaKojiPostoji = 1;
	}

	@AfterEach
	void tearDown() {
		obj = null;
		racun = null;
	}

	@Test
	public void shouldReturnFalseWhenAccountDoesntExistInAL() {
		boolean rez = obj.postojiLiRacunSaIstimBrojem(brojRacunaKojiNePostoji);
		assertFalse(rez);
	}

	@Test
	public void shouldReturnTrueWhenAccountExistInAL() {
		boolean rez = obj.postojiLiRacunSaIstimBrojem(brojRacunaKojiPostoji);
		assertTrue(rez);
	}

		
	
	}

