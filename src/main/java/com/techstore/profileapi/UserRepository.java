package com.techstore.profileapi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}


