package lab.createAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface Annotation {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Subject { String[] categories() default "default"; }

    @Subject(categories = {"Test", "Annotation"})
    public class TestClass {

    }
}
