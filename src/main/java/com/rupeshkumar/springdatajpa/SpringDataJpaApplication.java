package com.rupeshkumar.springdatajpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.rupeshkumar.springdatajpa.entity.Player;
import com.rupeshkumar.springdatajpa.entity.User;
import com.rupeshkumar.springdatajpa.repository.PlayerRepository;
import com.rupeshkumar.springdatajpa.repository.UserRepository;
import com.rupeshkumar.springdatajpa.repository.UserRepository2;

@SpringBootApplication
public class SpringDataJpaApplication {

	private final UserRepository2 userRepository2;

	SpringDataJpaApplication(UserRepository2 userRepository2) {
		this.userRepository2 = userRepository2;
	}

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
		
		
		
		
//		  User u2 = new User(105, "Prakash", "Male", 23, "India"); 
//		  User u3 = new  User(106, "Olivia", "Female", 24, "Canada"); 
//		  User u4 = new User(107, "Johny", "Male", 28, "France");
//		  User u5 = new User(108, "Ganesh", "Male", 45, "India"); 
//		  User u6 = new  User(109, "Alex", "Male", 24, "Germany"); 
//		  User u7 = new User(110, "Tony", "Male", 35, "USA");
//		  
//		  userBean.saveAll(Arrays.asList(u5,u6,u7));
		 
		 
		 
		
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
		
		/*
		 * userBean.deleteById(104);
		 * 
		 * userBean.deleteAllById(Arrays.asList(102,103));
		 */
		//======================== findBy =============================
		
		List<User> byCountry = userBean.findByCountry("INDIA");
		byCountry.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> byAge = userBean.findByAge(25);
		byAge.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> byAgeG = userBean.findByAgeGreaterThanEqual(29);
		byAgeG.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> byCountryIn = userBean.findByCountryIn(Arrays.asList("INDIA","USA"));
		byCountryIn.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> byCountryAndAge = userBean.findByCountryAndAge("INDIA", 25);
		byCountryAndAge.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> byCountryAndAgeGender = userBean.findByCountryAndAgeAndGender("INDIA", 25, "Male");
		byCountryAndAgeGender.forEach(user -> {
			System.out.println(user);
		});
		
		//####################################################################
		System.out.println("########### Custom Queries ############");
		
		List<User> users = userBean.getAllUsersHql();
		users.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> usersSql = userBean.getAllUserSql();
		usersSql.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> allUsersByCountryHql = userBean.getAllUsersByCountryHql("USA");
		allUsersByCountryHql.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> allUsersByCountryAndAge = userBean.getAllUsersByCountryAndAge("India", 29);
		allUsersByCountryAndAge.forEach(user -> {
			System.out.println(user);
		});
	
		//###########################################################################
		System.out.println("############### JpaRepository ######################");
		
		
		
		UserRepository2 userRepository = context.getBean(UserRepository2.class);
		
		// sorting
		List<User> allUsersSorted = userRepository.findAll(Sort.by("age").ascending());
		allUsersSorted.forEach(user -> {
			System.out.println(user);
		});
		
		List<User> allUsersSortedDesc = userRepository.findAll(Sort.by("userName","age").descending());
		allUsersSortedDesc.forEach(user -> {
			System.out.println(user);
		});
		
		// Pagination
		int pageSize = 3;
		int pageNo = 1;
		PageRequest pr = PageRequest.of(pageNo-1, pageSize);
		Page<User> pageData = userRepository.findAll(pr);
		int totalPages = pageData.getTotalPages();
		System.out.println("Total pages : "+totalPages);
		List<User> pUsers = pageData.getContent();
		pUsers.forEach(user -> {
			System.out.println(user);
		});
		
		
	}

}
