package data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private DataHelper() {

    }

    public static Faker faker = new Faker(new Locale("en"));

    public static AuthInfo getValidAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static String generateRandomPassword() {

        return faker.internet().password();
    }

    public static String generateRandomLogin() {

        return faker.name().username();
    }

    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static  VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(faker.numerify("#####"));

    }


    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode{
        String code;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode{
        private String id;
        private String user_id;
        private String code;
        private String created;


    }


}
