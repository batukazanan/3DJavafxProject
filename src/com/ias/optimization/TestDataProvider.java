package com.ias.optimization;

import java.util.ArrayList;
import java.util.Random;

public class TestDataProvider {
    public static ArrayList<SimpleBox> randomizeSize(int boxCount) {

        ArrayList<SimpleBox> list = new ArrayList<>();

        for (int i=0;i<boxCount;i++){
            SimpleBox simpleBox = new SimpleBox(i*10, i*10,  i*10);
            list.add(simpleBox);
        }


        return list;
    }

    public static ArrayList<SimpleBox> randomizeSizeAndLocation(int boxCount) {

        ArrayList<SimpleBox> list = new ArrayList<>();
        Random r = new Random();

        for (int i=0;i<boxCount;i++){

//            int cubeSize =  r.nextInt(4) + 1;

            SimpleBox simpleBox = new SimpleBox( r.nextInt(4) + 1,   r.nextInt(4) + 1,   r.nextInt(4) + 1);
            list.add(simpleBox);
        }


        return list;
    }




}
