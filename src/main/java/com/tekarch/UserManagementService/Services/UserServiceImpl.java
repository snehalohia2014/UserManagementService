package com.tekarch.UserManagementService.Services;

import com.tekarch.UserManagementService.Model.User;
import com.tekarch.UserManagementService.Repository.UserRepository;
import com.tekarch.UserManagementService.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    // External API URL
//    String url = "https://localhost:8081/users";  // Example URL for testing
//
//    // Making a GET request to the API and getting the response as a String
//    String response = restTemplate.getForObject(url, String.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        if (userRepository.existsById(userId)) {
            updatedUser.setUserId(userId);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
