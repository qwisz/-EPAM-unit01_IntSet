package task03;

import lombok.Getter;

/**
 * Created by Anton on 02.03.2017.
 */

@Getter
abstract class WritingMaterials extends Stationers {

    private String inkColor;

    WritingMaterials(String producer, String color,double price, String inkColor){

        super(producer, color, price);
        this.inkColor = inkColor;
    }

}
