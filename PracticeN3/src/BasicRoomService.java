public class BasicRoomService<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T room) {
        System.out.println("Cleaning room " + room.getRoomNumber());
    }

    @Override
    public void reserve(T room) {
        if (room.getBooked()) {
            throw new RoomIsBookedException("Room " + room.getRoomNumber() + " is booked!");
        }
        room.setBooked(true);
        System.out.println("Room " + room.getRoomNumber() + " reserved");
    }

    @Override
    public void free(T room) {
        room.setBooked(false);
        System.out.println("Room " + room.getRoomNumber() + " free");
    }
}