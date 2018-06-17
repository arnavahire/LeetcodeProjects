/*PROBLEM STATEMENT: MERGE INTERVALS
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)   // if list is empty or of size 1, return it
            return intervals;

        LinkedList<Interval> intervalList=new LinkedList<Interval>();
        intervals.sort((i1,i2)->Integer.compare(i1.start,i2.start));   // We sort the intervals by ascending order of start time, using a comparator

        int start=intervals.get(0).start;
        int end=intervals.get(0).end;

        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<=end && intervals.get(i).end<=end)  // ignore the interval that has start time greater than previous interval and end time less than or equal to previous interval. EX: For intervals [1,3] and [2,3], we will ignore [2,3] since it is covered in [1,3] itself
                continue;
            if(intervals.get(i).start<=end && intervals.get(i).end>end) // if the interval has start time less than previous's finish time and has a finish time greater than previous's finish time then we rest the value of end, indicating this is ouur new endpoint of the interval
            {
                end=intervals.get(i).end;
            }
            else if(intervals.get(i).start>end)     // if the start time of the interval is greater than the end time of  the previous interval then we output the interval that we obtained so far and rest start and end
            {
                intervalList.add(new Interval(start,end));  // add the previous interval to the final interval's list and reset the start and end for new interval
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
        }

        intervalList.add(new Interval(start,end));  // we append the final interval that we obtained, to the interval's list

        return intervalList;
    }

    public static void main(String[] args) {
        MergeIntervals mi=new MergeIntervals();
        List<Interval> list=new LinkedList<Interval>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        List<Interval> result=mi.merge(list);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));

    }
}
