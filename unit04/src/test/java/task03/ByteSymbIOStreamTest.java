package task03;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class ByteSymbIOStreamTest {

    private static final String filePath1 = "src/test/resources/hello.txt";
    private static final String filePath2 = "src/test/resources/writeHello3";

    ByteSymbIOStream bsStream = new ByteSymbIOStream();

    @Test
    public void readFileTest(){
        assertThat(bsStream.readFromFile(filePath1),is("Привет, привет, мир!"));
    }

    @Test
    public void writeFileTest(){
        bsStream.writeToFile("Кодировка -- хрупкая вещь.",filePath2);
        assertThat(bsStream.readFromFile(filePath2),not("Кодировка -- хрупкая вещь."));
    }

}