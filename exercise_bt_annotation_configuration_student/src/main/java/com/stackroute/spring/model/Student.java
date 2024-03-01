package com.stackroute.spring.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Annotate the class with @Component so that spring framework will autodetect the class
 * for dependency injection
 *

 */

@Component(value = "student")

public class Student {
    private int studentId;
    private String studentName;
    private List<Course> courseList;

    public Student(int studentId, String studentName, List<Course> courseList) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseList = courseList;
    }
    public Student (){}

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseList=" + courseList +
                '}';
    }

    /**
     * This class should have three fields (studentId, studentName,courseList).
     * Use @Autowired annotation for courseList field
     * This class should also contain the getters and setters for the fields.
     */

    //No-arg constructor

    //Parameterized constructor to initialize studentId and studentName

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
