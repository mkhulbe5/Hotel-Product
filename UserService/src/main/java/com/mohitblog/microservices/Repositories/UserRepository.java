package com.mohitblog.microservices.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohitblog.microservices.Entity.User;

public interface UserRepository extends JpaRepository<User,String>{

}
