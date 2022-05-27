package SQL;

import java.sql.*;
public class JdbcSelectTest {
    public static void main(String[] args){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from books where author = 'Dang Kim Thi' ";
            System.out.println("The SQL Statement is: "+ strSelect+ "\n");

            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("the records selected are: ");
            int rowCount = 0;
            while (rset.next()){
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title+ ", "+price+", "+ qty);
            }
            System.out.println("Total number of records = "+ rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
