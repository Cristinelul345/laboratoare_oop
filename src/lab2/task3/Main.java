package lab2.task3;

public class Main {
    public static void main(String[] args) {
        // Constructorul cu numarul de puncte
        Polygon polygon1 = new Polygon(3); // Aloca spatiul pentru 3 puncte neinitializate
        polygon1.displayPoints(); // Momentan, acestea sunt nule

        // Constructorul cu coordonatele punctelor
        Float[] coords =  {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
        Polygon polygon2 = new Polygon(coords);
        polygon2.displayPoints(); // Afiseaza punctele

    }
}
