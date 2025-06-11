package net.microservices.course.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.microservices.course.springboot.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
