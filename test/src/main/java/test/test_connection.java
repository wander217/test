package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class test_connection {

	public static void main(String[] args) {
		String server_host = "localhost";
		String user_name = "wander217";
		String password = "Trinhthinh@217";
		String db_name = "FinancialManager";
		String connection_query = "jdbc:sqlserver://127.0.0.1:1433;"
				+ "database=FinancialManager;"
				+ "user=wander217;"
				+ "password=Trinhthinh@217;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;"
				+ "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connection_query);) {
            Statement statement = connection.createStatement();
            
            String sql_query = "SELECT * FROM FinancialManager.dbo.card_info";
            ResultSet rs = statement.executeQuery(sql_query);
            
            while(rs.next()) {
            	System.out.println(rs.getString("card_name"));
            }
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
