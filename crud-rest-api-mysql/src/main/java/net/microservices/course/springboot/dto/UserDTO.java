package net.microservices.course.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Data Transfer Object for User",
        title = "User DTO",
        requiredMode = Schema.RequiredMode.REQUIRED
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @Schema(description = "First name of the user")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @Schema(description = "Last name of the user")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Schema(description = "Email address of the user")
    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;
}
