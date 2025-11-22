package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int[] numbers = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> N = new AList<>();
        for(int i = 0; i < numbers.length; i++) {
            N.addLast(numbers[i]);
        }

        AList<Integer> ops=new AList<>();
        for(int i = 0; i < numbers.length; i++) {
            ops.addLast(10000);
        }
        AList<Double> times = new AList<>();
        double duration=0.0;
        double stime;
        double etime;
        int last;

        //add N items to Slist
        for(int i=0;i<N.size();i++){
            //ith sList
            SLList<Integer> s1 = new SLList<>();
            for(int j=0;j<N.get(i);j++){
                //add
                s1.addLast(j);
            }
            //start timer
            stime = System.currentTimeMillis();
            for(int m=0;m<ops.get(i);m++){
                last=s1.getLast();
            }
            etime = System.currentTimeMillis();
            //check timer
            duration += etime - stime;
            times.addLast(duration/1000);
        }
        printTimingTable(N,times,ops);
    }

}
