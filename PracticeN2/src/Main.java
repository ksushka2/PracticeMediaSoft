import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CarsPark1();
        CarsManagement2();
        Car3();
        StreamAPI4();
    }
//Задание 1
    public static void CarsPark1(){
        System.out.println("N1");
        int[] Cars = new int[50];
        int Sum = 0;

        System.out.println("Cars > 2015: ");
        for(int i=0; i<Cars.length; i++){
            Random random = new Random();
            Cars[i] = random.nextInt(2000, 2026);

            Sum += Cars[i];

            if (Cars[i] > 2015)
            {
                System.out.println(Cars[i]);
            }
        }

        double Average = (double) Sum / Cars.length;

        System.out.println("Average age: " + Average);
    }
//Задание 2
    public static void CarsManagement2()
    {
        System.out.println("N2");
        LinkedList<String> Cars = new LinkedList<String>();

        Cars.add("Lada Granta");
        Cars.add("Tesla Cybertruck");
        Cars.add("Cherry Arrizo8");
        Cars.add("Lada Granta");

        System.out.println("Cars: "+Cars);

        Set<String> UniqueCars=new HashSet<>(Cars);
        List<String> sortedModelsCars=new ArrayList<>(UniqueCars);

        Collections.sort(sortedModelsCars,Collections.reverseOrder());
        System.out.println("Sort Cars: "+sortedModelsCars);

        for (int i=0; i<sortedModelsCars.size();i++){
            String modelName=sortedModelsCars.get(i);
            if (modelName.contains("Tesla")){
                sortedModelsCars.set(i,"ELECTRO_CAR");
            }
        }

        System.out.println("Reset Name: "+ sortedModelsCars);
    }
//Задание 3
    public static void Car3()
    {
        Set<Car> CAR = new TreeSet<>();

        Car Car1 = new Car("QWERTYUIOP1234567", "Granta", "Lada", 2016, 50000, 500000);
        Car Car2 = new Car("QWERTYUIOP1111111", "Vesta", "Lada", 2020, 400000, 1000000);
        Car Car3 = new Car("QWERTYUIOP2222222", "Arrizo8", "Cherry", 2025, 1000, 2000000);
        Car Car4 = new Car("QWERTYUIOP1234567", "Granta", "Lada", 2016, 50000, 500000);

        CAR.add(Car1);
        CAR.add(Car2);
        CAR.add(Car3);
        CAR.add(Car4);
        System.out.println("N3");
        System.out.println("Sort: ");
        CAR.forEach(System.out::println);
    }
//Задание 4
    public static void StreamAPI4()
    {
        System.out.println("N4");

        List<Car> CarAPI = new LinkedList<Car>();
        Car Car1 = new Car("QWERTYUIOP1234567", "Granta", "Lada", 2016, 50000, 500000);
        Car Car2 = new Car("QWERTYUIOP1111111", "Vesta", "Lada", 2020, 400000, 1000000);
        Car Car3 = new Car("QWERTYUIOP2222222", "Arrizo8", "Cherry", 2025, 1000, 2000000);
        Car Car4 = new Car("QWERTYUIOP1234567", "Granta", "Lada", 2016, 50000, 500000);

        CarAPI.add(Car1);
        CarAPI.add(Car2);
        CarAPI.add(Car3);
        CarAPI.add(Car4);

        List<Car> FilterCarAPI = CarAPI.stream().filter(car -> car.getMileage() > 50000).toList();
        System.out.println("Filter Mileage:");
        FilterCarAPI.forEach(System.out::println);

        List<Car> SortedCarAPI = CarAPI.stream().sorted(Comparator.comparingDouble(Car::getPrice)).toList().reversed();
        System.out.println("Sorted Price:");
        SortedCarAPI.forEach(System.out::println);

        System.out.println("Top 3 Price:");
        for (int i = 0; i < 3 && i < SortedCarAPI.size(); i++)
        {
            System.out.println(SortedCarAPI.get(i));
        }

        double sum = 0;
        for (int i = 0; i < SortedCarAPI.size(); i++)
        {
            sum += SortedCarAPI.get(i).getMileage();
        }

        double AverageMileage = sum / SortedCarAPI.size();

        System.out.println("Average Mileage = "+AverageMileage);

        Map<String, List<Car>> map = CarAPI.stream().collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Group by Manufacturer: ");
        map.forEach((manufacturer, carList) -> {
            System.out.println(manufacturer + ":");
            carList.forEach(System.out::println);
        });
    }

}