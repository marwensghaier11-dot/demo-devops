package com.example.user_crud.repository;
import com.example.user_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Recherche par email
    Optional<User> findByEmail(String email);
    // Vérifie si un email existe
    boolean existsByEmail(String email);
// Recherche par nom (contient)
List<User> findByNomContainingIgnoreCase(String nom);
    // Recherche par nom et prénom
    List<User> findByNomAndPrenom(String nom, String prenom);
}