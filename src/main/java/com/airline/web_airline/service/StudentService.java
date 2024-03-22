package com.airline.web_airline.service;

import com.airline.web_airline.model.Student;
import java.util.List;
public interface StudentService {
    public
    Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
