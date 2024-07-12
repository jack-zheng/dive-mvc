package defect;

import java.util.ArrayList;

public class ConcurrentModificationExpReproduce {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Thread thread1 = new Thread(() -> {
            for (Integer integer : list) {
                System.out.println(integer);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> list.removeIf(integer -> integer == 2));
        thread1.start();
        thread2.start();
    }
}
