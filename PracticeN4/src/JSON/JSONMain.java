package JSON;

public class JSONMain {
    public static void main(String[] args) {
        Car MyCar = new Car("Cherry", "Arizzo8", 2023);

        try {
            String json = Serializator.Serielaze(MyCar);
            System.out.println("Object Car:");
            System.out.println(json);
        } catch (IllegalAccessException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
