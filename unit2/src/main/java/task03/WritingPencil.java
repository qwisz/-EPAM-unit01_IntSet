package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class WritingPencil extends WritingMaterials {

    private boolean eraser;

    public WritingPencil(String producer, String color, double price, String inkColor, boolean eraser){

        super(producer, color, price, inkColor);
        this.eraser = eraser;
    }
}
