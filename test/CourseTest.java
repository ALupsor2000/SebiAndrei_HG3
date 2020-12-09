import com.company.model.Course;
import com.company.model.Person;
import com.company.model.Student;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    public void TestCourse(){
        Course c = new Course(1, "TestCurs", new Person("Mirel", "Firu"), 75, new ArrayList<Student>(), 5);
        assertNotNull(c.getStudentsEnrolled());
        assertEquals("TestCurs", c.getName());
        assertEquals(75, c.getMaxEnrolled());
        assertEquals(5, c.getCredits());
    }
}
