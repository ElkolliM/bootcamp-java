package com.stackroute.spring.model;

//Professor Model class
public class Professor {
    private int employeeId;
    private String professorName;
    private Course course;

    public Professor(int employeeId, String professorName, Course course) {
        this.employeeId = employeeId;
        this.professorName = professorName;
        this.course = course;
    }

    public  Professor(){}

    /*
     * This class should have three fields (employeeId, professorName, course).
     * Use @Autowired for Course field
     * This class should also contain the getters and setters for the fields
     */



    //No-arg constructor


    //Parameterized constructor to initialize employeeId and professorName


    @Override
    public String toString() {
        return "Professor{" +
                "employeeId=" + employeeId +
                ", professorName='" + professorName + '\'' +
                ", course=" + course +
                '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
