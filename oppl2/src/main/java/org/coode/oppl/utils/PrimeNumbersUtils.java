package org.coode.oppl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luigi Iannone
 */
public class PrimeNumbersUtils {

    /**
     * Retrieves the first n prime numbers
     * 
     * @param n a non-negative integer
     * @return The first n prime numbers.
     */
    public static List<Integer> getNPrimes(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The input n must be >=0, it is in fact:  " + n);
        }
        int upperBound = n * 10;
        List<Integer> primes = runEratosthenesSieve(upperBound);
        boolean enough = primes.size() >= n;
        while (!enough) {
            upperBound += upperBound;
            primes = runEratosthenesSieve(upperBound);
            enough = primes.size() >= n;
        }
        return primes.subList(0, n);
    }

    /**
     * @param upperBound upperBound
     * @return list of primes
     */
    public static List<Integer> runEratosthenesSieve(int upperBound) {
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
        List<Integer> toReturn = new ArrayList<>(upperBound / 2);
        boolean[] isComposite = new boolean[upperBound + 1];
        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                for (int k = m * m; k <= upperBound; k += m) {
                    isComposite[k] = true;
                }
            }
        }
        for (int m = 1; m <= upperBound; m++) {
            if (!isComposite[m]) {
                toReturn.add(Integer.valueOf(m));
            }
        }
        return toReturn;
    }

    /**
     * @param n n
     * @return next prime from n
     */
    public static int getNextPrime(int n) {
        int toReturn = n + 1;
        boolean found = isPrime(toReturn);
        while (!found) {
            toReturn++;
            found = isPrime(toReturn);
        }
        return toReturn;
    }

    /**
     * @param n n
     * @return true if prime
     */
    public static boolean isPrime(int n) {
        // int dividersUpperbound = (int) Math.sqrt(n);
        // boolean found = false;
        // for (int i = 2; i < dividersUpperbound && !found; i++) {
        // found = n % i == 0;
        // }
        // return !found;
        return millerRabin32(n);
    }

    // Primality Test function source
    // http://en.literateprograms.org/Miller-Rabin_primality_test_(Java)
    private static boolean millerRabinPass32(int a, int n) {
        // 32-bit compute s and d
        int d = n - 1;
        int s = Integer.numberOfTrailingZeros(d);
        d >>= s;
        int a_to_power = modularExponent32(a, d, n);
        if (a_to_power == 1) {
            return true;
        }
        for (int i = 0; i < s - 1; i++) {
            if (a_to_power == n - 1) {
                return true;
            }
            a_to_power = modularExponent32(a_to_power, 2, n);
        }
        return a_to_power == n - 1;
    }

    private static int modularExponent32(int base, int power, int modulus) {
        long result = 1;
        for (int i = 31; i >= 0; i--) {
            result = result * result % modulus;
            if ((power & 1 << i) != 0) {
                result = result * base % modulus;
            }
        }
        return (int) result; // Will not truncate since modulus is an int
    }

    /**
     * @param n n
     * @return true if prime
     */
    public static boolean millerRabin32(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            return millerRabinPass32(2, n) && (n <= 7 || millerRabinPass32(7, n))
                && (n <= 61 || millerRabinPass32(61, n));
        }
    }
}
