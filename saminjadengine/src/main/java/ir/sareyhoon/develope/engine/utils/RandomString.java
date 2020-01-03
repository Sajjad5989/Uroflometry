package ir.sareyhoon.develope.engine.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Sajjad Assal on 1398/07/10
 */

public class RandomString {


    /*
     * static { for (int idx = 0; idx < 10; ++idx) symbols[idx] = (char)
     * ('0' + idx); for (int idx = 10; idx < 36; ++idx) symbols[idx] =
     * (char) ('a' + idx - 10); }
     */

    private static final char[] symbols = new char[ 36 ];

    static{
        for ( int idx = 0; idx < 10; ++idx )
            symbols[ idx ] = ( char ) ( '0' + idx );
        for ( int idx = 10; idx < 36; ++idx )
            symbols[ idx ] = ( char ) ( 'a' + idx - 10 );
    }

    private final Random random = new Random();

    private final char[] buf;

    public RandomString( int length ){
        if ( length < 1 )
            throw new IllegalArgumentException( "length < 1: " + length );
        buf = new char[ length ];
    }

    public static String getRandomString( ){

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        return randomUUIDString;

    }

    public static int generateRandomIntIntRange( int min, int max ){

        Random r = new Random();

        return r.nextInt( ( max - min ) + 1 ) + min;

    }

    public String nextString( ){
        for ( int idx = 0; idx < buf.length; ++idx )
            buf[ idx ] = symbols[ random.nextInt( symbols.length ) ];
        return new String( buf );
    }

}
