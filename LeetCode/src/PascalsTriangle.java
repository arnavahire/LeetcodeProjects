import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> listOfList=new LinkedList<List<Integer>>();

        for(int i=0;i<numRows;i++)
        {
            LinkedList<Integer> row=new LinkedList<Integer>();
            if(i==0)
            {
                row.add(1);
            }
            else if(i==1)
            {
                row.add(1);
                row.add(1);
            }
            else
            {
                row.add(listOfList.get(listOfList.size()-1).get(0)); // get the 0th index of the last list present in the list of list and append it to current row
                for(int j=0;j<listOfList.get(listOfList.size()-1).size()-1;j++)  // execute the loop till the second last element in the list containing integers
                {
                    row.add(listOfList.get(listOfList.size()-1).get(j)+listOfList.get(listOfList.size()-1).get(j+1)); // append the current element and the next element to the current row
                }
                row.add(listOfList.get(listOfList.size()-1).get(listOfList.get(listOfList.size()-1).size()-1));  // append the last element of the final list currently present in the list of list to the current row
            }
            listOfList.add(row);

        }
        return listOfList;


    }

    public static void main(String[] args) {
        PascalsTriangle pt=new PascalsTriangle();
        int numRows=6;
        List<List<Integer>> list=pt.generate(numRows);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }

    }
}
