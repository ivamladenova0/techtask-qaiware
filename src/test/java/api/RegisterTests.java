package api;

import objects.Register;
import objects.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dataproviders.DataProviders;

public class RegisterTests extends BaseTest {

    private RegisterApi registerApi;

    @BeforeClass
    public void beforeUsersTests() {
        registerApi = new RegisterApi();
    }

    @Test(dataProvider = "register-positive-cases", dataProviderClass = DataProviders.class)
    public void canRegisterDefinedUser(String userEmail, String userPassword, String expectedUserId, String expectedToken, String expectedStatusCode) {
        User userToRegister = new User();
        userToRegister.email = userEmail;
        userToRegister.password = userPassword;
        Register response = registerApi.registerUser(userToRegister, expectedStatusCode);
        verify(response.id, Integer.parseInt(expectedUserId), "User id differs from expected. Expected: ");
        verify(response.token, expectedToken, "Verify token is as expected");
    }

    @Test(dataProvider = "register-negative-cases", dataProviderClass = DataProviders.class)
    public void cannotRegisterUndefinedUser(String userEmail, String password, String expectedError, String expectedStatusCode) {
        User userToRegister = new User();
        userToRegister.email = userEmail;
        userToRegister.password = password;
        Register response = registerApi.registerUser(userToRegister, expectedStatusCode);
        verify(response.error, expectedError, "Verify error is as expected");
    }
}
