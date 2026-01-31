package randomizedtest;

import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class testThreeAddThreeRemove {

    @Test
    public void addThreeRemoveThree(){
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        //连续添加三次值
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);

        b.addLast(4);
        b.addLast(5);
        b.addLast(6);
        assertEquals(a.get(0),b.get(0));
        assertEquals(a.get(1),b.get(1));
        assertEquals(a.get(2),b.get(2));

        //连续删3次
        assertEquals(a.removeLast(),b.removeLast());
        assertEquals(a.removeLast(),b.removeLast());
        assertEquals(a.removeLast(),b.removeLast());

    }
    @Test
    public void randAdd(){
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
            else if (operationNumber == 2){
                //getlast
                if (L.size() != 0){
                    System.out.println("getLast(" + L.getLast() + ")");
                }
            }
            else if (operationNumber == 3){
                //remove
                if (L.size() != 0){
                    System.out.println("RemoveLast(" + L.removeLast() + ")");
                }
            }
        }

    }

}
