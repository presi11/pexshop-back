package co.edu.udea.pexshop.domain.user.model.dto;

import co.edu.udea.pexshop.domain.user.model.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    String username;
    boolean isAcive;
    String authenticationCode;
    List<Permission> permissions;
}
