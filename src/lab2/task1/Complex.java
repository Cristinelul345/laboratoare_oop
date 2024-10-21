package lab2.task1;

public class Complex {
    private int real;
    private int imaginary;

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public Complex(int real_nr, int imaginary_nr) {
        real = real_nr;
        imaginary = imaginary_nr;
    }

    public void addWithComplex(Complex c) {
        this.real += c.getReal();
        this.imaginary += c.getImaginary();
    }

    public void showNumber() {
        if (this.imaginary > 0) {
            System.out.println(this.real + " + i * " + this.imaginary);
        } else if (this.imaginary < 0) {
            System.out.println(this.real + " - i * " + (this.imaginary * -1));
        } else if (this.imaginary == 0) {
            System.out.println(this.real);
        }
    }
}
