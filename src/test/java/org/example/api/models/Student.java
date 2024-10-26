package org.example.api.models;

public class Student {
    private String  name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public String toJson() {
        return "{\"name\":\"" + name + "\", \"grade\":" + grade + "}";
    }
}
