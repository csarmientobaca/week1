package it.carlosSB.week1.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.carlosSB.week1.model.Edificio;
import it.carlosSB.week1.repo.JpaEdificioRepo;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Service
@Slf4j
public class EdificioServices {
	
	@Autowired 
	private JpaEdificioRepo repoEdificio;
	
	@Autowired @Qualifier("fakeEdificio")
	private ObjectProvider<Edificio> fakeEdificio;
	
	
	public void createfakeEdificio() {
		persistEdificio(fakeEdificio.getObject());
	}
	
	public void persistEdificio(Edificio ed) {
		repoEdificio.save(ed);
		log.info("edificio salvato");
	}
	
	

	public void updateEdificio(Edificio b) {
		repoEdificio.save(b);
		log.info("edificio aggiornato");
	}
	public void removeEdificioConNome(Edificio b) {
		repoEdificio.delete(b);
		log.info("edificio salvato");
	}
	public void removeEdificioConId(Long id) {
		repoEdificio.deleteById(id);
		log.info("edificio salvato usando id");
	}
	public Edificio cercaId(Long id) {
		return repoEdificio.findById(id).get();
	}
	public List<Edificio> findAllEdifici() {
		return (List<Edificio>) repoEdificio.findAll();
	}
}
