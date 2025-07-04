public class Main {
    public static void main(String[] args) {

        EconomyRoom economyRoom = new EconomyRoom(101);
        System.out.println("Room 101; People: " + economyRoom.getMaxPeople() + "; Price: " + economyRoom.getPrice() + "; Is Booked: " + economyRoom.getBooked());
        StandardRoom standardRoom = new StandardRoom(201);
        System.out.println("Room 201; People: " + standardRoom.getMaxPeople() + "; Price: " + standardRoom.getPrice() + "; Is Booked: " + standardRoom.getBooked());
        LuxRoom luxRoom = new LuxRoom(301);
        System.out.println("Room 301; People: " + luxRoom.getMaxPeople() + "; Price: " + luxRoom.getPrice() + "; Is Booked: " + luxRoom.getBooked());
        UltraLuxRoom ultraLuxRoom = new UltraLuxRoom(401);
        System.out.println("Room 401; People: " + ultraLuxRoom.getMaxPeople() + "; Price: " + ultraLuxRoom.getPrice() + "; Is Booked: " + ultraLuxRoom.getBooked());

        BasicRoomService<Room> basicService = new BasicRoomService<>();

        try {
            System.out.println("\nTesting basic service:");
            basicService.reserve(economyRoom);
            basicService.reserve(standardRoom);
            basicService.clean(economyRoom);
            basicService.free(standardRoom);

            basicService.reserve(economyRoom);
        } catch (RoomIsBookedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        DeliveryLuxRoomService luxService = new DeliveryLuxRoomService();

        //luxService.foodDelivery(economyRoom, "Tea");

        try {
            System.out.println("\nTesting lux service:");
            luxService.reserve(luxRoom);
            luxService.foodDelivery(luxRoom, "Strawberries");
            luxService.clean(luxRoom);

            try {
                luxService.reserve(luxRoom);
            } catch (RoomIsBookedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            luxService.free(luxRoom);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
