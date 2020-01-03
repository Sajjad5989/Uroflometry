package ir.sareyhoon.develope.engine.utils;


import android.annotation.SuppressLint;
import android.content.Context;

public class OnlineCheck {
    @SuppressLint( "StaticFieldLeak" )
    private static OnlineCheck instance = null;
    private final Context context;

    private OnlineCheck( Context context ){
        this.context = context;
    }

    public static OnlineCheck getInstance( Context context ){
        if ( instance == null )
            instance = new OnlineCheck( context );
        return instance;
    }

    public boolean isOnline( ){
        ConnectionManager connectionManager = new ConnectionManager( context );
        return connectionManager.isConnectingToInternet();
    }

}
