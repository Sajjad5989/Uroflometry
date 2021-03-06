package ir.sareyhoon.develope.engine.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalendarTool {

    private int irYear; // Year part of a Iranian date
    private int irMonth; // Month part of a Iranian date
    private int irDay;  // Day part of a Iranian date
    private int gYear;  // Year part of a Gregorian date
    private int gMonth; // Month part of a Gregorian date
    private int gDay;   // Day part of a Gregorian date
    private int juYear; // Year part of a Julian date
    private int juMonth; // Month part of a Julian date
    private int juDay;  // Day part of a Julian date
    private int leap;   // Number of years since the last leap year (0 to 4)
    private int JDN;    // Julian Day Number
    private int march;  // The march day of Farvardin the first (First day of jaYear)


    public CalendarTool( ){
        Calendar calendar = new GregorianCalendar();
        setGregorianDate( calendar.get( Calendar.YEAR ),
                calendar.get( Calendar.MONTH ) + 1,
                calendar.get( Calendar.DAY_OF_MONTH ) );
    }


    public CalendarTool( int year, int month, int day ){
        setGregorianDate( year, month, day );
    }

    @SuppressLint( "SimpleDateFormat" )
    public String getPersianDateTime( ){

        //DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat( "yyyy" );
        DateFormat dateFormat3 = new SimpleDateFormat( "MM" );
        DateFormat dateFormat4 = new SimpleDateFormat( "dd" );
        Calendar cal = Calendar.getInstance();

        //String time = dateFormat1.format(cal.getTime());
        String y = dateFormat2.format( cal.getTime() );
        String m = dateFormat3.format( cal.getTime() );
        String d = dateFormat4.format( cal.getTime() );

        setGregorianDate( Integer.parseInt( y ), Integer.parseInt( m ), Integer.parseInt( d ) );

        String MonthName = "";
        if ( irMonth == 1 )
            MonthName = "فروردین";
        else if ( irMonth == 2 )
            MonthName = "اردی بهشت";
        else if ( irMonth == 3 )
            MonthName = "خرداد";
        else if ( irMonth == 4 )
            MonthName = "تیر";
        else if ( irMonth == 5 )
            MonthName = "مرداد";
        else if ( irMonth == 6 )
            MonthName = "شهریور";
        else if ( irMonth == 7 )
            MonthName = "مهر";
        else if ( irMonth == 8 )
            MonthName = "آبان";
        else if ( irMonth == 9 )
            MonthName = "آذر";
        else if ( irMonth == 10 )
            MonthName = "دی";
        else if ( irMonth == 11 )
            MonthName = "بهمن";
        else if ( irMonth == 12 )
            MonthName = "اسفند";

        return ( irDay + " " + MonthName + " " + irYear );
    }

    public String getFaMonthName( ){
        if ( irMonth == 1 )
            return "فروردین";
        else if ( irMonth == 2 )
            return "اردی بهشت";
        else if ( irMonth == 3 )
            return "خرداد";
        else if ( irMonth == 4 )
            return "تیر";
        else if ( irMonth == 5 )
            return "مرداد";
        else if ( irMonth == 6 )
            return "شهریور";
        else if ( irMonth == 7 )
            return "مهر";
        else if ( irMonth == 8 )
            return "آبان";
        else if ( irMonth == 9 )
            return "آذر";
        else if ( irMonth == 10 )
            return "دی";
        else if ( irMonth == 11 )
            return "بهمن";
        else if ( irMonth == 12 )
            return "اسفند";
        else
            return "اسفند";
    }

    @SuppressLint( "SimpleDateFormat" )
    public String getIntPersianDateTime( ){

        //DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat( "yyyy" );
        DateFormat dateFormat3 = new SimpleDateFormat( "MM" );
        DateFormat dateFormat4 = new SimpleDateFormat( "dd" );
        Calendar cal = Calendar.getInstance();

        //String time = dateFormat1.format(cal.getTime());
        String y = dateFormat2.format( cal.getTime() );
        String m = dateFormat3.format( cal.getTime() );
        String d = dateFormat4.format( cal.getTime() );

        setGregorianDate( Integer.parseInt( y ), Integer.parseInt( m ), Integer.parseInt( d ) );

        String M, D;
        if ( irMonth < 10 )
            M = "0" + irMonth;
        else
            M = String.valueOf( irMonth );

        if ( irDay < 10 )
            D = "0" + irDay;
        else
            D = String.valueOf( irDay );

        return ( irYear + "" + M + "" + D );
    }

    @SuppressLint( "SimpleDateFormat" )
    public String getActualPersianDateTime( ){

        //DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat( "yyyy" );
        DateFormat dateFormat3 = new SimpleDateFormat( "MM" );
        DateFormat dateFormat4 = new SimpleDateFormat( "dd" );
        Calendar cal = Calendar.getInstance();

        //String time = dateFormat1.format(cal.getTime());
        String y = dateFormat2.format( cal.getTime() );
        String m = dateFormat3.format( cal.getTime() );
        String d = dateFormat4.format( cal.getTime() );

        setGregorianDate( Integer.parseInt( y ), Integer.parseInt( m ), Integer.parseInt( d ) );

        String M, D;
        if ( irMonth < 10 )
            M = "0" + irMonth;
        else
            M = String.valueOf( irMonth );

        if ( irDay < 10 )
            D = "0" + irDay;
        else
            D = String.valueOf( irDay );

        return ( irYear + "/" + M + "/" + D );
    }

    @SuppressLint( "SimpleDateFormat" )
    public String getEnglishDateTime( ){

        //DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat( "yyyy" );
        DateFormat dateFormat3 = new SimpleDateFormat( "MM" );
        DateFormat dateFormat4 = new SimpleDateFormat( "dd" );
        Calendar cal = Calendar.getInstance();

        //String time = dateFormat1.format(cal.getTime());
        String y = dateFormat2.format( cal.getTime() );
        String m = dateFormat3.format( cal.getTime() );
        String d = dateFormat4.format( cal.getTime() );

        String MonthName = "";
        if ( Integer.parseInt( m ) == 1 )
            MonthName = "ژانویه";
        else if ( Integer.parseInt( m ) == 2 )
            MonthName = "فوریه";
        else if ( Integer.parseInt( m ) == 3 )
            MonthName = "مارس";
        else if ( Integer.parseInt( m ) == 4 )
            MonthName = "آوریل";
        else if ( Integer.parseInt( m ) == 5 )
            MonthName = "مه";
        else if ( Integer.parseInt( m ) == 6 )
            MonthName = "ژوئن";
        else if ( Integer.parseInt( m ) == 7 )
            MonthName = "جولای";
        else if ( Integer.parseInt( m ) == 8 )
            MonthName = "آگوست";
        else if ( Integer.parseInt( m ) == 9 )
            MonthName = "سپتامبر";
        else if ( Integer.parseInt( m ) == 10 )
            MonthName = "اکتبر";
        else if ( Integer.parseInt( m ) == 11 )
            MonthName = "نوامبر";
        else if ( Integer.parseInt( m ) == 12 )
            MonthName = "دسامبر";

        return ( d + " " + MonthName + " " + y );
    }


    public int getIranianYear( ){
        return irYear;
    }


    public int getIranianMonth( ){
        return irMonth;
    }


    public int getIranianDay( ){
        return irDay;
    }


    public int getGregorianYear( ){
        return gYear;
    }


    public int getGregorianMonth( ){
        return gMonth;
    }


    public int getGregorianDay( ){
        return gDay;
    }


    public int getJulianYear( ){
        return juYear;
    }


    public int getJulianMonth( ){
        return juMonth;
    }


    public int getJulianDay( ){
        return juDay;
    }


    public String getIranianDate( ){
        return ( irYear + "/" + irMonth + "/" + irDay );
    }

    public String getDate( ){
        return irYear + "/" + ( irMonth < 10 ? "0" + irMonth : String.valueOf( irMonth ) ) + "/" + ( irDay < 10 ? "0" + irDay : String.valueOf( irDay ) );
    }

    private String getGregorianDate( ){
        return ( gYear + "-" + gMonth + "-" + gDay );
    }


    private String getJulianDate( ){
        return ( juYear + "-" + juMonth + "-" + juDay );
    }


    private String getWeekDayStr( ){
        String[] weekDayStr = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday" };
        return ( weekDayStr[ getDayOfWeek() ] );
    }

    public String getWeekDayStrFa( ){
        String[] weekDayStr = {
                "دوشنبه",
                "سه شنبه",
                "چهارشنبه",
                "پنج شنبه",
                "جمعه",
                "شنبه",
                "یک شنبه" };
        return ( weekDayStr[ getDayOfWeek() ] );
    }


    public String to_String( ){
        return ( getWeekDayStr() +
                ", Gregorian:[" + getGregorianDate() +
                "], Julian:[" + getJulianDate() +
                "], Iranian:[" + getIranianDate() + "]" );
    }


    private int getDayOfWeek( ){
        return ( JDN % 7 );
    }


    public void nextDay( ){
        JDN++;
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    public void nextDay( int days ){
        JDN += days;
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    public void previousDay( ){
        JDN--;
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    public void previousDay( int days ){
        JDN -= days;
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    public void setIranianDate( int year, int month, int day ){
        irYear = year;
        irMonth = month;
        irDay = day;
        JDN = IranianDateToJDN();
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    private void setGregorianDate( int year, int month, int day ){
        gYear = year;
        gMonth = month;
        gDay = day;
        JDN = gregorianDateToJDN( year, month, day );
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    public void setJulianDate( int year, int month, int day ){
        juYear = year;
        juMonth = month;
        juDay = day;
        JDN = julianDateToJDN( year, month, day );
        JDNToIranian();
        JDNToJulian();
        JDNToGregorian();
    }


    private void IranianCalendar( ){
        // Iranian years starting the 33-year rule
        int[] Breaks =
                { -61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181,
                        1210, 1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178 };
        int jm, N, leapJ, leapG, jp, j, jump;
        gYear = irYear + 621;
        leapJ = -14;
        jp = Breaks[ 0 ];
        // Find the limiting years for the Iranian year 'irYear'
        j = 1;
        do {
            jm = Breaks[ j ];
            jump = jm - jp;
            if ( irYear >= jm ) {
                leapJ += ( jump / 33 * 8 + ( jump % 33 ) / 4 );
                jp = jm;
            }
            j++;
        }
        while ( ( j < 20 ) && ( irYear >= jm ) );
        N = irYear - jp;
        // Find the number of leap years from AD 621 to the begin of the current
        // Iranian year in the Iranian (Jalali) calendar
        leapJ += ( N / 33 * 8 + ( ( N % 33 ) + 3 ) / 4 );
        if ( ( ( jump % 33 ) == 4 ) && ( ( jump - N ) == 4 ) )
            leapJ++;
        // And the same in the Gregorian date of Farvardin the first
        leapG = gYear / 4 - ( ( gYear / 100 + 1 ) * 3 / 4 ) - 150;
        march = 20 + leapJ - leapG;
        // Find how many years have passed since the last leap year
        if ( ( jump - N ) < 6 )
            N = N - jump + ( ( jump + 4 ) / 33 * 33 );
        leap = ( ( ( N + 1 ) % 33 ) - 1 ) % 4;
        if ( leap == -1 )
            leap = 4;
    }


    public boolean IsLeap( int irYear1 ){
        // Iranian years starting the 33-year rule
        int[] Breaks =
                { -61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181,
                        1210, 1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178 };
        int jm, N, leapJ, leapG, jp, j, jump;
        gYear = irYear1 + 621;
        leapJ = -14;
        jp = Breaks[ 0 ];
        // Find the limiting years for the Iranian year 'irYear'
        j = 1;
        do {
            jm = Breaks[ j ];
            jump = jm - jp;
            if ( irYear1 >= jm ) {
                leapJ += ( jump / 33 * 8 + ( jump % 33 ) / 4 );
                jp = jm;
            }
            j++;
        }
        while ( ( j < 20 ) && ( irYear1 >= jm ) );
        N = irYear1 - jp;
        // Find the number of leap years from AD 621 to the begin of the current
        // Iranian year in the Iranian (Jalali) calendar
        leapJ += ( N / 33 * 8 + ( ( N % 33 ) + 3 ) / 4 );
        if ( ( ( jump % 33 ) == 4 ) && ( ( jump - N ) == 4 ) )
            leapJ++;
        // And the same in the Gregorian date of Farvardin the first
        leapG = gYear / 4 - ( ( gYear / 100 + 1 ) * 3 / 4 ) - 150;
        march = 20 + leapJ - leapG;
        // Find how many years have passed since the last leap year
        if ( ( jump - N ) < 6 )
            N = N - jump + ( ( jump + 4 ) / 33 * 33 );
        leap = ( ( ( N + 1 ) % 33 ) - 1 ) % 4;
        if ( leap == -1 )
            leap = 4;
        return leap == 4 || leap == 0;

    }


    private int IranianDateToJDN( ){
        IranianCalendar();
        return ( gregorianDateToJDN( gYear, 3, march ) + ( irMonth - 1 ) * 31 - irMonth / 7 * ( irMonth - 7 ) + irDay - 1 );
    }


    private void JDNToIranian( ){
        JDNToGregorian();
        irYear = gYear - 621;
        IranianCalendar(); // This invocation will update 'leap' and 'march'
        int JDN1F = gregorianDateToJDN( gYear, 3, march );
        int k = JDN - JDN1F;
        if ( k >= 0 ) {
            if ( k <= 185 ) {
                irMonth = 1 + k / 31;
                irDay = ( k % 31 ) + 1;
                return;
            } else
                k -= 186;
        } else {
            irYear--;
            k += 179;
            if ( leap == 1 )
                k++;
        }
        irMonth = 7 + k / 30;
        irDay = ( k % 30 ) + 1;
    }


    private int julianDateToJDN( int year, int month, int day ){
        return ( year + ( month - 8 ) / 6 + 100100 ) * 1461 / 4 + ( 153 * ( ( month + 9 ) % 12 ) + 2 ) / 5 + day - 34840408;
    }


    private void JDNToJulian( ){
        int j = 4 * JDN + 139361631;
        int i = ( ( j % 1461 ) / 4 ) * 5 + 308;
        juDay = ( i % 153 ) / 5 + 1;
        juMonth = ( ( i / 153 ) % 12 ) + 1;
        juYear = j / 1461 - 100100 + ( 8 - juMonth ) / 6;
    }


    private int gregorianDateToJDN( int year, int month, int day ){
        int jdn = ( year + ( month - 8 ) / 6 + 100100 ) * 1461 / 4 + ( 153 * ( ( month + 9 ) % 12 ) + 2 ) / 5 + day - 34840408;
        jdn = jdn - ( year + 100100 + ( month - 8 ) / 6 ) / 100 * 3 / 4 + 752;
        return ( jdn );
    }


    private void JDNToGregorian( ){
        int j = 4 * JDN + 139361631;
        j = j + ( ( ( ( ( 4 * JDN + 183187720 ) / 146097 ) * 3 ) / 4 ) * 4 - 3908 );
        int i = ( ( j % 1461 ) / 4 ) * 5 + 308;
        gDay = ( i % 153 ) / 5 + 1;
        gMonth = ( ( i / 153 ) % 12 ) + 1;
        gYear = j / 1461 - 100100 + ( 8 - gMonth ) / 6;
    }
} // End of Class 'JavaSource_Calendar
