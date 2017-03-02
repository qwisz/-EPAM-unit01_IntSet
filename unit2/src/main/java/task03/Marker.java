package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Marker extends WritingMaterials {

    private boolean isFull;

    public Marker(String producer, String color,  double price, String inkColor, boolean isFull){

        super(producer, color, price, inkColor);
        this.isFull = isFull;
    }
}
