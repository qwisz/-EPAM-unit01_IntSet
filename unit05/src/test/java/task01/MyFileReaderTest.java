package task01;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyFileReaderTest {

    public static final String PATH = "src/test/resources/";
    public static final String DELETE_IN_FUTURE_TXT = "deleteInFuture.txt";

    @Test
    public void readFile() throws Exception {
        try(MyFileReader mfReader = new MyFileReader(PATH + "example.txt")){
            assertThat(mfReader.readFile().orElse("Error"),is("Test reading file"));
        }
    }

    @Test
    public void writeFile() throws Exception {
        String checkText = "Read/write example";
        try(MyFileReader mfReader = new MyFileReader(PATH + "example2.txt")){
            mfReader.writeFile(checkText);
            assertThat(mfReader.readFile().orElse("Error"),is(checkText));
        }
    }

    @Test
    public void deleteFile() throws Exception {
        try(MyFileReader mfReader = new MyFileReader(PATH)){
            mfReader.createFile(PATH+ DELETE_IN_FUTURE_TXT);
            assertThat(mfReader.allFilesInDir().contains(DELETE_IN_FUTURE_TXT),is(true));
            mfReader.deleteFile(PATH+DELETE_IN_FUTURE_TXT);
            assertThat(mfReader.allFilesInDir().contains(DELETE_IN_FUTURE_TXT),is(false));
        }
    }

}