package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banka.Racun;

class RacunTest {

	
	Racun obj;
	Racun racun;
	int brojRacunaKojiNePostoji;
	int brojRacunaKojiPostoji;
	
	@BeforeEach
	void setUp() {
		obj = new Racun();
		racun = new Racun();
		racun.setBrojRacuna(1);
		obj.pohranjeniRacuni.add(racun);
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

