package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，
 * 线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。
 */
public class Test13 {

    private char[] chars;
    private volatile AtomicInteger index;

    public Test13(char[] chars, AtomicInteger index) {
        this.chars = chars;
        this.index = index;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            int count = Integer.valueOf(s);
            Test13 test13 = new Test13(new char[count * 4], new AtomicInteger(0));
            ReentrantLock lock = new ReentrantLock();
            Condition a = lock.newCondition();
            Condition b = lock.newCondition();
            Condition c = lock.newCondition();
            Condition d = lock.newCondition();
            Thread threada = new Thread(new PrintAbcd(test13, lock, a, b, 'A'));
            Thread threadb = new Thread(new PrintAbcd(test13, lock, b, c, 'B'));
            Thread threadc = new Thread(new PrintAbcd(test13, lock, c, d, 'C'));
            Thread threadd = new Thread(new PrintAbcd(test13, lock, d, a, 'D'));
            threada.start();
            threadb.start();
            threadc.start();
            threadd.start();
            threada.join();
            threadb.join();
            threadc.join();
            threadd.join();
            System.out.println(new String(test13.chars));
        }

    }

    static class PrintAbcd implements Runnable {
        private Test13 test13;
        private Lock lock;
        private Condition self;
        private Condition next;
        private char name;

        public PrintAbcd(Test13 test13, Lock lock, Condition self, Condition next, char name) {
            this.test13 = test13;
            this.lock = lock;
            this.self = self;
            this.next = next;
            this.name = name;
        }

        @Override
        public void run() {
            while (test13.index.get() < test13.chars.length) {
                lock.lock();
                try {

                    if (test13.index.get() % 4 == 0 && 'A' == name) {
                        test13.chars[test13.index.get()] = name;
                    } else if (test13.index.get() % 4 == 1 && 'B' == name) {
                        test13.chars[test13.index.get()] = name;
                    } else if (test13.index.get() % 4 == 2 && 'C' == name) {
                        test13.chars[test13.index.get()] = name;
                    } else /* (test13.index % 4 == 3 && 'D' == name)*/ {
                        test13.chars[test13.index.get()] = name;
                    }
                    test13.index.incrementAndGet();
                    next.signal();
                    try {
                        self.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } finally {
                    next.signal();
                    lock.unlock();
                }
            }
        }
    }


}
