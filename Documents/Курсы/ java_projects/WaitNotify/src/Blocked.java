/**
 * Created by dmitro on 24.02.15.
 */
public class Blocked {

    private int i = 1000;
    private boolean locker=true;
    public void setLocker (boolean locker){
        this.locker=locker;

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public synchronized void doWait() {
        try {
            System.out.print("Welcome ");
            while(locker)
            this.wait();
            System.out.print("fabrika.");
           // Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < 5; j++) i/=5;
        System.out.print("od.");
    }
}
