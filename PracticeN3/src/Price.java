public enum Price {
    ECONOMY(1000),
    STANDART(1600),
    LUX(4200);

    private final int Price;

    Price(int price)
    {
        Price = price;
    }

    public int getPrice(){ return  Price; }
}
