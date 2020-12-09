package com.company;

import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseRepository;
import com.company.view.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class where program starts.
 */
public class StartApp {

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Start point");

        List<Course> c1 = new ArrayList<Course>();
        List<Course> c2 = new ArrayList<Course>();
        List<Course> c3 = new ArrayList<Course>();
        List<Course> c4 = new ArrayList<Course>();

        Teacher t1 = new Teacher("Claudiu", "Mino", 411, c1);
        Teacher t2 = new Teacher( "Dragos", "Ban",412, c2);

        Student s1 = new Student("Ana", "Popoviciu",111, 15, c1);
        Student s2 = new Student("Mirela", "Ionescu",112, 21, c2);
        Student s3 = new Student("Darius", "Marinovici",113, 17, c3);
        Student s4 = new Student("Ion", "Popescu",114, 17, c4);

        List<Student> l1 = new ArrayList<Student>();
        List<Student> l2 = new ArrayList<Student>();

        Course curs1 = new Course(84912, "Baze de date", t1, 75, l1, 5);
        Course curs2 = new Course(84913, "Informatica aplicata", t2, 90, l2, 6 );
        Course curs3 = new Course(84914,"Arhitectura calculatoarelor", t1, 75, l2, 6);

        List<Course> courses = new ArrayList<Course>();
        courses.add(curs1);
        courses.add(curs2);
        courses.add(curs3);

        CourseRepository courseRepo = new CourseRepository(courses);
        RegistrationSystem regSys = new RegistrationSystem(courseRepo);

        regSys.register(curs1, s1);
        regSys.register(curs1, s2);
        regSys.register(curs1, s3);
        regSys.register(curs2, s2);
        regSys.register(curs2, s4);
        regSys.register(curs3, s3);

        Menu menu = new Menu(regSys, courseRepo);
        menu.menu();
    }
}
