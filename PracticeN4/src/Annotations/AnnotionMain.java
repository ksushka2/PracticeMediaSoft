package Annotations;

import java.security.Provider;

public class AnnotionMain {
    public static void main(String[] args) {
        ProcessorAnnotation.Process(OldService.class);

        OldService service = new OldService();
        System.out.println("\nTest methods:");
        service.testAnnotation1();
        service.testAnnotation2();
        service.testAnnotation3();
    }
}
