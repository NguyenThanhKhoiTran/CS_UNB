
/********************************************************************
 * Some review before the final exam - Prime Number 
 * @author Nguyen Thanh Khoi Tran
 * @date 12/03/2023
 * @version Khoi_V1
 ********************************************************************/
import java.util.ArrayList;

public class PrimeNum {
    public static ArrayList<Integer> primeNum(int number) {
        ArrayList<Integer> prime = new ArrayList<>();
        int i = 2;

        if (number == 0) {
            System.out.println("No prime number !!!");
        } else
            while (number > 1) {
                if (number % i == 0) {
                    number /= i;
                    prime.add(i);
                } else
                    i++;
            }
        if (prime.isEmpty()) {
            prime.add(number);
        }
        return prime;
    }

    public static void main(String[] args) {
        int a = 100;
        System.out.print("The number " + a + " = ");
        primeNum(a);
        for (int i = 0; i < primeNum(a).size() - 1; i++) {
            System.out.print(primeNum(a).get(i) + " x ");
        }
        System.out.print(primeNum(a).get(primeNum(a).size() - 1));
    }
}
