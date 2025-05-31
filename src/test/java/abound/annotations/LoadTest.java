package abound.annotations;

import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Test
public @interface LoadTest
{
        int invocationCount() default 1; // -1 means use default from config
        int threadPoolSize() default 1;
        boolean enabled() default true;
        String description() default "";
        String[] groups() default {};

}
