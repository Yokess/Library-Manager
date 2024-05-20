package util;

import com.mysql.jdbc.Connection;

public interface DBManager {
    Connection conn = null;
    DBConnect dbc = null;


    public  void Insert(String sql);

    public  void Update(String sql);


    public  void Delete(String id) ;


    public  void Select(String sql) ;




}
