import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessInfo {
    int id;
    double rating;
    public static double calculateMedianRating(List<BusinessInfo> businessInfoList)
    {
        double median=0;
        ArrayList<Double> ratingsList=new ArrayList<>();
        for(int i=0;i<businessInfoList.size();i++)
        {
            ratingsList.add(businessInfoList.get(i).rating);
        }

        Collections.sort(ratingsList);
        if(ratingsList.size()==0)
        {
            return median;
        }
        else if(ratingsList.size()%2==0)
        {
            median=ratingsList.get(ratingsList.size()/2)+ratingsList.get((ratingsList.size()/2)+1);
        }
        else
        {
            median=ratingsList.get(ratingsList.size()/2);
        }

        return median;
    }
}

