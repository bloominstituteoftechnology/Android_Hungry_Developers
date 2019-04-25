import java.awt.*;
import java.util.Random;

public class Developer implements  Runnable{

    private String name;
    private Spoon leftSpoon;
    private Spoon rightSpoon;
    private Random rand = new Random();


    public void think(){
        System.out.println(name + " Is Thinking...");
        try {
            Thread.sleep(rand.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat() {
        System.out.println(name + " Is eating!!!!");
        try {
            Thread.sleep(rand.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " put down both spoons. Yum!");
        leftSpoon.putDown();
        rightSpoon.putDown();
    }

    public void run() {

        while (true) {
            think();
            leftSpoon.pickup();
            System.out.println(name + " Picked up Spoon " + leftSpoon.getIndex());
            //think();
            rightSpoon.pickup();
            System.out.println(name + " Picked up Spoon " + rightSpoon.getIndex());
            eat();
        }
    }

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLeftSpoon(Spoon leftSpoon) {
        this.leftSpoon = leftSpoon;
    }

    public void setRightSpoon(Spoon rightSpoon) {
        this.rightSpoon = rightSpoon;
    }
}
