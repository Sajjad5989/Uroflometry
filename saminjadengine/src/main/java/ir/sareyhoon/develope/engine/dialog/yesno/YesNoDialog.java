package ir.sareyhoon.develope.engine.dialog.yesno;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import ir.sareyhoon.develope.engine.R;

public class YesNoDialog extends Dialog {

    private final OnYesNoDialogListener listener;
    private final YesNo yesNo;

    private AppCompatTextView textViewTitle;
    private AppCompatTextView textViewBody;
    private AppCompatTextView buttonNegative;
    private AppCompatTextView buttonPositive;

    public YesNoDialog( @NonNull Context context, YesNo yesNo, OnYesNoDialogListener listener ){
        super( context );
        this.listener = listener;
        this.yesNo = yesNo;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ){

        super.onCreate( savedInstanceState );

        requestWindowFeature( Window.FEATURE_NO_TITLE );

        setContentView( R.layout.dialog_yes_no );

        findViews();
        setComponentsText();

        onClickSetting();

    }

    private void findViews( ){
        textViewTitle = findViewById( R.id.text_view_title );
        textViewBody = findViewById( R.id.text_view_body );
        buttonNegative = findViewById( R.id.button_negative );
        buttonPositive = findViewById( R.id.button_positive );
    }

    private void setComponentsText( ){
        textViewTitle.setText( yesNo.getTitle() );
        textViewBody.setText( Html.fromHtml( yesNo.getBody() ), AppCompatTextView.BufferType.SPANNABLE );

        buttonPositive.setText( yesNo.getPositive() );
        buttonNegative.setText( yesNo.getNegative() );
    }

    private void onClickSetting( ){
        buttonPositive.setOnClickListener( view -> {
            listener.onPositiveClick();
            dismiss();
        } );

        buttonNegative.setOnClickListener( view -> {
            listener.onNegativeClick();
            dismiss();
        } );
    }
}
