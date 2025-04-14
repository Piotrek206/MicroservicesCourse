package net.microservices.course.springboot.mapper;

import static org.mapstruct.factory.Mappers.getMapper;

import org.mapstruct.Mapper;

import net.microservices.course.springboot.dto.UserDTO;
import net.microservices.course.springboot.entity.User;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper INSTANCE = getMapper(AutoUserMapper.class);

    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);
}
