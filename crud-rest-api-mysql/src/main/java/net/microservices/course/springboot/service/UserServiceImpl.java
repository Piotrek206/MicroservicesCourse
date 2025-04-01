package net.microservices.course.springboot.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.microservices.course.springboot.entity.User;
import net.microservices.course.springboot.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
