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
        //随机测试能提供bug在哪里的能力并不清晰 因此随机测试并不推荐！
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                //addLast -Buggy
                B.addLast(randVal);

            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
                int size_b = B.size();
                assertEquals(size,size_b);
            }
            else if (operationNumber == 2){
                //getlast
                if ((L.size() != 0) & (B.size() !=0)){
                    Integer lg=L.getLast();
                    System.out.println("getLast(" + lg + ")");
                    assertEquals(lg,B.getLast());
                }

            }
            else if (operationNumber == 3){
                //remove
                if ((L.size() != 0) & (B.size() !=0)){
                    Integer ir=L.removeLast();
                    System.out.println("RemoveLast(" + ir + ")");
                    assertEquals(ir,B.removeLast());
                }

            }
        }

    }

}
