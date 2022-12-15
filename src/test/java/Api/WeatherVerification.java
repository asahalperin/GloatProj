package Api;

import Extensions.Verify.Verify;
import Utilities.CommonOps;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class WeatherVerification extends CommonOps {
    @Test(priority = 1, testName =  "Verify Temperature in location")
    public void VerifyTemperature() {
        RestAssured.baseURI = environment().url();
        String response = given().log().all()
                .queryParam("zip", "20852,us")
                .queryParam("appid", "808ccd65fdb0d9ef62b219d282c562d4")
                .header("Content-Type", "application/json")
                .when().post("data/2.5/weather")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        double tempValue = js.getDouble("main.temp");
        System.out.println(tempValue);
        Verify.valueBetweenPercent(tempValue, 270, 10);
    }
}
