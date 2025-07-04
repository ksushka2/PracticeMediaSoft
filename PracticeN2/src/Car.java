//Задание 3
import java.util.Objects;

public class Car implements Comparable<Car> {
    private String VIN;
    private String Model;
    private String Manufacturer;
    private int Year;
    private int Mileage;
    private double Price;

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price)
    {
        VIN = vin;
        Model = model;
        Manufacturer = manufacturer;
        Year = year;
        Mileage = mileage;
        Price = price;
    }

    public String getVin()
    {
        return VIN;
    }
    public String getModel()
    {
        return Model;
    }
    public String getManufacturer()
    {
        return Manufacturer;
    }
    public int getYear()
    {
        return Year;
    }
    public int getMileage()
    {
        return Mileage;
    }
    public double getPrice()
    {
        return Price;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(VIN, car.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(VIN);
    }

    @Override
    public String toString() {
        return "Car: " +
                "VIN=" + VIN +
                ", Model=" + Model +
                ", Manufacturer=" + Manufacturer +
                ", Year=" + Year +
                ", Mileage=" + Mileage +
                ", Price=" + Price;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.Year, this.Year); // Сортировка по убыванию года
    }
}
