package ir.sareyhoon.develope.engine.utils;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.Display;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import ir.sareyhoon.develope.engine.R;

public class ToastUtil {
    public static void toast( Activity activity , String msg ){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize( size );

        LinearLayout localLinearLayout = new LinearLayout( activity );
        localLinearLayout.setBackground( ContextCompat.getDrawable( activity, R.drawable.bg_toast ) );
        localLinearLayout.setGravity( 1 );
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f );
        localLinearLayout.setLayoutParams( layoutParams );

        AppCompatTextView localTextView = new AppCompatTextView( activity );
        localTextView.setText( msg );
        localTextView.setGravity( Gravity.CENTER_HORIZONTAL );
        localTextView.setTextColor( Color.parseColor( "#FFFFFF" ) );
        localTextView.setTextSize( 16.0F );
        localTextView.setPadding( 12, 2, 12, 2 );
        localTextView.setTypeface( Typeface.createFromAsset( activity.getAssets(), "fonts/ir_yekan.ttf" ) );
        localLinearLayout.addView( localTextView );
        Toast localToast = new Toast( activity );
        localToast.setDuration( Toast.LENGTH_SHORT );
        localToast.setView( localLinearLayout );
        localToast.show();
    }
}
