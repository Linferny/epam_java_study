package javase05.t02.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertiesReader {
    List<String> keys;
    List<String> values;

    public PropertiesReader() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
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

        keys.clear();
        values.clear();

        // Возможно, здесь есть вероятность ошибки, но это не точно.
        // Может ли список ключей не совпасть со списком значений?
        for (Object o : properties.values()) {
            values.add((String) o);
        }
        Iterator<Object> key = properties.keys().asIterator();
        while (key.hasNext()) {
            keys.add((String) key.next());
        }

        System.out.println("Properties loaded!");
        return true;
    }

    public String getProperty(String propertyName) {
        if (keys.size() == 0)
            return "";
        try {
            String prop = values.get(keys.indexOf(propertyName));
            return prop;
        } catch (IndexOutOfBoundsException e){
            System.err.println("Property not found!");
        }
        return "";
    }
}
