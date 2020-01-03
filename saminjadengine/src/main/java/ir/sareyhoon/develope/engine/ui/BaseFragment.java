package ir.sareyhoon.develope.engine.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import ir.sareyhoon.develope.engine.R;
import ir.sareyhoon.develope.engine.dialog.internet.InternetDialog;
import ir.sareyhoon.develope.engine.utils.DialogUtil;
import ir.sareyhoon.develope.engine.utils.OnlineCheck;
import ir.sareyhoon.develope.engine.view.IGeneralView;
import ir.sareyhoon.develope.engine.view.IInternetListener;


public abstract class BaseFragment extends Fragment implements IInternetListener, IGeneralView {


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ){
        return inflater.inflate( getFragmentLayout(), container, false );
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState ){
        super.onViewCreated( view, savedInstanceState );
        injectViews( view );
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
    public void onInternetExit( ){
        getActivity().finishAffinity();
        ActivityCompat.finishAffinity( getActivity() );
        android.os.Process.killProcess( android.os.Process.myPid() );
    }

    @Override
    public void onShowInternetDialog( ){
        InternetDialog dialog = new InternetDialog( getContext(), this );
        DialogUtil.showDialog( getActivity(), dialog, false, true, true );
    }

    @Override
    public boolean noInternet( ){
        return !OnlineCheck.getInstance( getContext() ).isOnline();
    }

    /**
     * Every fragment has to inflate a layout in the onCreateView method. We have added this method to
     * avoid duplicate all the inflate code in every fragment. You only have to return the layout to
     * inflate in this method when extends BaseFragment.
     */
    protected abstract int getFragmentLayout( );

    /**
     * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
     * value.
     *
     * @param view to extract each widget injected in the fragment.
     */
    private void injectViews( final View view ){
        ButterKnife.bind( this, view );
    }

    @Override
    public void decideToRetry( ){
    }

}
