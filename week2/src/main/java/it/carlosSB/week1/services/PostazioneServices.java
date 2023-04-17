package it.carlosSB.week1.services;


import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import it.carlosSB.week1.enums.Tipo;
import it.carlosSB.week1.model.Edificio;
import it.carlosSB.week1.model.Postazione;
import it.carlosSB.week1.repo.JpaEdificioRepo;
import it.carlosSB.week1.repo.JpaPostazioneRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostazioneServices {
	
	@Autowired 
	private JpaPostazioneRepo repoPostazione;
	
	@Autowired 
	private JpaEdificioRepo repoEdificio;
	
	@Autowired @Qualifier("fakeWorkstation")
	private ObjectProvider<Postazione> fakePostazione;
		
	
	public void creaFakePostazione() {
		Postazione post = fakePostazione.getObject();
		Edificio ed = repoEdificio.randomEdificio();
		post.setEdificio(ed);
		salvaPostazione(post);
	}
	
	public void salvaPostazione(Postazione post) {
		
		repoPostazione.save(post);
		log.info("postazione salvata");
	}
		
	public void updatePostazione(Postazione w) {
		repoPostazione.save(w);
		log.info("postazione aggioranata");
	}
		
	public void cancellaPostazioneConNome(Postazione w) {
		repoPostazione.delete(w);
		log.info("postazione cancellata");
	}
	

	public Postazione cercaPostazioneId(Long id) {
		return repoPostazione.findById(id).get();
	}
	
	public void cancellaPostazioneId(Long id) {
		repoPostazione.deleteById(id);
		log.info("postazione cancellata con id");
	}
	public List<Postazione> findAllPostazione() {
		return (List<Postazione>) repoPostazione.findAll();
	}

	
	public List<Postazione> cercaPostazioneTipo(Tipo type) {
		return (List<Postazione>) repoPostazione.cercaTipo(type);
	}
	
}