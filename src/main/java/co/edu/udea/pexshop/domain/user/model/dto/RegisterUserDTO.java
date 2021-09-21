package co.edu.udea.pexshop.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {

    String userName;
    String email;
    String password;
    String authCode;
}
