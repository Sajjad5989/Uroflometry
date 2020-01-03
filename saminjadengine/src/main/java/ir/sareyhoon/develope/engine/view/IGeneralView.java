package ir.sareyhoon.develope.engine.view;

public interface IGeneralView {
    boolean noInternet( );

    void decideToRetry();

    void onShowInternetDialog( );
}
