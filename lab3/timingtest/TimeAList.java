package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int[] numbers = {1000,2000,4000,8000,16000,32000,64000,128000,1000000};
        AList<Integer> N = new AList<>();
        for(int i=0;i<numbers.length;i++){
            N.addLast(numbers[i]);
        }
        AList<Integer> ops = N;//double[] times=new double[8];//sum time
        AList<Double> times = new AList<>();
        //AList<Double> microsec = new AList<>();
        double duration; // times helper
        //double microHelper;


        for(int i=0;i<N.size();i++){
            AList<Integer> a1=new AList<Integer>();
            duration = 0.00;
            //microHelper = 0.00;
            for(int j=0;j<N.get(i);j++){
                //计时开始
                double stime = System.currentTimeMillis();
                //创建大小为N的Alist
                a1.addLast(j);
                //计时结束
                double etime = System.currentTimeMillis();
                duration+= (etime - stime);
                //microHelper +=(etime - stime);

            }
            times.addLast(duration/1000);// 1s == 1000 ms
            //microsec.addLast(microHelper/N.size());

        }
        printTimingTable(N,times,ops);
    }
}
