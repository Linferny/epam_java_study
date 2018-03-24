package javase02.t07.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Documented
public @interface AtomicAnnotation {
    boolean isBroken() default false;
    String createdBy();
}
