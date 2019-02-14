package org.lyx.concurrentDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
      final   CountDownLatch latch = new CountDownLatch(4);
        
        new Thread() {
            @Override
            public void run() {
                System.out.println("加工线程：" + Thread.currentThread().getName() + "开始等待数据");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("数据都到齐了！！！");
            }
        }.start();
        
        for (int i=0; i<4; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "开始统计数据");
                    try {
                        sleep(1000);  // 模拟统计过程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "统计完成");
                    latch.countDown();
                }
            }.start();
        }
    }
}