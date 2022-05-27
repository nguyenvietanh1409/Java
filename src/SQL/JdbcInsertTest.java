package SQL;

import java.sql.*;
public class JdbcInsertTest {
    public static void main(String[] args){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ){

            //delete
            String sqlDelete = "delete from books where id = 1001";
            System.out.println("The SQL Statement is: "+ sqlDelete+"\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted+ " records deleted.\n");

            //insert
            String sqlInsert = "insert into books values (1111, 'GoneFishing','Kumar',31.31,31)";
            System.out.println("The SQL Statement is: "+sqlInsert+"\n");
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert+" records inserted. \n");

            //INSERT MULTIPLE RECORDS
            sqlInsert = "insert into books values"
                    + "(3022,'GOneFishing 2','Kumar',22.22,22)"
                    + "(3033,'GOne Fishing3 ','Kumar',33.33,33)";
            System.out.println("The SQL Statement is: "+sqlInsert+"\n");
            countInsert = stmt.executeUpdate(sqlDelete);
            System.out.println(countInsert + " records inserted.\n");

            //INSERT A PARTIAL RECORD
            sqlInsert = "insert into books (id, title, author) values (3044,'Fishing 103','Kumar')";
            System.out.println("The SQL Statement is: "+sqlInsert+"\n");
            countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + " records inserted.\n");

            // ISSUE A SELECT TO CHECK THE CHANGES
            String strSelect = "select * from books";
            System.out.println("The SQL Statement is: "+strSelect+"\n");
            ResultSet rs = stmt.executeQuery(strSelect);
            while (rs.next()){
                System.out.println(rs.getInt("id")+", "
                + rs.getString("author")+", "
                + rs.getString("title")+ ", "
                + rs.getDouble("price")+ ", "
                + rs.getInt("qty"));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
