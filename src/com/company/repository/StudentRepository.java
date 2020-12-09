package com.company.repository;

import com.company.model.Course;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository implements ICrudRepository<Student> {

    private List<Student> students;

    public StudentRepository(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }


    @Override
    public Student findOne(long id) {
        for(Student s : students){
            if(s.getStudentId() == id){
                return  s;
            }
        }
        return null;
    }

    @Override
    public Iterable findAll() {
        return students;
    }

    @Override
    public Student save(Student entity) {
        if(students.contains(entity)){
            return entity;
        }
        students.add(entity);
        return null;
    }

    @Override
    public Student delete(long id) {
        for(Student s : students) {
            if (s.getStudentId() == id){
                Student to_be_deleted = s;
                students.remove(s);
                return to_be_deleted;
            }
        }
        return null;
    }

    @Override
    public Student update(Student entity) {
       Student update_student = findOne(entity.getStudentId());
       if(update_student != null){
           update_student.setEnrolledCourses(entity.getEnrolledCourses());
           update_student.setTotalCredits(entity.getTotalCredits());
           update_student.setFirstName(entity.getFirstName());
           update_student.setLastName(entity.getLastName());
           return null;
       }
       return entity;
    }
}
