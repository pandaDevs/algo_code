package code.HashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        while(n != 1) {
            int sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            n = sum;
            if(visited.contains(n)) {
                return false;
            }

            visited.add(n);
        }

        return true;
    }

    public static void main(String[] args) {
        HappyNumber ha = new HappyNumber();
        boolean isHa = ha.isHappy(19);
        System.out.println(isHa);
    }
}
