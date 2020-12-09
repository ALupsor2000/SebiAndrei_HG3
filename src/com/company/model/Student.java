package com.company.model;

import java.util.List;

public class Student extends Person{

    public long studentId;
    public int totalCredits;
    public List<Course> enrolledCourses;

    public Student(String firstName, String lastName, long studentId, int totalCredits, List<Course> enrolledCourses) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public long getStudentId() {
        return studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", totalCredits=" + totalCredits +
                ", enrolledCourses=" + enrolledCourses +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
