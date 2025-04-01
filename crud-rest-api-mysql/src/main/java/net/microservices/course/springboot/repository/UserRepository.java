package net.microservices.course.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.microservices.course.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
