package com.example.user_crud.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entité représentant un utilisateur du système")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant unique de l'utilisateur", example = "1", accessMode =
            Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    @Schema(description = "Nom de famille de l'utilisateur", example = "Ben Ahmed", required =
            true)
    private String nom;

    @Column(nullable = false)
    @NotBlank(message = "Le prénom est obligatoire")
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    @Schema(description = "Prénom de l'utilisateur", example = "Mohamed", required = true)
    private String prenom;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format d'email invalide")
    @Schema(description = "Adresse email unique", example = "mohamed.benahmed@email.com",
            required = true)
    private String email;

    @Pattern(regexp = "^[0-9]{8}$", message = "Le téléphone doit contenir 8 chiffres")
    @Schema(description = "Numéro de téléphone (8 chiffres)", example = "98765432")
    private String telephone;

    public boolean getUsername() {
        return false;
    }
}