package co.edu.udea.pexshop.domain.user.mapper;

import co.edu.udea.pexshop.domain.user.model.dto.UserRequestDTO;
import co.edu.udea.pexshop.domain.user.model.entity.User;

public interface IUserRequestMapper {

    UserRequestDTO modelToDto(User user);
    User dtoToModel(UserRequestDTO userRequestDTO);

}
