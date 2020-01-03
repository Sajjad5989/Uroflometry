package ir.toucan.project.app.android.uroflometry.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.multidex.MultiDex;

import com.google.android.material.snackbar.Snackbar;

import ir.sareyhoon.develope.engine.utils.DisplayUtils;
import ir.toucan.project.app.android.uroflometry.R;

public class APP extends Application {

    public static int deviceWidth = 0;
    public static int deviceWidthPix = 0;
    public static int deviceHeight = 0;
    public static int deviceHeightPix = 0;


    @SuppressLint( "StaticFieldLeak" )
    public static Context context;
    @SuppressLint( "StaticFieldLeak" )
    public static Activity currentActivity;

    public static void setDeviceDimensions( Activity activity ){
        deviceWidth = DisplayUtils.getWidth( activity );
        deviceWidthPix = DisplayUtils.getWidth( activity );
        deviceHeight = DisplayUtils.getWidth( activity );
        deviceHeightPix = DisplayUtils.getWidth( activity );
    }

    public static void playSnack( View view, String message ){
        Snackbar snackbar = Snackbar.make( view, message, Snackbar.LENGTH_SHORT );
        ViewCompat.setLayoutDirection( snackbar.getView(), ViewCompat.LAYOUT_DIRECTION_RTL );
        snackbar.show();
    }

    public static String getColorizeAppString( String inputValue ){
        String a = inputValue.replace( context.getString( R.string.app_name ), "<font color='#E53935'><b>" + context.getString( R.string.app_name ) + "</b></font>" );
        return a.replace( "اپلیکیشن", "<font color='#E53935'><b>اپلیکیشن</b></font>" );
    }

    public static String stringMapper( String input ){
        return input.
                replace( 'ك', 'ک' ).
                replace( 'ى', 'ی' ).
                replace( 'ي', 'ی' ).
                replace( '١', '۱' ).
                replace( '٢', '۲' ).
                replace( '٣', '۳' ).
                replace( '٤', '۴' ).
                replace( '٥', '۵' ).
                replace( '٦', '۶' ).
                replace( '٧', '۷' ).
                replace( '٨', '۸' ).
                replace( '٩', '۹' ).
                replace( '٠', '۰' );
    }

    public static void killApp( Activity activity ){
        activity.finishAffinity();
        ActivityCompat.finishAffinity( activity );
        android.os.Process.killProcess( android.os.Process.myPid() );
    }

    @Override
    public void onCreate( ){
        super.onCreate();
        context = getApplicationContext();

        FontManager.setDefaultFont( this, "DEFAULT" );
        FontManager.setDefaultFont( this, "MONOSPACE" );
        FontManager.setDefaultFont( this, "SERIF" );
        FontManager.setDefaultFont( this, "SANS_SERIF" );
    }

    @Override
    protected void attachBaseContext( Context base ){
        super.attachBaseContext( base );
        MultiDex.install( this );
    }
}