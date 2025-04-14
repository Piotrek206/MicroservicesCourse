package net.microservices.course.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.microservices.course.springboot.dto.UserDTO;
import net.microservices.course.springboot.entity.User;
import net.microservices.course.springboot.exception.ResourceNotFoundException;
import net.microservices.course.springboot.mapper.AutoUserMapper;
import net.microservices.course.springboot.mapper.UserMapper;
import net.microservices.course.springboot.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

//    private final ModelMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO user) {
        return AutoUserMapper.INSTANCE.mapToUserDTO(userRepository.save(AutoUserMapper.INSTANCE.mapToUser(user)));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(AutoUserMapper.INSTANCE::mapToUserDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.mapAllToDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User userToUpdate = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userDTO.getId()));
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setFirstName(userDTO.getFirstName());
        userToUpdate.setLastName(userDTO.getLastName());
        userRepository.save(userToUpdate);
        return UserMapper.mapToDTO(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }
}
