package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Pen extends WritingMaterials {

    public Pen(String producer, String color, double price, String inkColor){

        super(producer, color, price, inkColor);
    }
}
