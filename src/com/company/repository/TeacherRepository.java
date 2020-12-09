package com.company.repository;

import com.company.model.Course;
import com.company.model.Teacher;

import java.util.List;

public class TeacherRepository implements ICrudRepository<Teacher>{

    private List<Teacher> teachers;

    public TeacherRepository(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public Teacher findOne(long id) {
        for(Teacher t : teachers){
            if(t.getId() == id){
                return  t;
            }
        }
        return null;
    }

    @Override
    public Iterable findAll() {
        return teachers;
    }

    @Override
    public Teacher save(Teacher entity) {
        if(teachers.contains(entity)){
            return entity;
        }
        teachers.add(entity);
        return null;
    }

    @Override
    public Teacher delete(long id) {
        for(Teacher t : teachers) {
            if (t.getId().equals(id)) {
                Teacher to_be_deleted = t;
                teachers.remove(t);
                return to_be_deleted;
            }
        }
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        Teacher update_teacher = findOne(entity.getId());
        if(update_teacher != null) {
            update_teacher.setCourses(entity.getCourses());
            update_teacher.setFirstName(entity.getFirstName());
            update_teacher.setLastName(entity.getLastName());
            return null;
        }
        return entity;
    }
}
