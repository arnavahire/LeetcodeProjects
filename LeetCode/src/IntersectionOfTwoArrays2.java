import java.util.HashMap;
import java.util.LinkedList;

public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        LinkedList<Integer> intersectionList=new LinkedList<Integer>();  // to add the intersection points to
        int flag=0;
        if(nums1.length==0 || nums2.length==0)  // if any of the array has 0 length then return empty array
            return new int[0];
        else if(nums1.length<nums2.length)       // if num1 is smaller set flag = 1 else set flag = 0
            flag=1;
        else flag=0;

        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();

        if(flag==0)             // if num2 is equal to num1 or smaller
        {
            for(int i=0;i<nums1.length;i++)   // put the num1s contents in the hashmap
            {
                if(!map.containsKey(nums1[i]))      // for the first entry add <integer,1>
                {
                    map.put(nums1[i],1);
                }
                else                                // for the next entries add <integer,totalOccurenceCount>
                {
                    int count=map.get(nums1[i]);
                    map.put(nums1[i],++count);
                }
            }

            for(int i=0;i<nums2.length;i++)        // traverse the smaller list num2
            {
                if(map.containsKey(nums2[i]))      // if the map contains the element in num2 and the totalOccurrenceCount of that element is greater than 0 then add it to intersectionList
                {
                    if(map.get(nums2[i])>0)
                    {
                        intersectionList.add(nums2[i]);
                        int count=map.get(nums2[i]);      // for each match found, decrease the TotalOccurrenceCount by 1
                        map.put(nums2[i],--count);
                    }
                }
            }
        }
        else  // similar case if num1 is smaller than num2
        {
            for(int i=0;i<nums2.length;i++)
            {
                if(!map.containsKey(nums2[i]))
                {
                    map.put(nums2[i],1);
                }
                else
                {
                    int count=map.get(nums2[i]);
                    map.put(nums2[i],++count);
                }
            }
            for(int i=0;i<nums1.length;i++)
            {
                if(map.containsKey(nums1[i]))
                {
                    if(map.get(nums1[i])>0)
                    {
                        intersectionList.add(nums1[i]);
                        int count=map.get(nums1[i]);
                        map.put(nums1[i],--count);
                    }
                }
            }
        }

        int[] result=new int[intersectionList.size()];  // since we are returning an array and not a list, we will store this result in a array called 'result'

        for(int i=0;i<intersectionList.size();i++)
        {
            result[i]=intersectionList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays2 iota2=new IntersectionOfTwoArrays2();
        int[] nums1={1,2};
        int[] nums2={1,1};
        int[] result=iota2.intersect(nums1,nums2);
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }
    }
}
