class Complex_number {
    double real;
    double imag;

    Complex_number(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    boolean equals(Complex_number other) {
        return (real == other.real) && (imag == other.imag);
    }

    Complex_number add(Complex_number other) {
        return new Complex_number (real + other.real, imag + other.imag);
    }

    Complex_number sub(Complex_number other) {
        return new Complex_number (real - other.real, imag - other.imag);
    }

    Complex_number mult(double other) {
        return new Complex_number(real * other, imag * other);
    }

    Complex_number mult(Complex_number other) {
        return new Complex_number(real * other.real - imag * other.imag, real * other.real + imag * other.imag);
    }

    public String toString() {                                                                          
        return "[real: " + real + ", imag: " + imag + "]"; 
    }
}


public class Complex_num_test {
    public static void main(String[] args) {
        Complex_number num1, num2;
        num1 = new Complex_number(3, 4);
        num2 = new Complex_number(5, 7);

        System.out.println(num1);
        System.out.println(num2);

        System.out.println(num1.equals(num2));
        System.out.println(num1.add(num2));
        System.out.println(num1.sub(num2));
        System.out.println(num1.mult(num2));
        System.out.println(num1.mult(5.0));
    }
}
