package net.microservices.course.springboot.mapper;

import net.microservices.course.springboot.dto.UserDTO;
import net.microservices.course.springboot.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<UserDTO> mapAllToDTOs(List<User> users) {
        return users.stream().map(UserMapper::mapToDTO).collect(Collectors.toList());
    }

    public static UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static List<User> mapAllToEntities(List<UserDTO> users) {
        return users.stream().map(UserMapper::mapToEntity).collect(Collectors.toList());
    }

    public static User mapToEntity(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    }
}
