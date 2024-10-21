package lab2.task3;

public class Polygon {

    private Point[] points;

    public Polygon(int n) {
        points = new Point[n];
    }

    public Polygon(Float[] coordinates) {

        // Cream un nou poligon cu numarul de puncte corespunzator
        this(coordinates.length / 2);

        // Initializam punctele cu valorile din vectorul coordonate
        for(int i = 0; i < coordinates.length; i += 2) {
            points[i / 2] = new Point(coordinates[i], coordinates[i + 1]);
        }
    }

    // Metoda pentru afisarea punctelor
    public void displayPoints() {
        for(Point point : points) {
            System.out.println(point);
        }
    }
}
