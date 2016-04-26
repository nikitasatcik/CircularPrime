/**
 * Число 197 называется circular prime, потому циклический сдвиг числа дает также простое число: 197, 971 и 719.
 * Есть 13 таких чисел в диапазоне до 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79 и 97.
 * Сколько таких чисел до 1 миллиона?
 * Код решения задачи необходимо выложить в публичный репозиторий github, bitbucket или любой другой.
 */

/**
 * 1. Take the first number in the list.
 * 2. Check if it contains even numbers or five. If not continue to 3. Otherwise discard it and go to 1.
 * 3. Move the number to a temporary list.
 * 4. Rotate the number and check if it is a prime. If not discard the temporary list and go to 1.
 * 5. If the number is in the prime list move it to the temporary list.
 * 6. if the number is in the temporary list do nothing.
 * 7. if all rotations are not checked go to 4.
 * 8. return the length of the temporary list.
 */

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        for (long i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                String number = i + "";
                boolean isCircular = false;
                String temp = number;
                for (int j = 0; j < number.length(); j++) {
                    temp = temp.charAt(temp.length() - 1) + temp;
                    temp = temp.substring(0, temp.length() - 1);
                    if (!isPrime(Long.parseLong(temp))) {
                        isCircular = false;
                        break;
                    } else {
                        isCircular = true;
                    }
                }
                if (isCircular) {
                    counter++;
                }
            }
        }
        System.out.println("Circular Primes: " + counter);
    }
    
    static boolean isPrime(long num) {
        boolean prime = true;
        if (num == 2) {
            prime = true;
        } else if (num % 2 == 0) {
            prime = false;
        } else {
            for (int j = 3; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    prime = false;
                }
            }
        }
        return prime;
    }
}
