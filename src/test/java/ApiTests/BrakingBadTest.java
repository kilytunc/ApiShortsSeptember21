package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BrakingBadTest {

    String spartanBaseUrl = "http://54.205.239.177:8000";


    @Test
    public void spartanTest1(){
        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println(response.body().print());
        System.out.println(response.body().prettyPrint());
    }
}


