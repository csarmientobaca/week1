package it.carlosSB.week1.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.carlosSB.week1.model.Postazione;
import it.carlosSB.week1.model.Prenotazione;
import it.carlosSB.week1.model.User;


@Repository
public interface JpaPrenotazioneRepo extends CrudRepository<Prenotazione, Long> {
	
	public List<Prenotazione> findByLocation(Postazione location);
	public List<Prenotazione> findByDate(LocalDate date);
	public List<Prenotazione> findByOwner(User owner);
	
}