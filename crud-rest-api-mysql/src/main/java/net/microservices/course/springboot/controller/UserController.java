package net.microservices.course.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.microservices.course.springboot.dto.UserDTO;
import net.microservices.course.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "User Management",
        description = "APIs for managing users in the system"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Create User",
            description = "Create a new user in the system. If the email already exists, a 400 error is returned."
    )
    @ApiResponse(
            responseCode = "201",
            description = "User created successfully"
    )
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO user) {
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User by ID",
            description = "Retrieve a user by their unique identifier (ID). If the user is not found, a 404 error is returned."
    )
    @ApiResponse(
            responseCode = "200",
            description = "User found and returned successfully"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
//        try {
            UserDTO user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
//        } catch (ResourceNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

    @Operation(
            summary = "Get All Users",
            description = "Retrieve a list of all users in the system."
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of users returned successfully"
    )
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User",
            description = "Update an existing user's details. If the user is not found, a 404 error is returned."
    )
    @ApiResponse(
            responseCode = "200",
            description = "User updated successfully"
    )
    @PutMapping("{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @Operation(
            summary = "Delete User",
            description = "Delete a user by their unique identifier (ID). If the user is not found, a 404 error is returned."
    )
    @ApiResponse(
            responseCode = "200",
            description = "User deleted successfully"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("UserDTO deleted", HttpStatus.OK);
    }
}
