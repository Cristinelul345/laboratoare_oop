package lab4.main;

import java.util.*;

class Helpers {
    public static final String TOYOTA = "Toyota";
    public static final String HONDA = "Honda";
    public static final String FORD = "Ford";
    public static final String CHEVROLET = "Chevrolet";
    public static final String BMW = "BMW";
    public static final String MERCEDES_BENZ = "Mercedes-Benz";
    public static final String AUDI = "Audi";
    public static final String VOLKSWAGEN = "Volkswagen";
    public static final String NISSAN = "Nissan";
    public static final String HYUNDAI = "Hyundai";
    public static final String KIA = "Kia";
    public static final String MAZDA = "Mazda";
    public static final String SUBARU = "Subaru";
    public static final String JEEP = "Jeep";
    public static final String RAM = "Ram";
    public static final String GMC = "GMC";
    public static final String LEXUS = "Lexus";
    public static final String ACURA = "Acura";
    public static final String INFINITI = "Infiniti";

    public static void addSellers() {
        Database.getDatabase().addSellers(new ArrayList<>( Arrays.asList(
                new Seller("AutoRomânia", Arrays.asList(TOYOTA, HONDA, FORD)),
                new Seller("AutoLux", Arrays.asList(CHEVROLET, BMW, MERCEDES_BENZ)),
                new Seller("Mașini de Vis", Arrays.asList(AUDI, VOLKSWAGEN, NISSAN)),
                new Seller("AutoCity", Arrays.asList(HYUNDAI, KIA, MAZDA)),
                new Seller("Drumuri Off-Road", Arrays.asList(SUBARU, JEEP, RAM)),
                new Seller("Grup AutoElite", Arrays.asList(GMC, LEXUS, ACURA)),
                new Seller("AutoInfinit", Arrays.asList(INFINITI, TOYOTA, HONDA)),
                new Seller("AutoViteză", Arrays.asList(FORD, CHEVROLET, BMW)),
                new Seller("Mașini de Lux", Arrays.asList(MERCEDES_BENZ, AUDI, VOLKSWAGEN)),
                new Seller("Vânzări AutoExpress", Arrays.asList(NISSAN, HYUNDAI, KIA))
        )));
    }

    public static void addDealerships() {
        Database.getDatabase().addDealerships(Arrays.asList(
                new Dealership("Dealer AutoRomânia", Map.of(
                        HONDA, 22000,
                        CHEVROLET, 18000,
                        BMW, 31000,
                        MERCEDES_BENZ, 36000,
                        AUDI, 16000
                )),
                new Dealership("Dealer AutoLux", Map.of (
                        VOLKSWAGEN, 24000,
                        NISSAN, 19000,
                        HYUNDAI, 33000,
                        KIA, 37000,
                        JEEP, 16500
                )),
                new Dealership("Dealer AutoVision", Map.of (
                        LEXUS, 23000,
                        ACURA, 19500,
                        INFINITI, 32000,
                        GMC, 37000,
                        RAM, 16000
                )),
                new Dealership("Dealer AutoElite", Map.of (
                        TOYOTA, 26000,
                        FORD, 20500,
                        NISSAN, 35000,
                        KIA, 38000,
                        SUBARU, 17500
                )),
                new Dealership("Dealer AutoVitesse", Map.of (
                        VOLKSWAGEN, 27000,
                        HONDA, 21500,
                        AUDI, 36000,
                        MERCEDES_BENZ, 39000,
                        CHEVROLET, 18000
                )),
                new Dealership("Dealer AutoFast", Map.of (
                        LEXUS, 28000,
                        NISSAN, 22500,
                        ACURA, 37000,
                        BMW, 40000,
                        INFINITI, 18500
                )),
                new Dealership("Dealer AutoSpeed", Map.of (
                        GMC, 29000,
                        RAM, 23500,
                        JEEP, 38000,
                        CHEVROLET, 41000,
                        TOYOTA, 19000
                )),
                new Dealership("Dealer AutoPower", Map.of (
                        SUBARU, 30000,
                        FORD, 24500,
                        TOYOTA, 39000,
                        NISSAN, 42000,
                        KIA, 19500
                )),
                new Dealership("Dealer AutoRapid", Map.of (
                        ACURA, 31000,
                        INFINITI, 25500,
                        LEXUS, 40000,
                        VOLKSWAGEN, 43000,
                        HONDA, 20000
                ))
        ));
    }
}

class Dealership {
    private String name;
    private Map<String, Integer> cars;

    public Dealership(Dealership dealership) {
        this.name = dealership.getName();
        this.cars = dealership.getCars();
    }

