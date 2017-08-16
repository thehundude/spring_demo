package group.helixlab.spring_demo.util;

import group.helixlab.spring_demo.user.User;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Random;

public class PasswordUtil {
    public static String generatePassword(){
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        String generated = new String(array, Charset.forName("UTF-8"));

        byte[] encodedBytes = Base64.getEncoder().encode(generated.getBytes());
        String encodedPass = new String(encodedBytes);
        return encodedPass;
    }

    public static String basePassword(String pass){
        byte[] encodedBytes = Base64.getEncoder().encode(pass.getBytes());
        String encodedPass = new String(encodedBytes);
        return encodedPass;
    }

    public static User HidePassword(User user) {
        User returnUser = user;
        returnUser.setPassword("");
        return returnUser;
    }
}
