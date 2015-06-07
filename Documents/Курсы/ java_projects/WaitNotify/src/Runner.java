/**
 * Created by dmitro on 24.02.15.
 */
public class Runner {


    public static void main(String[] args) throws InterruptedException {

        final Blocked blocked = new Blocked();

        new Thread() {
            public void run() {
                blocked.doWait();
            }
        }.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (blocked) {
            blocked.setI(blocked.getI() + 2);
            System.out.print("to ");
            blocked.setLocker(false);
            blocked.notify();
        }
            Thread.sleep(1);


        synchronized (blocked) {
            blocked.setI(blocked.getI() + 3);
            System.out.print("ua.");
            /*try {
                blocked.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.print("=" + blocked.getI());
    }
}
