package me.lbing;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) throws Exception {
        testMyConfig("my-config.properties", "Can not load config resource my-config.properties in classpath");
        testMyConfig("config.properties", "Can not load config resource config.properties in classpath");
    }

    private static void testMyConfig(String name, String x) throws IOException {
        InputStream is = Main.class.getClassLoader().getResourceAsStream(name);
        if (is == null) {
            System.err.println(x);
        } else {
            Properties prop = new Properties();
            prop.load(is);
            is.close();
            for (String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key);
                if (value != null) {
                    System.out.printf("%s = %s %n", key, value);
                }
            }
        }
    }
}
