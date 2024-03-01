package com.stackroute.spring.config;

/*This class will contain the application-context for the application.
 * Define the following annotations:
 * @Configuration - Annotating a class with the @Configuration indicates that the
 *                  class can be used by the Spring IoC container as a source of
 *                  bean definitions
 * @ComponentScan- this annotation is used to search for the Spring components amongst the application.
 *
 * */

import com.stackroute.spring.model.Course;
import com.stackroute.spring.model.Professor;
import com.stackroute.spring.model.Student;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {

    @Bean(value = {"courseList"})
    public List<Course> courseList(){
        return new ArrayList<Course>();
    }
    @Bean(value = {"studentList"})
    public List<Student> studentList(){
        return new ArrayList<Student>();
    }

    @Bean(value = {"course"})
    public Course course(){
        return new Course();
    }
    @Bean (value = {"professor"})
    public Professor professor(){
        return new Professor(12,"majid",null);

    }






    //Define a bean for courseList


    //Define a bean for studentList


    //Define a bean for Course


    //Define a bean for professor


}
