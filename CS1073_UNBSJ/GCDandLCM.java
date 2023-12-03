
/********************************************************************
 * Some review before the final exam - GCD and LCM
 * @author Nguyen Thanh Khoi Tran
 * @date 11/30/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.ArrayList;

public class GCDandLCM {

    // Declaration and initialization

    // static method
    public static int GCDnumber(int a, int b) {
        ArrayList<Integer> aGCD = new ArrayList<>();
        ArrayList<Integer> bGCD = new ArrayList<>();
        int result = 0;

        // GCD for 1 num
        for (int i = 0; i < a; i++) {
            if (a % (i + 1) == 0) {
                aGCD.add(i);
            }
        }
        // GCD for 1 num
        for (int i = 0; i < b; i++) {
            if (b % (i + 1) == 0) {
                bGCD.add(i);
            }
        }
        // Using Euclidean Theorem - In Discrete Structure
        while (b != 0) {
            result = a % b;
            a = b;
            b = result;
        }
        return a;
    }

    // Using Euclidean Theorem
    public static int LCMnumber(int a, int b) {
        int gcd = GCDnumber(a, b);
        int result = a * b / gcd;
        return result;
    }

    // Driver class
    public static void main(String[] args) {
        int test1 = GCDandLCM.GCDnumber(20, 30);
        System.out.println(test1);

        int test2 = GCDandLCM.LCMnumber(20, 30);
        System.out.println(test2);
    }
}
