package org.trianz.eagleaccess.tests.practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class practiceRest {

    @Test(description = "Verify if the response code is 200",enabled = true)
    public static void testResponseCode(){
        Response response =  given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://demoqa.com/utilities/weather/city/chennai")
                .then()
                .extract().response();

        System.out.println("ResponseCode is "+response.getStatusCode());
        System.out.println("Response is "+response.asString());

    }


}
