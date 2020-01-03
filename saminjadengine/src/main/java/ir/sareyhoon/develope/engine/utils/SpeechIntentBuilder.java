package ir.sareyhoon.develope.engine.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import ir.sareyhoon.develope.engine.R;

public class SpeechIntentBuilder {

    @SuppressLint( "StaticFieldLeak" )
    private static SpeechIntentBuilder instance = null;
    private final Context context;

    public SpeechIntentBuilder( Context context ) {
        this.context = context;
    }

    public static SpeechIntentBuilder getInstance ( Context context ) {
        if ( instance == null )
            instance = new SpeechIntentBuilder( context );
        return instance;
    }

    public Intent getSpeechIntent ( ) {
        String fa = context.getString( R.string.speech_intent_extra_fa );

        Intent localIntent = new Intent( context.getString( R.string.speech_intent_action ) );
        localIntent.putExtra( context.getString( R.string.speech_intent_extra_lang ), fa );
        localIntent.putExtra( context.getString( R.string.speech_intent_extra_lang_ref ), fa );
        localIntent.putExtra( context.getString( R.string.speech_intent_extra_lang_ref_only ), fa );
        localIntent.putExtra( context.getString( R.string.speech_intent_extra_prompt ),
                context.getString( R.string.speech_prompt ) );

        return localIntent;
    }
}
