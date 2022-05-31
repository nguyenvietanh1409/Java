package MoreJDBC;

import java.sql.*;

public class JdbcCommitCatchTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            try {
                conn.setAutoCommit(false);

                stmt.executeUpdate("insert into books values (4001, 'Paul Chan', 'Mahjong 101', 4.4, 4)");

                stmt.executeUpdate("insert into books values (4001, 'Peter Chan', 'Mahjong 102', 4.4, 4)");
                conn.commit();
            } catch (SQLException ex) {
                System.out.println("-- Rolling back changes --");
                conn.rollback();
                ex.printStackTrace();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
