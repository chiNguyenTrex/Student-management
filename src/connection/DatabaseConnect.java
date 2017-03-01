/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import entity.Student;
import entity.StudentList;
import entity.Transcript;
import entity.TranscriptList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChiNguyen
 */
public class DatabaseConnect {

    private static Connection connection;

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentmanage";

            connection = DriverManager.getConnection(url, "LeChiNguyen", "localhost");
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return connection;
    }

    // Kiễm tra login đồng thời lấy ra vai trò của username
    public static String checkLogin(String username, String password) {
        String sqlCommand = "SELECT * FROM users WHERE Username = ? and Passwords = ?";
        try (PreparedStatement pst = connection.prepareStatement(sqlCommand)) {
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(5);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {

        }
        return "";
    }

    public static boolean checkUsername(String username) {
        // Kiễm tra ở bước đăng ký xem username có tồn tại chưa
        String sql = "select * from users where Username like ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false; // Nếu tồn tại username  thì returrn false
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static boolean checkIdStudent(String id) {
        String sql = "select * from student where StudentID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    // Chèn một user vào bảng user nếu signup thành công
    public static void insertUser(String username, String pass, String name, String email, String role) {
        String sql = "insert into users(Username, Passwords, Name, Email, Roles) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1, username);
            prst.setString(2, pass);
            prst.setString(3, name);
            prst.setString(4, email);
            prst.setString(5, role);
            prst.executeUpdate();

            connection.close();
            prst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Chèn SV vào DB ở bước thêm sinh viên của giáo vụ
    public static int insertStudentIntoDatabase(String id, String name, String birth,
            String sex, String phone, String mail, String address, String imageName) {
        String sql = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?)";
        int rowEffect = -1;
        try {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, birth);
                ps.setString(4, sex);
                ps.setString(5, phone);
                ps.setString(6, mail);
                ps.setString(7, address);
                ps.setString(8, imageName);

                rowEffect = ps.executeUpdate();
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowEffect;  // nếu chèn thành công trả về 1
    }

    // Xóa SV trong bảng student
    public static void deleteStudentByID(String id) {
        String sql = "delete student where StudentID like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            connection.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getStudentFromDatabase() { // Lấy Student từ database chèn vào STUDENT_LIST lúc giáo vụ khởi động
        // AddingStudet panel

        String sqlQuery = "select * from student";
        try {
            PreparedStatement prSt = connection.prepareStatement(sqlQuery);
            ResultSet rsS = prSt.executeQuery();

            while (rsS.next()) {
                Student st = new Student();

                st.setStudentId(rsS.getString(1));
                st.setStudentName(rsS.getString(2));
                st.setStudentBirth(rsS.getString(3));
                st.setStudentGender(rsS.getString(4));
                st.setStudentPhone(rsS.getString(5));
                st.setStudentEmail(rsS.getString(6));
                st.setStudentAddress(rsS.getString(7));
                st.setImageUrl(rsS.getString(8));

                StudentList.setData(st);
            }

            connection.close();
            prSt.close();
            rsS.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lấy danh sách môn học put vào 3 list: JAVA_LIST, WEB_LIST, NETWORK_LIST
    public static void getTranscriptFromDatabase() {
        try {
            String sql = "select * from transcripts";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transcript trs = new Transcript();

                String sub = rs.getString(2);

                trs.setStudentId(rs.getString(1));
                trs.setSubjectId(sub);
                trs.setLab1(rs.getDouble(3));
                trs.setLab2(rs.getDouble(4));
                trs.setLab3(rs.getDouble(5));
                trs.setLab4(rs.getDouble(6));
                trs.setQuiz1(rs.getDouble(7));
                trs.setQuiz2(rs.getDouble(8));
                trs.setQuiz3(rs.getDouble(9));
                trs.setQuiz4(rs.getDouble(10));
                trs.setAssignment1(rs.getDouble(11));
                trs.setAssignment2(rs.getDouble(12));
                trs.setTest(rs.getDouble(13));

                if (sub.equals("JAV2222")) { // Java
                    TranscriptList.setDataJavaList(trs);

                } else if (sub.equals("NET1111")) { // Network
                    TranscriptList.setDataNetWorkList(trs);

                } else {  //Web
                    TranscriptList.setDataWebList(trs);

                }

            }

            connection.close();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean checkIDSubjectAndIDStudent(String idStudent, String idSubject) {
        boolean result = true;
        try {
            String sql = "select * from transcripts where (StudentID like ? ) and (SubID like ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idStudent);
            ps.setString(2, idSubject);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = false; // Đã tồn tại this record
            }
            connection.close();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Insert a transcript into database
    public static int insertTranscripIntoDatabase(String idStudent, String idSubject, double lap1, double lab2,
            double lab3, double lab4, double q1, double q2, double q3, double q4, double ass1, double ass2, double test) {

        String sql = "insert into transcripts values(? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int rowAffect = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, idStudent);
            ps.setString(2, idSubject);
            ps.setDouble(3, lap1);
            ps.setDouble(4, lab2);
            ps.setDouble(5, lab3);
            ps.setDouble(6, lab4);
            ps.setDouble(7, q1);
            ps.setDouble(8, q2);
            ps.setDouble(9, q3);
            ps.setDouble(10, q4);
            ps.setDouble(11, ass1);
            ps.setDouble(12, ass2);
            ps.setDouble(13, test);

            rowAffect = ps.executeUpdate();

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowAffect;
    }

    public static int updateTranscript(String idStudent, String idSubject, double lap1, double lab2,
            double lab3, double lab4, double q1, double q2, double q3, double q4, double ass1, double ass2, double test) {
        int rowAffect = -1;
        String sql = "UPDATE transcripts SET Lab1 = ?, Lab2 = ?, Lab3 = ?, Lab4 = ?, Quiz1 = ?, Quiz2 = ?, Quiz3 = ?,"
                + " Quiz4 = ?, Assignment1 = ?, Assignment2 = ?, Test = ? WHERE (StudentID like ?) and (SubID like ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDouble(1, lap1);
            ps.setDouble(2, lab2);
            ps.setDouble(3, lab3);
            ps.setDouble(4, lab4);
            ps.setDouble(5, q1);
            ps.setDouble(6, q2);
            ps.setDouble(7, q3);
            ps.setDouble(8, q4);
            ps.setDouble(9, ass1);
            ps.setDouble(10, ass2);
            ps.setDouble(11, test);
            ps.setString(12, idStudent);
            ps.setString(13, idSubject);

            rowAffect = ps.executeUpdate();

            connection.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowAffect;
    }

    public static void closeConnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
