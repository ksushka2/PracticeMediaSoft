package Annotations;

import java.lang.classfile.Annotation;
import java.lang.reflect.Method;

public class ProcessorAnnotation {
    public static void Process(Class<?> clas)
    {
        if (clas.isAnnotationPresent(DeprecatedEx.class))
        {
            DeprecatedEx annotation = clas.getAnnotation(DeprecatedEx.class);
            String message = annotation.Message();
            System.out.println("Warning: Method " + clas.getSimpleName() + " is deprecated. Alternative: " + message);
        }
        for (Method method : clas.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx methodAnnotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("Warning: Method " + method.getName() + " is deprecated. Alternative: " + methodAnnotation.Message());
            }
        }
    }
}
