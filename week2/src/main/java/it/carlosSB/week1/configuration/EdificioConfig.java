package it.carlosSB.week1.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.carlosSB.week1.model.Edificio;

@Configuration
public class EdificioConfig {

	@Bean("customEdificio")
	@Scope("prototype")
	public Edificio customBuilding() {
		return new Edificio();
	}
	
	@Bean("fakeEdificio")
	@Scope("prototype")
	public Edificio fakeEdificio() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Edificio b = Edificio.builder()
					.id(null)
					.name(fake.university().name())
					.address(fake.address().streetName() + ", " + fake.address().streetAddressNumber())
					.city(fake.address().city())
					.build();
		return b;
	}
	
	@Bean("paramsEdificio")
	@Scope("prototype")
	public Edificio paramsEdificio(String nome, String indirizzo, String cita) {
		Edificio b = new Edificio(null, nome, indirizzo, cita);
		return b;
	}
	
}
