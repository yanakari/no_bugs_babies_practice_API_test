package org.example.api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    public static String createStudent(String body) {
        return given()
            .body(body)
            .contentType(ContentType.JSON)
            .when()
            .post("https://crudcrud.com/api/80a1a72808fd4adbb27d100d13a5c3be/student")
            .then()
            .assertThat()
            .statusCode(201)
            .body("$", hasKey("_id"))
            .extract()
            .path("_id");
    }

    public static void deleteStudent(String id) {
        given().delete("/student/" +id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
