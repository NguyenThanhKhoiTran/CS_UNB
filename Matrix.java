
/*******************************************************************************
 * Some review before the final exam - Convert from decimal to binary
 * 
 * @author Nguyen Thanh Khoi Tran
 * @date 12/03/2023
 * @version Khoi_V1
 *******************************************************************************/
import java.util.Random;

public class Matrix {

    // Declaration and Initialization
    private int columns;
    private int rows;
    private double[][] value;
    Random rd = new Random();

    // Construcor
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        value = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                value[i][j] = rd.nextInt(21) - 10; // Value is between -10 and 10 inclusive
            }
        }
    }

    // Accessor method
    public int getCol() {
        return columns;
    }

    public int getRow() {
        return rows;
    }

    public double[][] getValue() {
        return value;
    }

    // Change specific value in matrix
    public void changeValue(int rows, int columns, double newValue) {
        value[rows][columns] = newValue;
    }

    // Display the matrix
    public void display() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                System.out.format(" %10.2f ", value[i][k]);
            }
            System.out.print("\n");
        }
    }

    // Method #1: Transpose Matrix
    public Matrix transpose() {
        Matrix transposed = new Matrix(rows, columns);
        double[][] transposedValue = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                transposedValue[k][i] = value[i][k];
            }
        }
        value = transposedValue;

        int temp = rows;
        rows = columns;
        columns = temp;
        return transposed;
    }

    // Scalar Multiplication
    public Matrix sum(double n1, double n2, Matrix b) {
        Matrix sumMatrix = new Matrix(rows, columns);
        double[][] sum = sumMatrix.getValue();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = n1 * value[i][j] + n2 * b.value[i][j];
                sumMatrix.changeValue(i, j, sum[i][j]);
            }
        }
        return sumMatrix;
    }

    // Product of 2 matrix
    public Matrix multiply(Matrix matrixB) {
        double[][] B = matrixB.getValue();
        Matrix productAB = new Matrix(rows, matrixB.getCol());
        double sum;

        for (int i = 0; i < rows; i++) {
            sum = 0;
            for (int j = 0; j < matrixB.getCol(); j++) {
                for (int k = 0; k < columns; k++) {
                    sum += B[k][j] * value[i][k];
                }
                productAB.changeValue(i, j, sum);
            }
        }
        return productAB;
    }

    // Driver class
    public static void main(String[] args) {
        // Given Matrix
        Matrix a = new Matrix(4, 4);
        Matrix b = new Matrix(4, 4);
        System.out.println("\n\t\t\tMatrix A");
        a.display();
        System.out.println("\n\t\t\tMatrix B");
        b.display();

        // Transpose the matrix
        /********************************************************
         * System.out.println("\n\t\tTranspose of Matrix A");
         * a.transpose().display();
         *
         *********************************************************/

        // Scalar Multiplication the matrix
        System.out.println("\n\t\tScalar multiplication of 2A+3B");
        a.sum(2, 3, b).display();

        // Product of A and B
        a.multiply(b).display();

    }
}
