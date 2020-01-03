package ir.sareyhoon.develope.engine.utils;

public class StringUtil {
    public static boolean empty( final String s ){
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
