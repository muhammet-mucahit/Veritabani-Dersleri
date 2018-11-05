package ornek;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App
{
//    public static void updateStudent() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ornek?useSSL=false","root","root1234");
//
//        try {
//            PreparedStatement preparedStatement = con
//                    .prepareStatement("update student set student_number = ?, name = ?, surname = ?, password = ?" +
//                            "where student_number = ?");
//            preparedStatement.setInt(1, 313930);
//            preparedStatement.setString(2, "Muhammet");
//            preparedStatement.setString(3, "aktepe");
//            preparedStatement.setString(4, "4321");
//            preparedStatement.setInt(5, 313933);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ornek?useSSL=false","root","root1234");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from student");
        while(rs.next())
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
        con.close();
    }
}
















