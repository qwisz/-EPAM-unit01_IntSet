package task06;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by Anton on 02.03.2017.
 */
public class NuclearSubmarineTest {

    NuclearSubmarine submarine;

    @Test
    public void testSubmarineMoving(){
        submarine = new NuclearSubmarine("Terror",123,100,
                new NuclearSubmarine.EngineForNuclearSubmarine(
                        "PWERQW",1000
                ));
        submarine.turnOn();
        assertThat(submarine.isMoving(),
                is(true));
    }
}