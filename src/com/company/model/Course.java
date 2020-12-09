package com.company.model;

import java.util.List;

public class Course {

    private long id;
    public String name;
    public Person teacher;
    public int maxEnrolled;
    public List<Student> studentsEnrolled;
    public int credits;

    public Course() {
    }

    public Course(long Id, String Name, Person Teacher, int MaxEnrolled, List StudentsEnrolled, int Credits) {
        id = Id;
        name = Name;
        teacher = Teacher;
        maxEnrolled = MaxEnrolled;
        studentsEnrolled = StudentsEnrolled;
        credits = Credits;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public void setMaxEnrolled(int maxEnrolled) {
        this.maxEnrolled = maxEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public int getMaxEnrolled() {
        return maxEnrolled;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }
    
    public void addStudent(Student student){
        studentsEnrolled.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxEnrolled=" + maxEnrolled +
                ", studentsEnrolled=" + studentsEnrolled +
                ", credits=" + credits +
                '}';
    }
}
