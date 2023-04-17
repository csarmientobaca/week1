package it.carlosSB.week1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenota")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prenotazione {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User owner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "w_stat_id")
	private Postazione location;

	private LocalDate date;

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", owner=" + owner.getUsername() +"("+owner.getID()+")" + ", location=" + location.getId() + ", date=" + date + "]";
	}
	
	
}
