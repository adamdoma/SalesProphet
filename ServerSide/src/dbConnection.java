import java.sql.*;
import java.time.LocalDate;

public class dbConnection {
    private static Connection conn;
    private DatabaseMetaData dbmt;
    private ResultSet resultSet;
    private Statement statement;


    public dbConnection(){
        connect();

    }

    public  Connection connect(){
        try{
            if(conn == null)
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/salesProphet","root","");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    public  Connection getConn(){
        return conn;
    }

    public  void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfUserExists(String email, String password,User user){
        boolean flag = false;
        String query = "SELECT * FROM user";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password))
                {
                    user.setId(resultSet.getString("id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setBirthDate(resultSet.getInt("year"),resultSet.getInt("month"),resultSet.getInt("day"));
                    flag =true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
