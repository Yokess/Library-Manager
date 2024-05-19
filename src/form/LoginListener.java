package form;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import com.mysql.jdbc.Connection;
import table.User;
import table.Users;
import util.DBConnect;
public class LoginListener implements ActionListener {
    private JTextField userText;
    private JPasswordField passText;
    private JFrame LoginJframe;
    private DBConnect dbConnect=new DBConnect();
    private Users userList;


    int count=3;

    public LoginListener(JFrame LoginJframe,JTextField userText,JPasswordField passText) {
        this.userText=userText;
        this.passText=passText;
        this.LoginJframe=LoginJframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Users userList=new Users((Connection) dbConnect.getConnection());
        String txt=userText.getText().trim();
        String pass=passText.getText().trim();
        boolean exist=userList.selectUser(txt,pass);




        if (exist) {
            JOptionPane.showMessageDialog(null, "登录成功", "Title",JOptionPane.PLAIN_MESSAGE);
            new ManagerForm();
            LoginJframe.dispose();
        }else {
            count--;
            JOptionPane.showMessageDialog(null, "用户名或密码错误，您还有"+count+"次登录机会", "Title",JOptionPane.PLAIN_MESSAGE);
        }
        if(count==0) {
            LoginJframe.dispose();
        }
    }

}
