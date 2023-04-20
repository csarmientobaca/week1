package it.carlosSB.week1.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.carlosSB.week1.model.User;

@Configuration
public class UserConfig {

	@Bean
	@Scope("prototype")
	public User customUser() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public User fakeUser() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		String name = fake.name().firstName();
		String lastname = fake.name().lastName();
		String email = name + "." + lastname + "@example.com";
		String username = name + "_" + lastname;
		User u = User.builder().name(name).lastname(lastname).email(email).username(username).build();
		return u;
	}

	@Bean
	@Scope("prototype")
	public User paramsUser(String name, String lastname) {
		String email =  name + "." + lastname + "@example.com";
		String username = name + "_" + lastname;
		return new User(null, name, lastname, email, username);
	}
	
}
