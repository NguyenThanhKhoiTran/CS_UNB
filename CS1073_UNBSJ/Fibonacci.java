
/********************************************************************
 * Some review before the final exam - Fibonacci
 * @author Nguyen Thanh Khoi Tran
 * @date 11/30/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {

        // F(0) = 0, F(1) = 1, F(2) = 1, F(n) = F(n-1)+F(n-2)

        ArrayList<Integer> fibonacci = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Provide how many numbers you want to display (fibonacci) ==>");
        int number = sc.nextInt();
        sc.close();

        fibonacci.add(0);
        fibonacci.add(1);
        fibonacci.add(1);

        for (int i = 3; i <= number; i++) {
            int result = fibonacci.get(i - 1) + fibonacci.get(i - 2);
            fibonacci.add(result);
        }

        for (int i = 0; i < number; i++) {
            System.out.println(fibonacci.get(i));
        }
    }
}
