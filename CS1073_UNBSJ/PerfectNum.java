
/************************************************************
 * Practicing ArrayLists
 * 
 * @author Nguyen Thanh Khoi Tran
 * @date 11/24/2023
 * @version Lab_V1
 ************************************************************/
import java.util.ArrayList;

public class PerfectNum {
    public static boolean checkPerfectNum(int a) {

        // Create an ArrayList object to contain all the factor
        ArrayList<Integer> factor = new ArrayList<Integer>();

        // Instatiation
        int sum = 0;

        // Using Divisor class to take factor(s)
        Divisor.factor(a);

        // Removing the factor itself
        factor.remove(factor.size() - 1);

        // Add up all the factor
        for (int i = 0; i < factor.size(); i++) {
            sum += factor.get(i);
        }

        return sum == a;
    }
}
