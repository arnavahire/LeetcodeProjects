/*Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.*/
public class SqrtX {
    public int mySqrt(int x) {
        long r=x;
        while(r*r>x)       // Newton's method
        {
            r=(r+(x/r))/2;
        }
        return (int)r;
    }
}
