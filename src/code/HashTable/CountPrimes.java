package code.HashTable;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primesList = new boolean[n];
        for(int i = 2; i < n; ++i) {
            primesList[i] = true;
        }

        for(int i = 2; i * i < n; i++) {
            if(!primesList[i]) continue;
            for(int j = i * i; j < n; j+=i) {
                primesList[j] = false;
            }
        }

        int count = 0;
        for(int i = 2; i  < n; i++) {
            if(primesList[i]) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrimeNum(int s) {
        double sqrt = Math.sqrt(s);
        if(s < 2) {
            return false;
        }

        if(s == 2 || s == 3) {
            return true;
        }

        if(s % 2 == 0) {
            return false;
        }

        for(int i = 3; i <= sqrt; i+=2) {
            if(s % i == 0) {
                return false;
            }
        }

        return true;
    }
}
