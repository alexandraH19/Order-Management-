package connection;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/schooldb";
    private static final String USER = "root";
    private static final String PASS = "Caldura19";

    private static ConnectionFactory singleInstance= new ConnectionFactory();

    private ConnectionFactory(){
        try{
             Class.forName(DRIVER);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    private Connection createConnection(){
        Connection con = null;
        try{
            con= DriverManager.getConnection(DBURL,USER,PASS);

        }catch(SQLException e){
            System.err.format("SQL state: %s %s",e.getSQLState(),e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
         return con;
    }

    public static Connection getConnection(){
        return singleInstance.createConnection();
    }

    public static void close(Connection con)  {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.format("SQL state: %s %s",e.getSQLState(),e.getMessage());
            }
        }
    }

    public static void close(ResultSet resultSet)  {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.err.format("SQL state: %s %s",e.getSQLState(),e.getMessage());
            }
        }
    }

    public static void close(Statement stat)  {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.format("SQL state: %s %s",e.getSQLState(),e.getMessage());
            }
        }
    }


}
