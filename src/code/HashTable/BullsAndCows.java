package code.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] secretDigits = new int[10];

        int aCount = 0;
        int bCount = 0;
        for(int i = 0; i < secret.length(); ++i) {
            if(secret.charAt(i) == guess.charAt(i)) {
                aCount++;
            } else {
                secretDigits[secret.charAt(i) - '0']++;
            }
        }

        for(int i = 0; i < guess.length(); ++i) {
            if(secret.charAt(i) != guess.charAt(i)) {
                if(secretDigits[guess.charAt(i) - '0']-- > 0) {
                    bCount++;
                }
            }
        }

        return aCount + "A" + bCount + "B";
    }
}
