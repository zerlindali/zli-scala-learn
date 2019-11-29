package day01.happensbefore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ZerlindaLi create at 2019/5/15 14:29
 * @version 1.0.0
 * @description HappensBeforeDemo
 */
public class HappensBeforeDemo {


    int a = 0;
    int b = 0;
    int x = -1;
    int y = -1;

    public void path1() {
        a = 1;
        x = b;
    }

    public void path2() {
        b = 2;
        y = a;
    }

    public boolean test() throws InterruptedException {
        a = b = 0;
        x = y = -1;
        CyclicBarrier cy = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {
            try {
                cy.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            path1();
        });
        Thread t2 = new Thread(() -> {
            try {
                cy.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            path2();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

//        System.out.println("x="+x+", y="+y);
        if (x == 0 && y == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= 300000; i++) {
            HappensBeforeDemo tt = new HappensBeforeDemo();
            boolean b = tt.test();
            if (!b) {
                System.out.println(i);
            }
        }
    }

}
