import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car5> cars = new LinkedList<>();

    public boolean AddCar(Car5 car) {
        if (cars.contains(car)) {
            return false;
        }
        cars.add(car);
        return true;
    }

    public List<Car5> CarsByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double AveragePriceByType(CarType type) {
        return cars.stream()
                .filter(car -> car.getType() == type)
                .mapToDouble(Car5::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<Car5> CarsSortedByYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 5.1 Количество машин каждого типа
    public Map<CarType, Long> getCarTypeStatistics() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car5::getType, Collectors.counting()));
    }
    public Map<String, Car5> getOldestAndNewestCars() {
        Map<String, Car5> result = new HashMap<>();

        cars.stream()
                .min(Comparator.comparingInt(Car5::getYear))
                .ifPresent(car -> result.put("Oldest", car));

        cars.stream()
                .max(Comparator.comparingInt(Car5::getYear))
                .ifPresent(car -> result.put("Newest", car));

        return result;
    }
    public List<Car5> getAllCars() {
        return new ArrayList<>(cars);
    }
}
