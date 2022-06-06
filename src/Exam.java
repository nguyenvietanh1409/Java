import java.sql.*;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/netflyx", "root", "");
                PreparedStatement pstmtInsert = conn.prepareStatement(
                        "insert into Film values (?, ?, ?, ?, ?)");
                PreparedStatement pstmtUpdate = conn.prepareStatement(
                        "update Film set maphim = ? where tenphim = ?");
                PreparedStatement pstmtDelete = conn.prepareStatement(
                        "delete from Film where tenphim = ?");
                PreparedStatement pstmtSelect = conn.prepareStatement(
                        "select * from Film where tenphim = ?");
                PreparedStatement pstmtUpdate2 = conn.prepareStatement(
                        "update Film set date = ? where tenphim = ?")
        ) {
            conn.setAutoCommit(false);
            try {
                int type;
                int type2;
                String maPhim;
                String tenPhim;
                String  date;
                String daoDien;
                int thoiGian;
                Scanner ip = new Scanner(System.in);
                do {
                    System.out.println("Ban muon lam gi: ");
                    System.out.println("1.Them\t\t2.Sua\t\t3.Xoa\t\t4.Tim kiem");
                    type = ip.nextInt();
                    if (type == 1 ){
                        System.out.println("=== THEM PHIM ===");
                        ip.nextLine();
                        System.out.println("\nNhap ma phim: ");
                        maPhim = ip.nextLine();
                        System.out.println("\nNhap ten phim: ");
                        tenPhim = ip.nextLine();
                        System.out.println("\nNhap thoi gian chieu phim:  ");
                        date = ip.nextLine();
                        System.out.println("\nNhap ten dao dien: ");
                        daoDien = ip.nextLine();
                        System.out.println("\nNhap thoi luong phim: ");
                        thoiGian = ip.nextInt();
                        pstmtInsert.setString(1, maPhim);
                        pstmtInsert.setString(2, tenPhim);
                        pstmtInsert.setString(3, date);
                        pstmtInsert.setString(4, daoDien);
                        pstmtInsert.setInt   (5, thoiGian);
                        pstmtInsert.executeUpdate();
                        System.out.println("SUCCESS!");
                    }
                    else if (type == 2){
                        System.out.println("=== SUA THONG TIN PHIM ===");
                        ip.nextLine();
                        System.out.println("Nhap ten phim muon sua: ");
                        tenPhim = ip.nextLine();
                        System.out.println("\nBan muon sua thong tin gi:");
                        System.out.println("1.Ma Phim\t\t2.Thoi gian chieu");
                        type2 = ip.nextInt();
                        if (type2 == 1){
                            System.out.println("== SUA MA PHIM == ");
                            ip.nextLine();
                            System.out.println("Nhap ma phim: ");
                            maPhim = ip.nextLine();
                            pstmtUpdate.setString(1, maPhim);
                            pstmtUpdate.setString(2, tenPhim);
                            pstmtUpdate.executeUpdate();
                        }
                        if (type2 == 2){
                            System.out.println("== SUA THOI GIAN CHIEU PHIM ==");
                            ip.nextLine();
                            System.out.println("Nhap thoi gian: ");
                            date = ip.nextLine();
                            pstmtUpdate2.setString(1,date);
                            pstmtUpdate2.setString(2,tenPhim);
                            pstmtUpdate2.executeUpdate();
                        }
                    }
                    else if (type == 3){
                        System.out.println("=== XOA PHIM === ");
                        ip.nextLine();
                        System.out.println("\nNhap ten phim muon xoa: ");
                        tenPhim = ip.nextLine();
                        pstmtDelete.setString(1, tenPhim);
                        pstmtDelete.executeUpdate();
                    }
                    else if (type == 4){
                        System.out.println("=== TIM KIEM THONG TIN PHIM ===");
                        ip.nextLine();
                        System.out.println("\nNhap ten phim muon tim: ");
                        tenPhim = ip.nextLine();
                        pstmtSelect.setString(1, tenPhim);
                        ResultSet rset = pstmtSelect.executeQuery();
                        while (rset.next()){
                            System.out.println(rset.getString("maphim") + ", "
                                    + rset.getString("tenphim") + ", "
                                    + rset.getString("date") + ", "
                                    + rset.getString("tendaodien") + ", "
                                    + rset.getInt("thoigian"));
                        }
                    }
                    conn.commit();
                    System.out.println("Ban co muon tiep tuc khong: ");
                    System.out.println("5.Co\t\t6.Khong");
                    type = ip.nextInt();
                    if (type == 6){
                        break;
                    }
                }while (type != 1 || type != 2 || type != 3 || type != 4 || type != 5);

            } catch (SQLException ex) {
                System.out.println("NHAP SAI THONG TIN");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
