package it.carlosSB.week1.model;

import java.util.ArrayList;
import java.util.List;

import it.carlosSB.week1.enums.Stato;
import it.carlosSB.week1.enums.Tipo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "postazioni")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Postazione {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipoPostazione;
	
	@Enumerated(EnumType.STRING)
	private Stato statusPostazione;
	
	private Integer max_sit;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "building_id")
	private Edificio edificio;
	
	@OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
	private final List<Prenotazione> reservations = new ArrayList<Prenotazione>();

	@Override
	public String toString() {
		return "Workstation [id=" + id + ", description=" + description + ", type=" + tipoPostazione + ", status=" + statusPostazione
				+ ", max_sit=" + max_sit + ", building=" + edificio.getId() + "]";
	}
	
}
