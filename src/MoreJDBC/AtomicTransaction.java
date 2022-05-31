package MoreJDBC;

import java.sql.*;

public class AtomicTransaction {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            conn.setAutoCommit(false);

            //Before Changes
            ResultSet rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
            System.out.println("-- Before UPDATE --");
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit(); // Commit SELECT

            //Issue two UPDATE statement thru executeUpdate()
            stmt.executeUpdate("update books set qty = qty + 1 where id = 1001");
            stmt.executeUpdate("update books set qty = qty + 1 where id = 1002");
            conn.commit();

            rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
            System.out.println("-- After commit and  UPDATE --");
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit(); // Commit SELECT

            //Issue two update statements thru executeUpdate()
            stmt.executeUpdate("update books set qty = qty - 99 where id = 1001");
            stmt.executeUpdate("update books set qty = qty - 99 where id = 1001");
            conn.rollback();

            rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
            System.out.println("-- After rollback and  UPDATE --");
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit(); // Commit SELECT


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}