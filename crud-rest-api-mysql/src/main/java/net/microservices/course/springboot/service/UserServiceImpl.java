package net.microservices.course.springboot.service;

import net.microservices.course.springboot.dto.UserDTO;
import net.microservices.course.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.microservices.course.springboot.entity.User;
import net.microservices.course.springboot.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO user) {
        return UserMapper.mapToDTO(userRepository.save(UserMapper.mapToEntity(user)));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::mapToDTO).orElse(null);
    }

    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.mapAllToDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User userToUpdate = userRepository.findById(userDTO.getId()).orElse(new User());
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setFirstName(userDTO.getFirstName());
        userToUpdate.setLastName(userDTO.getLastName());
        userRepository.save(userToUpdate);
        return UserMapper.mapToDTO(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
