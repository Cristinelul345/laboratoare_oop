package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rand = new Random(20);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch(taskNum) {
            case 1:
                // TODO: uncomment for Task1
                 Car mercedes1 = new Car(20000, Car.CarType.MERCEDES, 2019);
                 System.out.println(mercedes1);

                 Car fiat1 = new Car(7000, Car.CarType.FIAT, 2020);
                 System.out.println(fiat1);

                 Car skoda1 = new Car(12000, Car.CarType.SKODA, 2022);
                 System.out.println(skoda1);

                 Dealership dealership1 = new Dealership();
                 System.out.println(dealership1);

                break;
            case 2:
                // TODO: uncomment for Task2
                 List<Car> cars2 = new ArrayList<>();

                 cars2.add(new Car(20000, Car.CarType.MERCEDES, 2011));
                 cars2.add(new Car(35000, Car.CarType.MERCEDES, 2016));
                 cars2.add(new Car(3500, Car.CarType.FIAT, 2009));
                 cars2.add(new Car(7000, Car.CarType.FIAT, 2011));
                 cars2.add(new Car(12000, Car.CarType.SKODA, 2016));
                 cars2.add(new Car(25000, Car.CarType.SKODA, 2022));

                 Dealership dealership2 = new Dealership();

                 for (Car car : cars2) {
                     System.out.println("The price for " + car + " after applying discounts: " + dealership2.getFinalPrice(car) + "\n");
                 }

                break;
            case 3:
                // TODO: uncomment for Task3
                 Car mercedes3 = new Car(20000, Car.CarType.MERCEDES, 2020);
                 Dealership dealership3 = new Dealership();

                 dealership3.negotiate(mercedes3, new Offer() {
                     @Override
                     public int getDiscount(Car car) {
                         return (int) (car.price * 0.05);
                     }
                 });

                 System.out.println("Final price for " + mercedes3 + " " + dealership3.getFinalPrice(mercedes3));

                break;
            case 4:
                // TODO: uncomment for Task4
                 List<Car> cars4 = new ArrayList<>();
                 cars4.add(new Car(20000, Car.CarType.MERCEDES, 2020));
                 cars4.add(new Car(35000, Car.CarType.MERCEDES, 2022));
                 cars4.add(new Car(3500, Car.CarType.FIAT, 2009));
                 cars4.add(new Car(7000, Car.CarType.FIAT, 2011));
                 cars4.add(new Car(32000, Car.CarType.SKODA, 2016));

                // TODO: Add cars here

                 System.out.println("Before filtering");
                 for (Car car : cars4) {
                     System.out.println(car);
                 }

                // TODO: Remove expensive cars here
                cars4.removeIf((v) -> v.price > 25000);


                 System.out.println("After filtering");
                 for (Car car : cars4) {
                     System.out.println(car);
                 }

                break;
        }
    }
}

// TODO: Add your classes here

interface Offer {
    int getDiscount (Car car);
}

class Dealership {
    public class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            switch (car.carType) {
                case MERCEDES:
                    return car.price / 20;
                case FIAT:
                    return car.price / 10;
                case SKODA:
                    return (car.price * 3) / 20;
            }
            return 0;
        }
    }
    //change

    class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            switch (car.carType) {
                case MERCEDES:
                    return (2024 - car.year) * 300;
                case FIAT:
                    return (2024 - car.year) * 100;
                case SKODA:
                    return (2024 - car.year) * 150;
            }
            return 0;
        }
    }

    class SpecialOffer implements Offer {
        private final Random rand = new Random(20);
        private int randomNr;

        public SpecialOffer() {
            this.randomNr = rand.nextInt(1000);
        }

        @Override
        public int getDiscount(Car car) {
            return randomNr;
        }
    }

    public int getFinalPrice(Car car){
        int finalPrice = car.price;

        BrandOffer offer = new BrandOffer();
        DealerOffer offer2 = new DealerOffer();
        SpecialOffer offer3 = new SpecialOffer();

        finalPrice -= offer.getDiscount(car);
        finalPrice -= offer2.getDiscount(car);
        finalPrice -= offer3.getDiscount(car);

        return finalPrice;
    }

    public void negotiate(Car car, Offer offer) {
        int discount = offer.getDiscount(car);
        car.price -= discount;
        System.out.println("New price after negotiation: " + car.price + "\n");
    }
}