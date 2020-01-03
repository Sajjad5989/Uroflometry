package ir.toucan.project.app.android.uroflometry.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import org.jetbrains.annotations.NotNull;


public class SareyhoonJustifiedTextView extends JustifiedTextView {

    public SareyhoonJustifiedTextView( final @NotNull Context context, final AttributeSet attrs ){
        super( context, attrs );
        //setOnClickListener( v -> Toast.makeText( context, "Click", Toast.LENGTH_SHORT ).show() );
    }

    @Override
    protected void onAttachedToWindow( ){
        super.onAttachedToWindow();
        setTextIsSelectable( true );
    }

    @SuppressLint( "ClickableViewAccessibility" )
    @Override
    public boolean onTouchEvent( final @NotNull MotionEvent event ){
        final Spannable text = ( Spannable ) getText();
        if ( text != null ) {
            if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
                final Layout layout = getLayout();
                if ( layout != null ) {
                    final int line = getLineAtCoordinate( layout, event.getY() );
                    final int pos = getOffsetAtCoordinate( layout, line, event.getX() );
                    final ClickableSpan[] links = text.getSpans( pos, pos, ClickableSpan.class );
                    if ( links != null && links.length > 0 ) {
                        links[ 0 ].onClick( this );
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent( event );
    }

    private int getLineAtCoordinate( final @NotNull Layout layout, final float y ){
        final int max = getHeight() - getTotalPaddingBottom() - 1;
        final int v = Math.min( max, Math.max( 0, ( int ) y - getTotalPaddingTop() ) ) + getScrollY();
        return layout.getLineForVertical( v );
    }

    private int getOffsetAtCoordinate( final @NotNull Layout layout, final int line, final float x ){
        final int max = getWidth() - getTotalPaddingRight() - 1;
        final int v = Math.min( max, Math.max( 0, ( int ) x - getTotalPaddingLeft() ) ) + getScrollX();
        return layout.getOffsetForHorizontal( line, v );
    }

}