
/********************************************************************
 * Some review before the final exam - Sum Integer
 * @author Nguyen Thanh Khoi Tran
 * @date 12/03/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.ArrayList;
import java.util.Collections;

public class SumInteger {
    public static ArrayList<Integer> splitInt(int n) {
        ArrayList<Integer> total = new ArrayList<>();
        int i;

        if (n == 0) {
            System.out.println("The sum of it is 0");
        } else
            do {
                i = n % 10;
                total.add(i);
                n /= 10;
            } while (n > 0);
        Collections.sort(total);
        return total;
    }

    public static void main(String[] args) {
        int k = 5698;
        int sum = 0;
        for (int i = 0; i < splitInt(k).size(); i++) {
            System.out.print(splitInt(k).get(i) + " ");
            sum += splitInt(k).get(i);
        }
        System.out.println("\nThe final answer is ==> " + sum);
    }
}
