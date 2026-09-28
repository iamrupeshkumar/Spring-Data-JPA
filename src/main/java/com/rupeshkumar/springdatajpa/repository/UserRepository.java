package com.rupeshkumar.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rupeshkumar.springdatajpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//############## findByXXXXX ##################
	
	//SELECT * FROM user_master where user_country=?
	public List<User> findByCountry(String cname);
	
	//SELECT * FROM user_master where user_age=?
	public List<User> findByAge(Integer age);
	
	//SELECT * FROM user_master where user_age >= ?
	public List<User> findByAgeGreaterThanEqual(Integer age);
	
	//SELECT * FROM user_master where user_country in (?,?...)
	public List<User> findByCountryIn(List<String> countries);
	
	//SELECT * FROM user_master where user_country=? and user_age = ?
	public List<User> findByCountryAndAge(String cname, Integer age);
	
	//SELECT * FROM user_master where user_country=? and user_age = ? and user_gender = ?
	public List<User> findByCountryAndAgeAndGender(String cname, Integer age, String gender);
	
	//#################### Custom queries ######################
	
	@Query(value="from User")
	public List<User> getAllUsersHql();
	
	@Query(value="select * from user_master", nativeQuery=true)
	public List<User> getAllUserSql();
	
	@Query(value="from User where country =:cname")
	public List<User> getAllUsersByCountryHql(String cname);
	
	@Query(value="from User where country=:cname and age=:age")
	public List<User> getAllUsersByCountryAndAge(String cname, Integer age);
	
	

}
