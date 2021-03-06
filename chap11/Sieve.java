// Uses a linked list to implement the Sieve of
// Eratosthenes algorithm for finding prime numbers.

import java.util.*;

public class Sieve {
    public static void main(String[] args) {
        System.out.println("This program will tell you all prime");
        System.out.println("numbers up to a given maximum.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("Maximum number? ");
        int max = console.nextInt();

        LinkedList<Integer> primes = sieve(max);
        System.out.println("Prime numbers up to " + max + ":");
        System.out.println(primes);
    }

    // Returns a list of all prime numbers up to the given maximum
    // using the Sieve of Eratosthenes algorithm.
    public static LinkedList<Integer> sieve(int max) {
        LinkedList<Integer> primes = new LinkedList<Integer>();

        // add all numbers from 2 to max to a list
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(2);
        for (int i = 3; i <= max; i+=2) {
            numbers.add(i);
        }

        while (numbers.get(0) < Math.sqrt(max)) {
            // remove a prime number from the front of the list
            int front = numbers.remove(0);
            primes.add(front);

            // remove all multiples of this prime number
            Iterator<Integer> itr = numbers.iterator();
            while (itr.hasNext()) {
                int current = itr.next();
                if (current % front == 0) {
                    itr.remove();
                }
            }
        }

        while (!numbers.isEmpty()){
            int front = numbers.remove(0);
            primes.add(front);
        }

        return primes;
    }
}
