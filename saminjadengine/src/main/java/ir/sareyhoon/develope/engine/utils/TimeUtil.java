package ir.sareyhoon.develope.engine.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    public static String time( ){
        SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss", Locale.US );
        return sdf.format( new Date() );

    }
}
