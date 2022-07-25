public class TTH {
    /**
     * recursively calculate the probability of flipping n' coins .
     * @param n- number of flips
     * @return - the n'th coin flipping probability.
     */
    private static double calcP(int n) {
        //TODO: Implement
        if( n<=2)
            return 0.0;

              return  0.5* calcP(n-1) + 0.25*calcP(n-2) +Math.pow(0.5,n);

    }
    /**
     * recursively calculate the probability of flipping
     *  n' coins using the memoization method.
     * @param n- number of flips
     * @param memory - memoization table
     * @return - the array of n'th coin flipping probability.
     */
    private static double calcPmem(int n, double[] memory) {
        //TODO: Implement
        if(n<2)
            return 0.0;
        if( memory[n]==0)
            memory[n]= 0.5*calcPmem(n-1,memory)+ 0.25*calcPmem(n-2,memory)+Math.pow(0.5,n);
        return memory[n];

    }

    // this main function is provided
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double duration = 0;
        double durationMem = 0;
        int reps = 1000;
        double startTime, endTime;

        for (int i=0; i < reps; i++) {
            startTime = System.nanoTime();
            calcP(n);
            endTime = System.nanoTime();
            duration += (endTime - startTime)/reps;

            double[] memory = new double[n + 1];
            startTime = System.nanoTime();
            calcPmem(n, memory);
            endTime = System.nanoTime();
            durationMem += (endTime - startTime)/reps;
        }
        StdOut.println("P(" + n + ") = " + calcP(n));
        StdOut.println("no memoization: " + duration/100);
        StdOut.println("with memoization: " + durationMem/100);
    }
}
