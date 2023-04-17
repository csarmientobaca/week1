package it.carlosSB.week1.configuration;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.carlosSB.week1.model.Postazione;
import it.carlosSB.week1.model.Prenotazione;
import it.carlosSB.week1.model.User;

@Configuration
public class PrenotazioneConfig {
	@Bean("customPrenotazione")
	@Scope("prototype")
	public Prenotazione customPrenotazione() {
		return new Prenotazione();
	}
	
	@Bean("fakePrenotazione")
	@Scope("prototype")
	public Prenotazione fakePrenotazione() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Prenotazione res = Prenotazione.builder()
				.id(null)
				.utente_prenotato(null)
				.posto(null)
				.date(LocalDate.of(2025, 12, fake.number().numberBetween(1, 28)))
				.build();
		return res;
	}
	
	@Bean("paramsPrenotazione")
	@Scope("prototype")
	public Prenotazione paramsPrenotazione(User utente, Postazione postazione, LocalDate data) {
		return new Prenotazione(null, utente, postazione, data);
	}
}
