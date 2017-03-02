package task02;

import lombok.Value;
import task03.StarterKit;

import java.util.Arrays;

/**
 * Created by Anton on 02.03.2017.
 */

@Value
class Cubicle<T> extends StarterKit<T> {

    public Cubicle(){
        super();
    }

    public Cubicle(T... t){
        super(Arrays.asList(t));
    }
}
