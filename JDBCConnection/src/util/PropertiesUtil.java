package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


//класс для загрузки данных из файла application.properties
public final class PropertiesUtil {



    private static final Properties PROPERTIES = new Properties();

    //статический блок иниц-ии отрабатывает один раз при первой загрузке в память JVM (metaspace)
    static {
        loadProperties();
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }

    }

    private PropertiesUtil(){

    }
}
