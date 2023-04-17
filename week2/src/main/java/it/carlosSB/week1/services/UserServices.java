package it.carlosSB.week1.services;


import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.carlosSB.week1.model.User;
import it.carlosSB.week1.repo.JpaUserRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServices {

	@Autowired private JpaUserRepo repoUser;
	
	@Autowired @Qualifier("fakeUser")
	private ObjectProvider<User> fakeUser;
	
	public void creafakeUser() {
		salvaUser(fakeUser.getObject());
	}	
	
	
	
	
	public void salvaUser(User u) {
		repoUser.save(u);
		log.info("user salvato");
	}
	public void aggiornaUser(User u) {
		repoUser.save(u);
		log.info("user aggiornato");
	}
	public void cancellaUserNome(User u) {
		repoUser.delete(u);
		log.info("user cancellato");
	}
	public void cancellaUserId(Long id) {
		repoUser.deleteById(id);
		log.info("usercancellato con id");
	}
	public User cercaId(Long id) {
		return repoUser.findById(id).get();
	}
	public List<User> findAllUser() {
		return (List<User>) repoUser.findAll();
	}
	
	
}