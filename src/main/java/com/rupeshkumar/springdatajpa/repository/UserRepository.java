package com.rupeshkumar.springdatajpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rupeshkumar.springdatajpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//SELECT * FROM user_master where user_country=?
	public List<User> findByCountry(String cname);
	
	//SELECT * FROM user_master where user_age=?
	public List<User> findByAge(Integer age);
	
	//SELECT * FROM user_master where user_age >= ?
	public List<User> findByAgeGreaterThanEqual(Integer age);
	
	//SELECT * FROM user_master where user_country in (?,?...)
	public List<User> findByCountryIn(List<String> countries);

}
