package ir.sareyhoon.develope.engine.ui;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.core.widget.NestedScrollView;

/**
 * Created by Sajjad Assal on 1398/07/10
 */

public class DeepScrollView {


    /**
     * Used to scroll to the given view.
     *
     * @param scrollViewParent Parent ScrollView
     * @param view             View to which we need to scroll.
     */
    public void scrollToView( NestedScrollView scrollViewParent, final View view ){
        // Get deepChild Offset
        Point childOffset = new Point();
        getDeepChildOffset( scrollViewParent, view.getParent(), view, childOffset );
        // Scroll to child.
        scrollViewParent.smoothScrollTo( 0, childOffset.y );
    }

    /**
     * Used to get deep child offset.
     * <p/>
     * 1. We need to scroll to child in scrollview, but the child may not the direct child to scrollview.
     * 2. So to get correct child position to scroll, we need to iterate through all of its parent views till the main parent.
     *
     * @param mainParent        Main Top parent.
     * @param parent            Parent.
     * @param child             Child.
     * @param accumulatedOffset Accumalated Offset.
     */
    public void getDeepChildOffset( final ViewGroup mainParent, final ViewParent parent, final View child, final Point accumulatedOffset ){
        ViewGroup parentGroup = ( ViewGroup ) parent;
        accumulatedOffset.x += child.getLeft();
        accumulatedOffset.y += child.getTop();
        if ( parentGroup.equals( mainParent ) ) {
            return;
        }
        getDeepChildOffset( mainParent, parentGroup.getParent(), parentGroup, accumulatedOffset );
    }
}
