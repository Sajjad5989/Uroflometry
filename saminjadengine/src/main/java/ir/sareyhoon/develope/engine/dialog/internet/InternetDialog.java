package ir.sareyhoon.develope.engine.dialog.internet;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;

import ir.sareyhoon.develope.engine.R;
import ir.sareyhoon.develope.engine.view.IInternetListener;

public class InternetDialog extends Dialog {

    private final IInternetListener listener;
    private AppCompatTextView bodyText;
    private AppCompatTextView buttonExit;
    private AppCompatTextView buttonRetry;
    private AppCompatTextView buttonConnect;

    public InternetDialog( @NonNull Context context, IInternetListener listener ){
        super( context );
        this.listener = listener;
    }

    @RequiresApi( api = Build.VERSION_CODES.KITKAT )
    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.dialog_internet );
        findViews();
        setComponentsText();
        onClickSetting();
    }

    private void findViews( ){
        bodyText = findViewById( R.id.text_view_body );
        buttonExit = findViewById( R.id.button_exit );
        buttonRetry = findViewById( R.id.button_retry );
        buttonConnect = findViewById( R.id.button_connect );
    }

    private void setComponentsText( ){
        bodyText.setText( getContext().getString( R.string.internet_checking_body ),
                AppCompatTextView.BufferType.SPANNABLE );
    }

    private void onClickSetting( ){
        buttonExit.setOnClickListener( view -> {
            listener.onInternetExit();
            dismiss();
        } );
        buttonRetry.setOnClickListener( view -> {
            listener.onInternetRetry();
            dismiss();
        } );
        buttonConnect.setOnClickListener( view -> {
            listener.onInternetConnect();
            dismiss();
        } );

    }

}
