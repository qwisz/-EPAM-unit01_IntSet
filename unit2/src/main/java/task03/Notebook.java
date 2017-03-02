package task03;

import lombok.Value;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
public class Notebook extends PaperMaterials {

    private boolean pictureOnFrontPage;

    public Notebook(String producer, String color, double price, int numberOfPages, boolean pictureOnFrontPage){

        super(producer,color, price, numberOfPages);
        this.pictureOnFrontPage = pictureOnFrontPage;
    }
}
