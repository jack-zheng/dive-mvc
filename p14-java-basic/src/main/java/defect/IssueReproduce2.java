package defect;

public class IssueReproduce2 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new IssueClass());
        Thread thread2 = new Thread(new IssueClass());

        thread1.start();
        thread2.start();
    }
}
