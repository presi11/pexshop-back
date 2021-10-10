package co.edu.udea.pexshop.integration.domain.commons.jwt;


import co.edu.udea.pexshop.domain.commons.jwt.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JWTUtilsSpec {

    @Autowired
    private JWTUtils jwtUtils;

    @Test
    public void getUserFromToken() {
        String rawJWT = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MzM5MDc3MzEsInVzZXJfbmFtZSI6Imp1YW5mZ2FsbG8yIiwiYXV0aG9yaXRpZXMiOlsic2NoZWR1bGVfcGV0IiwiY3JlYXRlIHBldCJdLCJqdGkiOiI5ZjdmNTUwMy1mZmVhLTQ1OTMtOGViYi04YWFkZjE4MTdkNGIiLCJjbGllbnRfaWQiOiJwZXhzaG9wLWZyb250Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.WmV-AngQVQ8z4zmJ2n1KxszPkuIlGAIW6cfZ1Q09n8s";
        jwtUtils.getJWTUser(rawJWT);
    }
}
