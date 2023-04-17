package it.carlosSB.week1.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.carlosSB.week1.enums.Stato;
import it.carlosSB.week1.enums.Tipo;
import it.carlosSB.week1.model.Edificio;
import it.carlosSB.week1.model.Postazione;

@Configuration
public class PostazioneConfig {

	@Bean("customPostazione")
	@Scope("prototype")
	public Postazione customWorkstation() {
		return new Postazione();
	}
	
	@Bean("fakePostazione") 
	@Scope("prototype") 
	public Postazione fakeWorkstation() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Integer random = fake.number().numberBetween(10, 200);
		Tipo tipo = null;
		
		 if(random <= 50) {
			 tipo = Tipo.PRIVATO;
		 } else if (random > 100 && random <= 150) {
			 tipo = Tipo.SALA_RIUNIONI;
		 } else {
			 tipo = Tipo.OPENSPACE;
		 }
		
		 Postazione post = 
				 Postazione.builder()
				.id(null)
				.descrizione(fake.lorem().characters(25))
				.tipoPostazione(tipo)
				.statusPostazione(Stato.LIBERO)
				.numero_massimo(random)
				.build();
		return post;
	}
	
	@Bean("paramsPostazione")
	@Scope("prototype")
	public Postazione paramsWorkstation(String descrizione, Tipo tipo, Stato stato, int numero_massimo, Edificio edificio) {
		Postazione post = new Postazione(null, descrizione, tipo, stato, numero_massimo, edificio);
		return post;
	}
	
}
