package task04;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;

@Value
@AllArgsConstructor
public class Movie implements Serializable {

    private String name;

    private String director;

    private ArrayList<Actor> actors;
}