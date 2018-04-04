package javase05.t02.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.util.Properties;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertiesReader {
    Properties properties;

    public PropertiesReader() {

    }

    public boolean loadProperties(String path) {
        properties = new Properties();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = loader.getResourceAsStream(path)) {
            properties.load(inputStream);
        } catch (IOException | NullPointerException e) {
            System.out.println("Can't load .properies file");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getProperty(String propertyName) {
        if (properties == null)
            return "";
        String prop = properties.getProperty(propertyName);
        if (prop == null)
            System.err.println("Property not found!");
        return prop == null ? "" : prop;
    }
}
