package javase07.t02.logic;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropSafeReader implements Runnable {
    @Getter
    Map<String, String> props;
    @Getter
    @Setter
    String fileName;

    public PropSafeReader() {
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

        System.out.println("Properties loaded! " + props.size());
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

    @Override
    public void run() {
        if (fileName == null || fileName.equals(""))
            return;
        System.out.println("Start " + Thread.currentThread().getName());
        loadProperties(fileName);
    }
}
