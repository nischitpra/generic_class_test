package utils;

public class Logger {
    public static void log( String s ) {
        System.out.println( s );
    }

    public static void log( String format, String... args ) {
        System.out.println( String.format( format, args ) );
    }
}
