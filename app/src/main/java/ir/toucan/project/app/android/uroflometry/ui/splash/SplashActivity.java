package ir.toucan.project.app.android.uroflometry.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import ir.sareyhoon.develope.engine.ui.BaseActivity;
import ir.sareyhoon.develope.engine.utils.ApplicationManager;
import ir.toucan.project.app.android.uroflometry.R;

public class SplashActivity extends BaseActivity implements SplashView {

    @BindView( R.id.text_view_version )
    protected AppCompatTextView textViewVersion;



    @Override
    public int setContentView( ){
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );

        textViewVersion.setText( getString( R.string.project_name_version, ApplicationManager.getVersionName( this ) ) );

        playAppWithDelay( );
    }

    @Override
    public void playAppWithDelay( ){
        final Handler handler = new Handler();
        handler.postDelayed( this :: startAppForm, 2000 );
    }

    @Override
    public void startAppForm( ){

    }

    @Override
    public void startLoginActivity( ){

    }

    @Override
    public void startIntroActivity( ){

    }
}
