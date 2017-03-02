package task03;

import lombok.Getter;

/**
 * Created by Anton on 01.03.2017.
 */

@Getter
abstract class DrawingMaterials extends Stationers {

    DrawingMaterials(String producer, String color, double price){
        super(producer, color, price);
    }
}
