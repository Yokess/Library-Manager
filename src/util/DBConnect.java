package util;
import java.sql.*;

public class DBConnect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    //连接对象
    private Connection conn;
    public DBConnect() {

        this.conn = null;
        connect();
    }
    //连接到数据库
    public void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("正在连接到数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("连接成功");

        } catch (SQLException e) {
            System.out.println("连接数据库失败" + e.getMessage());
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("找不到MySQL驱动类" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void disconnect() {
        if(conn != null) {
            try{
                conn.close();
                System.out.println("断开数据库连接。");

            }catch(SQLException e){
                System.out.println("关闭连接时出错"+e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public Connection getConnection() {
        return conn;
    }

}
