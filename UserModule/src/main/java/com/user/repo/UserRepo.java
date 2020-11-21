package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.bo.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	public User findByUsername(@Param("username")String username);

}
