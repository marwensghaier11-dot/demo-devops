package com.example.user_crud.service;
import com.example.user_crud.model.User;
import com.example.user_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    // CREATE
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email déjà utilisé: " + user.getEmail());
        }
        return userRepository.save(user);
    }
    // READ ALL
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // READ BY ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    // READ BY EMAIL
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    // SEARCH BY NOM
    public List<User> searchByNom(String nom) {
        return userRepository.findByNomContainingIgnoreCase(nom);
    }
    // UPDATE
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User non trouvé avec id: " + id));
        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setEmail(userDetails.getEmail());
        user.setTelephone(userDetails.getTelephone());
        return userRepository.save(user);
    }
    // DELETE
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User non trouvé avec id: " + id);
        }
        userRepository.deleteById(id);
    }
    // COUNT
    public long countUsers() {
        return userRepository.count();
    }
}