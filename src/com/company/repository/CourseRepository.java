package com.company.repository;

import com.company.model.Course;

import java.util.List;


public class CourseRepository implements ICrudRepository<Course> {

    private List<Course> courses;

    public CourseRepository(List<Course> courses) {
        this.courses = courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }


    @Override
    public Course findOne(long id){
        for(Course c : courses){
            if(c.getId() == id){
                return  c;
            }
        }
        return null;
    }

    @Override
    public Iterable findAll() {
        return courses;
    }

    @Override
    public Course save(Course entity) {
        if(courses.contains(entity)){
            return entity;
        }
        courses.add(entity);
        return null;
    }

    @Override
    public Course delete(long id){
        for(Course c : courses) {
            if (c.getId().equals(id)) {
                Course to_be_deleted = c;
                courses.remove(c);
                return to_be_deleted;
            }
        }
        return null;
    }

    @Override
        public Course update(Course entity){
        Course update_course = findOne(entity.getId());
        if(update_course != null){
            update_course.setCredits(entity.getCredits());
            update_course.setStudentsEnrolled(entity.getStudentsEnrolled());
            update_course.setMaxEnrolled(entity.getMaxEnrolled());
            update_course.setTeacher(entity.getTeacher());
            update_course.setName(entity.getName());
            return null;
        }
        return entity;
    }
}
