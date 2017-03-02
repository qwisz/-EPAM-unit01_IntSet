package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Stickers extends OfficeMaterials {

    private String format;

    public Stickers(String producer, String color, double price, String codeNumber, String format){

        super(producer, color, price, codeNumber);
        this.format = format;
    }
}
