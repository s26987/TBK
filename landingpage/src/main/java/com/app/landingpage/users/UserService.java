package com.app.landingpage.users;

import com.app.landingpage.translations.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(existing -> {
                    if (updatedUser.getEmail() != null) {
                        existing.setEmail(updatedUser.getEmail());
                    }
                    if (updatedUser.getPreferences() != null) {
                        existing.setPreferences(updatedUser.getPreferences());
                    }
                    if (updatedUser.getRole() != null) {
                        existing.setRole(updatedUser.getRole());
                    }
                    return userRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("User o id:" + id + "nie zostal znaleziony"));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
