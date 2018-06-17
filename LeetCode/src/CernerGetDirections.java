public class CernerGetDirections {

    String getDirections(Point p1,Point p2)
    {
        StringBuilder result=new StringBuilder();

        if(p2.y!=p1.y)
        {
            if(p2.y>p1.y)
                result.append('N');
            else
                result.append('S');
            if(p2.x>p1.x)
                result.append('E');
            else if(p2.x<p1.x)
                result.append('W');
            else
                return result.toString();

        }
        else if(p2.y==p1.y)
        {
            if(p2.x==p1.x)
                return result.append("here").toString();
            if(p2.x>p1.x)
                result.append('E');
            else
                result.append('W');
        }

        return result.toString();
    }


    public static void main(String[] args) {
        CernerGetDirections cgd=new CernerGetDirections();
        Point p1=new Point(1,2);
        Point p2=new Point(-1,-3);
        String result=cgd.getDirections(p1,p2);
        System.out.println(result);
    }
}

class Point
{
    int x;
    int y;

    Point(int a,int b)
    {
        x=a;
        y=b;
    }
}
