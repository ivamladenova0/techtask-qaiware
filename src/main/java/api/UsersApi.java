package api;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import objects.User;
import objects.UserList;
import java.util.ArrayList;
import java.util.List;

public class UsersApi extends BaseApi {

    Response response;

    public UsersApi(){
        super();
        basePath = String.format("users/");
    }

    public User getSingleUser(String userId, String statusCode){
        return given().
                get("/{userId}", Integer.parseInt(userId)).
                then().
                statusCode(Integer.parseInt(statusCode)).extract().
                response().getBody().as(User.class);
    }

    public Response getSingleUserResponse(String userId, String statusCode){
        return response = given().
                get("/{userId}", Integer.parseInt(userId)).
                then().
                statusCode(Integer.parseInt(statusCode)).extract().
                response();
    }

    public UserList getAllUsersPerPage(int pageCounter){
        return given().
                param("page", pageCounter).
                get().
                then().
                statusCode(200).extract().
                response().getBody().as(UserList.class);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        int totalPages = getAllUsersPerPage(1).getTotalPages();

            for (int page = 1; page <= totalPages; page++) {
                allUsers.addAll(getAllUsersPerPage(page).getData());
    }

        return allUsers;
    }

    public User createUser(User newUser) {
        return given().
                contentType("application/json; charset=UTF-8").
                body(newUser).
                when().
                post().
                then().statusCode(201).
                extract().response().as(User.class);
    }

    public User updateUserWithPut(User updatedUser, String userId) {
        return given().
                contentType("application/json; charset=UTF-8").
                body(updatedUser).
                when().
                put("/{userId}", userId).
                then().statusCode(200).
                extract().response().as(User.class);
    }

    public User updateUserWithPatch(String body, String userId){
        return given().
                contentType("application/json; charset=UTF-8").
                body(body).
                when().
                patch("/{userId}", userId).
                then().statusCode(200).
                extract().response().as(User.class);
    }

    public Response deleteUser(String userId){
        return given().
                when().
                delete("/{userId}", userId).
                then().statusCode(204).
                extract().response();
    }
}