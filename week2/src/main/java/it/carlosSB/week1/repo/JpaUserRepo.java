package it.carlosSB.week1.repo;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.carlosSB.week1.model.User;


@Repository
public interface JpaUserRepo extends CrudRepository<User, Long> {
		public User findByName(String name);
		public User findByLastname(String lastname);
		public User findByUsername(String username);
		public User findByEmail(String email);
		
		@Query(value = "SELECT COUNT(u) FROM User u")
		public Integer quantiUsers();	
		@Query(value = "SELECT u FROM User u ORDER BY random() LIMIT 1")
		public User RandomUser();
			
}