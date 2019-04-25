public class MainActivity {

    public static void main(String[] args) {


        Developer[] developers = new Developer[5];
        Spoon[] spoons = new Spoon[5];

        developers[0] = new Developer("Spencer");
        developers[1] = new Developer("Jake");
        developers[2] = new Developer("Brandon");
        developers[3] = new Developer("Basil");
        developers[4] = new Developer("Vivek");


        spoons[0] = new Spoon();
        spoons[1] = new Spoon();
        spoons[2] = new Spoon();
        spoons[3] = new Spoon();
        spoons[4] = new Spoon();

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
