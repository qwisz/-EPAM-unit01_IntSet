package task07;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Anton on 02.03.2017.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    String language() default "Java";
    String info() default "Annotation example";
}
