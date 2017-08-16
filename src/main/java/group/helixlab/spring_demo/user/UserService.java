package group.helixlab.spring_demo.user;

import group.helixlab.spring_demo.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    Iterable<User> findAll() {
        // return userRepository.findAll();
        return userRepository.getEnabledUser(true);
    }

    User findUserById(int id) {
        return userRepository.findOne(id);
    }

    User createUser(User user) {
        user.setPassword(PasswordUtil.generatePassword());
        /* userRepository.saveAndFlush(user);
        return PasswordUtil.HidePassword(user); */
        return userRepository.saveAndFlush(user);
    }

    void deleteUserById(int id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
    }

    User updateUser(int id, User user) {
        if(userRepository.findOne(id).getId() == id)
            return userRepository.saveAndFlush(user);
        throw new NullPointerException();
    }

    // ...
    String loginUser(String username, String pass) {
        User user = userRepository.checkUsernamePass(username, //PasswordUtil.basePassword(pass)
                pass);
        String string = new String();
        if (user == null){
            string = "Nincs ilyen user";
        } else {
            string = "Van ilyen user";
        }
        return string;
    }
}
