
/************************************************************
 * Practicing ArrayLists
 * 
 * @author Nguyen Thanh Khoi Tran
 * @date 11/24/2023
 * @version Lab_V1
 ************************************************************/
import java.util.ArrayList;

public class Divisor {

    // THE FIRST WAY: VOID RETURN TYPE
    public static void factor(int y) {

        // Create an ArrayList object to contain the factor of given int
        ArrayList<Integer> factor = new ArrayList<Integer>();
        for (int x = 1; x <= y; x++) {
            if (y % x == 0) {
                factor.add(x);
            }
        }
        System.out.println(factor.toString());
    }

    // THE SECOND WAY: ARRAYLIST<INTEGER> RETURN TYPE
    public static ArrayList<Integer> factor_2(int y2) {

        // Create an ArrayList object to contain the factor of given int
        ArrayList<Integer> factor = new ArrayList<Integer>();
        for (int x = 1; x <= y2; x++) {
            if (y2 % x == 0) {
                factor.add(x);
            }
        }
        return factor;
    }
}
