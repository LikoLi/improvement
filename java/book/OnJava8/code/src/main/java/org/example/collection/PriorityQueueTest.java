package org.example.collection;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * PriorityQueueTest
 *
 * @author liko
 * @date 2020/7/27
 */
public class PriorityQueueTest {

    static Random random = new Random(47);

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        for (int j = 0; j < 10; j++) {
            int i = random.nextInt(100);
            System.out.println("Random int :" + i);
            queue.offer(i);
            System.out.println(queue);
        }

        for (Object o : queue) {
            System.out.println(o);
        }

    }
}
