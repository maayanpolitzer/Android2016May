package com.company;

/**
 * Created by hackeru on 5/30/2016.
 */
public class Student extends Person {

    private String course;

    public Student(String firstName, String lastName, String course){
        super(firstName, lastName);
        this.course = course;
    }

    @Override
    public void sayHi() {
        System.out.println("Whatuppppppppp from student");
    }

    public String getCourse() {
        return course;
    }
}
