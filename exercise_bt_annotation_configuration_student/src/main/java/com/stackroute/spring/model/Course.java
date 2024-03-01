package com.stackroute.spring.model;

import java.util.List;

public class Course {

    private String courseId;
    private String courseName;
    private List<Student> studentList;

    public Course(String courseId, String courseName, List<Student> studentList) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentList = studentList;
    }



    /**
     * This class should have three fields (courseId, courseName,studentList).
     * Use @Autowired for studentList field
     * This class should also contain the getters and setters for the fields.
     */


    //No-arg constructor
    public Course() {
    }

    //parameterized constructor to initialize courseId and courseName


    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
