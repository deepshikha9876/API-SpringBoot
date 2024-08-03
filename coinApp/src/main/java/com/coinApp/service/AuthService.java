package com.coinApp.service;

import com.coinApp.model.Response;
import com.coinApp.model.User;
import com.coinApp.repository.UserRepository;
import com.coinApp.util.JwtTokenProvider;
import com.coinApp.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidationUtil validationUtil;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public Response registerUser(User user) {
        System.out.println(user);
        Response re = new Response();

        if (userRepository.findByUsername(user.getUsername()) != null) {
            System.out.println("Username is already taken.......");
            re.setMessage("Username is already taken.......");
            re.setError("0");
            return re;
        }

        if (!validationUtil.isValidUsername(user.getUsername())) {
            re.setMessage("Username is invalid. It should be 4-15 characters long and contain only letters and numbers.");
            re.setError("0");
            return re;
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("Email is already registered.......");
            re.setMessage("Email is already registered.......");
            re.setError("0");
            return re;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("user registered........");
        userRepository.save(user);
        re.setMessage("user registered.........");
        re.setError("0");
        return re;
    }

    public String login(String username, String password) {
        System.out.println("Logging in user.......");

        User user = userRepository.findByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtTokenProvider.createToken(username);
    }
}
