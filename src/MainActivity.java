public class MainActivity {

    public static void main(String[] args) {


        Developer[] developers = new Developer[5];
        Spoon[] spoons = new Spoon[5];

        developers[0] = new Developer("Dev1");
        developers[1] = new Developer("Dev2");
        developers[2] = new Developer("Dev3");
        developers[3] = new Developer("Dev4");
        developers[4] = new Developer("Dev5");


        spoons[0] = new Spoon(0);
        spoons[1] = new Spoon(1);
        spoons[2] = new Spoon(2);
        spoons[3] = new Spoon(3);
        spoons[4] = new Spoon(4);

        for (int i = 0; i < developers.length; ++i){ //assign spoons
            if (i==0) {
                developers[i].setLeftSpoon(spoons[developers.length-1]);
                System.out.println(developers[i].getName() + " was assigned left spoon " + (developers.length - 1));
            } else {
                developers[i].setLeftSpoon(spoons[i-1]);
                System.out.println(developers[i].getName() + " was assigned left spoon " + (i-1));


            }
            developers[i].setRightSpoon(spoons[i]);
            System.out.println(developers[i].getName() + " was assigned right spoon " + i);
        }

        for(Developer developer: developers) {
            new Thread(developer).start();
        }

    }
}