    public Dealership(String name, Map<String, Integer> cars) {
        this.name = name;
        this.cars = cars;
    }

    public double averagePrice() {
        double avgPrice = 0;
        int counter = 0;
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            avgPrice += car.getValue();
            counter += 1;
        }
        return avgPrice / counter;
    }

    public int getPriceForBrand(String brand) {
        return cars.get(brand);
    }

    public List<Seller> getAllSellers() {
        // TODO
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getAllSellers()));
    }

    public List<Dealership> getAllDealerships() {
        // TODO
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getAllDealerships()));
    }

    public List<Dealership> getDealershipsByBrand(String brand) {
        // TODO
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getDealershipsByBrand(brand)));
    }

    public List<Seller> getSellersByBrand(String brand) {
        // TODO
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getSellersByBrand(brand)));
    }

    public List<Dealership> getDealershipsByAveragePrice() {
        // TODO
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getDealershipsByAveragePrice()));
    }

    public List<Dealership> getDealershipsByPriceForBrand(String brand) {
        // TODO
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getDealershipsByPriceForBrand(brand)));
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Seller {
    private String name;
    private List<String> carBrands = new ArrayList<>();

    public Seller(Seller seller) {
        // TODO
        this.name = seller.getName();
        this.carBrands = seller.getCarBrands();
    }

    public Seller(String name, List<String> carBrands) {
        this.name = name;
        this.carBrands = carBrands;
    }

    public List<Seller> getAllSellers() {
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getAllSellers()));
    }

    public List<Dealership> getAllDealerships() {
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getAllDealerships()));
    }

    public List<Dealership> getDealershipsByBrand(String brand) {
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getDealershipsByBrand(brand)));
    }

    public List<Seller> getSellersByBrand(String brand) {
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getSellersByBrand(brand)));
    }

    public List<Dealership> getDealershipsByAveragePrice() {
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getDealershipsByAveragePrice()));
    }

    public List<Dealership> getDealershipsByPriceForBrand(String brand) {
        Database database = Database.getDatabase();
        return Collections.unmodifiableList(new ArrayList<>(database.getDealershipsByPriceForBrand(brand)));
    }

    public String getName() {
        return name;
    }

    public List<String> getCarBrands() {
        return carBrands;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", carBrands=" + carBrands +
                '}';
    }
}

class Database {

    private final List<Seller> sellers = new ArrayList<>();
    private final List<Dealership> dealerships = new ArrayList<>();

    // TODO: make it Singleton

    private static Database instance;

    private static int aux = 0;

