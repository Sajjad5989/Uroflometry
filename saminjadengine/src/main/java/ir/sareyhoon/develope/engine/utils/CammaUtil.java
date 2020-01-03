package ir.sareyhoon.develope.engine.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CammaUtil {
    public static String attachCamma( long inputMoney ){
        return NumberFormat.getNumberInstance( Locale.US ).format( ( int ) inputMoney );
    }
}
