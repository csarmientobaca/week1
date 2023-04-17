package it.carlosSB.week1.repo;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.carlosSB.week1.enums.Stato;
import it.carlosSB.week1.enums.Tipo;
import it.carlosSB.week1.model.Postazione;

@Repository
public interface JpaPostazioneRepo extends CrudRepository<Postazione, Long> {
	
	// finders
	public List<Postazione> findByStatus(Stato status);
	
	public List<Postazione> findByType(Tipo type);
	
	@Query(value = "SELECT w FROM Workstation w ORDER BY random() LIMIT 1")
	public Postazione randomPostazione();
		
	@Query(value = "SELECT COUNT(w) FROM Workstation w")
	public Integer quantePostazioni();
	
}