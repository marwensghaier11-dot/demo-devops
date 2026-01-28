package com.example.user_crud.service;

import com.example.user_crud.model.User;
import com.example.user_crud.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests unitaires de UserService")
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Ahmed", "ahmed@email.com", "aa", "ggg");
    }
   /* @Test
    @DisplayName("Doit sauvegarder un utilisateur avec succès")
    void saveUser_Success() {
// Arrange
        when(userRepository.save(any(User.class))).thenReturn(user);
// Act
        User result = userService.createUser(user);
// Assert
        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo("Ahmed");
        verify(userRepository, times(1)).save(user);
    }
    /*@Test
    @DisplayName("Doit retourner tous les utilisateurs")
    void getAllUsers_Success() { // Arrange
        List<User> users = Arrays.asList(
                new User(1L, "Ahmed", "ahmed@email.com","aa","555"),
                new User(2L, "Fatma", "fatma@email.com","akak","777")
        );
        when(userRepository.findAll()).thenReturn(users);
// Act
        List<User> result = userService.getAllUsers();
// Assert
   /*     assertThat(result).hasSize(2);
        assertThat(result.get(0).getUsername()).isEqualTo("Ahmed");
    }
    @Test
    @DisplayName("Doit trouver un utilisateur par ID")
    void getUserById_Found() {
// Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
// Act
        Optional<User> result = userService.getUserById(1L);
// Assert
        assertThat(result).isPresent();
        assertThat(result.get().getUsername()).isEqualTo("Ahmed");
    }
    @Test
    @DisplayName("Doit retourner vide si utilisateur non trouvé")
    void getUserById_NotFound() {
// Arrange
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
// Act
        Optional<User> result = userService.getUserById(99L);
// Assert
        assertThat(result).isEmpty();
    }
    @Test
    @DisplayName("Doit mettre à jour un utilisateur existant")
    void updateUser_Success() {
// Arrange
        User updatedUser = new User(1L, "Ahmed Updated", "new@email.com","aaa","1523");
        when(userRepository.existsById(1L)).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
// Act
        User result = userService.updateUser(1L, updatedUser);
// Assert
        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo("Ahmed Updated");
    }
    @Test
    @DisplayName("Doit retourner null si utilisateur à mettre à jour n'existe pas")
    void updateUser_NotFound(){}
}
// Arrange
        //when(userRepository.existsById(99L)).thenReturn(false);

    */
}