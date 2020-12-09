import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void TestGetter(){

        List<Course> curs = new ArrayList<>();
        Student s = new Student("Marian", "Gherman", 111L, 15,  curs);

        assertNotEquals("Cristi", s.getFirstName());
        assertEquals("Gherman", s.getLastName());
        assertEquals(111L, s.getStudentId());
        assertEquals(15, s.getTotalCredits());
        assertTrue(s.getEnrolledCourses().isEmpty());
    }
}