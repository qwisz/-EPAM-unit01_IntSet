package task02;

import org.junit.Test;
import static org.junit.Assert.*;
import task03.Notebook;
import task03.Pen;
import static org.hamcrest.core.Is.is;

/**
 * Created by Anton on 02.03.2017.
 */
public class EmployeeTest {

    Employee emp = new Employee("Ivan","Ivanov",
            new Cubicle<>(
                    new Pen("Pilot","blue",215.23,"blue"),
                    new Notebook("aTauras","green",231,300,false)
            ));

    @Test
    public void costTest() throws Exception {

        assertThat(emp.cost(), is(215.23+231));
    }

}