package it.carlosSB.week1.repo;

import org.springframework.stereotype.Repository;

import it.carlosSB.week1.model.Edificio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface JpaEdificioRepo extends CrudRepository<Edificio, Long>{

		public Edificio cercaName(String name);
		public Edificio cercaAddress(String address);
		public List<Edificio> cercaCity(String city);
		
		@Query(value = "SELECT COUNT(e) FROM Building b")
		public Integer quantiEdifici();
		@Query(value = "SELECT e FROM Building e ORDER BY random() LIMIT 1")
		public Edificio randomEdificio();
		
		
	
}
