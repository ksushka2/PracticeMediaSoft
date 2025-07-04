public abstract class Room {
    private int RoomNumber;
    private int MaxPeople;
    private int Price;
    private boolean Booked;

    public Room(int roomNumber, int maxPeople, int price)
    {
        RoomNumber = roomNumber;
        MaxPeople = maxPeople;
        Price = price;
        Booked = false;
    }

    public int getRoomNumber() { return  RoomNumber; }
    public int getMaxPeople() { return  MaxPeople; }
    public int getPrice() { return Price; }
    public boolean getBooked() { return Booked; }
    public void setBooked(boolean booked) { Booked = booked; }
}
