package task02;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SymbolIOStreamTest {

    private static final String filePath1 = "src/test/resources/hello.txt";
    private static final String filePath2 = "src/test/resources/writeHello2";
    private static final String filePath3 = "src/main/java/task01/ByteIOStream.java";

    SymbolIOStream symbolStream = new SymbolIOStream();

    @Test
    public void readFromFile() throws Exception {
        assertThat(symbolStream.readFromFile(filePath1),is("Привет, привет, мир!"));
    }

    @Test
    public void writeToFile() throws Exception {

        String text = "I wrote it in the file again\nIn three lines\nnow";
        symbolStream.writeToFile(text,filePath2);
        assertThat(symbolStream.readFromFile(filePath2),is(text));

    }

    @Test
    public void countKeywordAppereance(){

        String fileInString = symbolStream.readFromFile(filePath3);
        HashMap<String, Integer> map = symbolStream.processString(fileInString);
        assertThat(map.get("new"),is(4));
    }

    @Test
    public void replacementTest(){

        String bigString = "It is\nnew String\nand it will\nkeeewwwqqee ewqwe";
        assertThat(bigString.replaceAll("\n"," "),
                is("It is new String and it will keeewwwqqee ewqwe"));
    }

    @Test
    public void readWriteProcessTest(){

        symbolStream.taskExample(filePath3,"src/test/resources/symbolOutput.txt");

    }
}