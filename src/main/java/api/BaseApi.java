package api;

import utils.PropertyReader;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public class BaseApi {

    public BaseApi(){
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = PropertyReader.baseURL;
    }
}