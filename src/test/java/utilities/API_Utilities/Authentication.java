package utilities.API_Utilities;

import config_Requirements.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class Authentication{
    public static String generateToken(String user) {

        JSONObject reqBody = null;

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url","api")).build();

        switch (user) {
            case "admin":
                spec.pathParams("pp1", "api", "pp2", "getToken");
                reqBody = new JSONObject();
                reqBody.put("email", ConfigReader.getProperty("adminEmail","api"));
                reqBody.put("password", ConfigReader.getProperty("adminPassword","api"));
                break;
            case "teacher":
                spec.pathParams("pp1", "api", "pp2", "getToken");
                reqBody = new JSONObject();
                reqBody.put("email", ConfigReader.getProperty("teacherEmail","api"));
                reqBody.put("password", ConfigReader.getProperty("teacherPassword","api"));
                break;
            case "student":
                spec.pathParams("pp1", "apistudent", "pp2", "getToken");
                reqBody = new JSONObject();
                reqBody.put("email", ConfigReader.getProperty("studentEmail","api"));
                reqBody.put("password", ConfigReader.getProperty("studentPassword","api"));
                break;
        }

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(reqBody.toString())
                .post("/{pp1}/{pp2}");


        JsonPath repJP = response.jsonPath();

        String token = repJP.getString("token");
        System.out.println("Token : " +  token);
        return token;
    }
}
