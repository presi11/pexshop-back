package co.edu.udea.pexshop.domain.commons.jwt;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JWTUtils {


    public String getJWTUser(String rawToken) {
        Base64.Decoder decoder = Base64.getDecoder();
        String[] chunks = rawToken.split("\\.");
        String payload = new String(decoder.decode(chunks[1]));
        Gson gson = new Gson();
        JsonObject bdy = gson.fromJson(payload, JsonObject.class);
        JsonElement results = bdy.get("user_name");
        System.out.println(results.getAsString());
        return results.getAsString();
    }
}
