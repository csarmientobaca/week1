package it.carlosSB.week1.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String lastname;
	private String name;
	private String email;
	private String username;
	@OneToMany(mappedBy = "utente_prenotato")
	private final List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

	@Override
	public String toString() {
		return "User [id=" + ID + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", username="
				+ username  + "]";
	}

}
