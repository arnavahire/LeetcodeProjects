public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        moves=moves.toUpperCase();
        int lCount=0,rCount=0,uCount=0,dCount=0;
        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='L')    lCount++;
            else if(moves.charAt(i)=='R')   rCount++;
            else if(moves.charAt(i)=='D')   dCount++;
            else if(moves.charAt(i)=='U')   uCount++;
        }
        if(lCount!=rCount)
            return false;
        if(dCount!=uCount)
            return false;
        return true;               //return true when leftcount=rightcount and downcount=upcount
    }

    public boolean anotherMethodjudgeCircle(String moves) {
        int centre = 0;
        char[] chars = moves.toCharArray();
        for(char c: chars)
        {
            switch(c)
            {
                case 'U': centre+=3; break;
                case 'D': centre+=-3;break;
                case 'R': centre+=2;break;
                case 'L': centre+=-2;break;
            }
        }
        return centre == 0 ? true: false;
    }

    public static void main(String[] args) {
        JudgeRouteCircle jrc=new JudgeRouteCircle();
        String str="UDLR";
        boolean result=jrc.judgeCircle(str);
        System.out.println(result);
        boolean result2=jrc.anotherMethodjudgeCircle(str);
        System.out.println(result2);
    }
}
