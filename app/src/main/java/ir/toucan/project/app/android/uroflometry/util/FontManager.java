package ir.toucan.project.app.android.uroflometry.util;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;


final class FontManager {

    static void setDefaultFont( Context context,
                                String staticTypefaceFieldName ){
        final Typeface regular = Typeface.createFromAsset( context.getAssets(),
                "fonts/ir_yekan.ttf" );
        replaceFont( staticTypefaceFieldName, regular );
    }

    private static void replaceFont( String staticTypefaceFieldName,
                                     final Typeface newTypeface ){
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField( staticTypefaceFieldName );
            staticField.setAccessible( true );
            staticField.set( null, newTypeface );
        } catch ( NoSuchFieldException | IllegalAccessException e ) {
            e.printStackTrace();
        }
    }
}