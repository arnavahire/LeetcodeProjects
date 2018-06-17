import java.util.LinkedList;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        if(k>nums.length)       // if the array is to be rotated by a count that is greater than its size, we do mod of that k to get the rotating factor
            k=k%nums.length;

        LinkedList<Integer> list=new LinkedList<Integer>();

        for(int i=nums.length-k;i<nums.length;i++)    // the elements from n-k index to n-1 index will be added to the linkedlist. Ex: {1,2,3,4,5,6,7} --> [5,6,7] in the list
            list.add(nums[i]);

        for(int i=nums.length-1-k;i>=0;i--)           // all the elements before the n-k index will be moved forward in the array Ex: {1,2,3,4,5,6,7} --> [1,2,3,1,2,3,4] in the nums array
            nums[i+k]=nums[i];

        for(int i=0;i<k;i++)        // we add the elements from the list to the respective rotated positions Ex: {1,2,3,4,5,6,7} --> [5,6,7,1,2,3,4]
            nums[i]=list.get(i);

        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);

    }

    public static void main(String[] args) {
        RotateArray ra=new RotateArray();
        int[] nums={1,2,3,4,5,6,7};
        int rotationFactor=3;
        ra.rotate(nums,rotationFactor);

    }
}
