package ir.sareyhoon.develope.engine.dialog.getnumber;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Objects;

import ir.sareyhoon.develope.engine.R;
import ir.sareyhoon.develope.engine.utils.StringUtil;

public class NumberReceptionDialog extends Dialog {
    private Context context;
    private IOnNumberReceptionListener listener;
    private int currentCount;
    private String productCounter;

    private AppCompatEditText editWeight;
    private AppCompatTextView buttonPositive;
    private AppCompatTextView buttonNegative;

    public NumberReceptionDialog( @NonNull Context context, IOnNumberReceptionListener listener, int currentCount, String productCounter ){
        super( context );
        this.context = context;
        this.listener = listener;
        this.currentCount = currentCount;
        this.productCounter = productCounter;
    }


    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.dialog_number_reception );
        findViews();
        onClick();
    }

    private void findViews( ){
        editWeight = findViewById( R.id.edit_weight );
        buttonPositive = findViewById( R.id.button_positive );
        buttonNegative = findViewById( R.id.button_negative );
        AppCompatTextView textViewDesc = findViewById( R.id.text_view_desc );
        textViewDesc.setText( context.getString( R.string.text_format_dialog_number_current_value, currentCount, productCounter ) );

        editWeight.setText( "" );
        editWeight.requestFocus();

    }

    private void onClick( ){
        buttonPositive.setOnClickListener( view -> {
            String tx = Objects.requireNonNull( editWeight.getText() ).toString().trim();
            if ( StringUtil.empty( tx ) ) {
                tx = "1";
            }
            listener.onDoneNumber( Integer.parseInt( tx ) );
            dismiss();
        } );

        buttonNegative.setOnClickListener( view -> {
            listener.onCancel();
            dismiss();
        } );
    }
}
