package lab3;

import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

class Form {
    // TODO[0]: Add fields

    public String color;

    public Form(String color) {
        this.color = color;
    }

    // TODO[1]: Add constructors

    public Form() {
        this.color = "white";
    }

//    public void Form(String color) {  aici am scris gresit nu trebuie cu void este doar public form
//        this.color = color;           la fel si la FOrm() am schimbat
//    }

    // TODO[2]: Add the function getArea
    public float getArea() {
        return 0;
    }

    // TODO[3]: Override toString
    @Override
    public String toString() {
        System.out.println("This form has a color " + this.color);
        return this.color;
    }
}

class Triangle extends Form {
    // TODO[0]: Add fields

    public float height;
    public float base;

    // TODO[1]: Add constructors
    public Triangle() {}

    public Triangle(String color, float height, float base) {
        super.color = color;
        this.height = height;
        this.base = base;
    }


    // TODO[2]: Override toString
    @Override
    public String toString() {
        System.out.println(super.toString() + " and is a triangle with base " + base + " and height " + height);
        return super.toString();
    }

    public void printTriangleDimensions() {
        System.out.println(base + height);
    }

    // TODO[3]: Override getArea
    public float getArea() {
        return ((float)height * base) / 2;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Triangle triangle = (Triangle) o;
            boolean sameDimensions = Float.compare(height, triangle.height) == 0 && Float.compare(base, triangle.base) == 0;
            boolean sameColor = (color != null ? color.equals(triangle.color) : triangle.color == null);
            result = sameDimensions && sameColor;

        }
        return result;
    }
}

class Square extends Form {

    // TODO[0]: Add fields
    public float side;

    // TODO[1]: Add constructors
    public Square() {}

    public Square(String color, float side) {
        super.color = color;
        this.side = side;
    }

    // TODO[2]: Override toString
    public void printSquareDimensions() {
        System.out.println(side);
    }


    @Override
    public String toString() {
        //System.out.println("This square has a color " + Square.super.toString());
        return super.toString() + " and is a square with side " + side;
    }

    // TODO[3]: Override getArea
    public float getArea() {
        return (float)Math.pow(side, 2) ;
    }
}

class Circle extends Form {
    // TODO[0]: Add fields

    public float radius;

    // TODO[1]: Add constructors
    public Circle() {}

    public Circle(String color, float radius) {
        super.color = color;
        this.radius = radius;
    }

    // TODO[2]: Override toString
    public void printCircleDimensions() {
        System.out.println(radius);
    }

    @Override
    public String toString() {
        System.out.println("This circle has a color " + Circle.super.toString());
        return super.toString();
    }

    // TODO[3]: Override getArea
    public float getArea() {
        return (float) (3.14 * (float)Math.pow(radius, 2));
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();
        // TODO: Uncomment the code after implementing the task.
        // Task 1:

        Form form1 = new Form();
        Form form2 = new Form("blue");

        // Task 2:
        Triangle triangle1 = new Triangle("red", 4, 3);
        Triangle triangle2 = new Triangle();
        Square square1 = new Square("yellow", 4);
        Square square2 = new Square();
        Circle circle1 = new Circle("green",10);
        Circle circle2 = new Circle();

//        Task 4: add in this order the elements in the shape vector: triangle1, triangle2,
//                  square1, square2, circle1, circle2

        Form [] forms = new Form[6];
        forms[0] = triangle1;
        forms[1] = triangle2;
        forms[2] = square1;
        forms[3] = square2;
        forms[4] = circle1;
        forms[5] = circle2;

        switch(task) {
            case 1:
//                Task 1:
                System.out.println(1);
                System.out.println(form2);
                break;
            case 2:
//                Task 2:
                System.out.println(triangle1);
                System.out.println("The Area is: " + triangle1.getArea());
                System.out.println(triangle2);
                System.out.println("The Area is: " + triangle2.getArea());
                System.out.println(square1);
                System.out.println("The Area is: " + square1.getArea());
                System.out.println(square2);
                System.out.println("The Area is: " + square2.getArea());
                System.out.println(circle1);
                System.out.println("The Area is: " + circle1.getArea());
                System.out.println(circle2);
                System.out.println("The Area is: " + circle2.getArea());
                break;
            case 3:
//                Task 3:
                Triangle triangle3 = new Triangle("yellow", 4, 3);
                Triangle triangle4 = new Triangle("red", 4, 3);
                System.out.println(triangle1.equals(triangle3));
                System.out.println(triangle1.equals(triangle4));
                System.out.println(triangle1.equals(square1));
                break;
            case 4:
                // Task 4: for each element of the vector call the toString function
                for (int i = 0; i < forms.length; i++) {
                    System.out.println(forms[i].toString());
                }
                break;

            case 5:
                // Task 5: Loop through the vector from the previous exercise and, using downcasting to the appropriate class, call
                // methods specific to each class (printTriangleDimensions for Triangle, printCircleDimensions for Circle
                // printSquareDimensions for Square)
                for (int i = 0; i < forms.length; i++) {
                    if (forms[i] instanceof Triangle) {
                        System.out.println(forms[i].toString());
                    } else if (forms[i] instanceof Square) {
                        System.out.println(forms[i].toString());
                    } else if (forms[i] instanceof Circle) {
                        System.out.println(forms[i].toString());
                    }

                }
                break;
            case 6:
                //Task 6: Show shape sizes without using instanceof
                break;
        }
    }
}

