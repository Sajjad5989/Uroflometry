package ir.sareyhoon.develope.engine.listener;

import android.view.View;

public interface RecyclerViewClickWithLongListener {

    void onItemClick( View v, int position );

    boolean onItemLongClick( View v, int position );
}
