package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Notepad extends PaperMaterials {

    private String format;

    public Notepad(String producer, String color, double price, int numberOfPages, String format){

        super(producer, color, price, numberOfPages);
        this.format = format;
    }
}
