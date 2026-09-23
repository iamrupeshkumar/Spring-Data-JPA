package com.rupeshkumar.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rupeshkumar.springdatajpa.entity.Player;
import com.rupeshkumar.springdatajpa.repository.PlayerRepository;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		PlayerRepository bean = context.getBean(PlayerRepository.class);
//		System.out.println(bean.getClass().getName());
		
		Player p1 = new Player();
		p1.setPlayerId(102);
		p1.setPlayerName("V Shehwag");
		p1.setPlayerAge(45);
		p1.setLocation("Delhi");
		
		bean.save(p1); // upsert method (insert + update)
		
		// save is polymorphic method - it checks first the data is present or not 
		//if not then insert the record and if present then update the record	
		
	}

}
