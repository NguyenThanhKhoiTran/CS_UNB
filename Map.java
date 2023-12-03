
/********************************************************************
 * Some review before the final exam - a number = its square
 * @author Nguyen Thanh Khoi Tran
 * @date 11/30/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.Scanner;

public class Map {
    public static void main(String[] args) {
        String result = "";
        Scanner sc = new Scanner(System.in);

        System.out.format("%s", "Please provide a number that you want to have its map ==> ");
        int number = sc.nextInt();
        sc.close();

        for (int i = 1; i < number; i++) {
            int[] a = new int[number];
            int[] b = new int[number];
            a[i] = i;
            b[i] = i * i;
            result = "[ " + a[i] + "=" + b[i] + "]";
            System.out.println(result);
        }
    }
}
