package mysqlTest;

import java.sql.*;


public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //加载数据库驱动程序
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }
        String dburl = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
        String sql = "SELECT * FROM student";
        try(    Connection conn = DriverManager.getConnection(dburl,"root","pyh903903");
                Statement stmt = conn.createStatement();
                ResultSet rst = stmt.executeQuery(sql))

        {
            while (rst.next()){
                System.out.println(rst.getString(1) );
            }

        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
