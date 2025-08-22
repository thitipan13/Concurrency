import java.util.ArrayList;

public class BankTest {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        ArrayList<Thread> t = new ArrayList<>();
        int NUM_DEPOSITOR = 3;
        int NUM_WITHDEAWER = 0;
        int VALUE = 100;
        int ROUND = 10000;
        //สร้างคนฝาก
        for (int i = 0; i < NUM_DEPOSITOR; i++) {
            Thread x = new Thread(new Depositor(a, VALUE, ROUND));
            t.add(x);
        }

        //สั่งทำงาน
        for(Thread thread : t){
            thread.start();
        }
        //ทำงานจนเสร็จ
        try {
            for(Thread thread : t){
                thread.join();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Expected value : "+(NUM_DEPOSITOR-NUM_WITHDEAWER)*VALUE*ROUND);
        System.out.println("Real value : "+a.getBalance());
    }
}
