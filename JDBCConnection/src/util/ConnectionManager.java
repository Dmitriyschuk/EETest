package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";

//    до Java 1.8 были проблемы с загрузкой драйвера для БД

//    поэтому загружали принудительно в статическом блоке
    static {
        loadDriver();
    }

    public ConnectionManager(){
    }


    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver"); // таким образом загружаем драйвер в память JVM
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection open(){
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
