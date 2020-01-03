package ir.sareyhoon.develope.engine.utils;

import java.util.Random;

public class RandomNumber {
    public static long getLongRandom( ){
        long leftLimit = 10000000L;
        long rightLimit = 100000000L;
        return leftLimit + ( long ) ( Math.random() * ( rightLimit - leftLimit ) );
    }

    public static int getIntRandom(){
        int leftLimit = 1;
        int rightLimit = 10;
        return leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
    }
}
