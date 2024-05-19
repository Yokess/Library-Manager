package util;

import com.mysql.jdbc.Connection;

public class DBManager {
    private Connection conn;
    private DBConnect dbc;

    public DBManager() {
        dbc = new DBConnect();
        dbc.connect();
        if(dbc.getConnection()!=null){
            conn= (Connection) dbc.getConnection();
        }else{
            System.out.println("连接未成功");
        }

    }
    public Connection getConnection() {
        return conn;
    }
    public  void Insert(String sql){

    }
    public  void Update(String sql) {

    }
    public  void Delete(String id) {

    }
    public  void Select(String sql) {


    }

}
