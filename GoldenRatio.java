
public class GoldenRatio {
    /**
     * recursively calculate the n'th approximation to the golden ratio.
     * @param n- number calculated in relation to the golden ratio.
     * @return - the n'th approximation to the golden ratio.
     */
    static double goldenRec(int n) {
        if( n==0)
            return 1;
        else

            return 1+1/goldenRec(n-1);

    }
    /**
     *  calculate the n'th approximation to the golden ratio.
     * @param n- number calculated in relation to the golden ratio.
     * @return sum- the n'th approximation to the golden ratio.
     */
    static double goldenIter(int n) {
        if (n<2)  return  n;

         double sum=1.0;
         for (int i=0; i<n; i++){
             sum= 1+1/sum;
        }
          return sum;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.println("Golden Ratio calc by recursion="+ goldenRec(n));
        System.out.println("Golden Ratio calc by iteration="+  goldenIter(n));

    }

}