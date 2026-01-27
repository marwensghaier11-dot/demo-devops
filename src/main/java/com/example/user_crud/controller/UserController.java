package com.example.user_crud.controller;
import com.example.user_crud.model.User;
import com.example.user_crud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users")
@Tag(name = "Utilisateurs", description = "API de gestion des utilisateurs")
public class UserController {
    @Autowired
    private UserService userService;
    // ==================== CREATE ====================
    @Operation(
            summary = "Créer un nouvel utilisateur",
            description = "Crée un utilisateur avec les informations fournies. L'email doit être unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur créé avec succès",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "409", description = "Email déjà existant")
    })
    @PostMapping
    public ResponseEntity<User> createUser(
            @Valid @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Informations de l'utilisateur à créer",
                    required = true
            ) User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    // ==================== READ ALL ====================
    @Operation(
            summary = "Récupérer tous les utilisateurs",
            description = "Retourne la liste complète de tous les utilisateurs enregistrés"
    )
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    // ==================== READ BY ID ====================
    @Operation(
            summary = "Récupérer un utilisateur par ID",
            description = "Retourne les détails d'un utilisateur spécifique"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur trouvé"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @Parameter(description = "ID de l'utilisateur", example = "1")
            @PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // ==================== SEARCH ====================
    @Operation(
            summary = "Rechercher des utilisateurs par nom",
            description = "Recherche les utilisateurs dont le nom contient la chaîne spécifiée"
    )
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @Parameter(description = "Nom à rechercher", example = "Ben")
            @RequestParam String nom) {
        return ResponseEntity.ok(userService.searchByNom(nom));
    }
    // ==================== UPDATE ====================
    @Operation(
            summary = "Mettre à jour un utilisateur",
            description = "Met à jour les informations d'un utilisateur existant"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur mis à jour"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @Parameter(description = "ID de l'utilisateur à modifier", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
    // ==================== DELETE ====================
    @Operation(
            summary = "Supprimer un utilisateur",
            description = "Supprime définitivement un utilisateur du système"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Utilisateur supprimé"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "ID de l'utilisateur à supprimer", example = "1")
            @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    // ==================== COUNT ====================
    @Operation(summary = "Compter les utilisateurs", description = "Retourne le nombre total d'utilisateurs")
    @GetMapping("/count")
    public ResponseEntity<Long> countUsers() {
        return ResponseEntity.ok(userService.countUsers());
    }
}