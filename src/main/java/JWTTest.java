import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.profile.JwtGenerator;

public class JWTTest{
    public static void main(String[] args){
        TestProfile profile = new TestProfile();
        final String jwtSalt = "Some random salt here can really be anything for the purposes of this test 1234567890";

        final JwtGenerator<TestProfile> generator = new JwtGenerator<>(new SecretSignatureConfiguration(jwtSalt));
        String token = null;
        if(profile != null) {
            token = generator.generate(profile);
        }
    }
}
