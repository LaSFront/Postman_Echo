import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest2 {

    @Test
    void shouldReturnTextCyrillic() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Привет")
                .when()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("Hi"));
    }
}