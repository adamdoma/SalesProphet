import java.sql.*;

public class dbConnection {
    private static Connection conn;
    private DatabaseMetaData dbmt;
    private ResultSet resultSet;
    private Statement statement;

    public dbConnection(){
        connect();
    }

    public static Connection connect(){
        try{
            if(conn == null)
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/salesProphet","root","");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    public static Connection getConn(){
        return conn;
    }

    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfUserExists(String email){
        boolean flag = false;
        String query = "SELECT * FROM user";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                if(resultSet.getString("email").equals(email))
                    flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
