package table;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Users implements DBManager {
    private List<User> users=new ArrayList<User>();
    private Connection conn;
    private int count=0;

    public Users(Connection connection){
        this.conn=connection;
        loadUsers();

    }
    public int getCount(){
        return users.size();
    }
    public void setCount(){
        count=users.size();
    }
    public void loadUsers(){
        users.clear();
        String sql="select * from users";
        try{
            PreparedStatement statement= (PreparedStatement)conn .prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                int userId=rs.getInt("user_id");
                String username=rs.getString("username");
                String password=rs.getString("password");
                String fullName=rs.getString("full_name");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                User user=new User(username,password,fullName,email,phone,address);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        setCount();
    }
    public void addUser(User user) throws SQLException {
        String selectMaxIdSql = "SELECT MAX(user_id) AS uuz FROM users";
        String insertUserSql = "INSERT INTO users (user_id, username, password, full_name, email, phone, address, membership_date,role) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

        PreparedStatement selectStatement = null;
        PreparedStatement insertStatement = null;
        ResultSet rs = null;

        try {
            // 获取当前最大的 user_id
            selectStatement = (PreparedStatement) conn.prepareStatement(selectMaxIdSql);
            rs = selectStatement.executeQuery();
            rs.next();
            int userId = rs.getInt("uuz") + 1;

            // 获取当前日期
            Date currentDate = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

            // 插入新用户
            insertStatement = (PreparedStatement) conn.prepareStatement(insertUserSql);
            insertStatement.setInt(1, userId);
            insertStatement.setString(2, user.getUsername());
            insertStatement.setString(3, user.getPassword());
            insertStatement.setString(4, user.getFull_name());
            insertStatement.setString(5, user.getEmail());
            insertStatement.setString(6, user.getPhone());
            insertStatement.setString(7, user.getAddress());
            insertStatement.setDate(8, sqlDate); // 使用当前日期
            insertStatement.setString(9, user.getRole());
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // 重新抛出异常以便调用者处理
        } finally {
            // 关闭资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (insertStatement != null) {
                try {
                    insertStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        loadUsers();
    }
    public void updateUser(User user){

    }
    public void deleteUser(int userId){

    }
    public boolean selectUser(String username,String password){
        for(User user:users){
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void Insert(String sql) {

    }

    @Override
    public void Update(String sql) {

    }

    @Override
    public void Delete(String id) {

    }

    @Override
    public void Select(String sql) {

    }
}
