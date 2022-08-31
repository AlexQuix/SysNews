package news.dal;

import java.sql.*;

public class CommonDb {
    static String ConnectionUrl = "jdbc:sqlserver://NewssDB.mssql.somee.com;"
        + "database=NewssDB;"
        + "user=WernerMolina_SQLLogin_1;"
        + "password=pj6scdgx7i;"
        + "loginTimeout=30;encrypt=false;trustServerCertificate=false";
    
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Connection connection = DriverManager.getConnection(ConnectionUrl); 
        return connection; 
    }
    
}
