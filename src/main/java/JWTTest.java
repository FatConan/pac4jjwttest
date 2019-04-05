import net.minidev.json.JSONObject;
import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.profile.JwtGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class JWTTest{
    public static void recreatePlayFrameworkError(){
        System.out.println("Trying something similar to what pac4j is doing in play");

        Map<String, Object> additionalData = new HashMap<>();
        additionalData.put("String", "String");
        additionalData.put("Long", 1L);
        additionalData.put("Boolean", true);
        additionalData.put("Date", LocalDate.now());
        additionalData.put("DateTime", LocalDateTime.now());

        TestProfile profile = new TestProfile();
        profile.setId(1);
        profile.addAttribute("Boolean", true);
        profile.addAttribute("Date", LocalDate.now());
        profile.addAttribute("DateTime", LocalDateTime.now());
        profile.addAttribute("Long", 1);
        profile.setAdditionalData(additionalData);

        profile.addRole("TEST");

        final String jwtSalt = "Some random salt here can really be anything for the purposes of this test 1234567890";

        final JwtGenerator<TestProfile> generator = new JwtGenerator<>(new SecretSignatureConfiguration(jwtSalt));
        generator.generate(profile);
    }

    public static void highlightWonkyJsonError(){
        System.out.println("Just using the JSONObject gubbins from json-smart directly");
        JSONObject object = new JSONObject();
        object.put("String", "String");
        object.put("Long", 1L);
        object.put("Boolean", true);
        object.put("Date", LocalDate.now());
        object.put("DateTime", LocalDateTime.now());
        System.out.println(object.toJSONString());
    }

    public static void main(String[] args){
        try{
            highlightWonkyJsonError();
        }catch(java.lang.IllegalAccessError e){
            System.out.println("This would be considered a fatal error.");
            e.printStackTrace();
        }

        try{
            recreatePlayFrameworkError();
        }catch(java.lang.IllegalAccessError e){
            System.out.println("Akka catches and shuts down the JVM");
            e.printStackTrace();
        }
    }
}
