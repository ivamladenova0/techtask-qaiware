package api;

import io.restassured.response.Response;
import objects.User;
import objects.UserList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dataproviders.DataProviders;
import utils.Utils;
import java.io.IOException;
import java.util.List;

public class UserTests extends BaseTest {

    private UsersApi usersApi;

    @BeforeClass
    public void beforeUsersTests(){
        usersApi = new UsersApi();
    }

    @Test(dataProvider = "get-single-user-positive", dataProviderClass = DataProviders.class)
    public void canGetSingleUser(String userId, String expectedStatusCode, String expectedEmail, String expectedFirstName, String expectedLastName, String expectedAvatarUrl){
        User user = usersApi.getSingleUser(userId, expectedStatusCode);
        verifyIntValues(user.data.id, userId, "Verify user with invalid id is not found");
        verify(user.data.email, expectedEmail, "Verify user email is as expected");
        verify(user.data.firstName, expectedFirstName, "Verify user first name is as expected");
        verify(user.data.lastName, expectedLastName, "Verify user last nae is as expected");
        verify(user.data.avatar, expectedAvatarUrl, "Verify user avatar url is as expected");

    }

    @Test(dataProvider = "get-single-user-negative", dataProviderClass = DataProviders.class)
    public void cannotGetInvalidSingleUser(String userId, String expectedStatusCode){
        Response user = usersApi.getSingleUserResponse(userId, expectedStatusCode);
        verifyIntValues(user.getStatusCode(), expectedStatusCode, "Verify user with invalid id is not found");

    }

    @Test(dataProvider = "create-new-user", dataProviderClass = DataProviders.class)
    public void createNewUser(String userName, String userJob){
        User user = new User();
        user.name = userName;
        user.job = userJob;
        User newUser = usersApi.createUser(user);
        verify(newUser.name, userName, "Verify user name is correct");
        verify(newUser.job, userJob, "Verify user job is correct");

    }

    @Test
    public void canUpdateUserWithPutMethod(){
        User expectedUser = new User();
        expectedUser.name = "Morphius is renamed to Neo";
        expectedUser.job = "The one";
        User actualUser = usersApi.updateUserWithPut(expectedUser, "2");
        verify(actualUser.name, expectedUser.name, "Verify user name is updated");
        verify(actualUser.job, expectedUser.job, "Verify user job is updated");
    }

    @Test
    public void canUpdateUserWithPatchMethod() throws IOException {
        String body = Utils.readFile("data/patch-user-name-body.json");
        User actualUser = usersApi.updateUserWithPatch(body, "2");
        verify(actualUser.name, "only name is changed", "Verify user name is updated");
    }

    @Test(dataProvider = "delete-user", dataProviderClass = DataProviders.class)
    public void canDeleteUser(String userId, String expectedStatusCode, String expectedResponse) {
        Response response = usersApi.deleteUser(userId);
        verifyIntValues(response.getStatusCode(), expectedStatusCode, "Verify status code is 204");
        verify(response.asString(), expectedResponse, "Verify response does not contain errors");
    }

    @Test
    public void listAllUsersOnPage() {
        UserList userList = usersApi.getAllUsersPerPage(1);
        verifyIntValues(userList.getPerPage(), "3", "Verify users per page count is correct");
    }

    @Test
    public void listAllUsers(){
        List allUsers = usersApi.getAllUsers();
        verifyIntValues(allUsers.size(), "12","Verify total users counter is correct" );
    }
}