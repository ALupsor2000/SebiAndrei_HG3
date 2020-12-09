package com.company.model;

import java.util.List;

public class Teacher extends Person{

    private long id;
    public List<Course> courses;

    public Teacher(String firstName, String lastName, long id, List<Course> courses) {
        super(firstName, lastName);
        this.id = id;
        this.courses = courses;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courses=" + courses +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
