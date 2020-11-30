package org.example.model;

import lombok.Data;

import java.util.List;
@Data
public class Teacher {
    private String name;
    private String age;
    private List<Student> students;
}
