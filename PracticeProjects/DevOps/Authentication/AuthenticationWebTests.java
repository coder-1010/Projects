import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mongo.controller.UsersController;
import com.mongo.model.UserModel;
import com.mongo.service.UserService;

public class AuthenticationWebTests {
	@Mock
    private UserService userService;

    @InjectMocks
    private UsersController usersController;

    private MockMvc mockMvc;

    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
    }
    
    @Test
    public void testGetRegisterPage() throws Exception {
        setup();

        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register_page"))
                .andExpect(model().attributeExists("registerRequest"))
                .andReturn();
    }
    @Test
    public void testGetLoginPage() throws Exception {
        setup();

        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login_page"))
                .andExpect(model().attributeExists("loginRequest"))
                .andReturn();

    }

    @Test
    public void testRegister() throws Exception {
        setup();

        String login = "user1";
        String password = "password";
        String email = "user1@example.com";

        mockMvc.perform(post("/register")
                .param("login", login)
                .param("password", password)
                .param("email", email))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }
    @Test
    public void testLogin() throws Exception {
        setup();
        String login = "user1";
        String password = "password";

        UserModel authenticatedUser = new UserModel();
        authenticatedUser.setLogin(login);

        // Mock the authenticate() method of the UserService to return the authenticatedUser
        when(userService.authenticate(login, password)).thenReturn(authenticatedUser);

        mockMvc.perform(post("/login")
                .param("login", login)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(view().name("personal_page"))
                .andExpect(model().attribute("userLogin", login))
                .andReturn();
    }
    
}
