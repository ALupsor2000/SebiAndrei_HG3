package com.company.controller;

import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {

    CourseRepository courses;

    // Constructor pentru clasa RegistrationSystem
    public RegistrationSystem(CourseRepository courses) {
        this.courses = courses;
    }

    /**
     *
     * @param course in wich you want to register student
     * @param student you want to enroll
     * @return true if student was succsefully added, false otherwise
     */
    public boolean register(Course course, Student student){

        //verifica daca studentul se afla deja in lista de studenti a cursului
        for(int i=0; i <= course.getStudentsEnrolled().size()-1; i++) {
            if (student == course.getStudentsEnrolled().get(i)) {
                System.out.println("You are enrolled in this course. Choose another one");
                return false;
            }
        }

        //verifica disponibilitatea locurilor cursului
        if(course.getStudentsEnrolled().size() == course.getMaxEnrolled()){
                    System.out.println("The course you are trying to join is full");
                    return false;
            }
        //daca exista locuri, atunci verifcam daca studetnul va avea mai mult de 30 de credite dupa adaugarea acestui curs
        else if(student.getTotalCredits() + course.getCredits() > 30){
            System.out.println("You already have 30 credits");
            return false;
        }
        //daca toate conditiile sunt indeplinite, adaugam cursului noul student si modificam numarul de credite pentru acest student
        else {
            course.addStudent(student);
            student.setTotalCredits(student.getTotalCredits() + course.getCredits());
            return true;
        }
    }

    public List<Course> retrieveCoursesWithFreePlaces(){

        // lista de cursuri cu locuri libere, care este null la inceput
        List<Course> freePlace = new ArrayList<>();

        for(int i=0; i <= courses.getCourses().size()-1; i++){
            // daca conditia ca numarul alocat de locuri libere nu depaseste numarul total de locuri
            // atunci inseram in lista freePlace cursul
            if(courses.getCourses().get(i).getStudentsEnrolled().size()<courses.getCourses().get(i).getMaxEnrolled()){
                freePlace.add(courses.getCourses().get(i));
            }
        }
        return freePlace;
    }

    /**
     *
     * @param course to show enrolled students
     * @return list of students enrolled in a course
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course course){
        return course.getStudentsEnrolled();
    }

    /**
     *
     * @return list with all courses
     */
    public List<Course> getAllCourses(){

        // lista de tip Course
        List<Course> cursuri = new ArrayList<>();

        // din lista din CourseRepository preiau toate cursurile si le introduc in lista cursuri
        for(int i=0; i <= courses.getCourses().size()-1; i++){
            cursuri.add(courses.getCourses().get(i));
        }
        return cursuri;
    }

}
