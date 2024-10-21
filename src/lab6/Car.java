package lab6;

public class Car {

    public enum CarType {
        MERCEDES,
        FIAT,
        SKODA
    }

    public int price;
    public CarType carType;
    public int year;

    public Car(int price, CarType carType, int year) {
        this.price = price;
        this.carType = carType;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", carType=" + carType +
                ", year=" + year +
                '}';
    }
}
