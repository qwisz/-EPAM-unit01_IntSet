package task04;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Value
@AllArgsConstructor
public class Actor implements Serializable {

    private String firstName;

    private String lastName;
}