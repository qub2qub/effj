package effj.ch07.item44;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is a test method that must throw the designated exception to
 * succeed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {

    /**
     * The exception that the annotated test method must throw in order to pass. (The test is
     * permitted to throw any subtype of the type described by this class object.)
     */
    Class<? extends Exception> value();
}