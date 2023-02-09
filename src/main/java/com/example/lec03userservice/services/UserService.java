package com.example.lec03userservice.services;

import com.example.lec03userservice.services.exceptions.*;
import com.example.lec03userservice.stores.entities.User;
import com.example.lec03userservice.stores.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        validateName(user.getName());
        validatePassword(user.getPassword());
        validateEmail(user.getEmail());
        checkPasswordMatch(user.getPassword(),user.getPasswordConfirm());

        return userRepository.save(user);
    }

    private void validateName(String name) {
        if(!checkNameLength(name)){
            throw new NameValidationException("10002", "Name length must be greater than 5 and less than 50");
        }
    }

    private void validatePassword(String password) {
        if (!checkPasswordLength(password)) {
            throw new PasswordValidationException("10002", "Password length must be greater than 5 and less than 50");
        }
    }

    private void validateEmail(String email) {
        //check email length
        if (!checkEmailLength(email)) {
            throw new EmailValidationException("10001", "Email length must be greater than 5 and less than 50");
        }

        // check email already exists
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExists("10000", "Email already exists");
        }
    }
    private void checkPasswordMatch(String password, String passwordConfirm){
        // password = passwordConfirm
        if (!password.equals(passwordConfirm)) {
            throw new PasswordNotMatch("10003","Password and password confirm are not same");
        }
    }

    private boolean checkNameLength(String name) {
        // name length must be greater than 5 and less than 50
        return name.length() >= 5 && name.length() <= 50;
    }

    private boolean checkPasswordLength(String password) {
        // name length must be greater than 5 and less than 50
        return password.length() >= 5 && password.length() <= 50;
    }

    private boolean checkEmailLength(String email) {
        // name length must be greater than 5 and less than 50
        return email.length() >= 5 && email.length() <= 50;
    }

    // update user
    public User update(Long id, User user){
        //only update name and email if they are not null
        Optional<User> existingUser = userRepository.findById(id);
        return existingUser.map(u -> {
            if (user.getName() != null){
                validateName(user.getName());
                u.setName(user.getName());
            }

            if (user.getEmail() != null){
                validateEmail(user.getEmail());
                u.setEmail(user.getEmail());
            }
            return userRepository.save(u);
        }).orElseThrow(() -> new UserNotExist("10002", "User not found"));
    }
    // delete by id
    public void deleteById(Long id) {
        userRepository
                .findById(id)
                .ifPresentOrElse(
                        userRepository::delete
                        , () -> {throw new UserNotExist("10002", "User not found");}
                );
    }
    // get user by id
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotExist("10002", "User not found"));
    }
    // get all users
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
    // password check
    public boolean checkPassword(String email, String password) {
        return getByEmailAndPassword(email, password).isPresent();
    }

    private Optional<User> getByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
