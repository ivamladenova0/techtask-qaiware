package api;

import objects.Register;
import objects.User;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class RegisterApi extends BaseApi {

    public RegisterApi(){
        super();
        basePath = String.format("register");
    }

    public Register registerUser(User newUser, String statusCode){
        return given().
                contentType("application/json; charset=UTF-8").
                body(newUser).
                when().
                post().
                then().statusCode(Integer.parseInt(statusCode)).
                extract().response().as(Register.class);
    }
}