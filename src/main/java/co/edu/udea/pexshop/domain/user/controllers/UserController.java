package co.edu.udea.pexshop.domain.user.controllers;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/api")
public class UserController {


    @PostMapping("/users/me")
    public ResponseEntity<?> authenticate() {
        UserResponseDTO userResponseDTO = null;
        Map<String, Object> response = new HashMap<>();

        try{

        }catch (DataAccessException e) {
            response.put("msj:", "Error in authentication. User or password invalid");
            response.put("error: ", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.UNAUTHORIZED);
    }
}
