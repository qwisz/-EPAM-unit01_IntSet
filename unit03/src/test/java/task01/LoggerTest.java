package task01;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anton on 08.03.2017.
 */
public class LoggerTest {

    Logger logger = new Logger();

    @Test
    public void containsText() throws Exception {

        String message = "Hello worlds!";
        String message2 = "New Hello World!";
        logger.log(message);
        logger.log(message2);

        assertThat(logger.contains(message),is(true));
    }

    @Test
    public void testTest(){

        String message = "HELLO WORLD";
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-YYYY:hh-mm--");

        sb.append(sdf.format(new Date())).append(message);

        String text = sb.toString();

        assertThat(text.contains(message),is(true));
    }

    @Test
    public void containsDate(){

        String message = "Hey you!";
        logger.log(message);
        Date date = new Date();

        assertThat(logger.contains(date),is(true));
    }

}