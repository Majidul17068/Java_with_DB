import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnection {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String url="jdbc:mysql://127.0.0.1/db_with_java?useSSL=false&allowPublicKeyRetrieval=true";
    private final String username = "demo_user_select";
    private final String password = "demo@123";

    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void insertCustomer() throws SQLException {
        this.connection = this.getConnection();
        this.preparedStatement = this.connection.prepareStatement("INSERT INTO customer (name, contact ,last_purches)VALUES(?,?,NOW())");

        this.preparedStatement.setString(1,"Mehedi Hasan Rabbe");
        this.preparedStatement.setString(2,"01521107529");
        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println(affectedRows+" inserted into database");
        this.connection.close();
        this.preparedStatement.close();

    }
    public void getCustomerInfoByID(int id) throws SQLException {
        this.connection = this.getConnection();
        this.preparedStatement = this.connection.prepareStatement(
                "select * from customer where id = ? ");

        this .preparedStatement.setInt(1,2);
        this.connection.close();
        this.preparedStatement.close();

    }
}

