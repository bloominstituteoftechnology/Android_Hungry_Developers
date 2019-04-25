import java.util.concurrent.Semaphore;

public class Spoon {

    private Semaphore lock;
    private int index;

    public Spoon(int index) {
        this.index = index;
        lock = new Semaphore(1);
    }

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

    public int getIndex() {
        return index;
    }
}
