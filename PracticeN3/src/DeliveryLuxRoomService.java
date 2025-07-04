public class DeliveryLuxRoomService implements LuxRoomService<LuxRoom> {
    @Override
    public void clean(LuxRoom room) {
        System.out.println("Cleaning lux room " + room.getRoomNumber());
    }

    @Override
    public void reserve(LuxRoom room) {
        if (room.getBooked()) {
            throw new RoomIsBookedException("Lux room is booked!");
        }
        room.setBooked(true);
        System.out.println("Lux room " + room.getRoomNumber() + " reserved");
    }

    @Override
    public void free(LuxRoom room) {
        room.setBooked(false);
        System.out.println("Lux room " + room.getRoomNumber() + " free");
    }

    @Override
    public void foodDelivery(LuxRoom room, String order) {
        System.out.println("Delivering food " + room.getRoomNumber() + ": " + order);
    }
}