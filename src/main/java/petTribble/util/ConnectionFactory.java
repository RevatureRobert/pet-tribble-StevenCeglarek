package petTribble.util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory implements Closeable {

    Class clazz;

    {
        try {
            clazz = Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final String URL = "jdbc:postgresql://cardealership.cltilemkbrbk.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=tribble";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "password123";


    public static final int CONNECTIONS = 1;
    private final Connection[] connectionPool = new Connection[CONNECTIONS];

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        for (int i = 0; i < CONNECTIONS; i++) {
            connectionPool[i] = createConnection();
        }
    }

    public static ConnectionFactory getInstance(){
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    private Connection createConnection() {
        Properties props = new Properties();
        try {
//            props.load(new FileReader("src/main/resources/db.properties"));
//            return DriverManager.getConnection(
//                    props.getProperty("petTribble.jdbc.connection.profile.dev.url"),
//                    props.getProperty("petTribble.jdbc.connection.profile.dev.username"),
//                    props.getProperty("petTribble.jdbc.connection.profile.dev.password"));
            return DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Connection[] getConnectionPool() {
        return connectionPool;
    }

    @Override
    public void close(){
        for(Connection con: connectionPool){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
