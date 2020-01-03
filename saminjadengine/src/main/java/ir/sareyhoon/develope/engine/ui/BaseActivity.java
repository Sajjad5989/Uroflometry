package ir.sareyhoon.develope.engine.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate;
import com.akexorcist.localizationactivity.core.OnLocaleChangedListener;

import java.util.Locale;

import butterknife.ButterKnife;
import ir.sareyhoon.develope.engine.R;
import ir.sareyhoon.develope.engine.dialog.internet.InternetDialog;
import ir.sareyhoon.develope.engine.utils.DialogUtil;
import ir.sareyhoon.develope.engine.utils.OnlineCheck;
import ir.sareyhoon.develope.engine.view.IGeneralView;
import ir.sareyhoon.develope.engine.view.IInternetListener;


public abstract class BaseActivity extends AppCompatActivity implements IInternetListener, IGeneralView, OnLocaleChangedListener {

    private LocalizationActivityDelegate localizationDelegate = new LocalizationActivityDelegate( this );

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        localizationDelegate.addOnLocaleChangedListener( this );
        localizationDelegate.onCreate( savedInstanceState );

        super.onCreate( savedInstanceState );

        setContentView( setContentView() );
        ButterKnife.bind( this );
    }

    @Override
    public void onResume( ){
        super.onResume();
        localizationDelegate.onResume( this );
    }

    @Override
    protected void attachBaseContext( Context newBase ){
        super.attachBaseContext( localizationDelegate.attachBaseContext( newBase ) );
    }

    @Override
    public Context getApplicationContext( ){
        return localizationDelegate.getApplicationContext( super.getApplicationContext() );
    }

    @Override
    public Resources getResources( ){
        return localizationDelegate.getResources( super.getResources() );
    }

    public final void setLanguage( String language ){
        localizationDelegate.setLanguage( this, language );
    }

    public final void setLanguage( Locale locale ){
        localizationDelegate.setLanguage( this, locale );
    }

    public final void setDefaultLanguage( String language ){
        localizationDelegate.setDefaultLanguage( language );
    }

    public final void setDefaultLanguage( Locale locale ){
        localizationDelegate.setDefaultLanguage( locale );
    }

    public final Locale getCurrentLanguage( ){
        return localizationDelegate.getLanguage( this );
    }

    @Override
    public void onDestroy( ){
        super.onDestroy();
    }

    @Override
    public void onStart( ){
        super.onStart();
    }

    @Override
    public void onStop( ){
        super.onStop();
    }

    @Override
    public void onInternetConnect( ){
        startActivityForResult( new Intent( getString( R.string.wi_fi_action ) ), 999 );
    }

    @Override
    public void onInternetRetry( ){
        decideToRetry();
    }

    @Override
    public void decideToRetry( ){
    }

    @Override
    public void onInternetExit( ){
        this.finishAffinity();
        ActivityCompat.finishAffinity( this );
        android.os.Process.killProcess( android.os.Process.myPid() );
    }

    @Override
    public void onShowInternetDialog( ){
        InternetDialog dialog = new InternetDialog( this, this );
        DialogUtil.showDialog( this, dialog, false, true, true );
    }

    @Override
    public boolean noInternet( ){
        return !OnlineCheck.getInstance( this ).isOnline();
    }

    // Just override method locale change event
    @Override
    public void onBeforeLocaleChanged( ){
    }

    @Override
    public void onAfterLocaleChanged( ){
    }

    /**
     * Every activity has to inflate a layout in the onCreate method. We have added this method to
     * avoid duplicate all the inflate code in every activity. You only have to return the layout to
     * inflate in this method when extends BaseActivity.
     */
    public abstract int setContentView( );
}