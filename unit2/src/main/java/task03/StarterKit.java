package task03;

import java.util.*;

/**
 * Created by Anton on 02.03.2017.
 */

public class StarterKit<T> extends ArrayList<T> {

    public StarterKit(){
        super();
    }

    public StarterKit(T... t){
        super(Arrays.asList(t));
    }

    public StarterKit(List<T> t){
        super(t);
    }
}
