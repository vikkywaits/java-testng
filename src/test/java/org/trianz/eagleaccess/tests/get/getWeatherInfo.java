package org.trianz.eagleaccess.tests.get;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;

public class getWeatherInfo {

   @Test(description = "Verify if the response code is 200",enabled = false)
   public static void testResponseCode(){
       Response response =  given()
               .contentType(ContentType.JSON)
               .when()
               .get("http://demoqa.com/utilities/weather/city/chennai")
               .then()
               .extract().response();
       System.out.println(response.getStatusCode());
       System.out.println(response.asString());
       System.out.println(response.path("City").toString());
       System.out.println(response.path("Temperature").toString());
       System.out.println(response.path("Humidity").toString());

       assertThat(response.statusCode()).isEqualTo(200);
       Map<Object, Object> test = response.jsonPath().getMap("");
       System.out.println(test);
       System.out.println(test.get("City")+" - "+test.get("Temperature"));

       String strResponse = response.asString();
       Map<String,String> map = from(strResponse).get("");
       System.out.println(test);
       System.out.println(test.get("City")+" - "+test.get("Temperature"));

   }

    @Test(description = "Verify if the response code is 200",dataProvider = "cityData",enabled = false)
    public static void testRestResponseCode(String cityName){
        Response response =  given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://demoqa.com/utilities/weather/city/"+cityName)
                .then()
                .extract().response();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test(description = "Verify if the response code is 200")
    public static void testReqresResponseCode(){
        Response response =  given()
                .contentType(ContentType.JSON)
                .param("page","2")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .extract().response();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        Map<Object, Object> test = response.jsonPath().getMap("");
        System.out.println(test);
        System.out.println(test.get("page")+" - "+test.get("total"));
        System.out.println(test.get("data"));
        JsonPath jp = new JsonPath(response.asString());
        List<Map> dataValues = jp.getList("data");
        System.out.println(dataValues);
        System.out.println(dataValues.get(0).get("first_name"));
    }

    @DataProvider
    private static Object[][] cityData() {
        Object[][] data = new Object[][]{
                // Description  |  Channel Id  |  Expected status  |  Expected error
                new Object[]{"Chennai"},
                new Object[]{"Hydrabad"},
        };
        return data;
    }


}
