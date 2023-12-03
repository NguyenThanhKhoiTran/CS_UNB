
/**************************************************************************
 * 12 weeks of Java - Question 1
 * 
 * @author Nguyen Thanh Khoi Tran
 * @date 12-01-2023
 * @version Lab_V1
 **************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class RowEchelonForm {

    // Program #1
    public static double[][] matrixCreate(int n, int m) {
        // Initialization and declaration
        double[][] A = new double[n][m];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = rd.nextDouble(9) + 1;
            }
        }
        return A;
    }

    // Program #2
    public static void display(double[][] A, double[][] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.format("%7.2f", A[i][j]);
            }
            System.out.format("%7.2f \n", B[i][0]);
        }
        System.out.println();
    }

    // Program 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        int n;
        do {
            System.out.print("Please provide a positive integer N ==> ");
            n = sc.nextInt();
            if (n > 0) {
                System.out.println("Thank you");
                done = true;
            } else
                System.out.println("Sorry, your input is invaild, try again please!");
        } while (!done);

        double[][] A = matrixCreate(n, n);
        double[][] B = matrixCreate(n, 1);
        display(A, B);
        for (int i = 0; i < n; i++) {
            double t = A[i][i];
            for (int j = 0; j < n; j++) {
                A[i][j] = A[j][i] / t;
            }
            B[i][0] /= t;
            A[i][i] = 1;

            for (int r = i + 1; r < n; r++) {
                for (int c = i + 1; c < n; c++) {
                    A[r][c] -= A[r][i] * A[i][c];
                    B[r][0] -= B[i][0] * A[r][i];
                    A[r][i] = 0;
                }
            }
        }
        display(A, B);
        sc.close();
    }

}
