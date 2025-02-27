import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestApi {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://dashboard.aversiclinic.ge";
    }


    //მეთოდი ამოწმებს სტატუს კოდს და აბრუნებს response body-ს თუ სტატუს კოდი ემთხვევა 200-ს
    @Test
    public void restApi(){
        RestAssured.baseURI = "https://dashboard.aversiclinic.ge";

        given()
                .when()
                .get("api/pages/laboratory/ka")
                .then()
                .statusCode(200)
                .log().ifStatusCodeIsEqualTo(200);

    }
}