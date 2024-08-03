package com.coinApp.controller;

import com.coinApp.dto.UserDTO;
import com.coinApp.model.Response;
import com.coinApp.model.User;
import com.coinApp.service.ProfileService;
import com.coinApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestBody User updatedUser, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Update the fields except username and password
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setMobile(updatedUser.getMobile());

        User updated = profileService.updateUser(user);

        // Convert to UserDTO
        UserDTO userDTO = new UserDTO(
            updated.getId(),
            updated.getFirstName(),
            updated.getLastName(),
            updated.getEmail(),
            updated.getMobile()
        );
        Response res = new Response();
        res.setError("0");
        res.setMessage("User Updated Sucessfully");
        return ResponseEntity.ok(res);
    }
}
