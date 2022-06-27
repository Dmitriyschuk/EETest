import util.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        String sql;
        String sql2;

        //language=PostgreSQL
        sql = "CREATE SCHEMA info ";


//        try (Connection connection = ConnectionManager.open();
//             Statement statement = connection.createStatement()) {
//            System.out.println(connection.getSchema());
//            System.out.println(connection.getTransactionIsolation());

//            ResultSet executeResult = statement.executeQuery(sql);
//           boolean test = statement.execute(sql);
//            System.out.println(test);
//            while (executeResult.next()) {
//                System.out.println(executeResult.getLong("id"));
//                System.out.println(executeResult.getString("passenger_no"));
//                System.out.println(executeResult.getString("passenger_name"));
//                System.out.println(executeResult.getBigDecimal("cost"));
//                System.out.println("--------------");
//            }
//        }


//        sql = "CREATE TABLE IF NOT EXISTS my_schema.info ("
//                + "id SERIAL PRIMARY KEY,"
//                + "data TEXT NOT NULL)";
//
//        sql2 = "INSERT INTO my_schema.info(data)" +
//                "VALUES " +
//                "('Test1')," +
//                "('Test2')," +
//                "('Test3')," +
//                "('Test4')"  ;
//
//
//        sql3 = "UPDATE my_schema.info " +
//                "SET data = 'TestTest' " +
//                "WHERE id=11";
//        String flightId= "2 or 1 = 1; DROP SCHEMA info;"; // sql injection
//        Long flightId = 2L;
//        List<Long> result = getTicketsByFlightId_injection(flightId);

//        List<Long> result = getTicketsByFlightId(flightId);
//        System.out.println(result);

//        List<Long> resultFlightIdBeetweenDates = getFlightsBetween(LocalDate.of(2020, 1,1).atStartOfDay(), LocalDateTime.now());
//        System.out.println(resultFlightIdBeetweenDates);

        checkMetaData();
    }

    private static List<Long> getTicketsByFlightId_injection(String flightId) throws SQLException {
        //language=PostgreSQL
        String sql = String.format("SELECT id FROM ticket WHERE flight_id = %s", flightId);

        List<Long> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
//                result.add(resultSet.getLong("id")); // Могут быть ошибки с null, поэтому лучше делать ниже.
                result.add(resultSet.getObject("id", Long.class)); //NULL safe

            }
        }
        return result;
    } // есть SQL injection


    private static List<Long> getTicketsByFlightId(Long flightId) throws SQLException {
        //language=PostgreSQL
        String sql = "SELECT id FROM ticket WHERE flight_id = ?";

        List<Long> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setLong(1, flightId);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
//                result.add(resultSet.getLong("id")); // Могут быть ошибки с null, поэтому лучше делать ниже.
                result.add(resultSet.getObject("id", Long.class)); //NULL safe

            }
        }
        return result;
    }


    private static List<Long> getFlightsBetween(LocalDateTime start, LocalDateTime end) throws SQLException {
        String sql = "SELECT id FROM flight WHERE departure_date BETWEEN ? AND ?";

        List<Long> result = new ArrayList<>();

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setFetchSize(50);// возвращает определенное количество строк чтобы не положить приложение с ошибкой out of memory


            /*сколько ждать выполнения запроса,
            так как соединение это дорогостоящая опреация
            и обычно выделяется определенный пул соединений*/
            preparedStatement.setQueryTimeout(10);

            preparedStatement.setMaxRows(100);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(start));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(end));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                result.add(resultSet.getLong("id"));
            }
        }
        return result;
    }


    //Работа с метаданными. Получаем данные БД
    private static void checkMetaData() throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();


            while (catalogs.next()){
                String catalog =catalogs.getString(1);
//                System.out.println(catalogs.getString(1)); // можем обратиться либо по индексу, либо по названию таблицы TABLE_CAT. Пример по названию ниже.
                ResultSet schemas = metaData.getSchemas();
                while (schemas.next()){
                    String schema = schemas.getString("TABLE_SCHEM");
//                    System.out.println(schemas.getString("TABLE_SCHEM"));
                    ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
                    if (schema.equals("public")){
                        while (tables.next()){
                        System.out.println(tables.getString("TABLE_NAME"));
                    }
//
//
//
                    }
                }
            }

        }

    }
}