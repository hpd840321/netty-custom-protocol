package org.lyx.concurrentDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
      final   CyclicBarrier barrier = new CyclicBarrier(4);
        
        for (int i=0; i<4; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "开始检查文件");
                    try {
                        sleep(2000);  // 模拟检查过程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "检查文件结束，等待其他线程");
                    try {
                        barrier.await();  // 等待
                    } catch (InterruptedException  e) {
                        e.printStackTrace();
                    }catch ( BrokenBarrierException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "统计");
                }
            }.start();
        }
    }
}