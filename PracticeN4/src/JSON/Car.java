package JSON;

public class Car {

    @JsonField(Name = "Brand")
    private final String Manufacturer;

    @JsonField(Name = "Model")
    private final String Model;

    private final int Year;

    public Car( String manufacturer, String model, int year)
    {
        Manufacturer = manufacturer;
        Model = model;
        Year = year;
    }
}