    private Database() {}

    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
            aux++;
        }
        return instance;
    }

    public static int getNumberOfInstances() {
        // TODO
        return aux;
    }

    public List<Seller> getAllSellers() {
        Database database = Database.getDatabase();
        return sellers;
    }

    public List<Dealership> getAllDealerships() {
        Database database = Database.getDatabase();
        return dealerships;
    }

    public List<Dealership> getDealershipsByBrand(String brand) {
        // Initialize the list to store filtered dealerships
        List<Dealership> auxDealerships = new ArrayList<>();

        // Obtain the database instance
        Database database = Database.getDatabase();

        // Iterate through each dealership to check if they have the car's brand
        for (Dealership dealership : dealerships) {
            if (dealership.getCars().containsKey(brand)) {
                auxDealerships.add(dealership);
            }
        }
        return auxDealerships;
    }

    public List<Seller> getSellersByBrand(String brand) {

        List<Seller> auxSellers = new ArrayList<>();

        Database database = Database.getDatabase();

        for (Seller seller : sellers) {
            if (seller.getCarBrands().contains(brand)) {
                auxSellers.add(seller);
            }
        }
        return auxSellers;
    }

    public List<Dealership> getDealershipsByAveragePrice() {
        // TODO
        List<Dealership> auxSellers = new ArrayList<>();

        TreeMap<Double, List<Dealership>> orderSellers = new TreeMap<>();

        Database database = Database.getDatabase();

        for (Dealership dealership : dealerships) {
            double median = 0;
            Integer aux = 0;
            for (Integer it : dealership.getCars().values()) {
                median = median + it;
                aux += 1;
            }
            median = median / aux;
            orderSellers.putIfAbsent(median, new ArrayList<>());
            orderSellers.get(median).add(dealership);
        }

        List<Dealership> sortedDealerships = new ArrayList<>();
        for (List<Dealership> dealershipList : orderSellers.values()) {
            sortedDealerships.addAll(dealershipList);
        }
        return sortedDealerships;
    }

    public List<Dealership> getDealershipsByPriceForBrand(String brand) {
        // TODO
        //getDealershipsByPriceForBrand - primește ca parametru numele unui brand și întoarce
        //lista cu dealershipurile care detin acel brand, sortate după pretul acestuia în ordine crescătoare.
        List<Dealership> auxSellers = new ArrayList<>();

        TreeMap<Integer, List<Dealership>> orderDealerships = new TreeMap<>();

        Database database = Database.getDatabase();

        for (Dealership dealership : dealerships ) {
            if (dealership.getCars().containsKey(brand)) {
                orderDealerships.putIfAbsent(dealership.getCars().get(brand), new ArrayList<>());
                orderDealerships.get(dealership.getCars().get(brand)).add(dealership);
            }
        }
        List<Dealership> sortedDealerships = new ArrayList<>();
        for (List<Dealership> dealershipList : orderDealerships.values()) {
            sortedDealerships.addAll(dealershipList);
        }
        return sortedDealerships;
    }

    public void addSellers(List<Seller> sellers) {
        this.sellers.addAll(sellers);
    }

    public void addDealerships(List<Dealership> dealerships) {
        this.dealerships.addAll(dealerships);
    }

    @Override
    public String toString() {
        return "Database{" +
                "sellers=" + sellers +
                ", dealerships=" + dealerships +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();

        // adding entities to database
        Helpers.addDealerships();
        Helpers.addSellers();

        // tests
        Dealership testDealership = Database.getDatabase().getAllDealerships().get(0);
        Seller testSeller = Database.getDatabase().getAllSellers().get(0);

        switch(task) {
            case 1:
                System.out.println(testDealership.getName());
                System.out.println(testSeller.getName());
                break;

            case 2:
                System.out.println(testDealership.averagePrice());
                System.out.println(testDealership.getPriceForBrand("Chevrolet"));
                break;

            case 3:
                Seller testSellerCopy = new Seller(testSeller);
                System.out.println(testSellerCopy);
                break;

            case 4:
                for (Dealership dealership : Database.getDatabase().getAllDealerships()) {
                    System.out.println(dealership.getName());
                }
                System.out.println("------------------------------");
                for (Seller seller : Database.getDatabase().getAllSellers()) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : Database.getDatabase().getDealershipsByBrand("Honda")) {
                    System.out.println(dealership.getName());
                }
                System.out.println("------------------------------");
                for (Seller seller : Database.getDatabase().getSellersByBrand("Toyota")) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : Database.getDatabase().getDealershipsByAveragePrice()) {
                    System.out.println(dealership.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : Database.getDatabase().getDealershipsByPriceForBrand("Lexus")) {
                    System.out.println(dealership.getName());
                }
                break;

            case 5:
                System.out.println("TESTING SELLER FUNCTIONALITIES:\n");

                for (Seller seller : testSeller.getAllSellers()) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Seller seller : testSeller.getSellersByBrand("Toyota")) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Seller seller : testSeller.getSellersByBrand("Mercedes-Benz")) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : testSeller.getAllDealerships()) {
                    System.out.println(dealership.getName());
                }

                System.out.println("\nTESTING MUTABILITY FOR SELLERS:\n");

                testSeller.getAllDealerships().get(0).setName("New Dealership");
                for (Dealership dealership : testSeller.getAllDealerships()) {
                    System.out.println(dealership.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : testSeller.getDealershipsByBrand("Nissan")) {
                    System.out.println(dealership.getName());
                }
                for (Dealership dealership : testSeller.getDealershipsByAveragePrice()) {
                    System.out.println(dealership.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : testSeller.getDealershipsByPriceForBrand("Kia")) {
                    System.out.println(dealership.getName());
                }
                break;

            case 6:
                System.out.println("TESTING DEALERSHIP FUNCTIONALITIES:\n");

                for (Seller seller : testDealership.getAllSellers()) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Seller seller : testDealership.getSellersByBrand("Nissan")) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Seller seller : testDealership.getSellersByBrand("Kia")) {
                    System.out.println(seller.getName());
                }
                System.out.println("------------------------------");
                for (Dealership dealership : testDealership.getAllDealerships()) {
                    System.out.println(dealership.getName());
                }
                break;

            case 7:
                try {
                    // testing immutability for Dealership
                    testDealership.getAllDealerships().get(0).setName("New Dealership");

                    // it should throw an error if getAllDealerships() from Dealership is completely immutable
                    testDealership.getAllDealerships().add(new Dealership(testDealership));
                }
                catch(Exception e) {
                    System.out.println("Dealership immutability test passed!");
                }
                break;

            case 8:
                System.out.println(Database.getNumberOfInstances());
                break;
        }

    }
}