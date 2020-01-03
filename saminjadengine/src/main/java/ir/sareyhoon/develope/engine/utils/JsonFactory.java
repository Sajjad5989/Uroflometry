package ir.sareyhoon.develope.engine.utils;

public class JsonFactory {
    public String jsonManipulate( String json ){
        String formattedJson = json.substring( 1, json.length() - 1 );
        return formattedJson.replace( "\\", "" );
    }
}
