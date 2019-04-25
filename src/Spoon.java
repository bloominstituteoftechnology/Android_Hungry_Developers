import java.util.concurrent.Semaphore;

public class Spoon {

    private Semaphore lock;

public boolean pickup(){
    try {
        lock.acquire();
        return true;
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return false;
}

public void putDown(){
    lock.release();
}

}
