package javase06.t02.main;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapPropertiesLoader {
    Map<String, String> props;

    public MapPropertiesLoader() {
        props = new HashMap<>();
    }

    public boolean loadProperties(String path) {
        Properties properties = new Properties();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = loader.getResourceAsStream(path)) {
            properties.load(inputStream);
        } catch (IOException | NullPointerException e) {
            System.err.println("Can't load .properies file");
            return false;
        }

        props.clear();

        Iterator<Object> keyIterator = properties.keys().asIterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            props.put((String) key, properties.getProperty((String) key));
        }

        System.out.println("Properties loaded!");
        return true;
    }

    public String getProperty(String propertyName) {
        if (props.size() == 0)
            return "";
        try {
            String prop = props.get(propertyName);
            return prop;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Property not found!");
        }
        return "";
    }
}
