import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DealershipMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarDealership dealership = new CarDealership();

        // Добавим несколько машин для примера
        dealership.AddCar(new Car5("VIN1", "Model S", "Tesla", 2022, 15000, 85000.0, CarType.ELECTRONIC));
        dealership.AddCar(new Car5("VIN2", "Camry", "Toyota", 2021, 25000, 30000.0, CarType.SEDAN));
        dealership.AddCar(new Car5("VIN3", "RAV4", "Toyota", 2023, 10000, 35000.0, CarType.SUV));
        dealership.AddCar(new Car5("VIN4", "MX-5", "Mazda", 2020, 18000, 28000.0, CarType.CABRIOLET));
        dealership.AddCar(new Car5("VIN5", "Bolt", "Chevrolet", 2022, 20000, 27000.0, CarType.ELECTRONIC));

        while (true) {
            System.out.println("\nМеню автоцентра:");
            System.out.println("1. Добавить машину");
            System.out.println("2. Найти машины по производителю");
            System.out.println("3. Средняя цена машин по типу");
            System.out.println("4. Список машин (от новых к старым)");
            System.out.println("5. Статистика по типам машин");
            System.out.println("6. Самая старая и новая машина");
            System.out.println("7. Показать все машины");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCarMenu(scanner, dealership);
                    break;
                case 2:
                    findCarsByManufacturerMenu(scanner, dealership);
                    break;
                case 3:
                    averagePriceByTypeMenu(scanner, dealership);
                    break;
                case 4:
                    showCarsSortedByYear(dealership);
                    break;
                case 5:
                    showCarTypeStatistics(dealership);
                    break;
                case 6:
                    showOldestAndNewestCars(dealership);
                    break;
                case 7:
                    showAllCars(dealership);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void addCarMenu(Scanner scanner, CarDealership dealership) {
        System.out.println("\nДобавление новой машины:");

        System.out.print("VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Модель: ");
        String model = scanner.nextLine();

        System.out.print("Производитель: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Год выпуска: ");
        int year = scanner.nextInt();

        System.out.print("Пробег: ");
        int mileage = scanner.nextInt();

        System.out.print("Цена: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Доступные типы:");
        for (CarType type : CarType.values()) {
            System.out.println(type.ordinal() + ". " + type);
        }
        System.out.print("Выберите тип: ");
        int typeIndex = scanner.nextInt();
        scanner.nextLine(); // consume newline

        CarType type = CarType.values()[typeIndex];

        Car5 newCar = new Car5(vin, model, manufacturer, year, mileage, price, type);
        if (dealership.AddCar(newCar)) {
            System.out.println("Машина успешно добавлена!");
        } else {
            System.out.println("Ошибка: машина с таким VIN уже существует.");
        }
    }

    private static void findCarsByManufacturerMenu(Scanner scanner, CarDealership dealership) {
        System.out.print("\nВведите производителя: ");
        String manufacturer = scanner.nextLine();

        List<Car5> foundCars = dealership.CarsByManufacturer(manufacturer);

        if (foundCars.isEmpty()) {
            System.out.println("Машины производителя " + manufacturer + " не найдены.");
        } else {
            System.out.println("Найденные машины:");
            foundCars.forEach(System.out::println);
        }
    }

    private static void averagePriceByTypeMenu(Scanner scanner, CarDealership dealership) {
        System.out.println("\nДоступные типы:");
        for (CarType type : CarType.values()) {
            System.out.println(type.ordinal() + ". " + type);
        }
        System.out.print("Выберите тип для расчета средней цены: ");
        int typeIndex = scanner.nextInt();
        scanner.nextLine(); // consume newline

        CarType type = CarType.values()[typeIndex];
        double averagePrice = dealership.AveragePriceByType(type);

        System.out.printf("Средняя цена машин типа %s: %.2f\n", type, averagePrice);
    }

    private static void showCarsSortedByYear(CarDealership dealership) {
        System.out.println("\nСписок машин (от новых к старым):");
        List<Car5> sortedCars = dealership.CarsSortedByYear();
        sortedCars.forEach(System.out::println);
    }

    private static void showCarTypeStatistics(CarDealership dealership) {
        System.out.println("\nСтатистика по типам машин:");
        Map<CarType, Long> stats = dealership.getCarTypeStatistics();
        stats.forEach((type, count) -> System.out.println(type + ": " + count));
    }

    private static void showOldestAndNewestCars(CarDealership dealership) {
        System.out.println("\nСамая старая и новая машина:");
        Map<String, Car5> cars = dealership.getOldestAndNewestCars();

        System.out.println("Самая старая: " + cars.get("Oldest"));
        System.out.println("Самая новая: " + cars.get("Newest"));
    }

    private static void showAllCars(CarDealership dealership) {
        System.out.println("\nВсе машины в автоцентре:");
        dealership.getAllCars().forEach(System.out::println);
    }
}
