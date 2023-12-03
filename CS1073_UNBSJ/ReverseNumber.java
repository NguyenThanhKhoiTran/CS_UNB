
/********************************************************************
 * Some review before the final exam - Reverse Number
 * @author Nguyen Thanh Khoi Tran
 * @date 12/02/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.ArrayList;

public class ReverseNumber {
    public static boolean reverseNum(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> finalAns = new ArrayList<>();

        do {
            result.add(num % 10);
            num /= 10;
        } while (num > 0);

        for (int i = 0; i < (result.size()); i++) {
            finalAns.add(result.get(result.size() - 1 - i));
            if (finalAns.get(i) != result.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (reverseNum(23432)) {
            System.out.println("This is a reverse number");
        } else
            System.out.println("This is not a reverse number");

    }
}
