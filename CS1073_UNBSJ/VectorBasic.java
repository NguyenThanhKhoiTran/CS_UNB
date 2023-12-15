
/********************************************************************
 * Some review before the final exam - Basic thing about vectors
 * 
 * @author Nguyen Thanh Khoi Tran
 * @date 12/03/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.Random;

public class VectorBasic {
    // Declaration and Initialization
    private int index;
    private double[] vector;

    // Constructor
    public VectorBasic(int index) {
        this.index = index;
        vector = new double[index];
        randomValue();
    }

    // Random method
    private void randomValue() {
        Random rd = new Random();
        for (int i = 0; i < index; i++) {
            vector[i] = rd.nextInt(21) - 10;
        }
    }

    // Accessor method
    public int getIndex() {
        return index;
    }

    public double[] getVector() {
        return vector;
    }

    // Change value of vector
    public void changeValueVector(int index, double newValue) {
        vector[index] = newValue;
    }

    // Display Matrix
    public void display() {
        System.out.println();
        for (int i = 0; i < index; i++) {
            System.out.format(" %10.2f ", vector[i]);
        }
    }

    // Method #1 - Sum of 2 vector
    public void sum(VectorBasic b) {

        double[] result = new double[vector.length];

        if (vector.length != b.getIndex()) {
            System.out.println("\nSorry, invaild input");

        } else
            for (int i = 0; i < vector.length; i++) {
                result[i] = vector[i] + b.vector[i];
                changeValueVector(i, result[i]);
            }
    }

    // Method #2 - Dot product
    public double dotProduct(VectorBasic b) {
        double[] result = new double[vector.length];
        double total = 0;
        if (vector.length != b.getIndex()) {
            System.out.println("\nSorry, invaild input");

        } else
            for (int i = 0; i < vector.length; i++) {
                result[i] = vector[i] * b.getVector()[i];
                total += result[i];
            }
        return total;
    }

    // Method #3 - Magnitude of the vector
    public double magnitude() {
        double total = 0;
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = Math.pow(vector[i], 2);
            total += result[i];
        }
        return Math.sqrt(total);
    }

    // Method #4 - The cross product (3-dimension vector)
    public void crossProduct(VectorBasic b) {
        double[] result = new double[vector.length];
        if (vector.length > 3) {
            System.out.println("Sorry, input must be 3-dimensional vector !!!");
        } else
            result[0] = vector[1] * b.vector[2] - b.vector[1] * vector[2];
        result[1] = vector[2] * b.vector[0] - b.vector[2] * vector[0];
        result[2] = vector[0] * b.vector[1] - b.vector[0] * vector[1];
        for (int i = 0; i < vector.length; i++) {
            changeValueVector(i, result[i]);
        }
    }

    // Method #5 - Create a vector that given 2 points (3-dimension vector)
    public VectorBasic createVector(double[] a, double[] b) {
        VectorBasic result = new VectorBasic(a.length);
        boolean done = false;
        do {
            if (a.length > 3 || b.length > 3) {
                System.out.println("Sorry, input must be 3-dimensional vector !!!");
                done = true;
            } else {
                for (int j = 0; j < a.length; j++) {
                    result.getVector()[j] = b[j] - a[j];
                    changeValueVector(j, result.getVector()[j]);
                }
                done = true;
            }
        } while (!done);
        return result;
    }

    // Method #6 - Create a plane includes 3 given points
    public String planePt(double[] a, double[] b, double[] c) {
        String result = "";
        double[] x = new double[a.length];
        VectorBasic ab = createVector(a, b);
        VectorBasic ac = createVector(a, c);
        ab.crossProduct(ac);

        for (int i = 0; i < a.length; i++) {
            x[i] = ab.getVector()[i];
        }
        double d = a[0] * x[0] + a[1] * x[1] + a[2] * x[2];
        result += String.format("%.2fx %+.2fy %+.2fz = %.2f", x[0], x[1], x[2], d);
        return result;
    }

    // Method #7 - Projection of vector u onto vector v
    public VectorBasic projection(VectorBasic u, VectorBasic v) {
        VectorBasic result = new VectorBasic(index);
        double numerator = Math.pow(v.magnitude(), 2);
        for (int i = 0; i < index; i++) {
            result.getVector()[i] = u.dotProduct(v) * v.getVector()[i] / numerator;
            changeValueVector(i, result.getVector()[i]);
        }
        return result;
    }

    // Driver class
    public static void main(String[] args) {

        VectorBasic a = new VectorBasic(3);
        System.out.print("\t\t\tVector a");
        a.display();

        VectorBasic b = new VectorBasic(3);
        System.out.print("\n\n\t\t\tVector b");
        b.display();

        VectorBasic c = new VectorBasic(3);
        System.out.print("\n\n\t\t\tVector c");
        c.display();

        // Sum 2 vector
        System.out.print("\n\n\t\tSum of 2 vector a and b (current vector a)");
        a.sum(b);
        a.display();

        // The dot product
        System.out.format("\n\n%s %.2f", "The dot product of 2 vector ==>", a.dotProduct(b));

        // The Magnitude of vector
        System.out.format("\n\n%s %.2f", "The magnitude vector ==>", a.magnitude());

        // The cross product of b and c
        System.out.format("\n\n%s", "The cross product of vector b and c");
        b.crossProduct(c);
        b.display();

        // Create vector
        double[] m = { 1, 2, 3 };
        double[] n = { 3, -6, 0 };
        VectorBasic temp = new VectorBasic(3);
        temp.createVector(m, n);
        System.out.println("\n\nA vector from 2 given points (1,2,3) and (3,-6,0)");
        temp.display();

        // Create a plane
        double[] a1 = { 1, 3, -2 };
        double[] a2 = { 1, 1, 5 };
        double[] a3 = { 2, -2, 3 };

        System.out.println("\nThe equation of the plane is: " + temp.planePt(a1, a2, a3));

        // Projection of vector u onto vector v
        VectorBasic temp2 = new VectorBasic(3);
        VectorBasic u = new VectorBasic(3);
        System.out.print("\n\n\t\t\tVector u");
        u.display();

        VectorBasic v = new VectorBasic(3);
        System.out.print("\n\n\t\t\tVector v");
        v.display();

        temp2.projection(u, v);
        System.out.println("\n\n\t\tProjection vector u onto vector v");
        temp2.display();

        // Check the unit vector
        VectorBasic f = new VectorBasic(3);

        f.changeValueVector(1, 1);
        f.changeValueVector(0, 3);
        f.changeValueVector(2, 0);
        System.out.println("\n\n\t\tCheck unit vector");
        f.display();

        if (f.magnitude() == 1) {
            System.out.println("\nThis is an unit vector");
        } else
            System.out.println("\nThis is not a unit vector");

    }
}
