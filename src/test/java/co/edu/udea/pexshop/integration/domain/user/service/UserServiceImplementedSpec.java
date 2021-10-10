package co.edu.udea.pexshop.integration.domain.user.service;

import co.edu.udea.pexshop.domain.user.model.dto.UserResponseDTO;
import co.edu.udea.pexshop.domain.user.service.UserServiceSecure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceImplementedSpec {

    @Autowired
    private UserServiceSecure userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    String MOCK_USER_NAME = "chorro";

    @Test
    public void getUserByName(){
        UserResponseDTO returnedUser = userService.findByUsername(MOCK_USER_NAME);
        assertTrue(returnedUser.isAcive());
    }

    @Test
    public void testPasswordEncorder() {
        String password = "112060934623572530636";
        for(int i = 0; i < 4; i++){
            String passworBcrypted = bCryptPasswordEncoder.encode(password);
            System.out.println(passworBcrypted);
        }
    }

}
