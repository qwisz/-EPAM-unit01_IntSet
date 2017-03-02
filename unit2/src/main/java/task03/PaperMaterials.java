package task03;

import lombok.Getter;

/**
 * Created by Anton on 02.03.2017.
 */

@Getter
abstract class PaperMaterials extends Stationers {

    private int numberOfPages;

    PaperMaterials(String producer, String color, double price, int numberOfPages){

        super(producer, color, price);
        this.numberOfPages = numberOfPages;
    }

}