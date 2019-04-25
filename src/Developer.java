public class Developer implements  Runnable{

    private String name;
    private Spoon leftSpoon;
    private Spoon rightSpoon;



    public void think(){
    }

    public boolean eat() {
        return false;
    }

    public void run() {

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
