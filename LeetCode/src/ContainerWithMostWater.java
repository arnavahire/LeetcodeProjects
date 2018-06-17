/* PROBLEM STATEMENT: Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

*/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int maxArea=Integer.MIN_VALUE;    // let maxArea be the least value initially
        int left=0;                       // left pointer is the 0th index of height
        int right=height.length-1;        // right pointer is the last index of height
        int area=0;
        while(left < right)              // we will end, when left as well as right pointer point to same point
        {
            int leftHeight=height[left];
            int rightHeight=height[right];
            int minHeight=Math.min(leftHeight,rightHeight);  // calculate each tie which amongst left and right pointers has a lesser height, since that will be the height of the container

            area=(right-left)*minHeight;              // the difference between left and right gives us the width of the container, hence that multiplied by the height will give us the area of the container
            maxArea=Math.max(maxArea,area);

            if(minHeight==leftHeight)               // move the pointer depending on which pointer has smaller height, we wont move the pointer that has larger height because we want a container that is wide enough, as well as tall enough
                left++;
            else
                right--;
        }

        return maxArea;

    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw=new ContainerWithMostWater();
        int[] height={0,1,2,3,4,5};
        int result=cwmw.maxArea(height);
        System.out.println(result);
    }
}
