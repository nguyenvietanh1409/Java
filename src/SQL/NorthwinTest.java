package SQL;

import java.sql.*;
import java.util.Scanner;

public class NorthwinTest {

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwin", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            //Hiển thị danh sách khách hàng
            String sqlSelect = "select * from customers";
            System.out.println("The statement is: "+ sqlSelect+"\n");
            ResultSet rs = stmt.executeQuery(sqlSelect);
            while (rs.next()){
                String CustomerID = rs.getString("CustomerID");
                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                String City = rs.getString("City");
                String Region = rs.getString("Region");
                String PostalCode = rs.getString("PostalCode");
                String Country = rs.getString("Country");
                String Phone = rs.getString("Phone");
                String Fax = rs.getString("Fax");
                System.out.println(CustomerID+", "+
                        CompanyName+", "+
                        ContactName+", "+
                        ContactTitle+", "+
                        Address+", "+
                        City+", "+
                        Region+", "+
                        PostalCode+", "+
                        Country+", "+
                        Phone+", "+Fax);

            }
            //Tìm khách hàng theo tên
            String name;
            Scanner ip = new Scanner(System.in);
            System.out.println("Enter contact name: ");
            //Maria Anders
            name = ip.nextLine();
            sqlSelect = "Select CustomerID, ContactName, Address from customers where ContactName like '%"+name+"%'";
            System.out.println("The statement is: "+ sqlSelect+"\n");
            rs = stmt.executeQuery(sqlSelect);
            while (rs.next()){
                String customerID = rs.getString("CustomerID");
                String ContactName = rs.getString("ContactName");
                String Address = rs.getString("Address");
                System.out.println(customerID+", "+ ContactName+", "+ Address);
            }
            //Hiển thị danh sách sách sản phẩm
            sqlSelect = "select * from products";
            System.out.println("The statement is: "+ sqlSelect+"\n");
            rs = stmt.executeQuery(sqlSelect);
            while (rs.next()){
                int ProductID = rs.getInt("ProductID");
                String ProductName  = rs.getString("ProductName");
                int SupplierID  = rs.getInt("SupplierID");
                int CategoryID   = rs.getInt("CategoryID");
                String QuantityPerUnit  = rs.getString("QuantityPerUnit");
                double UnitPrice  = rs.getInt("UnitPrice");
                int UnitsInStock  = rs.getInt("UnitsInStock");
                int UnitsOnOrder  = rs.getInt("UnitsOnOrder");
                int ReorderLevel  = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                System.out.println(ProductID+", "+
                        ProductName+", "+
                        SupplierID+", "+
                        CategoryID +", "+
                        QuantityPerUnit+", "+
                        UnitPrice+", "+
                        UnitsInStock+", "+
                        UnitsOnOrder+", "+
                        ReorderLevel+", "+Discontinued);
            }

            //Tìm sản phẩm theo giá bán trong khoảng do người dùng nhập vào
            double price;
            System.out.println("Find product by price: ");
            price = ip.nextDouble();
            sqlSelect = "select * from products where UnitPrice = "+price;
            System.out.println("The statement is: "+ sqlSelect+"\n");
            rs = stmt.executeQuery(sqlSelect);
            while (rs.next()){
                int ProductID = rs.getInt("ProductID");
                String ProductName  = rs.getString("ProductName");
                int SupplierID  = rs.getInt("SupplierID");
                int CategoryID   = rs.getInt("CategoryID");
                String QuantityPerUnit  = rs.getString("QuantityPerUnit");
                double UnitPrice  = rs.getDouble("UnitPrice");
                int UnitsInStock  = rs.getInt("UnitsInStock");
                int UnitsOnOrder  = rs.getInt("UnitsOnOrder");
                int ReorderLevel  = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                System.out.println(ProductID+", "+
                        ProductName+", "+
                        SupplierID+", "+
                        CategoryID +", "+
                        QuantityPerUnit+", "+
                        UnitPrice+", "+
                        UnitsInStock+", "+
                        UnitsOnOrder+", "+
                        ReorderLevel+", "+Discontinued);
            }
            //Hiển thị thông tin chi tiết của một đơn hàng
            sqlSelect = "SELECT * FROM `order details`";
            System.out.println("The statement is: "+ sqlSelect+"\n");
            rs = stmt.executeQuery(sqlSelect);
            while (rs.next()){
                int OrderID = rs.getInt("OrderID");
                int ProductID  = rs.getInt("ProductID");
                double UnitPrice  = rs.getDouble("UnitPrice");
                int Quantity  = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                System.out.println(OrderID +", "+ProductID+", "+UnitPrice+", "+Quantity+", "+Discount);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
