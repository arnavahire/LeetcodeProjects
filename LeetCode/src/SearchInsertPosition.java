import java.util.Scanner;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int i=0;
        for(i=0;i<nums.length;i++)
        {
            if(target==nums[i])
            {
                return i;
            }
            else if(target<nums[i])
            {
                return i;
            }
            else if(target>nums[i] && i==nums.length-1)
            {
                return i+1;
            }
        }
        return i;
    }

    public int improvedSearchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(target<nums[mid]) high=mid-1;
            else if(target>nums[mid]) low=mid+1;
            else return mid;
        }
        return low;
    }
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len=scan.nextInt();

        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++)
        {
            System.out.println("Enter element:");
            arr[i]=scan.nextInt();
        }

        System.out.println("Enter the target: ");
        int target=scan.nextInt();

        SearchInsertPosition sip=new SearchInsertPosition();
        int res=sip.searchInsert(arr,target);
        System.out.println(res);
        int res2=sip.improvedSearchInsert(arr,target);
        System.out.println(res2);

    }
}
