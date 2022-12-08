package com.tddtoday.tddtoday.dto;



import com.tddtoday.tddtoday.validators.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    @NotBlank(message = "Field 'username' -> cannot be blank")
    private String username;

    @Email(message = "Field 'email' -> wrong format")
    private String email;

    @ValidPassword
    private String password;

}
