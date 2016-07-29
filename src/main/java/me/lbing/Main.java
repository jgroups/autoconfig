package me.lbing;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;


public class Main {
	public static void main( String[] args ) throws Exception {
		InputStream is = Main.class.getClassLoader().getResourceAsStream( "my-config.properties" );
		if ( is == null ) {
			System.err.println( "Can not load config resource my-config.properties in classpath" );
		} else {
			Properties prop = new Properties();
			prop.load( is );
			is.close();
			for( String key : prop.stringPropertyNames() ) {
				String value = prop.getProperty( key );
				if ( value != null ) {
					System.out.printf( "%s = %s %n", key, value );
				}
			}
		}
		testConfig();
	}

	private static void testConfig() throws IOException {
		InputStream is = Main.class.getClassLoader().getResourceAsStream( "config.properties" );
		if ( is == null ) {
			System.err.println( "Can not load config resource config.properties in classpath" );
		} else {
			Properties prop = new Properties();
			prop.load( is );
			is.close();
			for( String key : prop.stringPropertyNames() ) {
				String value = prop.getProperty( key );
				if ( value != null ) {
					System.out.printf( "%s = %s %n", key, value );
				}
			}
		}
	}
}
