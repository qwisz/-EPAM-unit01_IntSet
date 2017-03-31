package task02;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class PropertyReader implements AutoCloseable{

    @Getter
    public String path;

    @Getter
    private Map<String, String> map = null;

    public PropertyReader(String path){

        this.path = path;
    }

    private void readPropFile(String path) {

        try(BufferedReader bReader = new BufferedReader(
                new FileReader(path))){

            map =  bReader.lines()
                    .filter(line -> line.trim().charAt(0)!='#')
                    .collect(Collectors.toMap(
                            l -> l.split("=")[0].trim(),
                            l -> l.split("=")[1].trim()
                    ));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        map = null;
    }

    public String readProperty(String propName) throws NoSuchPropertyException {

        if (map == null)
            readPropFile(path);

        if (!map.containsKey(propName))
            throw new NoSuchPropertyException("No such property in this file!");
        else return map.get(propName);

    }
}