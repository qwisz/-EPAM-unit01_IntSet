package task03;

import lombok.Getter;

/**
 * Created by Anton on 02.03.2017.
 */

@Getter
abstract class OfficeMaterials extends Stationers {

    private String codeNumber;

    OfficeMaterials(String producer, String color, double price, String codeNumber) {

        super(producer, color, price);
        this.codeNumber = codeNumber;
    }
}