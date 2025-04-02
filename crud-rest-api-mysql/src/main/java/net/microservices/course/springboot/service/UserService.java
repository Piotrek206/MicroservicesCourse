package net.microservices.course.springboot.service;

import net.microservices.course.springboot.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long id);

    List<UserDTO> getUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long id);
}
