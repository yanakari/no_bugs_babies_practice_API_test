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
        RestAssured.baseURI = "https://crudcrud.com/api/31ed61ebe0514fc2acc01e65f6d3efff";

        //Принцип программирования DRY=DO NOT REPEAT YOURSELF
    }
    @Test
    public void userShouldBeAbleToCreateStudent() {

        //given-when-then BDD

        //серилизация из json в объект и наоборот
        Student student = Student.builder().name("Саша Осипов").grade(2).build();

        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {
        //принципы разработки API тестов
        //1.Атомарность
        //2.Тест сам себе готовит данные

        //Шаг 1: Создание студента
        Student student = Student.builder().name("Саша Осипов").grade(2).build();
        Student createdStudent = StudentRequests.createStudent(student);

        //Шаг 2: Удаление студента

        StudentRequests.deleteStudent(createdStudent.getId());

        //Шаг 3: Проверить, что студент больше не существует
        given()
                .get("/student/" + createdStudent.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
