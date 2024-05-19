package table;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import util.RegexValidator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Users {
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

        String sql="select max(user_id) as uuz from users";
        PreparedStatement statement= (PreparedStatement)conn .prepareStatement(sql);
        ResultSet rs=statement.executeQuery();
        rs.next();
        int userId=rs.getInt("uuz")+1;
        Date d=new Date();
        java.sql.Date date=new java.sql.Date(d.getTime());
        String sql2="insert into users values("+userId+",'"+user.getUsername()+"','"+user.getPassword()+
                "','"+user.getFull_name()+"','"+user.getEmail()+"','"+user.getPhone()+"','"+user.getAddress()
                +"','"+  date    +"','"+user.getRole()+"')";
        PreparedStatement statement2= (PreparedStatement) conn .prepareStatement(sql2);
        statement2.executeUpdate();
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
}
