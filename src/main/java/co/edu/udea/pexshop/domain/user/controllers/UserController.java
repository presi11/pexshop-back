package co.edu.udea.pexshop.domain.user.controllers;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService iUserService;

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

    @GetMapping(value = "/v1/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user = iUserService.findById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
