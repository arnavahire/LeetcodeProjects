import java.util.Random;

public class ShuffleAnArray {

    private int[] originalArray;
    private int[] shufflearray;
    private int capacity;

    public ShuffleAnArray(int[] nums) {
        shufflearray=nums;                       // the array to be modified
        originalArray=nums.clone();              // the original array
        capacity=nums.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand=new Random();

        for(int i=0;i<shufflearray.length;i++)
        {
            int number=rand.nextInt(capacity);     // generate a random number and swap the element at that index and the ith index in each iteration, this will shuffle our original array
            int temp=shufflearray[i];
            shufflearray[i]=shufflearray[number];
            shufflearray[number]=temp;
        }

        return shufflearray;

    }
}
