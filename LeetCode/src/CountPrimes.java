/*PROBLEM STATEMENT: Count Primes

Description:

Count the number of prime numbers less than a non-negative number, n.

*/

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime=new boolean[n];  // create a boolean of same size as the number
        int count=0;                       // initially count will be zero

        for(int i=2;i<n;i++)               // we start from 2 as the first number since 1 is not prime nor composite
        {
            if(isPrime[i]==false)          // if isPrime[i] =  false, it means 'i' is not a multiple of another number, hence it is prime and so we increase count
                count++;
            for(int j=2;i*j<n;j++)         // for j we perform i*j to determine the next multiple of i and j and set it true to represent it as non-prime
            {
                isPrime[i*j]=true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes cp=new CountPrimes();
        int n=5;
        int result=cp.countPrimes(n);
        System.out.println(result);
    }
}
