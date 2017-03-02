package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Clip extends OfficeMaterials {

    private String material;

    public Clip(String producer, String color, double price, String codeNumber, String material){

        super(producer, color, price, codeNumber);
        this.material = material;
    }
}
