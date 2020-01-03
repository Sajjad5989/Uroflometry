package ir.sareyhoon.develope.engine.utils;

public class DateUtil {
    private static String getToday( ){
        return new CalendarTool().getDate();
    }

    public static String getSimpleDateForApi( ){
        String today = getToday();
        String replace = today.replace( "/", "" );
        return replace.substring( 2, 8 );

    }

    public static String miladiToShamsi( String enDate ){
        String[] sepDate = enDate.split( "-" );
        int y = Integer.parseInt( sepDate[ 0 ] );
        int m = Integer.parseInt( sepDate[ 1 ] );
        int d = Integer.parseInt( sepDate[ 2 ] );
        CalendarTool calendarTool = new CalendarTool( y, m, d );

        return calendarTool.getDate();
    }
}
