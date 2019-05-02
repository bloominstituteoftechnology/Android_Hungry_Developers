package com.shoon.android_hungry_developers;

public class Developer extends Thread implements Runnable{
    private Spoon leftSpoon,
            rigthSpoon;
    String strName;
    public Developer(Spoon leftSpoon, Spoon rigthSpoon) {
        this.leftSpoon = leftSpoon;
        this.rigthSpoon = rigthSpoon;
    }
    public Developer(String Name, Spoon leftSpoon, Spoon rigthSpoon) {
        this.leftSpoon = leftSpoon;
        this.rigthSpoon = rigthSpoon;
        this.strName=Name;
    }


    public boolean think(){
        if(leftSpoon.pickup()&&rigthSpoon.pickup()){
            System.out.println(strName+" found both spoons on the table");
            return true;
        }else{
            System.out.println(strName+" found left spoon on the table");

            System.out.println(strName+" found right spoon on the table");
            return false;
        }

    }
    public void eat(){
        try {
            System.out.println(strName+" is eating");
            Thread.sleep((long) Math.random()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        leftSpoon.putDown();
        rigthSpoon.putDown();
        System.out.println(strName+" placed spoons on the table");
    }

    public void run(){

        if(think()) eat();
    }

}
