package com.stackroute.spring;

import com.stackroute.spring.config.AppConfig;
import com.stackroute.spring.model.Course;
import com.stackroute.spring.model.Professor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This class is only for self testing whether beans are created by printing bean property values
 * Not a mandatory class to complete while submitting to hobbes
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course = context.getBean("course",Course.class);
        Professor professor =context.getBean("professor",Professor.class);
        System.out.println(course);
        System.out.println(professor);

        //Application Context to be created to access the spring beans


    }
}
