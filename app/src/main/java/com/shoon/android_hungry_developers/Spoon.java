package com.shoon.android_hungry_developers;

public class Spoon {

    boolean bOnTable=true;
    public Spoon(boolean bOnTable) {
        this.bOnTable = bOnTable;
    }

    public boolean pickup(){
        if(bOnTable){
            bOnTable=false;
            return true;

        }else{
            bOnTable=false;
            return false;
        }
    }

    public void putDown() {

        bOnTable = true;

    }
}
