package com.rupeshkumar.springdatajpa;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rupeshkumar.springdatajpa.entity.Player;
import com.rupeshkumar.springdatajpa.entity.User;
import com.rupeshkumar.springdatajpa.repository.PlayerRepository;
import com.rupeshkumar.springdatajpa.repository.UserRepository;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		PlayerRepository playerBean = context.getBean(PlayerRepository.class);
//		System.out.println(bean.getClass().getName());
		
		/*
		 * Player p1 = new Player(); p1.setPlayerId(102); p1.setPlayerName("V Shehwag");
		 * p1.setPlayerAge(45); p1.setLocation("Delhi");
		 * 
		 * playerBean.save(p1); // upsert method (insert + update)
		 */		
		// save is polymorphic method - it checks first the data is present or not 
		//if not then insert the record and if present then update the record	
		
		UserRepository userBean = context.getBean(UserRepository.class);
		
		/*
		 * User u1 = new User(101, "Ramesh", "Male", 25, "India"); userBean.save(u1);
		 */
		
		
		/*
		 * User u2 = new User(102, "Akash", "Male", 23, "India"); User u3 = new
		 * User(103, "Sumit", "Male", 29, "India"); User u4 = new User(104, "John",
		 * "Male", 32, "USA");
		 * 
		 * userBean.saveAll(Arrays.asList(u2,u3,u4));
		 */
		 
		
		/*
		 * Optional<User> byId = userBean.findById(102); if(byId.isPresent()) {
		 * System.out.println(byId.get()); }
		 */
		
		/*
		 * Iterable<User> allById = userBean.findAllById(Arrays.asList(101,103,104));
		 * allById.forEach(user -> { System.out.println(user); });
		 */
		
		/*
		 * Iterable<User> all = userBean.findAll(); all.forEach(user -> {
		 * System.out.println(user); });
		 */
		
		
		/*
		 * long count = userBean.count(); System.out.println(count);
		 * 
		 * 
		 * boolean existsById = userBean.existsById(102);
		 * System.out.println(existsById);
		 */
		
		userBean.deleteById(104);
		
		userBean.deleteAllById(Arrays.asList(102,103));
		
		
		
	}

}
