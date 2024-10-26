package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/80a1a72808fd4adbb27d100d13a5c3be";

        //Принцип программирования DRY=DO NOT REPEAT YOURSELF
    }
    @Test
    public void userShouldBeAbleToCreateStudent() {

        //given-when-then BDD

        //серилизация из json в объект и наоборот
        Student student = new Student("Саша Осипов", 2 );

       StudentRequests.createStudent(student.toJson());
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {
        //принципы разработки API тестов
        //1.Атомарность
        //2.Тест сам себе готовит данные

        //Шаг 1: Создание студента
        Student student = new Student("Саша Осипов", 2 );
        String id = StudentRequests.createStudent(student.toJson());

        //Шаг 2: Удаление студента

        StudentRequests.deleteStudent(id);

        //Шаг 3: Проверить, что студент больше не существует
        given()
                .get("/student/" +id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
