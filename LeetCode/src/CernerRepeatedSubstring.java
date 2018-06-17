import java.util.Set;
import java.util.TreeSet;

public class CernerRepeatedSubstring {


    public static void main(String[] args) {

        String test = "ABCACBABC";

        int step = 1;

        Set<String> nonReaptingSeq = new TreeSet<>();

        Set<String> reaptingSeq = new TreeSet<>();

        for (int i = 0; (i < test.length() && (i + step) <= test.length()); i++) {

            String sub = test.substring(i, i + step);
            System.out.println(sub);

            if (!nonReaptingSeq.add(sub)) {
                reaptingSeq.add(sub);
            }

        }

        System.out.println(reaptingSeq);

    }
}
