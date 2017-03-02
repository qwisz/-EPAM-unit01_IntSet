package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Eraser extends DrawingMaterials {

    private String shape;

    public Eraser(String producer, String color, double price, String shape){

        super(producer, color, price);
        this.shape = shape;
    }
}
