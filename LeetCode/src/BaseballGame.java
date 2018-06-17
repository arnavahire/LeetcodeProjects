import java.io.FileReader;
import java.util.LinkedList;

public class BaseballGame {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list=new LinkedList<Integer>();  // this list will contain only all the VALID points for the number of rounds that took place
        int sum=0;
        for(String op:ops)
        {
            if(op.equals("C"))
            {
                sum-=list.getLast();      //get the last valid points and remove them from the total points since they were invalid
                list.removeLast();
            }
            else if(op.equals("D"))
            {
                list.add(2*list.getLast());  // this round we get double the points we received in the last round
                sum+=list.getLast();

            }
            else if(op.equals("+"))
            {
                list.add(list.getLast()+list.get(list.size()-2));  // we get the sum of last 2 rounds as the current round
                sum+=list.getLast();

            }
            else
            {
                list.add(Integer.parseInt(op));  // the points in intgegers that we get in the current round
                sum+=list.getLast();

            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
