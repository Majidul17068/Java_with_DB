import java.sql.SQLException;

public class mainClass {
    public static void main(String[] args) {
        DBconnection dbapp = new DBconnection();

        try {
            dbapp.insertCustomer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
