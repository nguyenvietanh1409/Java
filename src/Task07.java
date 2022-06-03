import java.sql.*;
import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) throws SQLException {
        Scanner ip = new Scanner(System.in);
        int sign;
        int tieptuc;
        String username;
        String password;
        String email;
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/SignGame", "root", "");
                PreparedStatement pstmtInsertU = conn.prepareStatement(
                        "insert into tbsignup(username, password, email) values (?, ?, ?)");
                PreparedStatement pstmtUpdate = conn.prepareStatement(
                        "update tbsignup set password = ? where username = ?");
                PreparedStatement pstmtDelete = conn.prepareStatement(
                        "delete from tbsignup where username = ?");



        ) {
            conn.setAutoCommit(false);
            try {
                do {
                    System.out.println("Hay chon dich vu: ");
                    System.out.println("1. Dang ky \t\t 2. Thay doi mat khau \t\t 3. Xoa tai khoan");
                    sign = ip.nextInt();
                    if (sign == 1){
                        System.out.println("BAN CHON DANG KY");
                        ip.nextLine();
                        System.out.println("Nhap username: ");
                        username = ip.nextLine();
                        System.out.println("Nhap password: ");
                        password = ip.nextLine();
                        System.out.println("Nhap email: ");
                        email = ip.nextLine();
                        pstmtInsertU.setString(1, username);
                        pstmtInsertU.setString(2, password);
                        pstmtInsertU.setString(3, email);
                        pstmtInsertU.executeUpdate();
                        System.out.println("Dang ky thanh cong");
                    }
                    else if (sign == 2){
                        System.out.println("BAN CHON THAY DOI MAT KHAU");
                        ip.nextLine();
                        System.out.println("Nhap username: ");
                        username = ip.nextLine();
                        System.out.println("Nhap password moi: ");
                        password = ip.nextLine();
                        pstmtUpdate.setString(1, username);
                        pstmtUpdate.setString(2, password);
                        pstmtUpdate.executeUpdate();
                        System.out.println("Thay doi mat khau thanh cong");
                    }
                    if (sign == 3){
                        System.out.println("BAN CHON XOA TAI KHOAN");
                        ip.nextLine();
                        System.out.println("Nhap username: ");
                        username = ip.nextLine();
                        pstmtDelete.setString(1, username);
                        pstmtDelete.executeUpdate();
                        System.out.println("Xoa tai khoan thanh cong");
                    }
                    conn.commit();
                    System.out.println("Ban co muon tiep tuc? ");
                    System.out.println("4. Co \t\t 5. Khong");
                    sign = ip.nextInt();
                    if (sign == 5){
                        break;
                    }
                }while (sign != 1 || sign != 2 || sign != 3 || sign != 4);

            }catch (SQLException ex) {
                System.out.println("BAN DA NHAP SAI THONG TIN");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
