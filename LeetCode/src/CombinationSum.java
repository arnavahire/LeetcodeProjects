import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if(target == 0 ){
            result.add(new ArrayList<Integer>(cur));
        }//else if

    }

    public static void main(String[] args) {
        CombinationSum cs=new CombinationSum();
        int[] nums={2,3,6,7};
        List<List<Integer>> list=cs.combinationSum(nums,7);
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).size();j++)
            {
                System.out.println(list.get(i).get(j));
            }
            System.out.println("**************");
        }
    }
}
