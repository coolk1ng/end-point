package com.coolk1ng.concurrency;

/**
 * 死锁
 *
 * @author coolk1ng
 * @since 2023/5/4 22:34
 */
public class DeadLock {
    public static final Object obj1 = new Object();
    public static final Object obj2 = new Object();

    public static void main(String[] args) {
        new DeadLock().func1();
        new DeadLock().func2();
    }

    public void func1() {
        new Thread(()-> {
           synchronized (obj1) {
               try {
                   Thread.sleep(1000);
                   System.out.println("get obj1...");
                   synchronized (obj2) {
                       System.out.println("get obj2...");
                   }
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        }).start();
    }

    public void func2() {
        new Thread(()-> {
            synchronized (obj2) {
                System.out.println("get obj2...");
                synchronized (obj1) {
                    System.out.println("get obj1...");
                }
            }
        }).start();
    }
}
