package MoreJDBC;

import java.sql.*;

public class ResultSetMetaData {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            ResultSet rset = stmt.executeQuery("select * from books");

            java.sql.ResultSetMetaData rsetMD = rset.getMetaData();

            int numcolumns = rsetMD.getColumnCount();

            for (int i = 1; i <= numcolumns; ++i){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            for (int i = 1; i <= numcolumns; ++i){
                System.out.printf("%-30s",
                        "("+ rsetMD.getColumnClassName(i) + ")");
            }
            System.out.println();

            while (rset.next()){
                for (int i = 1; i <= numcolumns; ++i){
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
