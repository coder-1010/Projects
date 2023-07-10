package practiceProject.card3.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import practiceProject.card3.three.UserModel;
import practiceProject.card3.three.UsersRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser_Positive() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the behavior of the usersRepository.save method
        when(usersRepository.save(any(UserModel.class))).thenReturn(createMockUserModel());

        // Call the registerUser method
        UserModel registeredUser = userService.registerUser("john", "password", "john@example.com");

        // Assert the result
        Assertions.assertNotNull(registeredUser);
        Assertions.assertEquals("john", registeredUser.getLogin());
        Assertions.assertEquals("password", registeredUser.getPassword());
        Assertions.assertEquals("john@example.com", registeredUser.getEmail());
    }

    @Test
    public void testAuthenticate_Positive() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Mock the behavior of the usersRepository.findByLoginAndPassword method
        when(usersRepository.findByLoginAndPassword(anyString(), anyString())).thenReturn(Optional.of(createMockUserModel()));

        // Call the authenticate method
        UserModel authenticatedUser = userService.authenticate("john", "password");

        // Assert the result
        Assertions.assertNotNull(authenticatedUser);
        Assertions.assertEquals("john", authenticatedUser.getLogin());
        Assertions.assertEquals("password", authenticatedUser.getPassword());
        Assertions.assertEquals("john@example.com", authenticatedUser.getEmail());
    }
    
    private UserModel createMockUserModel(){
        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setLogin("john");
        userModel.setPassword("password");
        userModel.setEmail("john@example.com");
        return userModel;
    }
}