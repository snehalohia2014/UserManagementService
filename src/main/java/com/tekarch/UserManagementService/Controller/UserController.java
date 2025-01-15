package com.tekarch.UserManagementService.Controller;

import com.tekarch.UserManagementService.Model.User;
import com.tekarch.UserManagementService.Services.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

        private static final Logger logger = LogManager.getLogger(UserController.class);

        @Autowired
        private UserServiceImpl userServiceImpl;

        @PostMapping("/users")
        public User createUser(@RequestBody User user) {
            return userServiceImpl.createUser(user);
        }

        @GetMapping("/users")
        public List<User> getUsers() {
            return userServiceImpl.getAllUsers();
        }

        @GetMapping("/users/{userId}")
        public Optional<User> getUserById(@PathVariable Long userId) {
            return userServiceImpl.getUserById(userId);
        }

        @PutMapping("/users/{userId}")
        public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
            return userServiceImpl.updateUser(userId, updatedUser);
        }

        @DeleteMapping("/users/{userId}")
        public void deleteUser(@PathVariable Long userId) {
            userServiceImpl.deleteUser(userId);
        }

        @ExceptionHandler
        public ResponseEntity<String> respondWithError(Exception e) {
            logger.error("Exception Occurred. Details : {}", e.getMessage());
            return new ResponseEntity<>("Exception Occurred. More info :" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

}
