package SQL;
import java.sql.*;
import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ){
            //Xóa tất cả các sách có id > 8000
            String sqlDeteled = "delete from books where id > 8000";
            System.out.println("The SQL Statement is: "+ sqlDeteled+"\n");
            int countDeleted = stmt.executeUpdate(sqlDeteled);
            System.out.println(countDeleted);
            //Thêm cùng lúc 2 bản ghi
            String sqlInsert = "insert into books values (8001,'Java Core','Dang Kim Thi',15.55,55), "
                    + "(8002,'Java Advanced','James Gosling',25.55,55)";
            System.out.println("The SQL Statement is: "+sqlInsert+"\n");
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);
            //Thêm 1 cuốn sách
            sqlInsert = "insert into books (id, title, author) values (2001, 'Java JDBC MySQL', 'ThiDK')";
            System.out.println("The SQL Statement is: "+sqlInsert+"\n");
            countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);

            //Xóa 1 cuốn sách
            sqlDeteled = "delete from books where id = 2001";
            System.out.println("The SQL Statement is: "+ sqlDeteled+"\n");
            countDeleted = stmt.executeUpdate(sqlDeteled);
            System.out.println(countDeleted);

            //Thêm mới 1 cuốn sách có đầy đủ thông tin do người dùng nhập vào từ bàn phím
            int bookID;
            String bookName;
            String bookAuthor;
            double bookPrice;
            int bookQty;
            Scanner ip = new Scanner(System.in);
            System.out.println("Enter book id: ");
            bookID = ip.nextInt();
            System.out.println("Enter book name: ");
            bookName = ip.nextLine();
            System.out.println("Enter book author: ");
            bookAuthor = ip.nextLine();
            System.out.println("Enter book price: ");
            bookPrice = ip.nextDouble();
            System.out.println("Enter book qty: ");
            bookQty = ip.nextInt();
                                                    //(8001,'Java Core','Dang Kim Thi',15.55,55)
            sqlInsert = "insert into books values ("+ bookID+", '"+bookName+"', '"+bookAuthor+"', "+ bookPrice+", "+ bookQty+")";
            System.out.println("The SQL Statement is: "+sqlInsert+"\n");
            countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
