import com.company.model.Course;
import com.company.model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void TestGetter(){

        List<Course> curs = new ArrayList<>();
        Teacher t = new Teacher("Cristi", "Lazar", 111L, curs);

        assertEquals("Cristi", t.getFirstName());
        assertEquals("Lazar", t.getLastName());
        assertEquals(111L, t.getId());
        assertTrue(t.getCourses().isEmpty());
    }
}
