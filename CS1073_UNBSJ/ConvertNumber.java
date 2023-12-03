
/*******************************************************************************
 * Some review before the final exam - Convert to binary
 * @author Nguyen Thanh Khoi Tran
 * @date 11/30/2023
 * @version Khoi_V1
 *******************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class ConvertNumber {
    static Scanner sc = new Scanner(System.in);

    // Convert decimal to binary
    public static void DecToBin(int number) {
        ArrayList<Integer> result = new ArrayList<>();
        int tempNumber = number;

        if (number < 0) {
            tempNumber = number;
            number = Math.abs(number);
        }
        do {
            int temp = number % 2;
            result.add(temp);
            number /= 2;
        } while (number > 0);

        for (int i = 0; i < result.size(); i++) {
            int temp = result.get(result.size() - 1 - i);
            result.set(i, temp);
        }

        if (tempNumber < 0) {
            for (int i = 0; i < result.size(); i++) {
                switch (result.get(i)) {
                    case 1:
                        result.set(i, 0);
                        break;
                    default:
                        result.set(i, 1);
                }
            }
        }
        System.out.println("Your final result is " + result.toString());
    }

    // Driver class
    public static void main(String[] args) {
        System.out.print("Please provide me a number ==> ");
        int num = sc.nextInt();
        DecToBin(num);
    }
}
