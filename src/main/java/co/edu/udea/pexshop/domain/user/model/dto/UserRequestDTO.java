package co.edu.udea.pexshop.domain.user.model.dto;

import co.edu.udea.pexshop.domain.user.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {

    private Long id;

    private String username;

    private String email;

    private String password;

    private Long role;


}
