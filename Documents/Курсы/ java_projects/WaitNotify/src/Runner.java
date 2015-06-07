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


            Thread.sleep(2);


        synchronized (blocked) {
            blocked.setI(blocked.getI() + 3);
            System.out.print("repository");
            /*try {
                blocked.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.print("=" + blocked.getI());
    }
}
