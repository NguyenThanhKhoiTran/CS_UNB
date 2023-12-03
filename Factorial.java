
/********************************************************************
 * Some review before the final exam - Factorial
 * @author Nguyen Thanh Khoi Tran
 * @date 11/30/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        // Declaration and initialization
        int result = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("Please input number that you want to have its factorial ==> ");
        int number = input.nextInt();

        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println(result);
        input.close();
    }
}
