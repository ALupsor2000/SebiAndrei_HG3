import com.company.*;

import com.company.controller.RegistrationSystem;
import com.company.model.Course;
import com.company.model.Person;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RegistrationSystemTest {

    CourseRepository courseRepository;
    RegistrationSystem registrationSystem;
    Course curs1;
    Course curs2;
    Course curs3;
    Student s1;
    Student s2;
    Student s3;
    Student s4;
    Teacher t1;
    Teacher t2;

    @BeforeEach
    public void Initialize(){

        List<Course> c1 = new ArrayList<Course>();
        List<Course> c2 = new ArrayList<Course>();
        List<Course> c3 = new ArrayList<Course>();
        List<Course> c4 = new ArrayList<Course>();


        t1 = new Teacher("Claudiu", "Mino", 411L, c1);
        t2 = new Teacher( "Dragos", "Ban",412L, c2);

        s1 = new Student("Ana", "Popoviciu",111L, 15, c1);
        s2 = new Student("Mirela", "Ionescu",112L, 21, c2);
        s3 = new Student("Darius", "Marinovici",113L, 17, c3);
        s4 = new Student("Ion", "Popescu",114L, 17, c4);

        List<Student> l1 = new ArrayList<Student>();
        List<Student> l2 = new ArrayList<Student>();

        curs1 = new Course(1,"Baze de date", t1, 75, l1, 5);
        curs2 = new Course(2,"Informatica aplicata", t2, 90, l2, 6 );
        curs3 = new Course(3,"Arhitectura calculatoarelor", t1, 75, l2, 6);

        List<Course> courses = new ArrayList<Course>();
        courses.add(curs1);
        courses.add(curs2);
        courses.add(curs3);

        courseRepository = new CourseRepository(courses);

        registrationSystem = new RegistrationSystem(courseRepository);

        registrationSystem.register(curs1, s1);
        registrationSystem.register(curs1, s2);
        registrationSystem.register(curs1, s3);
        registrationSystem.register(curs2, s2);
        registrationSystem.register(curs2, s4);
        registrationSystem.register(curs3, s3);
    }

    @Test
    public void register() {
        assertTrue(registrationSystem.register(curs1, s4));
        assertTrue(registrationSystem.register(curs2, s1));
        assertFalse(registrationSystem.register(curs2, s4));
        assertFalse(registrationSystem.register(curs3, s3));
    }

    @Test
    public void retrieveCoursesWithFreePlaces() {
        assertNotNull(registrationSystem.retrieveCoursesWithFreePlaces());
    }

    @Test
    public void getAll(){
        assertNotNull(registrationSystem.getAllCourses());
    }
}