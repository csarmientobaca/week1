package it.carlosSB.week1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.carlosSB.week1.repo.JpaPostazioneRepo;
import it.carlosSB.week1.repo.JpaPrenotazioneRepo;
import it.carlosSB.week1.repo.JpaUserRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneServices {
	@Autowired private JpaPrenotazioneRepo repoPrenotazione;
	@Autowired private JpaUserRepo repoUser;
	@Autowired private JpaPostazioneRepo repoPostazione;
	@Autowired private PostazioneServices postazioneService;

	
	
	
}
	