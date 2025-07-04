package Annotations;

@DeprecatedEx(Message = "Use new class")

public class OldService {
    void testAnnotation1()
    {
        System.out.println("Test 1");
    }

    @DeprecatedEx(Message = "Use new method testAnnotation3")
    void testAnnotation2()
    {
        System.out.println("Old Test 2");
    }

    void testAnnotation3()
    {
        System.out.println("New Test 3");
    }
}
